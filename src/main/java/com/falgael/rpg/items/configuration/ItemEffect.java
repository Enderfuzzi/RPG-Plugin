package com.falgael.rpg.items.configuration;

import com.falgael.rpg.items.ItemDrop;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import com.falgael.rpg.definitions.stats.BlockStats;
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

public interface ItemEffect extends ItemDrop {

    default boolean cropHarvest(Event e, ProficiencyExperienceCalculation proficiencyAdapter) {

        if (!(e instanceof BlockBreakEvent event)) return false;
        BlockStats block = BlockStats.getBlock(event.getBlock().getType());
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

        proficiencyAdapter.calculateExperience(event.getPlayer(), block.getProficiencies(), block.getExperienceAmount());
        int droppedBlocks = proficiencyAdapter.calculateLoot(event.getPlayer(), block.getProficiencies());

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        //proficiencyAdapter.dropAdditionalLoot(drops, ++droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());
        dropItem(drops, ++droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

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


    private StructureRotation getSurroundedJungleLog(Block target) {
        if (getSurroundedJungleLog(target, BlockFace.EAST)) return StructureRotation.CLOCKWISE_90;
        if (getSurroundedJungleLog(target,BlockFace.SOUTH)) return StructureRotation.CLOCKWISE_180;
        if (getSurroundedJungleLog(target, BlockFace.WEST)) return StructureRotation.COUNTERCLOCKWISE_90;
        return StructureRotation.NONE;
    }

    private boolean getSurroundedJungleLog(Block target, BlockFace blockFace) {
        if (target == null || blockFace == null) return false;
        return target.getRelative(blockFace).getType() == Material.JUNGLE_LOG
                || target.getRelative(blockFace).getType() == Material.JUNGLE_WOOD;
    }


    default boolean cropPlant(Event e, int radius, Material toPlace, Material toPlaceOn) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (event.getClickedBlock().getType() != Material.FARMLAND) return false;
        Location location = event.getClickedBlock().getLocation();
        Player player = event.getPlayer();
        ArrayList<Location> candidates = new ArrayList<>();
        location.subtract(Math.floor(radius / 2),0,Math.floor(radius / 2));
        location.add(0,1,0);
        for (int j = 0; j < radius; j++) {
            for (int i = 0; i< radius; i++) {
                if (location.getBlock().getType() == Material.AIR
                        && location.getBlock().getRelative(BlockFace.DOWN).getType() == toPlaceOn) {
                    candidates.add(location.clone());
                }
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

    default boolean furnaceFuelBurn(Event e, double speedIncrease) {
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

    default boolean weatherClear(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCoolDown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(false);
        event.getPlayer().getWorld().setThundering(false);
        event.getPlayer().getWorld().setClearWeatherDuration(duration);
        return true;
    }

    default boolean weatherRain(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCoolDown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(true);
        event.getPlayer().getWorld().setThundering(false);
        event.getPlayer().getWorld().setWeatherDuration(duration);
        return true;
    }

    default boolean weatherStorm(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCoolDown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(true);
        event.getPlayer().getWorld().setThundering(true);
        event.getPlayer().getWorld().setThunderDuration(duration);
        return true;
    }

    private boolean setItemCoolDown(PlayerInteractEvent event, int duration) {
        if (event.getPlayer().hasCooldown(event.getItem().getType())) return false;
        event.getPlayer().setCooldown(event.getItem().getType(),duration);
        return true;
    }




    default boolean veinMining(Event e, ProficiencyExperienceCalculation proficiencyAdapter, int maxAmount) {
        return veinHarvest(e, proficiencyAdapter, maxAmount, (start, current) -> {
            BlockStats startBlock = BlockStats.getBlock(start.getType());
            BlockStats currentBlock = BlockStats.getBlock(current.getType());

            if (startBlock.isNone() || currentBlock.isNone()) return false;
            if (!startBlock.veinMining() || !currentBlock.veinMining()) return false;
            if (start.getType() != current.getType()) return false;
            return true;
        });
    }

    default boolean treeHarvest(Event e, ProficiencyExperienceCalculation proficiencyAdapter, int maxAmount) {
        return veinHarvest(e, proficiencyAdapter, maxAmount, (start, current) -> {
            BlockStats startBlock = BlockStats.getBlock(start.getType());
            BlockStats currentBlock = BlockStats.getBlock(current.getType());

            if (startBlock.isNone() || currentBlock.isNone()) return false;
            if (!startBlock.hasWoodType() || !currentBlock.hasWoodType()) return false;
            if (startBlock.getWoodType() != currentBlock.getWoodType()) return false;
            return true;
        });
    }

    interface Predicate {
        boolean accept(Block start, Block current);
    }


    private ArrayList<Location> getSurroundedBlocks(Location startLocation, int maxBlocks, Predicate consumer) {
        ArrayList<Location> result = new ArrayList<>();
        Queue<Location> queue = new LinkedList<>();
        queue.add(startLocation);
        while (!queue.isEmpty() && maxBlocks > result.size()) {
            Location tmp = queue.remove();
            if (tmp.getBlock().getType() == Material.AIR) continue;
            if (!consumer.accept(startLocation.getBlock(),tmp.getBlock())) continue;
            if (result.contains(tmp)) continue;
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

    private boolean veinHarvest(Event e, ProficiencyExperienceCalculation proficiencyAdapter, int maxAmount, Predicate consumer) {

        if (!(e instanceof BlockBreakEvent event)) return false;
        BlockStats block = BlockStats.getBlock(event.getBlock().getType());
        ArrayList<Location> blocks = getSurroundedBlocks(event.getBlock().getLocation(), maxAmount, consumer);
        if (blocks.isEmpty()) return false;
        proficiencyAdapter.calculateExperience(event.getPlayer(), block.getProficiencies(), block.getExperienceAmount() * blocks.size());
        int droppedBlocks = proficiencyAdapter.calculateLoot(event.getPlayer(), block.getProficiencies());
        Bukkit.getLogger().info("Dropped Blocks: " + droppedBlocks + 1);
        Bukkit.getLogger().info("Additional Blocks: " + blocks.size());
        droppedBlocks = ((droppedBlocks + 1) * blocks.size()) - 1;
        Bukkit.getLogger().info("Dropped Blocks modified: " + droppedBlocks);
        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        //proficiencyAdapter.dropAdditionalLoot(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());
        dropItem(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

        for (Location location : blocks) {
            Bukkit.getLogger().info("Location to remove: " + location);
            if (event.getBlock().getLocation().equals(location)) continue;
            location.getBlock().setType(Material.AIR);
        }
        return true;
    }


}
