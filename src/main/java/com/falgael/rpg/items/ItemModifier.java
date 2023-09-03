package com.falgael.rpg.items;

import org.bukkit.ChatColor;

public enum ItemModifier {

    EXPERIENCE(ChatColor.ITALIC + "" + ChatColor.GOLD),

    LOOT(ChatColor.ITALIC + "" + ChatColor.DARK_GREEN),

    BURN_TIME(ChatColor.ITALIC + "" + ChatColor.RED)


    ;
    private final String representation;

    ItemModifier(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

}
