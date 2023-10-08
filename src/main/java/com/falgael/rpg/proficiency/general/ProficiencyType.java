package com.falgael.rpg.proficiency.general;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public enum ProficiencyType {

    NONE(""),

    MISC("Misc"),

    WOODWORK("Woodwork"),

    STONEWORK("Stonework"),

    FARMING("Farming"),

    HUNTING("Hunting");

    private final String representation;

    ProficiencyType(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return getRepresentationWithoutReset() + ChatColor.RESET;
    }

    public String getRepresentationWithoutReset() {
        return ChatColor.YELLOW + representation;
    }

    public String getName() {
        return representation;
    }

    public static ProficiencyType isProficiency(String key) {
        for (ProficiencyType proficiencyType : ProficiencyType.values()) {
            if (proficiencyType.representation.equals(key)) return proficiencyType;
        }
        return NONE;
    }

    public static List<String> proficiencies() {
        List<String> result = new ArrayList<>();
        for (ProficiencyType type : ProficiencyType.values()) {
            result.add(type.getName());
        }
        return result;
    }

    public boolean levelCheck() {
        return switch (this) {
            case MISC, NONE -> false;
            default -> true;
        };
    }

}
