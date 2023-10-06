package com.falgael.rpg.tmp;

import com.falgael.rpg.items.ConfigurationFlag;
import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MusicInstrumentMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public enum CustomItem {

    NONE(ProficiencyType.NONE, Material.AIR,"", Rarity.NONE, null),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------


    MISC_IRON_NUGGET(ProficiencyType.MISC, Material.IRON_NUGGET,"Silver Coin", Rarity.ADVANCED,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()),
    MISC_GOLD_NUGGET(ProficiencyType.MISC, Material.GOLD_NUGGET, "Gold Coin", Rarity.ELITE,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()),

    STAT_O_METER(ProficiencyType.MISC,Material.AMETHYST_SHARD,"Stat-O-Meter",Rarity.EPIC, new ItemConfiguration.Builder().addFlag(ConfigurationFlag.ENCHANTED).create()),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    WOODWORK_BASIC_SIMPLE_AXE(ProficiencyType.WOODWORK,Material.WOODEN_AXE,"Axe",Rarity.SIMPLE,"Simple lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LOOT, 0.5f)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.LUMBERJACK_TIER_I),
    WOODWORK_BASIC_SIMPLE_HELMET(ProficiencyType.WOODWORK, Material.LEATHER_HELMET,"Helmet",Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            EquipmentSet.LUMBERJACK_TIER_I),
    WOODWORK_BASIC_SIMPLE_CHESTPLATE(ProficiencyType.WOODWORK, Material.LEATHER_CHESTPLATE,"Chestplate",Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            EquipmentSet.LUMBERJACK_TIER_I),
    WOODWORK_BASIC_SIMPLE_LEGGINGS(ProficiencyType.WOODWORK, Material.LEATHER_LEGGINGS,"Leggings",Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            EquipmentSet.LUMBERJACK_TIER_I),
    WOODWORK_BASIC_SIMPLE_BOOTS(ProficiencyType.WOODWORK, Material.LEATHER_BOOTS,"Boots",Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            EquipmentSet.LUMBERJACK_TIER_I),


    WOODWORK_BASIC_COMMON_AXE(ProficiencyType.WOODWORK,Material.STONE_AXE,"Axe",Rarity.COMMON,"Common lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ConfigurationFlag.EXPERIENCE,2f).addFlag(ConfigurationFlag.LOOT, 1f)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5f).addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_HELMET(ProficiencyType.WOODWORK, Material.CHAINMAIL_HELMET,"Helmet",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5f).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_CHESTPLATE(ProficiencyType.WOODWORK, Material.CHAINMAIL_CHESTPLATE,"Chestplate",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5f).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_LEGGINGS(ProficiencyType.WOODWORK, Material.CHAINMAIL_LEGGINGS,"Leggings",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5f).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_BOOTS(ProficiencyType.WOODWORK, Material.CHAINMAIL_BOOTS,"Boots",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5f).create(),
            EquipmentSet.LUMBERJACK_TIER_II),


    WOODWORK_BASIC_ADVANCED_AXE(ProficiencyType.WOODWORK,Material.IRON_AXE,"Axe",Rarity.ADVANCED,"Advanced lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ConfigurationFlag.EXPERIENCE,3f).addFlag(ConfigurationFlag.LOOT, 1.5f)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10f).addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_HELMET(ProficiencyType.WOODWORK, Material.IRON_HELMET,"Helmet",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10f).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_CHESTPLATE(ProficiencyType.WOODWORK, Material.IRON_CHESTPLATE,"Chestplate",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LOOT, 1f)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10f).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_LEGGINGS(ProficiencyType.WOODWORK, Material.IRON_LEGGINGS,"Leggings",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10f).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_BOOTS(ProficiencyType.WOODWORK, Material.IRON_BOOTS,"Boots",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10f).create(),
            EquipmentSet.LUMBERJACK_TIER_III),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONEWORK_INFINITE_COAL_TIER_I(ProficiencyType.STONEWORK, Material.OAK_WOOD, "Infinite Fuel",Rarity.ADVANCED, "Burns until end of time",
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.BURN_TIME, 0.1f).addFlag(ConfigurationFlag.ENCHANTED).create()),
    STONEWORK_INFINITE_COAL_TIER_II(ProficiencyType.STONEWORK, Material.COAL, "Infinite Fuel",Rarity.ELITE, "Burns until end of time",
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.BURN_TIME, 0.5f).addFlag(ConfigurationFlag.ENCHANTED).create()),
    STONEWORK_INFINITE_COAL_TIER_III(ProficiencyType.STONEWORK, Material.CHARCOAL, "Infinite Fuel",Rarity.EPIC,"Burns until end of time",
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.BURN_TIME, 0.7f).addFlag(ConfigurationFlag.ENCHANTED).create()),
    STONEWORK_INFINITE_COAL_TIER_VI(ProficiencyType.STONEWORK, Material.COAL_BLOCK, "Infinite Fuel",Rarity.LEGENDARY,"Burns until end of time",
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.BURN_TIME, 0.85f).addFlag(ConfigurationFlag.ENCHANTED).create()),



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


    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, ItemConfiguration configuration) {
        this(type,material,name,rarity, "", configuration, EquipmentSet.NONE);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, String lore, ItemConfiguration configuration) {
        this(type,material,name,rarity, List.of(lore), configuration, EquipmentSet.NONE);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, List<String> lore,ItemConfiguration configuration) {
        this(type, material, name, rarity, lore, configuration, EquipmentSet.NONE);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, String lore, ItemConfiguration configuration, EquipmentSet equipmentSet) {
        this(type, material, name, rarity, List.of(lore), configuration, equipmentSet);
    }


    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, List<String> lore, ItemConfiguration configuration, EquipmentSet equipmentSet) {
        this.type = type;
        this.item = new ItemBuilder(material).setName(name).setRarity(rarity).addProficiency(type).addLore(lore).setConfiguration(configuration).setEquipmentSet(equipmentSet).create();
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
            case WOODWORK_BASIC_SIMPLE_AXE -> true;
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
