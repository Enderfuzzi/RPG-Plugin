package com.falgael.rpg.proficiency;

import org.bukkit.ChatColor;

public enum ProficiencyTypes {

    NONE(""),

    MISC("Misc"),

    WOODWORK("Woodwork"),

    STONEWORK("Stonework"),

    FARMING("Farming"),

    HUNTING("Hunting");

    private final String representation;

    ProficiencyTypes(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return ChatColor.YELLOW +  representation + ChatColor.RESET;
    }

    public String getName() {
        return representation;
    }

}
