package com.falgael.rpg.proficiency.items;

import org.bukkit.ChatColor;

public enum Rarity {

    NONE(ChatColor.RESET + ""),
    SIMPLE(ChatColor.DARK_GRAY + "Simple "),
    COMMON(ChatColor.GRAY + "Common "),
    ADVANCED(ChatColor.DARK_AQUA + "Advanced "),
    ELITE(ChatColor.DARK_PURPLE + "Elite "),
    EPIC(ChatColor.RED  + "Epic "),
    LEGENDARY(ChatColor.GOLD + "" + ChatColor.MAGIC + "Legendary" + ChatColor.RESET + " " + ChatColor.GOLD);


    private final String representation;

    Rarity(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

}
