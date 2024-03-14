package com.falgael.rpg.proficiency;

import org.bukkit.ChatColor;

public enum Rarity {

    NONE(ChatColor.RESET,""),
    SIMPLE(ChatColor.DARK_GRAY,"Misc"),
    COMMON(ChatColor.GRAY ,"Common"),
    ADVANCED(ChatColor.DARK_AQUA ,"Advanced"),
    ELITE(ChatColor.LIGHT_PURPLE, "Elite"),
    EPIC(ChatColor.YELLOW, "Epic"),
    LEGENDARY(ChatColor.GOLD,"Legendary"),
    UNIQUE(ChatColor.RED, "Unique"),

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


}
