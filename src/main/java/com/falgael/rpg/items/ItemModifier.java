package com.falgael.rpg.items;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public enum ItemModifier {

    EXPERIENCE(ChatColor.GOLD, "More experience"),

    LOOT(ChatColor.DARK_GREEN, "More loot"),

    BURN_TIME(ChatColor.RED, "Burn time"),

    DEFAULT(ChatColor.DARK_PURPLE, ""),

    CURRENCY(ChatColor.DARK_PURPLE, "Currency"),

    LEVEL_REQUIREMENT(ChatColor.DARK_AQUA,"Level requirement:"),

    ;
    private final ChatColor color;

    private final String lore;


    ItemModifier(ChatColor color, String lore) {
        this.color = color;
        this.lore = lore;
    }

    public String getRepresentation() {
        return ChatColor.ITALIC + "" + color;
    }

    public String createLore(String value) {
        return getRepresentation() + switch (this) {
            case LEVEL_REQUIREMENT -> String.format("%s %s", lore, value);
            case BURN_TIME -> String.format("-%s%% %s", value, lore);
            case CURRENCY -> lore;
            case DEFAULT -> value;
            default -> String.format("+%s%% %s", value, lore);
        };
    }
}
