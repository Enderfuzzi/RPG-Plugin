package com.falgael.rpg.nousage;

import com.falgael.rpg.items.set.NameBuilding;

@Deprecated
public enum Items implements NameBuilding {
    /*
    NONE(Proficiency.NONE, Material.AIR,"", Rarity.NONE, null),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------


    SILVER_COIN(Proficiency.MISC, Material.IRON_NUGGET, Rarity.ADVANCED,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()
    ),
    GOLD_COIN(Proficiency.MISC, Material.GOLD_NUGGET, Rarity.ELITE,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()
    ),
    CRYSTAL_COIN(Proficiency.MISC, Material.DIAMOND, Rarity.EPIC,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.CURRENCY).create()
    ),

    STAT_O_METER(Proficiency.MISC,Material.AMETHYST_SHARD,Rarity.EPIC,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.ENCHANTED)
                    .create()
    ),

    SUNSHINE_CREATOR_1(Proficiency.MISC, Material.GOAT_HORN, Rarity.ADVANCED, "Have a clear view to the sun",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_CLEAR, 12000)
                    .create(),
            MusicInstrument.SING
    ),
    SUNSHINE_CREATOR_2(Proficiency.MISC, Material.GOAT_HORN, Rarity.EPIC, "Nearly endless sunshine",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_CLEAR, 6000)
                    .create(),
            MusicInstrument.PONDER
    ),
    RAIN_CREATOR(Proficiency.MISC, Material.GOAT_HORN, Rarity.EPIC, "Make it rain",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_RAIN, 6000)
                    .create(),
            MusicInstrument.SEEK
    ),

    STORM_CREATOR(Proficiency.MISC, Material.GOAT_HORN, Rarity.EPIC, "calls the storm gods",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addFlag(ConfigurationFlag.WEATHER_THUNDER, 6000 )
                    .create(),
            MusicInstrument.FEEL
    ),

    SEA_BRAIN(Proficiency.MISC, Material.HEART_OF_THE_SEA, Rarity.EPIC, "Used to build Atlantis",
            new ItemConfiguration.Builder(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addPotionEffect(PotionEffectType.CONDUIT_POWER, 2)
                    .addPotionEffect(PotionEffectType.DOLPHINS_GRACE)
                    .create()
    ),

    TEAR_OF_SPEED(Proficiency.MISC, Material.GHAST_TEAR, Rarity.ADVANCED,
            new ItemConfiguration.Builder(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.ENCHANTED)
                    .addPotionEffect(PotionEffectType.SPEED)
                    .create()
    ),


    KING_MIDAS_CROWN(Proficiency.MISC, Material.GOLDEN_HELMET, Rarity.EPIC, "A Crown for the richest",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 50)
                    .create(),
            OLDItemSet.KING_MIDAS
    ),
    KING_MIDAS_CHEST(Proficiency.MISC, Material.GOLDEN_HELMET, Rarity.EPIC, "Protects with layered Gold",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 50)
                    .create(),
            OLDItemSet.KING_MIDAS
    ),

    KING_MIDAS_SWORD(Proficiency.MISC, Material.GOLDEN_SWORD, "Midas Sword", Rarity.EPIC, "Slaughter the poor",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.KING_MIDAS
    ),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    LUMBERJACK_AXE_1(Proficiency.WOODWORK,Material.WOODEN_AXE,Rarity.SIMPLE,"Simple lumberjack tool",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.LUMBERJACK_1
    ),
    LUMBERJACK_HELMET_1(Proficiency.WOODWORK, Material.LEATHER_HELMET, Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            OLDItemSet.LUMBERJACK_1
    ),
    LUMBERJACK_CHESTPLATE_1(Proficiency.WOODWORK, Material.LEATHER_CHESTPLATE, Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            OLDItemSet.LUMBERJACK_1
    ),
    LUMBERJACK_LEGGINGS_1(Proficiency.WOODWORK, Material.LEATHER_LEGGINGS, Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            OLDItemSet.LUMBERJACK_1
    ),
    LUMBERJACK_BOOTS_1(Proficiency.WOODWORK, Material.LEATHER_BOOTS,Rarity.SIMPLE,"Simple lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            OLDItemSet.LUMBERJACK_1
    ),


    LUMBERJACK_AXE_2(Proficiency.WOODWORK,Material.STONE_AXE, Rarity.COMMON,"Common lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 16)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.LUMBERJACK_2
    ),
    LUMBERJACK_HELMET_2(Proficiency.WOODWORK, Material.CHAINMAIL_HELMET,Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.LUMBERJACK_2
    ),

    LUMBERJACK_CHESTPLATE_2(Proficiency.WOODWORK, Material.CHAINMAIL_CHESTPLATE, Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.LUMBERJACK_2
    ),
    LUMBERJACK_LEGGINGS_2(Proficiency.WOODWORK, Material.CHAINMAIL_LEGGINGS, Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.LUMBERJACK_2
    ),
    LUMBERJACK_BOOTS_2(Proficiency.WOODWORK, Material.CHAINMAIL_BOOTS, Rarity.COMMON,"Common lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.LUMBERJACK_2
    ),


    LUMBERJACK_AXE_3(Proficiency.WOODWORK,Material.IRON_AXE, Rarity.ADVANCED,"Advanced lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.TREE_HARVEST,32)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.LUMBERJACK_3
    ),
    LUMBERJACK_HELMET_3(Proficiency.WOODWORK, Material.IRON_HELMET, Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.LUMBERJACK_3
    ),
    LUMBERJACK_CHESTPLATE_3(Proficiency.WOODWORK, Material.IRON_CHESTPLATE, Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.LUMBERJACK_3
    ),
    LUMBERJACK_LEGGINGS_3(Proficiency.WOODWORK, Material.IRON_LEGGINGS, Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.LUMBERJACK_3
    ),
    LUMBERJACK_BOOTS_3(Proficiency.WOODWORK, Material.IRON_BOOTS, Rarity.ADVANCED,"Advanced lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.LUMBERJACK_3
    ),


    LUMBERJACK_AXE_4(Proficiency.WOODWORK,Material.GOLDEN_AXE,Rarity.ELITE,"Elite lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 48)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.LUMBERJACK_4
    ),
    LUMBERJACK_HELMET_4(Proficiency.WOODWORK, Material.GOLDEN_HELMET, Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.LUMBERJACK_4
    ),
    LUMBERJACK_CHESTPLATE_4(Proficiency.WOODWORK, Material.GOLDEN_CHESTPLATE, Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.LUMBERJACK_4
    ),
    LUMBERJACK_LEGGINGS_4(Proficiency.WOODWORK, Material.GOLDEN_LEGGINGS,Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.LUMBERJACK_4
    ),
    LUMBERJACK_BOOTS_4(Proficiency.WOODWORK, Material.GOLDEN_BOOTS,Rarity.ELITE,"Elite lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.LUMBERJACK_4
    ),


    LUMBERJACK_AXE_5(Proficiency.WOODWORK,Material.DIAMOND_AXE,Rarity.EPIC,"Epic lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 64)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.LUMBERJACK_5
    ),
    LUMBERJACK_HELMET_5(Proficiency.WOODWORK, Material.DIAMOND_HELMET,Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.LUMBERJACK_5
    ),
    LUMBERJACK_CHESTPLATE_5(Proficiency.WOODWORK, Material.DIAMOND_CHESTPLATE, Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            OLDItemSet.LUMBERJACK_5
    ),
    LUMBERJACK_LEGGINGS_5(Proficiency.WOODWORK, Material.DIAMOND_LEGGINGS, Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.LUMBERJACK_5
    ),
    LUMBERJACK_BOOTS_5(Proficiency.WOODWORK, Material.DIAMOND_BOOTS, Rarity.EPIC,"Epic lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            OLDItemSet.LUMBERJACK_5
    ),


    LUMBERJACK_AXE_6(Proficiency.WOODWORK,Material.NETHERITE_AXE, Rarity.LEGENDARY,"Legendary lumberjack axe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.TREE_HARVEST, 100)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING, 1)
                    .create(),
            OLDItemSet.LUMBERJACK_6
    ),
    LUMBERJACK_HELMET_6(Proficiency.WOODWORK, Material.NETHERITE_HELMET, Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            OLDItemSet.LUMBERJACK_6
    ),
    LUMBERJACK_CHESTPLATE_6(Proficiency.WOODWORK, Material.NETHERITE_CHESTPLATE,Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.LUMBERJACK_6
    ),
    LUMBERJACK_LEGGINGS_6(Proficiency.WOODWORK, Material.NETHERITE_LEGGINGS, Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.LUMBERJACK_6
    ),
    LUMBERJACK_BOOTS_6(Proficiency.WOODWORK, Material.NETHERITE_BOOTS, Rarity.LEGENDARY,"Legendary lumberjack protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.LUMBERJACK_6
    ),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------


    MINING_HELMET_1(Proficiency.STONEWORK, Material.CHAINMAIL_HELMET, Rarity.COMMON, "enlightens your way in the dark",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 8)
                    .addPotionEffect(PotionEffectType.NIGHT_VISION)
                    .create()
    ),
    MINING_HELMET_2(Proficiency.STONEWORK, Material.IRON_HELMET, Rarity.ADVANCED, "enlightens your way in the dark",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 12)
                    .addPotionEffect(PotionEffectType.NIGHT_VISION)
                    .create()
    ),
    MINING_HELMET_3(Proficiency.STONEWORK, Material.GOLDEN_HELMET, "Miners Helmet", Rarity.ELITE, "enlightens your way in the dark",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                    .addPotionEffect(PotionEffectType.NIGHT_VISION)
                    .create()
    ),



    DEEP_MINING_HELMET(Proficiency.STONEWORK, Material.DIAMOND_HELMET, Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                    .create(),
            OLDItemSet.DEEP_MINER
    ),
    DEEP_MINING_CHESTPLATE(Proficiency.STONEWORK, Material.DIAMOND_CHESTPLATE, Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40).create(),
            OLDItemSet.DEEP_MINER
    ),
    DEEP_MINING_LEGGINGS(Proficiency.STONEWORK, Material.DIAMOND_LEGGINGS, Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                    .create(),
            OLDItemSet.DEEP_MINER
    ),
    DEEP_MINING_BOOTS(Proficiency.STONEWORK, Material.DIAMOND_BOOTS, Rarity.EPIC,"Deep mining protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                    .create(),
            OLDItemSet.DEEP_MINER
    ),



    MINER_PICKAXE_1(Proficiency.STONEWORK, Material.WOODEN_PICKAXE, Rarity.SIMPLE,"Simple miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.MINER_1
    ),
    MINER_SHOVEL_1(Proficiency.STONEWORK, Material.WOODEN_SHOVEL, Rarity.SIMPLE,"Simple miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .create(),
            OLDItemSet.MINER_1
    ),
    MINER_HELMET_1(Proficiency.STONEWORK, Material.LEATHER_HELMET, Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            OLDItemSet.MINER_1
    ),
    MINER_CHESTPLATE_1(Proficiency.STONEWORK, Material.LEATHER_CHESTPLATE,"Chestplate",Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            OLDItemSet.MINER_1
    ),
    MINER_LEGGINGS_1(Proficiency.STONEWORK, Material.LEATHER_LEGGINGS, Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            OLDItemSet.MINER_1
    ),
    MINER_BOOTS_1(Proficiency.STONEWORK, Material.LEATHER_BOOTS, Rarity.SIMPLE,"Simple miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            OLDItemSet.MINER_1
    ),


    MINER_PICKAXE_2(Proficiency.STONEWORK, Material.STONE_PICKAXE, Rarity.COMMON,"Common miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.MINER_2
    ),
    MINER_SHOVEL_2(Proficiency.STONEWORK, Material.STONE_SHOVEL, Rarity.COMMON,"Common miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.MINER_2
    ),
    MINER_HELMET_2(Proficiency.STONEWORK, Material.CHAINMAIL_HELMET, Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5).create(),
            OLDItemSet.MINER_2
    ),
    MINER_CHESTPLATE_2(Proficiency.STONEWORK, Material.CHAINMAIL_CHESTPLATE, Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .create(),
            OLDItemSet.MINER_2
    ),
    MINER_LEGGINGS_2(Proficiency.STONEWORK, Material.CHAINMAIL_LEGGINGS, Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5).create(),
            OLDItemSet.MINER_2
    ),
    MINER_BOOTS_2(Proficiency.STONEWORK, Material.CHAINMAIL_BOOTS, Rarity.SIMPLE,"Common miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5).create(),
            OLDItemSet.MINER_2
    ),


    MINER_PICKAXE_3(Proficiency.STONEWORK, Material.IRON_PICKAXE, Rarity.ADVANCED,"Advanced miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.MINER_3
    ),
    MINER_SHOVEL_3(Proficiency.STONEWORK, Material.IRON_SHOVEL, Rarity.ADVANCED,"Advanced miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.MINER_3
    ),
    MINER_HELMET_3(Proficiency.STONEWORK, Material.IRON_HELMET, Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                    .create(),
            OLDItemSet.MINER_3
    ),
    MINER_CHESTPLATE_3(Proficiency.STONEWORK, Material.IRON_CHESTPLATE, Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                    .create(),
            OLDItemSet.MINER_3
    ),
    MINER_LEGGINGS_3(Proficiency.STONEWORK, Material.IRON_LEGGINGS, Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                    .create(),
            OLDItemSet.MINER_3
    ),
    MINER_BOOTS_3(Proficiency.STONEWORK, Material.IRON_BOOTS, Rarity.ADVANCED,"Advanced miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                    .create(),
            OLDItemSet.MINER_3
    ),


    MINER_PICKAXE_4(Proficiency.STONEWORK, Material.GOLDEN_PICKAXE, Rarity.ELITE,"Elite miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 8)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.MINER_4
    ),
    MINER_SHOVEL_4(Proficiency.STONEWORK,Material.GOLDEN_SHOVEL, Rarity.ELITE,"Elite miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            OLDItemSet.MINER_4
    ),
    MINER_HELMET_4(Proficiency.STONEWORK, Material.GOLDEN_HELMET,Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            OLDItemSet.MINER_4
    ),
    MINER_CHESTPLATE_4(Proficiency.STONEWORK, Material.GOLDEN_CHESTPLATE, Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20).create(),
            OLDItemSet.MINER_4
    ),
    MINER_LEGGINGS_4(Proficiency.STONEWORK, Material.GOLDEN_LEGGINGS, Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.MINER_4
    ),
    MINER_BOOTS_4(Proficiency.STONEWORK, Material.GOLDEN_BOOTS, Rarity.ELITE,"Elite miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.MINER_4
    ),


    MINER_PICKAXE_5(Proficiency.STONEWORK, Material.DIAMOND_PICKAXE, Rarity.EPIC,"Epic miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 12)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.MINER_5
    ),
    MINER_SHOVEL_5(Proficiency.STONEWORK, Material.DIAMOND_SHOVEL, Rarity.EPIC,"Epic miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.MINER_5
    ),
    MINER_HELMET_5(Proficiency.STONEWORK, Material.DIAMOND_HELMET, Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.MINER_5
    ),
    MINER_CHESTPLATE_5(Proficiency.STONEWORK, Material.DIAMOND_CHESTPLATE, Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.MINER_5
    ),
    MINER_LEGGINGS_5(Proficiency.STONEWORK, Material.DIAMOND_LEGGINGS, Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.MINER_5
    ),
    MINER_BOOTS_5(Proficiency.STONEWORK, Material.DIAMOND_BOOTS, Rarity.EPIC,"Epic miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.MINER_5
    ),


    MINER_PICKAXE_6(Proficiency.STONEWORK, Material.NETHERITE_PICKAXE, Rarity.LEGENDARY,"Legendary miner pickaxe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.VEIN_MINING, 20)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.MINER_6
    ),
    MINER_SHOVEL_6(Proficiency.STONEWORK, Material.NETHERITE_SHOVEL, Rarity.LEGENDARY,"Legendary miner shovel",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.MINER_6
    ),
    MINER_HELMET_6(Proficiency.STONEWORK, Material.NETHERITE_HELMET, Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.MINER_6
    ),
    MINER_CHESTPLATE_6(Proficiency.STONEWORK, Material.NETHERITE_CHESTPLATE, Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.MINER_6
    ),
    MINER_LEGGINGS_6(Proficiency.STONEWORK, Material.NETHERITE_LEGGINGS, Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.MINER_6
    ),
    MINER_BOOTS_6(Proficiency.STONEWORK, Material.NETHERITE_BOOTS, Rarity.LEGENDARY,"Legendary miner protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.MINER_6
    ),

    INFINITE_FUEL_1(Proficiency.STONEWORK, Material.OAK_WOOD, Rarity.ADVANCED, "Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.1)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),
    INFINITE_FUEL_2(Proficiency.STONEWORK, Material.COAL, Rarity.ELITE, "Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.5)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),
    INFINITE_FUEL_3(Proficiency.STONEWORK, Material.CHARCOAL, Rarity.EPIC,"Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.7)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),
    INFINITE_FUEL_4(Proficiency.STONEWORK, Material.COAL_BLOCK, Rarity.LEGENDARY,"Burns until end of time",
            new ItemConfiguration.Builder()
                    .addFlag(ConfigurationFlag.BURN_TIME, 0.85)
                    .addFlag(ConfigurationFlag.ENCHANTED).create()),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------


    FARMER_HOE_1(Proficiency.FARMING, Material.WOODEN_HOE, Rarity.SIMPLE,"Simple farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.FARMER_1
    ),
    FARMER_HELMET_1(Proficiency.FARMING, Material.LEATHER_HELMET, Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            OLDItemSet.FARMER_1
    ),
    FARMER_CHESTPLATE_1(Proficiency.FARMING, Material.LEATHER_CHESTPLATE, Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            OLDItemSet.FARMER_1
    ),
    FARMER_LEGGINGS_1(Proficiency.FARMING, Material.LEATHER_LEGGINGS, Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            OLDItemSet.FARMER_1
    ),
    FARMER_BOOTS_1(Proficiency.FARMING, Material.LEATHER_BOOTS, Rarity.SIMPLE,"Simple farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            OLDItemSet.FARMER_1
    ),


    FARMER_HOE_2(Proficiency.FARMING, Material.STONE_HOE, Rarity.COMMON,"Common farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.FARMER_2
    ),
    FARMER_SHEARS_1(Proficiency.FARMING, Material.SHEARS, Rarity.COMMON, "Common farmer shears",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 8)
                    .create(),
            OLDItemSet.FARMER_2
    ),
    FARMER_SWORD_1(Proficiency.FARMING, Material.STONE_SWORD, Rarity.COMMON, "Common farmer knife",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.FARMER_2
    ),
    FARMER_HELMET_2(Proficiency.FARMING, Material.CHAINMAIL_HELMET, Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.FARMER_2
    ),
    FARMER_CHESTPLATE_2(Proficiency.FARMING, Material.CHAINMAIL_CHESTPLATE, Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.FARMER_2
    ),
    FARMER_LEGGINGS_2(Proficiency.FARMING, Material.CHAINMAIL_LEGGINGS, Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.FARMER_2
    ),
    FARMER_BOOTS_2(Proficiency.FARMING, Material.CHAINMAIL_BOOTS, Rarity.COMMON,"Common farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .create(),
            OLDItemSet.FARMER_2
    ),


    FARMER_HOE_3(Proficiency.FARMING, Material.IRON_HOE, Rarity.ADVANCED,"Advanced farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.FARMER_3
    ),

    FARMER_FISHING_ROD_1(Proficiency.FARMING, Material.FISHING_ROD, Rarity.ADVANCED, "Advanced farmer fishing rod",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 12)
                    .addPotionEffect(PotionEffectType.LUCK)
                    .create(),
            OLDItemSet.FARMER_3
    ),
    FARMER_SWORD_2(Proficiency.FARMING, Material.IRON_SWORD, Rarity.ADVANCED, "Advanced farmer knife",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.FARMER_3
    ),
    FARMER_HELMET_3(Proficiency.FARMING, Material.IRON_HELMET,"Helmet",Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            OLDItemSet.FARMER_3
    ),
    FARMER_CHESTPLATE_3(Proficiency.FARMING, Material.IRON_CHESTPLATE,"Chestplate",Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            OLDItemSet.FARMER_3
    ),
    FARMER_LEGGINGS_3(Proficiency.FARMING, Material.IRON_LEGGINGS,"Leggings",Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            OLDItemSet.FARMER_3
    ),
    FARMER_BOOTS_3(Proficiency.FARMING, Material.IRON_BOOTS, Rarity.ADVANCED,"Advanced farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            OLDItemSet.FARMER_3
    ),


    FARMER_HOE_4(Proficiency.FARMING, Material.GOLDEN_HOE, Rarity.ELITE,"Elite farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.FARMER_4
    ),
    FARMER_FISHING_ROD_2(Proficiency.FARMING, Material.FISHING_ROD, Rarity.ELITE, "Elite farmer fishing rod",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                    .addPotionEffect(PotionEffectType.LUCK)
                    .create(),
            OLDItemSet.FARMER_4
    ),
    FARMER_SWORD_3(Proficiency.FARMING, Material.GOLDEN_SWORD, Rarity.ELITE, "Elite farmer knife",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.FARMER_4
    ),
    FARMER_HELMET_4(Proficiency.FARMING, Material.GOLDEN_HELMET, Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.FARMER_4
    ),
    FARMER_CHESTPLATE_4(Proficiency.FARMING, Material.GOLDEN_CHESTPLATE, Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.FARMER_4
    ),
    FARMER_LEGGINGS_4(Proficiency.FARMING, Material.GOLDEN_LEGGINGS, Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.FARMER_4
    ),
    FARMER_BOOTS_4(Proficiency.FARMING, Material.GOLDEN_BOOTS, Rarity.ELITE,"Elite farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.FARMER_4
    ),


    FARMER_HOE_5(Proficiency.FARMING, Material.DIAMOND_HOE, Rarity.EPIC,"Epic farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING)
                    .create(),
            OLDItemSet.FARMER_5
    ),
    FARMER_SHEARS_2(Proficiency.FARMING, Material.SHEARS, Rarity.EPIC, "Epic farmer shears",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 40)
                    .create(),
            OLDItemSet.FARMER_2
    ),
    FARMER_HELMET_5(Proficiency.FARMING, Material.DIAMOND_HELMET, Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.FARMER_5
    ),
    FARMER_CHESTPLATE_5(Proficiency.FARMING, Material.DIAMOND_CHESTPLATE, Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.FARMER_5
    ),
    FARMER_LEGGINGS_5(Proficiency.FARMING, Material.DIAMOND_LEGGINGS, Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.FARMER_5
    ),
    FARMER_BOOTS_5(Proficiency.FARMING, Material.DIAMOND_BOOTS, Rarity.EPIC,"Epic farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35).create(),
            OLDItemSet.FARMER_5
    ),


    FARMER_HOE_6(Proficiency.FARMING,Material.NETHERITE_HOE, Rarity.LEGENDARY,"Legendary farmer hoe",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.CROP_HARVEST)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.FAST_DIGGING, 1)
                    .create(),
            OLDItemSet.FARMER_6
    ),
    FARMER_FISHING_ROD_3(Proficiency.FARMING, Material.FISHING_ROD, Rarity.LEGENDARY, "Legendary farmer fishing rod",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 60)
                    .addPotionEffect(PotionEffectType.LUCK,1)
                    .create(),
            OLDItemSet.FARMER_6
    ),
    FARMER_HELMET_6(Proficiency.FARMING, Material.NETHERITE_HELMET, Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            OLDItemSet.FARMER_6),
    FARMER_CHESTPLATE_6(Proficiency.FARMING, Material.NETHERITE_CHESTPLATE, Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            OLDItemSet.FARMER_6),
    FARMER_LEGGINGS_6(Proficiency.FARMING, Material.NETHERITE_LEGGINGS, Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            OLDItemSet.FARMER_6),
    FARMER_BOOTS_6(Proficiency.FARMING, Material.NETHERITE_BOOTS, Rarity.LEGENDARY,"Legendary farmer protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55).create(),
            OLDItemSet.FARMER_6),


    BAKERS_HEAD(Proficiency.FARMING, Material.IRON_HELMET, "Baker's head", Rarity.ADVANCED, "For every true baker",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15).create(), OLDItemSet.NONE),

    BUTCHER_LEGGINGS(Proficiency.FARMING, Material.IRON_LEGGINGS, "Butcher apron", Rarity.ADVANCED, "Protection against animal blood",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,15).create(),
            OLDItemSet.BUTCHER),

    BUTCHER_BOOTS(Proficiency.FARMING, Material.IRON_BOOTS, "Butcher boots", Rarity.ADVANCED, "Protection against animal blood",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15).create(),
            OLDItemSet.BUTCHER),


    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------


    NARSIL(Proficiency.HUNTING, Material.NETHERITE_SWORD, Rarity.UNIQUE,"The Red and White flame",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 6)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,75)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE, 2)
                    .addPotionEffect(PotionEffectType.REGENERATION)
                    .addPotionEffect(PotionEffectType.ABSORPTION)
                    .create()
    ),
    
    HUNTER_SWORD_1(Proficiency.HUNTING, Material.WOODEN_SWORD, Rarity.SIMPLE,"Simple hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 0.5)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE)
                    .create(),
            OLDItemSet.HUNTER_1
    ),
    HUNTER_HELMET_1(Proficiency.HUNTING, Material.LEATHER_HELMET, Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
            OLDItemSet.HUNTER_1
    ),
    HUNTER_CHESTPLATE_1(Proficiency.HUNTING, Material.LEATHER_CHESTPLATE, Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
            OLDItemSet.HUNTER_1
    ),
    HUNTER_LEGGINGS_1(Proficiency.HUNTING, Material.LEATHER_LEGGINGS, Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
            OLDItemSet.HUNTER_1
    ),
    HUNTER_BOOTS_1(Proficiency.HUNTING, Material.LEATHER_BOOTS, Rarity.SIMPLE,"Simple hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
            OLDItemSet.HUNTER_1
    ),


    HUNTER_SWORD_2(Proficiency.HUNTING, Material.STONE_SWORD, Rarity.COMMON,"Common hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE)
                    .create(),
            OLDItemSet.HUNTER_2
    ),
    HUNTER_BOW_1(Proficiency.HUNTING,Material.BOW, Rarity.COMMON,"Common hunter Bow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 0.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,7).create(),
            OLDItemSet.HUNTER_2
    ),
    HUNTER_HELMET_2(Proficiency.HUNTING, Material.CHAINMAIL_HELMET, Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            OLDItemSet.HUNTER_2
    ),
    HUNTER_CHESTPLATE_2(Proficiency.HUNTING, Material.CHAINMAIL_CHESTPLATE, Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            OLDItemSet.HUNTER_2
    ),
    HUNTER_LEGGINGS_2(Proficiency.HUNTING, Material.CHAINMAIL_LEGGINGS, Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            OLDItemSet.HUNTER_2
    ),
    HUNTER_BOOTS_2(Proficiency.HUNTING, Material.CHAINMAIL_BOOTS, Rarity.COMMON,"Common hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5).create(),
            OLDItemSet.HUNTER_2
    ),


    HUNTER_SWORD_3(Proficiency.HUNTING,Material.IRON_SWORD, Rarity.ADVANCED,"Advanced hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1.5)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE).create(),
            OLDItemSet.HUNTER_3
    ),
    HUNTER_SHIELD_1(Proficiency.HUNTING, Material.SHIELD, Rarity.ADVANCED, "Advanced hunter shield",
            new ItemConfiguration.Builder(EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15).create(),
            OLDItemSet.HUNTER_3
    ),

    HUNTER_HELMET_3(Proficiency.HUNTING, Material.IRON_HELMET, Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            OLDItemSet.HUNTER_3
    ),
    HUNTER_CHESTPLATE_3(Proficiency.HUNTING, Material.IRON_CHESTPLATE, Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10).create(),
            OLDItemSet.HUNTER_3
    ),
    HUNTER_LEGGINGS_3(Proficiency.HUNTING, Material.IRON_LEGGINGS, Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.HUNTER_3
    ),
    HUNTER_BOOTS_3(Proficiency.HUNTING, Material.IRON_BOOTS, Rarity.ADVANCED,"Advanced hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                    .create(),
            OLDItemSet.HUNTER_3
    ),


    HUNTER_SWORD_4(Proficiency.HUNTING, Material.GOLDEN_SWORD, Rarity.ELITE,"Elite hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE)
                    .create(),
            OLDItemSet.HUNTER_4
    ),
    HUNTER_SHIELD_2(Proficiency.HUNTING, Material.SHIELD, Rarity.ELITE, "Elite hunter shield",
            new ItemConfiguration.Builder(EquipmentSlot.OFF_HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                    .create(),
            OLDItemSet.HUNTER_4
    ),
    HUNTER_BOW_2(Proficiency.HUNTING,Material.BOW, Rarity.ELITE,"Elite hunter Bow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
                    .create(),
            OLDItemSet.HUNTER_4
    ),
    HUNTER_CROSSBOW_1(Proficiency.HUNTING,Material.CROSSBOW, Rarity.ELITE,"Elite hunter Crossbow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
                    .create(),
            OLDItemSet.HUNTER_4),

    HUNTER_HELMET_4(Proficiency.HUNTING, Material.GOLDEN_HELMET, Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.HUNTER_4),
    HUNTER_CHESTPLATE_4(Proficiency.HUNTING, Material.GOLDEN_CHESTPLATE, Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.HUNTER_4),
    HUNTER_LEGGINGS_4(Proficiency.HUNTING, Material.GOLDEN_LEGGINGS, Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.HUNTER_4),
    HUNTER_BOOTS_4(Proficiency.HUNTING, Material.GOLDEN_BOOTS, Rarity.ELITE,"Elite hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                    .create(),
            OLDItemSet.HUNTER_4),


    HUNTER_SWORD_5(Proficiency.HUNTING,Material.DIAMOND_SWORD, Rarity.EPIC,"Epic hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1.5)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE)
                    .create(),
            OLDItemSet.HUNTER_5
    ),
    HUNTER_BOW_3(Proficiency.HUNTING,Material.BOW, Rarity.EPIC,"Epic hunter Bow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                    .create(),
            OLDItemSet.HUNTER_5
    ),
    HUNTER_CROSSBOW_2(Proficiency.HUNTING,Material.CROSSBOW, Rarity.EPIC,"Epic hunter Crossbow",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,5)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                    .create(),
            OLDItemSet.HUNTER_5
    ),
    HUNTER_HELMET_5(Proficiency.HUNTING, Material.DIAMOND_HELMET, Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.HUNTER_5
    ),
    HUNTER_CHESTPLATE_5(Proficiency.HUNTING, Material.DIAMOND_CHESTPLATE, Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.HUNTER_5
    ),
    HUNTER_LEGGINGS_5(Proficiency.HUNTING, Material.DIAMOND_LEGGINGS, Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.HUNTER_5
    ),
    HUNTER_BOOTS_5(Proficiency.HUNTING, Material.DIAMOND_BOOTS, Rarity.EPIC,"Epic hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                    .create(),
            OLDItemSet.HUNTER_5
    ),


    HUNTER_SWORD_6(Proficiency.HUNTING,Material.NETHERITE_SWORD, Rarity.LEGENDARY,"Legendary hunter Sword",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,6)
                    .addFlag(ConfigurationFlag.LOOT, 5)
                    .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .addPotionEffect(PotionEffectType.INCREASE_DAMAGE, 1)
                    .create(),
            OLDItemSet.HUNTER_6
    ),
    HUNTER_HELMET_6(Proficiency.HUNTING, Material.NETHERITE_HELMET,"Helmet",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.HUNTER_6
    ),
    HUNTER_CHESTPLATE_6(Proficiency.HUNTING, Material.NETHERITE_CHESTPLATE,"Chestplate",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                    .addFlag(ConfigurationFlag.EXPERIENCE,4)
                    .addFlag(ConfigurationFlag.LOOT, 3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.HUNTER_6
    ),
    HUNTER_LEGGINGS_6(Proficiency.HUNTING, Material.NETHERITE_LEGGINGS,"Leggings",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LOOT,1)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.HUNTER_6
    ),
    HUNTER_BOOTS_6(Proficiency.HUNTING, Material.NETHERITE_BOOTS,"Boots",Rarity.LEGENDARY,"Legendary hunter protection",
            new ItemConfiguration.Builder(EquipmentSlot.FEET)
                    .addFlag(ConfigurationFlag.EXPERIENCE,3)
                    .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                    .create(),
            OLDItemSet.HUNTER_6
    ),
    ;

    private static final Items[] COPY = Items.values();

    private static final HashMap<Proficiency, ArrayList<Items>> GROUPED_BY_PROFICIENCY = new HashMap<>();

    private static final HashMap<OLDItemSet, ArrayList<Items>> EQUIPMENT_SET_MAP = new HashMap<>();

    static {
            for (Items current : Items.values()) {
                if (!EQUIPMENT_SET_MAP.containsKey(current.itemSet)) {
                    EQUIPMENT_SET_MAP.put(current.itemSet, new ArrayList<>());
                }
                EQUIPMENT_SET_MAP.get(current.itemSet).add(current);

                if (!GROUPED_BY_PROFICIENCY.containsKey(current.proficiencies)) {
                    GROUPED_BY_PROFICIENCY.put(current.proficiencies.get(0), new ArrayList<>());
                }
                GROUPED_BY_PROFICIENCY.get(current.proficiencies).add(current);
            }
    }

    private final List<Proficiency> proficiencies;

    private final ItemStack item;

    private final ItemConfiguration configuration;

    private final OLDItemSet itemSet;


    Items(Proficiency type, Material material, String name, Rarity rarity, ItemConfiguration configuration) {
        this(type,material,name,rarity, "", configuration, OLDItemSet.NONE);
    }
    Items(Proficiency type, Material material, Rarity rarity, ItemConfiguration configuration) {
        this(type,material,null,rarity, "", configuration, OLDItemSet.NONE);
    }

    Items(Proficiency type, Material material, String name, Rarity rarity, String lore, ItemConfiguration configuration) {
        this(type,material,name,rarity, List.of(lore), configuration, OLDItemSet.NONE);
    }

    Items(Proficiency type, Material material, Rarity rarity, String lore, ItemConfiguration configuration) {
        this(type,material,null,rarity, List.of(lore), configuration, OLDItemSet.NONE);
    }

    Items(Proficiency type, Material material, Rarity rarity, List<String> lore, ItemConfiguration configuration, OLDItemSet itemSet) {
        this(type, material,null , rarity, lore, configuration, OLDItemSet.NONE);
    }

    Items(Proficiency type, Material material, String name, Rarity rarity, String lore, ItemConfiguration configuration, OLDItemSet itemSet) {
        this(type, material, name, rarity, List.of(lore), configuration, itemSet);
    }

    Items(Proficiency type, Material material, Rarity rarity, String lore, ItemConfiguration configuration, OLDItemSet itemSet) {
        this(type, material, null, rarity, List.of(lore), configuration, itemSet);
    }

    Items(Proficiency type, Material material, String name, Rarity rarity, String lore, ItemConfiguration configuration, MusicInstrument instrument) {
        this(type, material, name, rarity, List.of(lore), configuration, OLDItemSet.NONE, instrument);
    }
    Items(Proficiency type, Material material, Rarity rarity, String lore, ItemConfiguration configuration, MusicInstrument instrument) {
        this(type, material, null, rarity, List.of(lore), configuration, OLDItemSet.NONE, instrument);
    }


    Items(Proficiency type, Material material, String name, Rarity rarity, List<String> lore, ItemConfiguration configuration, OLDItemSet itemSet) {
        this(type, material, name, rarity, lore, configuration, itemSet, null);
    }

    Items(Proficiency proficiency, Material material, String name, Rarity rarity, List<String> lore, ItemConfiguration configuration, OLDItemSet itemSet, MusicInstrument instrument) {
        this(List.of(proficiency), material, name, rarity, lore,configuration,itemSet,instrument);
    }

    Items(List<Proficiency> proficiencies, Material material, String name, Rarity rarity, List<String> lore, ItemConfiguration configuration, OLDItemSet itemSet, MusicInstrument instrument) {
        this.proficiencies = proficiencies;
        if (name == null) name = buildName(this.name());
        this.item = new ItemBuilder(material).setName(name).setRarity(rarity).addProficiency(this.proficiencies)
                .addLore(lore).setConfiguration(configuration).setEquipmentSet(itemSet).setMusicInstrument(instrument).create();
        this.configuration = configuration;
        this.itemSet = itemSet;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public boolean hasProficiency(Proficiency proficiency) {
        return proficiency == Proficiency.MISC || proficiency == Proficiency.NONE || hasExactProficiency(proficiency);
    }

    public boolean hasExactProficiency(Proficiency proficiency) {
        return proficiencies.contains(proficiency);
    }

    public boolean hasConfiguration() {
        return configuration != null;
    }

    public ItemConfiguration getConfiguration() {
        return configuration;
    }


    public ItemStack getItemByKey() {
        return item;
    }


    public boolean hasEquipmentSet() {
        return this.itemSet != OLDItemSet.NONE;
    }

    public OLDItemSet getEquipmentSet() {
        return this.itemSet;
    }


    public static Items getItemByKey(ItemStack itemStack) {
        if (itemStack == null) return NONE;

        for (Items current : COPY) {
            if (itemStack.getType() != current.getItemByKey().getType()) continue;
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta == null) continue;
            if (!itemMeta.isUnbreakable()) continue;
            ItemMeta currentMeta = current.getItemByKey().getItemMeta();
            if (currentMeta == null) continue;

            if (itemMeta instanceof MusicInstrumentMeta ^ currentMeta instanceof MusicInstrumentMeta) continue;
            if (itemMeta instanceof MusicInstrumentMeta itemMusicMeta && currentMeta instanceof MusicInstrumentMeta currentMusicMeta) {
                if (itemMusicMeta.getInstrument() != currentMusicMeta.getInstrument()) continue;
            }
            if (itemMeta.hasDisplayName() ^ currentMeta.hasDisplayName()) continue;
            if (itemMeta.hasDisplayName() && !itemMeta.getDisplayName().equals(currentMeta.getDisplayName())) continue;

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
        if (!itemMeta.getDisplayName().equals(STAT_O_METER.getItemByKey().getItemMeta().getDisplayName())) return false;
        return true;
    }

    public ArrayList<Items> getItemsOfSet() {
        return EQUIPMENT_SET_MAP.getOrDefault(itemSet, new ArrayList<>());
    }

    public static ArrayList<Items> getItemsOfSet(OLDItemSet itemSet) {
        return EQUIPMENT_SET_MAP.getOrDefault(itemSet, new ArrayList<>());
    }

    public static ArrayList<Items> getItemsOfProficiency(Proficiency type) {
        return GROUPED_BY_PROFICIENCY.getOrDefault(type, new ArrayList<>());
    }

    public boolean isBreakingTool() {
        switch (this) {
            case LUMBERJACK_AXE_1:
            case LUMBERJACK_AXE_2:
            case LUMBERJACK_AXE_3:
            case LUMBERJACK_AXE_4:
            case LUMBERJACK_AXE_5:
            case LUMBERJACK_AXE_6:
            case MINER_PICKAXE_1:
            case MINER_SHOVEL_1:
            case MINER_PICKAXE_2:
            case MINER_SHOVEL_2:
            case MINER_PICKAXE_3:
            case MINER_SHOVEL_3:
            case MINER_PICKAXE_4:
            case MINER_SHOVEL_4:
            case MINER_PICKAXE_5:
            case MINER_SHOVEL_5:
            case MINER_PICKAXE_6:
            case MINER_SHOVEL_6:
            case FARMER_HOE_1:
            case FARMER_HOE_2:
            case FARMER_HOE_3:
            case FARMER_HOE_4:
            case FARMER_HOE_5:
            case FARMER_HOE_6:
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


     */
}
