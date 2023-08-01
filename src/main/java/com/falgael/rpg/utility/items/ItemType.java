package com.falgael.rpg.utility.items;

import org.bukkit.ChatColor;

public enum ItemType {

    SIMPLE(ChatColor.DARK_GRAY + "Simple "),
    COMMON(ChatColor.GRAY + "Common "),
    ADVANCED(ChatColor.DARK_PURPLE + "Advanced "),
    RARE(ChatColor.YELLOW + "Rare "),
    EPIC(ChatColor.RED + "Epic "),
    LEGENDARY(ChatColor.GOLD + "" + ChatColor.MAGIC + "Legendary" + ChatColor.RESET + " " + ChatColor.GOLD);

    private final String prefix;

    ItemType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

}
