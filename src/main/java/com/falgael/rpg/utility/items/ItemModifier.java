package com.falgael.rpg.utility.items;

import org.bukkit.ChatColor;

public enum ItemModifier {

    EXPERIENCE(ChatColor.ITALIC + "" + ChatColor.GOLD),

    LOOT(ChatColor.ITALIC + "" + ChatColor.DARK_GREEN);


    private final String representation;

    ItemModifier(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

}
