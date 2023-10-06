package com.falgael.rpg.tmp;

import com.falgael.rpg.items.ConfigurationFlag;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.ItemConfiguration;

import java.util.ArrayList;
import java.util.List;

public enum EquipmentSet {

    NONE("", ProficiencyType.NONE, Rarity.NONE, 0, null, ""),

    WOODWORK_TEST("Basic", ProficiencyType.MISC, Rarity.EPIC, 4,
            new ItemConfiguration.Builder(null).addFlag(ConfigurationFlag.EXPERIENCE,1f).create(),
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
