package com.falgael.rpg.tmp;

import com.falgael.rpg.items.ConfigurationFlag;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.ItemConfiguration;

import java.util.ArrayList;
import java.util.List;

public enum EquipmentSet {

    NONE("", ProficiencyType.NONE, Rarity.NONE, 0, null, ""),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    LUMBERJACK_TIER_I("Lumberjack I", ProficiencyType.WOODWORK, Rarity.SIMPLE,5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 1f).addFlag(ConfigurationFlag.LOOT,0.5f).create(),
            "For wood specialists"),
    LUMBERJACK_TIER_II("Lumberjack II", ProficiencyType.WOODWORK, Rarity.COMMON,5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 1f).addFlag(ConfigurationFlag.LOOT,1f).create(),
            "For wood specialists"),
    LUMBERJACK_TIER_III("Lumberjack III", ProficiencyType.WOODWORK, Rarity.ADVANCED,5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 2f).addFlag(ConfigurationFlag.LOOT,1.5f).create(),
            "For wood specialists"),
    LUMBERJACK_TIER_IV("Lumberjack IV", ProficiencyType.WOODWORK, Rarity.ELITE,5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 2f).addFlag(ConfigurationFlag.LOOT,2f).create(),
            "For wood specialists"),
    LUMBERJACK_TIER_V("Lumberjack V", ProficiencyType.WOODWORK, Rarity.EPIC,5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 3f).addFlag(ConfigurationFlag.LOOT,3f).create(),
            "For wood specialists"),
    LUMBERJACK_TIER_VI("Lumberjack VI", ProficiencyType.WOODWORK, Rarity.LEGENDARY,5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 5f).addFlag(ConfigurationFlag.LOOT,4f).create(),
            "For wood specialists"),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    MINER_TIER_I("Miner I", ProficiencyType.STONEWORK, Rarity.SIMPLE, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LOOT, 0.5f).create(),
            "For stone specialists"),
    MINER_TIER_II("Miner II", ProficiencyType.STONEWORK, Rarity.COMMON, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LOOT, 1f).create(),
            "For stone specialists"),
    MINER_TIER_III("Miner III", ProficiencyType.STONEWORK, Rarity.ADVANCED, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,2f).addFlag(ConfigurationFlag.LOOT, 1.5f).create(),
            "For stone specialists"),
    MINER_TIER_IV("Miner IV", ProficiencyType.STONEWORK, Rarity.ELITE, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,2f).addFlag(ConfigurationFlag.LOOT, 2.0f).create(),
            "For stone specialists"),
    MINER_TIER_V("Miner V", ProficiencyType.STONEWORK, Rarity.EPIC, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,3f).addFlag(ConfigurationFlag.LOOT, 3f).create(),
            "For stone specialists"),
    MINER_TIER_VI("Miner VI", ProficiencyType.STONEWORK, Rarity.LEGENDARY, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,5f).addFlag(ConfigurationFlag.LOOT, 4f).create(),
            "For stone specialists"),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMER_TIER_I("Farmer I", ProficiencyType.FARMING, Rarity.SIMPLE, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 1f).addFlag(ConfigurationFlag.LOOT, 0.5f).create()),
    FARMER_TIER_II("Farmer II", ProficiencyType.FARMING, Rarity.COMMON, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 1f).addFlag(ConfigurationFlag.LOOT, 1f).create()),
    FARMER_TIER_III("Farmer III", ProficiencyType.FARMING, Rarity.ADVANCED, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 2f).addFlag(ConfigurationFlag.LOOT, 1.5f).create()),
    FARMER_TIER_IV("Farmer IV", ProficiencyType.FARMING, Rarity.ELITE, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 2f).addFlag(ConfigurationFlag.LOOT, 2f).create()),
    FARMER_TIER_V("Farmer V", ProficiencyType.FARMING, Rarity.EPIC, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 3f).addFlag(ConfigurationFlag.LOOT, 3f).create()),
    FARMER_TIER_VI("Farmer VI", ProficiencyType.FARMING, Rarity.LEGENDARY, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE, 5f).addFlag(ConfigurationFlag.LOOT, 4f).create()),


    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------

    HUNTER_TIER_I("Hunter I", ProficiencyType.HUNTING, Rarity.SIMPLE, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LOOT,0.5f).create()),
    HUNTER_TIER_II("Hunter II", ProficiencyType.HUNTING, Rarity.COMMON, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,1f).addFlag(ConfigurationFlag.LOOT,1f).create()),
    HUNTER_TIER_III("Hunter III", ProficiencyType.HUNTING, Rarity.ADVANCED, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,2f).addFlag(ConfigurationFlag.LOOT,1.5f).create()),
    HUNTER_TIER_IV("Hunter IV", ProficiencyType.HUNTING, Rarity.ELITE, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,2f).addFlag(ConfigurationFlag.LOOT,2f).create()),
    HUNTER_TIER_V("Hunter V", ProficiencyType.HUNTING, Rarity.EPIC, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,3f).addFlag(ConfigurationFlag.LOOT,3f).create()),
    HUNTER_TIER_VI("Hunter VI", ProficiencyType.HUNTING, Rarity.LEGENDARY, 5,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,5f).addFlag(ConfigurationFlag.LOOT,4f).create()),



    WOODWORK_TEST("Basic", ProficiencyType.MISC, Rarity.EPIC, 4,
            new ItemConfiguration.Builder().addFlag(ConfigurationFlag.EXPERIENCE,1f).create(),
            "for true wood specialists"),



    ;

    private final ProficiencyType proficiencyType;

    private final Rarity rarity;

    private final String name;

    private final int numberOfParts;

    private final ItemConfiguration configuration;

    private final List<String> description;

    EquipmentSet(String name,ProficiencyType proficiencyType, Rarity rarity, int numberOfParts, ItemConfiguration configuration, String... description) {
        this.name = name;
        this.proficiencyType = proficiencyType;
        this.rarity = rarity;

        this.numberOfParts = numberOfParts > 6 || numberOfParts <= 0 ? 1 : numberOfParts;

        this.configuration = configuration;

        if (description != null) {
            this.description = new ArrayList<>();
            for (String tmp : description) {
                this.description.add(tmp);
            }
        } else {
            this.description = null;
        }
    }

    public ProficiencyType getProficiencyType() {
        return proficiencyType;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getName() {
        return rarity.getColor() + name;
    }

    public int getNumberOfParts() {
        return numberOfParts;
    }

    public boolean hasConfiguration() {
        return configuration != null;
    }

    public ItemConfiguration getConfiguration() {
        return configuration;
    }


    public boolean hasDescription() {
        return description != null;
    }

    public List<String> getDescription() {
        return description;
    }

}
