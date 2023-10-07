package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.proficiency.blocks.BlockBreak;
import com.falgael.rpg.proficiency.blocks.WoodType;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.tmp.Calculation;
import com.falgael.rpg.tmp.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Furnace;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class ItemEffect {

    public static boolean cropHarvest(Event e) {
        if (!(e instanceof BlockBreakEvent event)) return false;
        BlockBreak block = BlockBreak.getBlock(event.getBlock().getType());
        if (block.isNone()) return false;

        // special crops
        if (block.specialHarvest()) {
            if (event.getBlock().getRelative(BlockFace.DOWN).getType() == event.getBlock().getType()) return false;
            event.setCancelled(true);
        }

        // ageable crop
        if (!block.ageable() || !(event.getBlock().getBlockData() instanceof Ageable cropAge)) return false;

        event.setCancelled(true);


        if (cropAge.getAge() != cropAge.getMaximumAge()) return true;

        long experienceAmount = Calculation.calculateExperience(block.getExperienceAmount(), block.getProficiency(), event.getPlayer());
        int droppedBlocks = Calculation.calculateLoot(block.getProficiency(), event.getPlayer());

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        Calculation.dropAdditionalLoot(drops, ++droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

        if (event.getPlayer().getInventory().contains(event.getBlock().getBlockData().getPlacementMaterial(),1)) {
            int slot = event.getPlayer().getInventory().first(event.getBlock().getBlockData().getPlacementMaterial());
            if (event.getPlayer().getInventory().getItem(slot).getAmount() != 1) event.getPlayer().getInventory().getItem(slot).setAmount(event.getPlayer().getInventory().getItem(slot).getAmount() - 1);
            else event.getPlayer().getInventory().remove(event.getPlayer().getInventory().getItem(slot));

            StructureRotation rotation = getSurroundedJungleLog(event.getBlock());
            event.getBlock().setType(block.getMaterial());

            if (rotation != StructureRotation.NONE) {
                BlockData blockData = event.getBlock().getBlockData();
                blockData.rotate(rotation);
                event.getBlock().setBlockData(blockData);
            }
        } else {
            event.getBlock().setType(Material.AIR);
        }

        return true;
    }


    private static StructureRotation getSurroundedJungleLog(Block target) {
        if (getSurroundedJungleLog(target, BlockFace.EAST)) return StructureRotation.CLOCKWISE_90;
        if (getSurroundedJungleLog(target,BlockFace.SOUTH)) return StructureRotation.CLOCKWISE_180;
        if (getSurroundedJungleLog(target, BlockFace.WEST)) return StructureRotation.COUNTERCLOCKWISE_90;
        return StructureRotation.NONE;
    }

    private static boolean getSurroundedJungleLog(Block target, BlockFace blockFace) {
        if (target == null || blockFace == null) return false;
        return target.getRelative(blockFace).getType() == Material.JUNGLE_LOG || target.getRelative(blockFace).getType() == Material.JUNGLE_WOOD;
    }


    public static boolean cropPlant(Event e, int radius, Material toPlace, Material toPlaceOn) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (event.getClickedBlock().getType() != Material.FARMLAND) return false;
        Location location = event.getClickedBlock().getLocation();
        Player player = event.getPlayer();


        ArrayList<Location> candidates = new ArrayList<>();

        location.subtract(Math.floor(radius / 2),0,Math.floor(radius / 2));

        location.add(0,1,0);

        for (int j = 0; j < radius; j++) {
            for (int i = 0; i< radius; i++) {
                if (location.getBlock().getType() == Material.AIR && location.getBlock().getRelative(BlockFace.DOWN).getType() == toPlaceOn) candidates.add(location.clone());
                location.add(0,0,1);
            }
            location.subtract(0,0,radius);
            location.add(1,0,0);
        }

        HashMap<Integer, ? extends ItemStack> playerItems = player.getInventory().all(toPlace.createBlockData().getPlacementMaterial());
        if (playerItems.isEmpty()) return false;

        int amountToPlace = candidates.size();
        ArrayList<Integer> indexToRemove = new ArrayList<>();
        for (Map.Entry<Integer, ? extends ItemStack> entry : playerItems.entrySet()) {
            if (entry == null) continue;
            if (amountToPlace < entry.getValue().getAmount()) {
                player.getInventory().getItem(entry.getKey()).setAmount(entry.getValue().getAmount() - amountToPlace);
                amountToPlace = 0;
                break;
            } else if (amountToPlace - entry.getValue().getAmount() == 0) {
                indexToRemove.add(entry.getKey());
                amountToPlace = 0;
                break;
            }
            amountToPlace -= entry.getValue().getAmount();
            indexToRemove.add(entry.getKey());
        }
        if (amountToPlace > 0) return false;

        playerItems.keySet().removeIf(indexToRemove::contains);


        for (Location loc : candidates) loc.getBlock().setType(toPlace);
        return true;
    }

    public static boolean furnaceFuelBurn(Event e, double speedIncrease) {
        if (!(e instanceof FurnaceBurnEvent event)) return false;
        if (!(event.getBlock().getState() instanceof Furnace furnace)) return false;


        ItemStack fuel = furnace.getInventory().getFuel();
        fuel.setAmount(fuel.getAmount() + 1);
        furnace.getInventory().setFuel(fuel);

        if (furnace.getCookTime() < furnace.getCookTimeTotal() * speedIncrease)
            furnace.setCookTime((short) (furnace.getCookTimeTotal() * speedIncrease));

        furnace.update();

        event.setBurnTime((short) (furnace.getCookTimeTotal() * (1 - speedIncrease)));
        event.setBurning(false);

        return true;
    }


    public static boolean treeHarvest(Event e, int maxAmount) {
        if (!(e instanceof BlockBreakEvent event)) return false;
        BlockBreak block = BlockBreak.getBlock(event.getBlock().getType());
        com.falgael.rpg.tmp.CustomItem customItem = CustomItem.getItem(event.getPlayer().getInventory().getItemInMainHand());
        if (customItem.isNone()) return false;
        if (!block.hasWoodType()) return false;
        ArrayList<Location> blocks = getTreeLogs(event.getBlock().getLocation(), block.getWoodType(), maxAmount);
        if (blocks.isEmpty()) return false;

        long experienceAmount = Calculation.calculateExperience(block.getExperienceAmount(), block.getProficiency(), event.getPlayer());
        int droppedBlocks = Calculation.calculateLoot(block.getProficiency(), event.getPlayer());

        experienceAmount *= blocks.size();
        droppedBlocks *=  blocks.size();

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        Calculation.dropAdditionalLoot(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

        for (Location location : blocks) {
            Bukkit.getLogger().info("Location to remove: " + location);
            if (event.getBlock().getLocation().equals(location)) continue;
            location.getBlock().setType(Material.AIR);
        }


        return true;
    }

    private static ArrayList<Location> getTreeLogs(Location location, WoodType type, int maxAmount) {
        ArrayList<Location> result = new ArrayList<>();
        Queue<Location> queue = new LinkedList<>();
        queue.add(location);

        while (!queue.isEmpty() && maxAmount > result.size()) {
            Location tmp = queue.remove();
            Bukkit.getLogger().info("Location: " + tmp);
            if (tmp.getBlock().getType() == Material.AIR) continue;
            if (result.contains(tmp)) continue;

            BlockBreak tmpBlockBreak = BlockBreak.getBlock(tmp.getBlock().getType());
            if (tmpBlockBreak.isNone()) continue;
            if (!tmpBlockBreak.hasWoodType()) continue;
            if (tmpBlockBreak.getWoodType() != type) continue;

            result.add(tmp);

            for (int x = -1;x < 2;x++) {
                for (int y = -1; y < 2; y++) {
                    for (int z = -1;z < 2; z++) {
                        if (x == 0 && y == 0 && z == 0) continue;
                        queue.add(tmp.getBlock().getRelative(x,y,z).getLocation());
                    }

                }
            }
        }



        return result;
    }

    public static boolean weatherClear(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCooldown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(false);
        event.getPlayer().getWorld().setThundering(false);
        event.getPlayer().getWorld().setClearWeatherDuration(duration);
        return true;
    }

    public static boolean weatherRain(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCooldown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(true);
        event.getPlayer().getWorld().setThundering(false);
        event.getPlayer().getWorld().setWeatherDuration(duration);
        return true;
    }

    public static boolean weatherStorm(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCooldown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(true);
        event.getPlayer().getWorld().setThundering(true);
        event.getPlayer().getWorld().setThunderDuration(duration);
        return true;
    }

    private static boolean setItemCooldown(PlayerInteractEvent event, int duration) {
        if (event.getPlayer().hasCooldown(event.getItem().getType())) return false;
        event.getPlayer().setCooldown(event.getItem().getType(),duration);
        return true;
    }

}
