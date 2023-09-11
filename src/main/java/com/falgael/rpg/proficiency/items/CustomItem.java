package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.RPG;
import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.general.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlastFurnace;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public enum CustomItem {

    NONE(ProficiencyType.NONE, new ItemStack(Material.AIR)),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------
    MISC_IRON_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.IRON_NUGGET).setName("Silver Coin").setCurrency(true).setRarity(Rarity.NONE).create()),
    MISC_GOLD_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.GOLD_NUGGET).setName("Gold Coin").setCurrency(true).setRarity(Rarity.NONE).create()),

    MISC_STAT_O_METER(ProficiencyType.MISC, new ItemBuilder(Material.AMETHYST_SHARD).setName("Stat-O-Meter").visibleEnchanted(true).setRarity(Rarity.LEGENDARY).create()),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------
    WOODWORK_COMPRESSED_OAK(ProficiencyType.WOODWORK, new ItemBuilder(Material.OAK_WOOD).addProficiency(ProficiencyType.WOODWORK).setCompressed(true).create()),



    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------
    STONEWORK_COMPRESSED_STONE(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE).addProficiency(ProficiencyType.STONEWORK).setCompressed(true).create()),


    STONEWORK_INFINITE_COAL_TIER_I(ProficiencyType.STONEWORK, new ItemBuilder(Material.COAL).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.ADVANCED).visibleEnchanted(true)
            .addBurnModifierLore("10% Burn Speed").addLore("Burns until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> {
                if (!(e instanceof FurnaceBurnEvent event)) return;
                if (event.getBlock().getState() instanceof Furnace furnace) furnaceItemBurn(furnace, 0.1,event);
    }).create()),
    STONEWORK_INFINITE_COAL_TIER_II(ProficiencyType.STONEWORK, new ItemBuilder(Material.CHARCOAL).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.ELITE).visibleEnchanted(true)
            .addBurnModifierLore("50% Burn Speed").addLore("Burning until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> {
               if (!(e instanceof FurnaceBurnEvent event)) return;
               if (event.getBlock().getState() instanceof Furnace furnace) {
                   furnaceItemBurn(furnace, 0.5,event);
                   /*
                   ItemStack fuel = furnace.getInventory().getFuel();
                   fuel.setAmount(fuel.getAmount() + 1);
                   furnace.getInventory().setFuel(fuel);

                   if (furnace.getCookTime() < furnace.getCookTimeTotal() * 0.5)
                       furnace.setCookTime((short) (furnace.getCookTimeTotal() * 0.5));

                   furnace.update();

                   event.setBurnTime(furnace.getCookTimeTotal() * 0.5);
                   event.setBurning(false);

                    */
               }
    }).create()),

    STONEWORK_INFINITE_COAL_TIER_III(ProficiencyType.STONEWORK, new ItemBuilder(Material.COAL_BLOCK).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.EPIC).visibleEnchanted(true)
            .addBurnModifierLore("75% Burn Speed").addLore("Burns until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> {
                if (!(e instanceof FurnaceBurnEvent event)) return;
                if (event.getBlock().getState() instanceof Furnace furnace) furnaceItemBurn(furnace, 0.75,event);
    }).create()),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_COMPRESSED_WHEAT(ProficiencyType.FARMING, new ItemBuilder(Material.HAY_BLOCK).addProficiency(ProficiencyType.FARMING).setCompressed(true).create()),

    FARMING_SEED_PLANTER(ProficiencyType.FARMING, new ItemBuilder(Material.ECHO_SHARD).addProficiency(ProficiencyType.FARMING).visibleEnchanted(true).setRarity(Rarity.ADVANCED).setName("Planter").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction((e) -> {
                if (!(e instanceof PlayerInteractEvent event)) return;
                if (event.getClickedBlock().getType() == Material.FARMLAND) {
                    Location location = event.getClickedBlock().getLocation();
                    placeCropsInRadius(location, 5, Material.WHEAT, event.getPlayer(), Material.WHEAT_SEEDS, Material.FARMLAND);
                    /*
                    ArrayList<Location> candidates = new ArrayList<>();

                    location.subtract(1,0,1);

                    for (int j = 0; j < 3; j++) {
                        for (int i = 0; i< 3; i++) {
                            if (location.getBlock().getType() == Material.FARMLAND) candidates.add(location.clone());
                            location.add(0,0,1);
                        }
                        location.subtract(0,0,3);
                        location.add(1,0,0);
                    }

                    for (Location loc : candidates) {
                       loc.add(0,1,0);
                       if (loc.getBlock().getType() == Material.AIR) loc.getBlock().setType(Material.WHEAT);
                    }


                     */



                }
            }).create()),

    ;

    private final ItemConfiguration configuration;


    private final ItemStack itemStack;

    private final ProficiencyType type;

    CustomItem(ProficiencyType type, ItemStack itemStack) {
        this(type, itemStack, null);
    }

    CustomItem(ProficiencyType type, ItemStack itemStack, ItemConfiguration itemConfiguration) {
        this.type = type;
        this.itemStack = itemStack;
        this.configuration = itemConfiguration;
    }

    public ItemStack getItem() {
        return itemStack;
    }

    public ProficiencyType getType() {
        return type;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public boolean hasConfiguration() {
        return configuration != null;
    }

    public ItemConfiguration getConfiguration() {
        return configuration;
    }

    public static boolean isStatOMeter(ItemStack heldItem) {
        if (heldItem == null) return false;
        ItemMeta heldItemMeta = heldItem.getItemMeta();
        if (!MISC_STAT_O_METER.getItem().getType().equals(heldItem.getType())) return false;
        ItemMeta statItemMeta = MISC_STAT_O_METER.itemStack.getItemMeta();
        if (statItemMeta == null || heldItemMeta == null) return false;
        if (!statItemMeta.getDisplayName().equals(heldItemMeta.getDisplayName())) return false;
        if (!statItemMeta.isUnbreakable() || !heldItemMeta.isUnbreakable()) return false;
        return true;
    }

    public static CustomItem getItem(ItemStack key) {
        if (key == null) return NONE;
        for (CustomItem customItem : CustomItem.values()) {
            if (key.getType() != customItem.itemStack.getType()) continue;

            ItemMeta keyMeta = key.getItemMeta();
            if (keyMeta == null) continue;
            ItemMeta toolMeta = customItem.getItem().getItemMeta();
            if (toolMeta == null) continue;

            if (!keyMeta.hasDisplayName()) continue;
            if (!ChatColor.stripColor(keyMeta.getDisplayName()).equals(ChatColor.stripColor(toolMeta.getDisplayName()))) continue;

            if (keyMeta.hasLore() ^ toolMeta.hasLore()) continue;
            if (!keyMeta.hasLore() && !keyMeta.getLore().equals(toolMeta.getLore())) continue;

            if (keyMeta.hasAttributeModifiers() ^ toolMeta.hasAttributeModifiers()) continue;
            //if (!keyMeta.hasAttributeModifiers() && !keyMeta.getAttributeModifiers().equals(toolMeta.getAttributeModifiers())) continue;
            //if (!keyMeta.getItemFlags().equals(toolMeta.getItemFlags())) continue;
            return customItem;
        }
        return NONE;
    }

    private static void placeCropsInRadius(Location location, int radius, Material toPlace) {
        ArrayList<Location> candidates = new ArrayList<>();

        location.subtract(Math.floor(radius / 2),0,Math.floor(radius / 2));

        for (int j = 0; j < radius; j++) {
            for (int i = 0; i< radius; i++) {
                if (location.getBlock().getType() == Material.FARMLAND) candidates.add(location.clone());
                location.add(0,0,1);
            }
            location.subtract(0,0,radius);
            location.add(1,0,0);
        }

        for (Location loc : candidates) {
            loc.add(0,1,0);
            if (loc.getBlock().getType() == Material.AIR) loc.getBlock().setType(toPlace);
        }
    }

    private static void placeCropsInRadius(Location location, int radius, Material toPlace, Player player, Material consume, Material toPlaceOn) {
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

        HashMap<Integer, ? extends ItemStack> playerItems = player.getInventory().all(consume);
        if (playerItems.isEmpty()) return;

        /*
        for (int i = 0; i < candidates.size(); i++) {
            candidates.get(i).add(0,1,0);
            if (candidates.get(i).getBlock().getType() != Material.AIR) {
                candidates.remove(i);
                i--;
            }
        }


         */

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
        if (amountToPlace > 0) return;

        playerItems.keySet().removeIf(indexToRemove::contains);


        for (Location loc : candidates) loc.getBlock().setType(toPlace);
    }

    private static void furnaceItemBurn(Furnace furnace, double speedIncrease, FurnaceBurnEvent event ) {
        ItemStack fuel = furnace.getInventory().getFuel();
        fuel.setAmount(fuel.getAmount() + 1);
        furnace.getInventory().setFuel(fuel);

        if (furnace.getCookTime() < furnace.getCookTimeTotal() * speedIncrease)
            furnace.setCookTime((short) (furnace.getCookTimeTotal() * speedIncrease));

        furnace.update();

        event.setBurnTime((short) (furnace.getCookTimeTotal() * (1 - speedIncrease)));
        event.setBurning(false);
    }



}
