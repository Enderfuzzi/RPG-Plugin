package com.falgael.rpg.tmp;

import com.falgael.rpg.items.ConfigurationFlag;
import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.proficiency.items.effects.FurnaceBurn;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MusicInstrumentMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public enum CustomItem {

    NONE(ProficiencyType.NONE, Material.AIR, Rarity.NONE),

    STAT_O_METER(ProficiencyType.MISC,Material.AMETHYST_SHARD,"Stat-O-Meter",Rarity.EPIC,true),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    TEST_WOODWORK_AXE(ProficiencyType.WOODWORK,Material.WOODEN_AXE,"Axe",Rarity.SIMPLE,Set.of("Test lore to add"),
            new ItemConfiguration.Builder(Set.of(EquipmentSlot.HAND)).addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LOOT, 0.5f).create(),
            EquipmentSet.WOODWORK_TEST),
    TEST_WOODWORK_HELMET(ProficiencyType.WOODWORK, Material.LEATHER_HELMET,"Helmet",Rarity.ELITE,Set.of("Test lore to add"),
            new ItemConfiguration.Builder(Set.of(EquipmentSlot.HEAD)).addFlag(ConfigurationFlag.EXPERIENCE,1f).create(),
            EquipmentSet.WOODWORK_TEST),
    TEST_WOODWORK_CHESTPLATE(ProficiencyType.WOODWORK, Material.LEATHER_CHESTPLATE,"Chestplate",Rarity.ELITE,Set.of("Test lore to add"),
            new ItemConfiguration.Builder(Set.of(EquipmentSlot.CHEST)).addFlag(ConfigurationFlag.EXPERIENCE,1f).create(),
            EquipmentSet.WOODWORK_TEST),
    TEST_WOODWORK_LEGGINGS(ProficiencyType.WOODWORK, Material.LEATHER_LEGGINGS,"Leggings",Rarity.ELITE,Set.of("Test lore to add"),
            new ItemConfiguration.Builder(Set.of(EquipmentSlot.LEGS)).addFlag(ConfigurationFlag.EXPERIENCE,1f).create(),
            EquipmentSet.WOODWORK_TEST),
    TEST_WOODWORK_BOOTS(ProficiencyType.WOODWORK, Material.LEATHER_BOOTS,"Boots",Rarity.ELITE,Set.of("Test lore to add"),
            new ItemConfiguration.Builder(Set.of(EquipmentSlot.FEET)).addFlag(ConfigurationFlag.EXPERIENCE,1f).create(),
            EquipmentSet.WOODWORK_TEST),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONEWORK_INFINITE_COAL_TIER_I(ProficiencyType.STONEWORK, Material.OAK_WOOD, "Infinite Fuel",Rarity.ADVANCED, Set.of("Burns until end of time"),
            new ItemConfiguration.Builder(null).addFlag(ConfigurationFlag.BURN_TIME, 0.1f).create(),true),
    STONEWORK_INFINITE_COAL_TIER_II(ProficiencyType.STONEWORK, Material.COAL, "Infinite Fuel",Rarity.ELITE, Set.of("Burns until end of time"),
            new ItemConfiguration.Builder(null).addFlag(ConfigurationFlag.BURN_TIME, 0.5f).create(), true),
    STONEWORK_INFINITE_COAL_TIER_III(ProficiencyType.STONEWORK, Material.CHARCOAL, "Infinite Fuel",Rarity.EPIC,Set.of("Burns until end of time"),
            new ItemConfiguration.Builder(null).addFlag(ConfigurationFlag.BURN_TIME, 0.7f).create(), true),
    STONEWORK_INFINITE_COAL_TIER_VI(ProficiencyType.STONEWORK, Material.COAL_BLOCK, "Infinite Fuel",Rarity.LEGENDARY,Set.of("Burns until end of time"),
            new ItemConfiguration.Builder(null).addFlag(ConfigurationFlag.BURN_TIME, 0.85f).create(), true),



    ;


    private static final HashMap<ProficiencyType, ArrayList<CustomItem>> GROUPED_BY_PROFICIENCY = new HashMap<>();

    private static final HashMap<EquipmentSet, ArrayList<CustomItem>> EQUIPMENT_SET_MAP = new HashMap<>();

    static {
            for (CustomItem current : CustomItem.values()) {
                if (!EQUIPMENT_SET_MAP.containsKey(current.equipmentSet)) {
                    EQUIPMENT_SET_MAP.put(current.equipmentSet, new ArrayList<>());
                }
                EQUIPMENT_SET_MAP.get(current.equipmentSet).add(current);

                if (!GROUPED_BY_PROFICIENCY.containsKey(current.type)) {
                    GROUPED_BY_PROFICIENCY.put(current.type, new ArrayList<>());
                }
                GROUPED_BY_PROFICIENCY.get(current.type).add(current);
            }
    }

    private final ProficiencyType type;

    private final ItemStack item;

    private final ItemConfiguration configuration;

    private final EquipmentSet equipmentSet;

    CustomItem(ProficiencyType type, Material material, Rarity rarity) {
        this(type, material, material.name(),rarity);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity) {
        this(type, material, name, rarity, null);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, Set<String> lore) {
        this(type, material, name, rarity, lore, null);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, Set<String> lore, ItemConfiguration configuration) {
        this(type,material,name,rarity,lore,configuration,EquipmentSet.NONE, false);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, boolean enchanted) {
        this(type, material, name, rarity, null, null, EquipmentSet.NONE, enchanted);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity,Set<String> lore,ItemConfiguration configuration, boolean enchanted) {
        this(type, material, name, rarity, lore, configuration, EquipmentSet.NONE, enchanted);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity,Set<String> lore, ItemConfiguration configuration, EquipmentSet equipmentSet) {
        this(type, material,name,rarity,lore,configuration,equipmentSet,false);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, Set<String> lore, ItemConfiguration configuration, EquipmentSet equipmentSet, boolean enchanted) {

        this.type = type;

        this.item = new ItemBuilder(material).setName(name).setRarity(rarity).addProficiency(type).addLore(lore).setConfiguration(configuration).setEquipmentSet(equipmentSet).visibleEnchanted(enchanted).create();


        this.configuration = configuration;

        this.equipmentSet = equipmentSet;
    }

    public ProficiencyType getProficiency() {
        return type;
    }

    public boolean hasConfiguration() {
        return configuration != null;
    }

    public ItemConfiguration getConfiguration() {
        return configuration;
    }


    public ItemStack getItem() {
        return item;
    }


    public boolean hasEquipmentSet() {
        return this.equipmentSet != EquipmentSet.NONE;
    }

    public EquipmentSet getEquipmentSet() {
        return this.equipmentSet;
    }


    public static CustomItem getItem(ItemStack itemStack) {
        if (itemStack == null) return NONE;

        for (CustomItem current : CustomItem.values()) {
            if (itemStack.getType() != current.getItem().getType()) continue;
            Bukkit.getLogger().info("After type comparison");
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta == null) continue;
            ItemMeta currentMeta = current.getItem().getItemMeta();
            if (currentMeta == null) continue;

            Bukkit.getLogger().info("After meta comparison");

            if (itemMeta instanceof MusicInstrumentMeta ^ currentMeta instanceof MusicInstrumentMeta) continue;
            if (itemMeta instanceof MusicInstrumentMeta itemMusicMeta && currentMeta instanceof MusicInstrumentMeta currentMusicMeta) {
                if (itemMusicMeta.getInstrument() != currentMusicMeta.getInstrument()) continue;
            }

            Bukkit.getLogger().info("After music comparison");

            if (!itemMeta.hasDisplayName()) continue;
            Bukkit.getLogger().info("After name comparison");
            if (!itemMeta.isUnbreakable()) continue;
            if (!itemMeta.getDisplayName().equals(currentMeta.getDisplayName())) continue;

            if (itemMeta.hasLore() ^ currentMeta.hasLore()) continue;

            return current;
        }

        return NONE;
    }

    public static boolean isStatOMeter(ItemStack itemStack) {
       return CustomItem.getItem(itemStack) == STAT_O_METER;
    }

    public ArrayList<CustomItem> getItemsOfSet() {
        return EQUIPMENT_SET_MAP.getOrDefault(equipmentSet, new ArrayList<>());
    }

    public static ArrayList<CustomItem> getItemsOfSet(EquipmentSet equipmentSet) {
        return EQUIPMENT_SET_MAP.getOrDefault(equipmentSet, new ArrayList<>());
    }

    public static ArrayList<CustomItem> getItemsOfProficiency(ProficiencyType type) {
        return GROUPED_BY_PROFICIENCY.getOrDefault(type, new ArrayList<>());
    }

    public boolean isBreakingTool() {
        return switch (this) {
            case TEST_WOODWORK_AXE -> true;
            default -> false;
        };
    }

    public boolean isWeapon() {
        return switch (this) {
            default -> false;
        };
    }

    public boolean isNone() {
        return this == NONE;
    }

}
