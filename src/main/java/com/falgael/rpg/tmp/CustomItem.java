package com.falgael.rpg.tmp;

import com.falgael.rpg.items.ConfigurationFlag;
import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import org.bukkit.Material;
import org.bukkit.MusicInstrument;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MusicInstrumentMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public enum CustomItem {

    NONE(ProficiencyType.NONE, Material.AIR,"", Rarity.NONE, null),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------


    IRON_COIN(ProficiencyType.MISC, Material.IRON_NUGGET,"Silver Coin", Rarity.ADVANCED,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()),
    GOLD_COIN(ProficiencyType.MISC, Material.GOLD_NUGGET, "Gold Coin", Rarity.ELITE,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()),
    CRYSTAL_COIN(ProficiencyType.MISC, Material.DIAMOND, "Crystal Coin", Rarity.EPIC,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()),

    STAT_O_METER(ProficiencyType.MISC,Material.AMETHYST_SHARD,"Stat-O-Meter",Rarity.EPIC,
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),

    ADVANCED_WEATHER_CLEAR_CREATOR(ProficiencyType.MISC, Material.GOAT_HORN, "Sunshine creator", Rarity.ADVANCED, "Clears the weather",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_CLEAR, 12000).create(),
            MusicInstrument.SING),
    EPIC_WEATHER_CLEAR_CREATOR(ProficiencyType.MISC, Material.GOAT_HORN, "Sunshine creator", Rarity.EPIC, "Clears the weather",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_CLEAR, 6000).create(),
            MusicInstrument.PONDER),
    EPIC_WEATHER_RAIN_CREATOR(ProficiencyType.MISC, Material.GOAT_HORN, "Rain creator", Rarity.EPIC, "Make it rain",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_RAIN, 6000).create(),
            MusicInstrument.SEEK),
    EPIC_WEATHER_STORM_CREATOR(ProficiencyType.MISC, Material.GOAT_HORN, "Storm creator", Rarity.EPIC, "calls the storm gods",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_THUNDER, 6000).create(),
            MusicInstrument.FEEL),

    EPIC_SEA_BRAIN(ProficiencyType.MISC, Material.HEART_OF_THE_SEA, "Sea Brain", Rarity.EPIC, "Used to build Atlantis",
            new ItemConfiguration.Builder(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addPotionEffect(PotionEffectType.CONDUIT_POWER, 2)
                    .addPotionEffect(PotionEffectType.DOLPHINS_GRACE).create()),

    TEAR_OF_SPEED(ProficiencyType.MISC, Material.GHAST_TEAR, "Tear of speed", Rarity.ADVANCED, "",
            new ItemConfiguration.Builder(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addPotionEffect(PotionEffectType.SPEED).create()),


    KING_MIDAS_CROWN(ProficiencyType.MISC, Material.GOLDEN_HELMET, "Midas Crown", Rarity.EPIC, "A Crown for the richest",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 50).create(),
            EquipmentSet.KING_MIDAS),
    KING_MIDAS_CHEST(ProficiencyType.MISC, Material.GOLDEN_HELMET, "Midas Chest", Rarity.EPIC, "Protects with layered Gold",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 50).create(),
            EquipmentSet.KING_MIDAS),

    KING_MIDAS_SWORD(ProficiencyType.MISC, Material.GOLDEN_SWORD, "Midas Sword", Rarity.EPIC, "Slaughter the poor",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.KING_MIDAS),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    WOODWORK_BASIC_SIMPLE_AXE(ProficiencyType.WOODWORK,Material.WOODEN_AXE,"Axe",Rarity.SIMPLE,"Simple lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
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
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 16)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_HELMET(ProficiencyType.WOODWORK, Material.CHAINMAIL_HELMET,"Helmet",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_CHESTPLATE(ProficiencyType.WOODWORK, Material.CHAINMAIL_CHESTPLATE,"Chestplate",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_LEGGINGS(ProficiencyType.WOODWORK, Material.CHAINMAIL_LEGGINGS,"Leggings",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.LUMBERJACK_TIER_II),
    WOODWORK_BASIC_COMMON_BOOTS(ProficiencyType.WOODWORK, Material.CHAINMAIL_BOOTS,"Boots",Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.LUMBERJACK_TIER_II),


    WOODWORK_BASIC_ADVANCED_AXE(ProficiencyType.WOODWORK,Material.IRON_AXE,"Axe",Rarity.ADVANCED,"Advanced lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.TREE_HARVEST,32)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_HELMET(ProficiencyType.WOODWORK, Material.IRON_HELMET,"Helmet",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_CHESTPLATE(ProficiencyType.WOODWORK, Material.IRON_CHESTPLATE,"Chestplate",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_LEGGINGS(ProficiencyType.WOODWORK, Material.IRON_LEGGINGS,"Leggings",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.LUMBERJACK_TIER_III),
    WOODWORK_BASIC_ADVANCED_BOOTS(ProficiencyType.WOODWORK, Material.IRON_BOOTS,"Boots",Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.LUMBERJACK_TIER_III),


    WOODWORK_BASIC_ELITE_AXE(ProficiencyType.WOODWORK,Material.GOLDEN_AXE,"Axe",Rarity.ELITE,"Elite lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 48)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.LUMBERJACK_TIER_IV),
    WOODWORK_BASIC_ELITE_HELMET(ProficiencyType.WOODWORK, Material.GOLDEN_HELMET,"Helmet",Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.LUMBERJACK_TIER_IV),
    WOODWORK_BASIC_ELITE_CHESTPLATE(ProficiencyType.WOODWORK, Material.GOLDEN_CHESTPLATE,"Chestplate",Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.LUMBERJACK_TIER_IV),
    WOODWORK_BASIC_ELITE_LEGGINGS(ProficiencyType.WOODWORK, Material.GOLDEN_LEGGINGS,"Leggings",Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.LUMBERJACK_TIER_IV),
    WOODWORK_BASIC_ELITE_BOOTS(ProficiencyType.WOODWORK, Material.GOLDEN_BOOTS,"Boots",Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.LUMBERJACK_TIER_IV),


    WOODWORK_BASIC_EPIC_AXE(ProficiencyType.WOODWORK,Material.DIAMOND_AXE,"Axe",Rarity.EPIC,"Epic lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 64)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.LUMBERJACK_TIER_V),
    WOODWORK_BASIC_EPIC_HELMET(ProficiencyType.WOODWORK, Material.DIAMOND_HELMET,"Helmet",Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.LUMBERJACK_TIER_V),
    WOODWORK_BASIC_EPIC_CHESTPLATE(ProficiencyType.WOODWORK, Material.DIAMOND_CHESTPLATE,"Chestplate",Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.LUMBERJACK_TIER_V),
    WOODWORK_BASIC_EPIC_LEGGINGS(ProficiencyType.WOODWORK, Material.DIAMOND_LEGGINGS,"Leggings",Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.LUMBERJACK_TIER_V),
    WOODWORK_BASIC_EPIC_BOOTS(ProficiencyType.WOODWORK, Material.DIAMOND_BOOTS,"Boots",Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.LUMBERJACK_TIER_V),


    WOODWORK_BASIC_LEGENDARY_AXE(ProficiencyType.WOODWORK,Material.NETHERITE_AXE,"Axe",Rarity.LEGENDARY,"Legendary lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 100)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING, 1).create(),
            EquipmentSet.LUMBERJACK_TIER_VI),
    WOODWORK_BASIC_LEGENDARY_HELMET(ProficiencyType.WOODWORK, Material.NETHERITE_HELMET,"Helmet",Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.LUMBERJACK_TIER_VI),
    WOODWORK_BASIC_LEGENDARY_CHESTPLATE(ProficiencyType.WOODWORK, Material.NETHERITE_CHESTPLATE,"Chestplate",Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.LUMBERJACK_TIER_VI),
    WOODWORK_BASIC_LEGENDARY_LEGGINGS(ProficiencyType.WOODWORK, Material.NETHERITE_LEGGINGS,"Leggings",Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.LUMBERJACK_TIER_VI),
    WOODWORK_BASIC_LEGENDARY_BOOTS(ProficiencyType.WOODWORK, Material.NETHERITE_BOOTS,"Boots",Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.LUMBERJACK_TIER_VI),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------


    COMMON_MINERS_HELMET(ProficiencyType.STONEWORK, Material.CHAINMAIL_HELMET, "Miners Helmet", Rarity.COMMON, "enlightens your way in the dark",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 8)
                    .addPotionEffect(PotionEffectType.NIGHT_VISION).create()),
    ADVANCED_MINERS_HELMET(ProficiencyType.STONEWORK, Material.IRON_HELMET, "Miners Helmet", Rarity.ADVANCED, "enlightens your way in the dark",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 12)
                    .addPotionEffect(PotionEffectType.NIGHT_VISION).create()),
    ELITE_MINERS_HELMET(ProficiencyType.STONEWORK, Material.GOLDEN_HELMET, "Miners Helmet", Rarity.ELITE, "enlightens your way in the dark",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                    .addPotionEffect(PotionEffectType.NIGHT_VISION).create()),



    DEEP_MINERS_HELMET(ProficiencyType.STONEWORK, Material.DIAMOND_HELMET,"Deep Miners Helmet",Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40).create(),
            EquipmentSet.DEEP_MINER),
    DEEP_MINERS_CHESTPLATE(ProficiencyType.STONEWORK, Material.DIAMOND_CHESTPLATE,"Deep Miners Chestplate",Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40).create(),
            EquipmentSet.DEEP_MINER),
    DEEP_MINERS_LEGGINGS(ProficiencyType.STONEWORK, Material.DIAMOND_LEGGINGS,"Deep Miners Leggings",Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40).create(),
            EquipmentSet.DEEP_MINER),
    DEEP_MINERS_BOOTS(ProficiencyType.STONEWORK, Material.DIAMOND_BOOTS,"Deep Miners Boots",Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40).create(),
            EquipmentSet.DEEP_MINER),



    STONEWORK_BASIC_SIMPLE_PICKAXE(ProficiencyType.STONEWORK,Material.WOODEN_PICKAXE,"Pickaxe",Rarity.SIMPLE,"Simple miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.MINER_TIER_I),
    STONEWORK_BASIC_SIMPLE_SHOVEL(ProficiencyType.STONEWORK,Material.WOODEN_SHOVEL,"Shovel",Rarity.SIMPLE,"Simple miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5).create(),
            EquipmentSet.MINER_TIER_I),
    STONEWORK_BASIC_SIMPLE_HELMET(ProficiencyType.STONEWORK, Material.LEATHER_HELMET,"Helmet",Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            EquipmentSet.MINER_TIER_I),
    STONEWORK_BASIC_SIMPLE_CHESTPLATE(ProficiencyType.STONEWORK, Material.LEATHER_CHESTPLATE,"Chestplate",Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            EquipmentSet.MINER_TIER_I),
    STONEWORK_BASIC_SIMPLE_LEGGINGS(ProficiencyType.STONEWORK, Material.LEATHER_LEGGINGS,"Leggings",Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            EquipmentSet.MINER_TIER_I),
    STONEWORK_BASIC_SIMPLE_BOOTS(ProficiencyType.STONEWORK, Material.LEATHER_BOOTS,"Boots",Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            EquipmentSet.MINER_TIER_I),


    STONEWORK_BASIC_COMMON_PICKAXE(ProficiencyType.STONEWORK,Material.STONE_PICKAXE,"Pickaxe",Rarity.COMMON,"Common miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.MINER_TIER_II),
    STONEWORK_BASIC_COMMON_SHOVEL(ProficiencyType.STONEWORK,Material.STONE_SHOVEL,"Shovel",Rarity.COMMON,"Common miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.MINER_TIER_II),
    STONEWORK_BASIC_COMMON_HELMET(ProficiencyType.STONEWORK, Material.CHAINMAIL_HELMET,"Helmet",Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5).create(),
            EquipmentSet.MINER_TIER_II),
    STONEWORK_BASIC_COMMON_CHESTPLATE(ProficiencyType.STONEWORK, Material.CHAINMAIL_CHESTPLATE,"Chestplate",Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1).create(),
            EquipmentSet.MINER_TIER_II),
    STONEWORK_BASIC_COMMON_LEGGINGS(ProficiencyType.STONEWORK, Material.CHAINMAIL_LEGGINGS,"Leggings",Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5).create(),
            EquipmentSet.MINER_TIER_II),
    STONEWORK_BASIC_COMMON_BOOTS(ProficiencyType.STONEWORK, Material.CHAINMAIL_BOOTS,"Boots",Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5).create(),
            EquipmentSet.MINER_TIER_II),


    STONEWORK_BASIC_ADVANCED_PICKAXE(ProficiencyType.STONEWORK,Material.IRON_PICKAXE,"Pickaxe",Rarity.ADVANCED,"Advanced miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.MINER_TIER_III),
    STONEWORK_BASIC_ADVANCED_SHOVEL(ProficiencyType.STONEWORK,Material.IRON_SHOVEL,"Shovel",Rarity.ADVANCED,"Advanced miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.MINER_TIER_III),
    STONEWORK_BASIC_ADVANCED_HELMET(ProficiencyType.STONEWORK, Material.IRON_HELMET,"Helmet",Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10).create(),
            EquipmentSet.MINER_TIER_III),
    STONEWORK_BASIC_ADVANCED_CHESTPLATE(ProficiencyType.STONEWORK, Material.IRON_CHESTPLATE,"Chestplate",Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10).create(),
            EquipmentSet.MINER_TIER_III),
    STONEWORK_BASIC_ADVANCED_LEGGINGS(ProficiencyType.STONEWORK, Material.IRON_LEGGINGS,"Leggings",Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10).create(),
            EquipmentSet.MINER_TIER_III),
    STONEWORK_BASIC_ADVANCED_BOOTS(ProficiencyType.STONEWORK, Material.IRON_BOOTS,"Boots",Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10).create(),
            EquipmentSet.MINER_TIER_III),


    STONEWORK_BASIC_ELITE_PICKAXE(ProficiencyType.STONEWORK,Material.GOLDEN_PICKAXE,"Pickaxe",Rarity.ELITE,"Elite miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 8)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.MINER_TIER_IV),
    STONEWORK_BASIC_ELITE_SHOVEL(ProficiencyType.STONEWORK,Material.GOLDEN_SHOVEL,"Shovel",Rarity.ELITE,"Elite miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.MINER_TIER_IV),
    STONEWORK_BASIC_ELITE_HELMET(ProficiencyType.STONEWORK, Material.GOLDEN_HELMET,"Helmet",Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.MINER_TIER_IV),
    STONEWORK_BASIC_ELITE_CHESTPLATE(ProficiencyType.STONEWORK, Material.GOLDEN_CHESTPLATE,"Chestplate",Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.MINER_TIER_IV),
    STONEWORK_BASIC_ELITE_LEGGINGS(ProficiencyType.STONEWORK, Material.GOLDEN_LEGGINGS,"Leggings",Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.MINER_TIER_IV),
    STONEWORK_BASIC_ELITE_BOOTS(ProficiencyType.STONEWORK, Material.GOLDEN_BOOTS,"Boots",Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.MINER_TIER_IV),


    STONEWORK_BASIC_EPIC_PICKAXE(ProficiencyType.STONEWORK,Material.DIAMOND_PICKAXE,"Pickaxe",Rarity.EPIC,"Epic miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 12)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.MINER_TIER_V),
    STONEWORK_BASIC_EPIC_SHOVEL(ProficiencyType.STONEWORK,Material.DIAMOND_SHOVEL,"Shovel",Rarity.EPIC,"Epic miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.MINER_TIER_V),
    STONEWORK_BASIC_EPIC_HELMET(ProficiencyType.STONEWORK, Material.DIAMOND_HELMET,"Helmet",Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.MINER_TIER_V),
    STONEWORK_BASIC_EPIC_CHESTPLATE(ProficiencyType.STONEWORK, Material.DIAMOND_CHESTPLATE,"Chestplate",Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.MINER_TIER_V),
    STONEWORK_BASIC_EPIC_LEGGINGS(ProficiencyType.STONEWORK, Material.DIAMOND_LEGGINGS,"Leggings",Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.MINER_TIER_V),
    STONEWORK_BASIC_EPIC_BOOTS(ProficiencyType.STONEWORK, Material.DIAMOND_BOOTS,"Boots",Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.MINER_TIER_V),


    STONEWORK_BASIC_LEGENDARY_PICKAXE(ProficiencyType.STONEWORK,Material.NETHERITE_PICKAXE,"Pickaxe",Rarity.LEGENDARY,"Legendary miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 20)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.MINER_TIER_VI),
    STONEWORK_BASIC_LEGENDARY_SHOVEL(ProficiencyType.STONEWORK,Material.NETHERITE_SHOVEL,"Shovel",Rarity.LEGENDARY,"Legendary miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.MINER_TIER_VI),
    STONEWORK_BASIC_LEGENDARY_HELMET(ProficiencyType.STONEWORK, Material.NETHERITE_HELMET,"Helmet",Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.MINER_TIER_VI),
    STONEWORK_BASIC_LEGENDARY_CHESTPLATE(ProficiencyType.STONEWORK, Material.NETHERITE_CHESTPLATE,"Chestplate",Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.MINER_TIER_VI),
    STONEWORK_BASIC_LEGENDARY_LEGGINGS(ProficiencyType.STONEWORK, Material.NETHERITE_LEGGINGS,"Leggings",Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.MINER_TIER_VI),
    STONEWORK_BASIC_LEGENDARY_BOOTS(ProficiencyType.STONEWORK, Material.NETHERITE_BOOTS,"Boots",Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.MINER_TIER_VI),

    STONEWORK_INFINITE_COAL_TIER_I(ProficiencyType.STONEWORK, Material.OAK_WOOD, "Infinite Fuel",Rarity.ADVANCED, "Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.1)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),
    STONEWORK_INFINITE_COAL_TIER_II(ProficiencyType.STONEWORK, Material.COAL, "Infinite Fuel",Rarity.ELITE, "Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.5)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),
    STONEWORK_INFINITE_COAL_TIER_III(ProficiencyType.STONEWORK, Material.CHARCOAL, "Infinite Fuel",Rarity.EPIC,"Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.7)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),
    STONEWORK_INFINITE_COAL_TIER_VI(ProficiencyType.STONEWORK, Material.COAL_BLOCK, "Infinite Fuel",Rarity.LEGENDARY,"Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.85)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------


    FARMING_BASIC_SIMPLE_HOE(ProficiencyType.FARMING,Material.WOODEN_HOE,"Hoe",Rarity.SIMPLE,"Simple farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.FARMER_TIER_I),
    FARMING_BASIC_SIMPLE_HELMET(ProficiencyType.FARMING, Material.LEATHER_HELMET,"Helmet",Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            EquipmentSet.FARMER_TIER_I),
    FARMING_BASIC_SIMPLE_CHESTPLATE(ProficiencyType.FARMING, Material.LEATHER_CHESTPLATE,"Chestplate",Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            EquipmentSet.FARMER_TIER_I),
    FARMING_BASIC_SIMPLE_LEGGINGS(ProficiencyType.FARMING, Material.LEATHER_LEGGINGS,"Leggings",Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            EquipmentSet.FARMER_TIER_I),
    FARMING_BASIC_SIMPLE_BOOTS(ProficiencyType.FARMING, Material.LEATHER_BOOTS,"Boots",Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            EquipmentSet.FARMER_TIER_I),


    FARMING_BASIC_COMMON_HOE(ProficiencyType.FARMING,Material.STONE_HOE,"Hoe",Rarity.COMMON,"Common farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.FARMER_TIER_II),
    FARMING_BASIC_COMMON_SHEARS(ProficiencyType.FARMING, Material.SHEARS, "Shears", Rarity.COMMON, "Common farmer shears",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 8).create(),
            EquipmentSet.FARMER_TIER_II),
    FARMING_BASIC_COMMON_SWORD(ProficiencyType.FARMING, Material.STONE_SWORD, "Sword", Rarity.COMMON, "Common farmer knife",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.FARMER_TIER_II),
    FARMING_BASIC_COMMON_HELMET(ProficiencyType.FARMING, Material.CHAINMAIL_HELMET,"Helmet",Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.FARMER_TIER_II),
    FARMING_BASIC_COMMON_CHESTPLATE(ProficiencyType.FARMING, Material.CHAINMAIL_CHESTPLATE,"Chestplate",Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.FARMER_TIER_II),
    FARMING_BASIC_COMMON_LEGGINGS(ProficiencyType.FARMING, Material.CHAINMAIL_LEGGINGS,"Leggings",Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.FARMER_TIER_II),
    FARMING_BASIC_COMMON_BOOTS(ProficiencyType.FARMING, Material.CHAINMAIL_BOOTS,"Boots",Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.FARMER_TIER_II),


    FARMING_BASIC_ADVANCED_HOE(ProficiencyType.FARMING,Material.IRON_HOE,"Hoe",Rarity.ADVANCED,"Advanced farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.FARMER_TIER_III),

    FARMING_BASIC_ADVANCED_FISHING_ROD(ProficiencyType.FARMING, Material.FISHING_ROD, "Fishing Rod", Rarity.ADVANCED, "Advanced farmer fishing rod",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 12)
                    .addPotionEffect(PotionEffectType.LUCK).create(),
            EquipmentSet.FARMER_TIER_III),
    FARMING_BASIC_ADVANCED_SWORD(ProficiencyType.FARMING, Material.IRON_SWORD, "Sword", Rarity.ADVANCED, "Advanced farmer knife",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.FARMER_TIER_III),
    FARMING_BASIC_ADVANCED_HELMET(ProficiencyType.FARMING, Material.IRON_HELMET,"Helmet",Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.FARMER_TIER_III),
    FARMING_BASIC_ADVANCED_CHESTPLATE(ProficiencyType.FARMING, Material.IRON_CHESTPLATE,"Chestplate",Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.FARMER_TIER_III),
    FARMING_BASIC_ADVANCED_LEGGINGS(ProficiencyType.FARMING, Material.IRON_LEGGINGS,"Leggings",Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.FARMER_TIER_III),
    FARMING_BASIC_ADVANCED_BOOTS(ProficiencyType.FARMING, Material.IRON_BOOTS,"Boots",Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.FARMER_TIER_III),


    FARMING_BASIC_ELITE_HOE(ProficiencyType.FARMING,Material.GOLDEN_HOE,"Hoe",Rarity.ELITE,"Elite farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.FARMER_TIER_IV),
    FARMING_BASIC_ELITE_FISHING_ROD(ProficiencyType.FARMING, Material.FISHING_ROD, "Fishing Rod", Rarity.ELITE, "Elite farmer fishing rod",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                    .addPotionEffect(PotionEffectType.LUCK).create(),
            EquipmentSet.FARMER_TIER_IV),
    FARMING_BASIC_ELITE_SWORD(ProficiencyType.FARMING, Material.GOLDEN_SWORD, "Sword", Rarity.ELITE, "Elite farmer knife",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.FARMER_TIER_IV),
    FARMING_BASIC_ELITE_HELMET(ProficiencyType.FARMING, Material.GOLDEN_HELMET,"Helmet",Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.FARMER_TIER_IV),
    FARMING_BASIC_ELITE_CHESTPLATE(ProficiencyType.FARMING, Material.GOLDEN_CHESTPLATE,"Chestplate",Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.FARMER_TIER_IV),
    FARMING_BASIC_ELITE_LEGGINGS(ProficiencyType.FARMING, Material.GOLDEN_LEGGINGS,"Leggings",Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.FARMER_TIER_IV),
    FARMING_BASIC_ELITE_BOOTS(ProficiencyType.FARMING, Material.GOLDEN_BOOTS,"Boots",Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.FARMER_TIER_IV),


    FARMING_BASIC_EPIC_HOE(ProficiencyType.FARMING,Material.DIAMOND_HOE,"Hoe",Rarity.EPIC,"Epic farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING).create(),
            EquipmentSet.FARMER_TIER_V),
    FARMING_BASIC_EPIC_SHEARS(ProficiencyType.FARMING, Material.SHEARS, "Shears", Rarity.EPIC, "Epic farmer shears",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 40).create(),
            EquipmentSet.FARMER_TIER_II),
    FARMING_BASIC_EPIC_HELMET(ProficiencyType.FARMING, Material.DIAMOND_HELMET,"Helmet",Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.FARMER_TIER_V),
    FARMING_BASIC_EPIC_CHESTPLATE(ProficiencyType.FARMING, Material.DIAMOND_CHESTPLATE,"Chestplate",Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.FARMER_TIER_V),
    FARMING_BASIC_EPIC_LEGGINGS(ProficiencyType.FARMING, Material.DIAMOND_LEGGINGS,"Leggings",Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.FARMER_TIER_V),
    FARMING_BASIC_EPIC_BOOTS(ProficiencyType.FARMING, Material.DIAMOND_BOOTS,"Boots",Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.FARMER_TIER_V),


    FARMING_BASIC_LEGENDARY_HOE(ProficiencyType.FARMING,Material.NETHERITE_HOE,"Hoe",Rarity.LEGENDARY,"Legendary farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING, 1).create(),
            EquipmentSet.FARMER_TIER_VI),
    FARMING_BASIC_LEGENDARY_FISHING_ROD(ProficiencyType.FARMING, Material.FISHING_ROD, "Fishing Rod", Rarity.LEGENDARY, "Legendary farmer fishing rod",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 60)
                    .addPotionEffect(PotionEffectType.LUCK,1).create(),
            EquipmentSet.FARMER_TIER_VI),
    FARMING_BASIC_LEGENDARY_HELMET(ProficiencyType.FARMING, Material.NETHERITE_HELMET,"Helmet",Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.FARMER_TIER_VI),
    FARMING_BASIC_LEGENDARY_CHESTPLATE(ProficiencyType.FARMING, Material.NETHERITE_CHESTPLATE,"Chestplate",Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.FARMER_TIER_VI),
    FARMING_BASIC_LEGENDARY_LEGGINGS(ProficiencyType.FARMING, Material.NETHERITE_LEGGINGS,"Leggings",Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.FARMER_TIER_VI),
    FARMING_BASIC_LEGENDARY_BOOTS(ProficiencyType.FARMING, Material.NETHERITE_BOOTS,"Boots",Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.FARMER_TIER_VI),


    BAKERS_HEAD(ProficiencyType.FARMING, Material.IRON_HELMET, "Baker's head", Rarity.ADVANCED, "For every true baker",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15).create(), EquipmentSet.NONE),

    BUTCHER_LEGGINGS(ProficiencyType.FARMING, Material.IRON_LEGGINGS, "Butcher apron", Rarity.ADVANCED, "Protection against animal blood",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,15).create(),
            EquipmentSet.BUTCHER),

    BUTCHER_BOOTS(ProficiencyType.FARMING, Material.IRON_BOOTS, "Butcher boots", Rarity.ADVANCED, "Protection against animal blood",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15).create(),
            EquipmentSet.BUTCHER),


    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------


    NARSIL(ProficiencyType.HUNTING,Material.NETHERITE_SWORD,"Narsil",Rarity.UNIQUE,"The Red and White flame",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 6)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,75)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE, 2)
                    .addPotionEffect(PotionEffectType.REGENERATION)
                    .addPotionEffect(PotionEffectType.ABSORPTION).create(),
            EquipmentSet.NONE),
    
    HUNTING_BASIC_SIMPLE_SWORD(ProficiencyType.HUNTING,Material.WOODEN_SWORD,"Sword",Rarity.SIMPLE,"Simple hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE).create(),
            EquipmentSet.HUNTER_TIER_I),
    HUNTING_BASIC_SIMPLE_HELMET(ProficiencyType.HUNTING, Material.LEATHER_HELMET,"Helmet",Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            EquipmentSet.HUNTER_TIER_I),
    HUNTING_BASIC_SIMPLE_CHESTPLATE(ProficiencyType.HUNTING, Material.LEATHER_CHESTPLATE,"Chestplate",Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            EquipmentSet.HUNTER_TIER_I),
    HUNTING_BASIC_SIMPLE_LEGGINGS(ProficiencyType.HUNTING, Material.LEATHER_LEGGINGS,"Leggings",Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            EquipmentSet.HUNTER_TIER_I),
    HUNTING_BASIC_SIMPLE_BOOTS(ProficiencyType.HUNTING, Material.LEATHER_BOOTS,"Boots",Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            EquipmentSet.HUNTER_TIER_I),


    HUNTING_BASIC_COMMON_SWORD(ProficiencyType.HUNTING,Material.STONE_SWORD,"Sword",Rarity.COMMON,"Common hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE).create(),
            EquipmentSet.HUNTER_TIER_II),
    HUNTING_BASIC_COMMON_BOW(ProficiencyType.HUNTING,Material.BOW,"Bow",Rarity.COMMON,"Common hunter Bow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,7).create(),
            EquipmentSet.HUNTER_TIER_II),
    HUNTING_BASIC_COMMON_HELMET(ProficiencyType.HUNTING, Material.CHAINMAIL_HELMET,"Helmet",Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.HUNTER_TIER_II),
    HUNTING_BASIC_COMMON_CHESTPLATE(ProficiencyType.HUNTING, Material.CHAINMAIL_CHESTPLATE,"Chestplate",Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.HUNTER_TIER_II),
    HUNTING_BASIC_COMMON_LEGGINGS(ProficiencyType.HUNTING, Material.CHAINMAIL_LEGGINGS,"Leggings",Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.HUNTER_TIER_II),
    HUNTING_BASIC_COMMON_BOOTS(ProficiencyType.HUNTING, Material.CHAINMAIL_BOOTS,"Boots",Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            EquipmentSet.HUNTER_TIER_II),


    HUNTING_BASIC_ADVANCED_SWORD(ProficiencyType.HUNTING,Material.IRON_SWORD,"Sword",Rarity.ADVANCED,"Advanced hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE).create(),
            EquipmentSet.HUNTER_TIER_III),
    HUNTING_BASIC_ADVANCED_SHIELD(ProficiencyType.HUNTING, Material.SHIELD, "Shield", Rarity.ADVANCED, "Advanced hunter shield",
            new ItemConfiguration.Builder(EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15).create(),
            EquipmentSet.HUNTER_TIER_III),

    HUNTING_BASIC_ADVANCED_HELMET(ProficiencyType.HUNTING, Material.IRON_HELMET,"Helmet",Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.HUNTER_TIER_III),
    HUNTING_BASIC_ADVANCED_CHESTPLATE(ProficiencyType.HUNTING, Material.IRON_CHESTPLATE,"Chestplate",Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.HUNTER_TIER_III),
    HUNTING_BASIC_ADVANCED_LEGGINGS(ProficiencyType.HUNTING, Material.IRON_LEGGINGS,"Leggings",Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.HUNTER_TIER_III),
    HUNTING_BASIC_ADVANCED_BOOTS(ProficiencyType.HUNTING, Material.IRON_BOOTS,"Boots",Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            EquipmentSet.HUNTER_TIER_III),


    HUNTING_BASIC_ELITE_SWORD(ProficiencyType.HUNTING,Material.GOLDEN_SWORD,"Sword",Rarity.ELITE,"Elite hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE).create(),
            EquipmentSet.HUNTER_TIER_IV),
    HUNTING_BASIC_ELITE_SHIELD(ProficiencyType.HUNTING, Material.SHIELD, "Shield", Rarity.ELITE, "Elite hunter shield",
            new ItemConfiguration.Builder(EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25).create(),
            EquipmentSet.HUNTER_TIER_IV),
    HUNTING_BASIC_ELITE_BOW(ProficiencyType.HUNTING,Material.BOW,"Bow",Rarity.ELITE,"Elite hunter Bow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25).create(),
            EquipmentSet.HUNTER_TIER_IV),
    HUNTING_BASIC_ELITE_CROSSBOW(ProficiencyType.HUNTING,Material.CROSSBOW,"Crossbow",Rarity.ELITE,"Elite hunter Crossbow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25).create(),
            EquipmentSet.HUNTER_TIER_IV),

    HUNTING_BASIC_ELITE_HELMET(ProficiencyType.HUNTING, Material.GOLDEN_HELMET,"Helmet",Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.HUNTER_TIER_IV),
    HUNTING_BASIC_ELITE_CHESTPLATE(ProficiencyType.HUNTING, Material.GOLDEN_CHESTPLATE,"Chestplate",Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.HUNTER_TIER_IV),
    HUNTING_BASIC_ELITE_LEGGINGS(ProficiencyType.HUNTING, Material.GOLDEN_LEGGINGS,"Leggings",Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.HUNTER_TIER_IV),
    HUNTING_BASIC_ELITE_BOOTS(ProficiencyType.HUNTING, Material.GOLDEN_BOOTS,"Boots",Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            EquipmentSet.HUNTER_TIER_IV),


    HUNTING_BASIC_EPIC_SWORD(ProficiencyType.HUNTING,Material.DIAMOND_SWORD,"Sword",Rarity.EPIC,"Epic hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE).create(),
            EquipmentSet.HUNTER_TIER_V),
    HUNTING_BASIC_EPIC_BOW(ProficiencyType.HUNTING,Material.BOW,"Bow",Rarity.EPIC,"Epic hunter Bow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40).create(),
            EquipmentSet.HUNTER_TIER_V),
    HUNTING_BASIC_EPIC_CROSSBOW(ProficiencyType.HUNTING,Material.CROSSBOW,"Crossbow",Rarity.EPIC,"Epic hunter Crossbow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40).create(),
            EquipmentSet.HUNTER_TIER_V),
    HUNTING_BASIC_EPIC_HELMET(ProficiencyType.HUNTING, Material.DIAMOND_HELMET,"Helmet",Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.HUNTER_TIER_V),
    HUNTING_BASIC_EPIC_CHESTPLATE(ProficiencyType.HUNTING, Material.DIAMOND_CHESTPLATE,"Chestplate",Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.HUNTER_TIER_V),
    HUNTING_BASIC_EPIC_LEGGINGS(ProficiencyType.HUNTING, Material.DIAMOND_LEGGINGS,"Leggings",Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.HUNTER_TIER_V),
    HUNTING_BASIC_EPIC_BOOTS(ProficiencyType.HUNTING, Material.DIAMOND_BOOTS,"Boots",Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            EquipmentSet.HUNTER_TIER_V),


    HUNTING_BASIC_LEGENDARY_SWORD(ProficiencyType.HUNTING,Material.NETHERITE_SWORD,"Sword",Rarity.LEGENDARY,"Legendary hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE, 1).create(),
            EquipmentSet.HUNTER_TIER_VI),
    HUNTING_BASIC_LEGENDARY_HELMET(ProficiencyType.HUNTING, Material.NETHERITE_HELMET,"Helmet",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.HUNTER_TIER_VI),
    HUNTING_BASIC_LEGENDARY_CHESTPLATE(ProficiencyType.HUNTING, Material.NETHERITE_CHESTPLATE,"Chestplate",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.HUNTER_TIER_VI),
    HUNTING_BASIC_LEGENDARY_LEGGINGS(ProficiencyType.HUNTING, Material.NETHERITE_LEGGINGS,"Leggings",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.HUNTER_TIER_VI),
    HUNTING_BASIC_LEGENDARY_BOOTS(ProficiencyType.HUNTING, Material.NETHERITE_BOOTS,"Boots",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            EquipmentSet.HUNTER_TIER_VI),
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
    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, String lore, ItemConfiguration configuration, MusicInstrument instrument) {
        this(type, material, name, rarity, List.of(lore), configuration, EquipmentSet.NONE, instrument);
    }


    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, List<String> lore, ItemConfiguration configuration, EquipmentSet equipmentSet) {
        this(type, material, name, rarity, lore, configuration, equipmentSet, null);
    }

    CustomItem(ProficiencyType type, Material material, String name, Rarity rarity, List<String> lore, ItemConfiguration configuration, EquipmentSet equipmentSet, MusicInstrument instrument) {
        this.type = type;
        this.item = new ItemBuilder(material).setName(name).setRarity(rarity).addProficiency(type)
                .addLore(lore).setConfiguration(configuration).setEquipmentSet(equipmentSet).setMusicInstrument(instrument).create();
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
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta == null) continue;
            ItemMeta currentMeta = current.getItem().getItemMeta();
            if (currentMeta == null) continue;


            if (itemMeta instanceof MusicInstrumentMeta ^ currentMeta instanceof MusicInstrumentMeta) continue;
            if (itemMeta instanceof MusicInstrumentMeta itemMusicMeta && currentMeta instanceof MusicInstrumentMeta currentMusicMeta) {
                if (itemMusicMeta.getInstrument() != currentMusicMeta.getInstrument()) continue;
            }

            if (itemMeta.hasDisplayName() ^ currentMeta.hasDisplayName()) continue;
            if (itemMeta.hasDisplayName() && !itemMeta.getDisplayName().equals(currentMeta.getDisplayName())) continue;

            if (!itemMeta.isUnbreakable()) continue;
            if (!itemMeta.getDisplayName().equals(currentMeta.getDisplayName())) continue;

            if (itemMeta.hasLore() ^ currentMeta.hasLore()) continue;
            if (itemMeta.hasLore() && !itemMeta.getLore().equals(currentMeta.getLore())) continue;


            return current;
        }

        return NONE;
    }

    public static boolean isStatOMeter(ItemStack itemStack) {
        if (itemStack == null) return false;
        if (itemStack.getType() != STAT_O_METER.item.getType()) return false;
        if (!itemStack.hasItemMeta()) return false;
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return false;
        if (!itemMeta.hasDisplayName()) return false;
        if (!itemMeta.getDisplayName().equals(STAT_O_METER.getItem().getItemMeta().getDisplayName())) return false;
        return true;
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
        switch (this) {
            case WOODWORK_BASIC_SIMPLE_AXE:
            case WOODWORK_BASIC_COMMON_AXE:
            case WOODWORK_BASIC_ADVANCED_AXE:
            case WOODWORK_BASIC_ELITE_AXE:
            case WOODWORK_BASIC_EPIC_AXE:
            case WOODWORK_BASIC_LEGENDARY_AXE:
            case STONEWORK_BASIC_SIMPLE_PICKAXE:
            case STONEWORK_BASIC_SIMPLE_SHOVEL:
            case STONEWORK_BASIC_COMMON_PICKAXE:
            case STONEWORK_BASIC_COMMON_SHOVEL:
            case STONEWORK_BASIC_ADVANCED_PICKAXE:
            case STONEWORK_BASIC_ADVANCED_SHOVEL:
            case STONEWORK_BASIC_ELITE_PICKAXE:
            case STONEWORK_BASIC_ELITE_SHOVEL:
            case STONEWORK_BASIC_EPIC_PICKAXE:
            case STONEWORK_BASIC_EPIC_SHOVEL:
            case STONEWORK_BASIC_LEGENDARY_PICKAXE:
            case STONEWORK_BASIC_LEGENDARY_SHOVEL:
            case FARMING_BASIC_SIMPLE_HOE:
            case FARMING_BASIC_COMMON_HOE:
            case FARMING_BASIC_ADVANCED_HOE:
            case FARMING_BASIC_ELITE_HOE:
            case FARMING_BASIC_EPIC_HOE:
            case FARMING_BASIC_LEGENDARY_HOE:
                return true;

            default: return false;

        }
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
