package com.falgael.rpg.items;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Provides possible Configuration modifiers for the Lore of an Item created by {@link ItemBuilder}
 * @author falgael
 * @version 0.0.1
 */
public enum ItemModifier {

    LEVEL_REQUIREMENT(ChatColor.DARK_AQUA,"Level"),

    EXPERIENCE(ChatColor.GOLD, "More experience"),

    LOOT(ChatColor.DARK_GREEN, "More loot"),

    BURN_TIME(ChatColor.RED, "Burn time"),

    DEFAULT(ChatColor.DARK_PURPLE, ""),

    CURRENCY(ChatColor.DARK_PURPLE, "Currency"),

    ;
    private final ChatColor color;

    private final String lore;


    ItemModifier(ChatColor color, String lore) {
        this.color = color;
        this.lore = lore;
    }

    /**
     * @return the color representation of the Modifier
     */
    @Contract(pure = true)
    public @NotNull String getRepresentation() {
        return ChatColor.ITALIC + "" + color;
    }

    /**
     * Creates the lore of a Item with a given String.
     * @param value String to insert into the modifier
     * @return a fully computed representational String of the modifier
     */
    public @NotNull String createLore(String value) {
        return getRepresentation() + switch (this) {
            case LEVEL_REQUIREMENT -> String.format("%s %s", lore, value);
            case BURN_TIME -> String.format("-%s%% %s", value, lore);
            case CURRENCY -> lore;
            case DEFAULT -> value;
            default -> String.format("+%s%% %s", value, lore);
        };
    }
}
