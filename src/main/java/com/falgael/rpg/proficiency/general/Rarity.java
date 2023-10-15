package com.falgael.rpg.proficiency.general;

import org.bukkit.ChatColor;

public enum Rarity {

    NONE(ChatColor.RESET,""),
    SIMPLE(ChatColor.DARK_GRAY,"Simple "),
    COMMON(ChatColor.GRAY ,"Common "),
    ADVANCED(ChatColor.DARK_AQUA ,"Advanced "),
    ELITE(ChatColor.LIGHT_PURPLE, "Elite "),
    EPIC(ChatColor.RED, "Epic "),
    LEGENDARY(ChatColor.GOLD,"Legendary "),
    UNIQUE(ChatColor.GOLD, ""),

    ;

    private final ChatColor color;

    private final String representation;

    Rarity(ChatColor color ,String representation) {
        this.color = color;
        this.representation = representation;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getRepresentation() {
        return  color + representation;
    }


    public String buildItemName(String value) {
        return switch (this) {
            case UNIQUE -> color + value;
            default -> getRepresentation() + ChatColor.WHITE + value;
        };
    }

}
