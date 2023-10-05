package com.falgael.rpg.items;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Provides possible Configuration modifiers for the Lore of an CustomItem created by {@link ItemBuilder}
 * @author falgael
 * @version 0.0.1
 */
public enum ConfigurationFlag {

    LEVEL_REQUIREMENT(ChatColor.DARK_AQUA,"Level"),

    EXPERIENCE(ChatColor.GOLD, "More experience"),

    LOOT(ChatColor.DARK_GREEN, "More loot"),

    BURN_TIME(ChatColor.RED, "Burn time"),

    DAMAGE_ADDITIVE(ChatColor.RED, "More Damage"),

    DAMAGE_MULTIPLIER(ChatColor.RED, "More Damage"),

    CURRENCY(ChatColor.DARK_PURPLE, "Currency"),

    SET_BONUS(ChatColor.GRAY, "Set"),

    SET_PART_NUMBER(ChatColor.GRAY, "Required Parts: "),

    DEFAULT(ChatColor.DARK_PURPLE, ""),

    ;
    private final ChatColor color;

    private final String lore;


    ConfigurationFlag(ChatColor color, String lore) {
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
     * Creates the lore of a CustomItem with a given String.
     * @param value String to insert into the modifier
     * @return a fully computed representational String of the modifier
     */
    public @NotNull String createLore(String value) {
        return getRepresentation() + switch (this) {
            case LEVEL_REQUIREMENT, SET_PART_NUMBER -> String.format("%s %s", lore, value);
            case BURN_TIME -> String.format("-%s%% %s", value, lore);
            case CURRENCY -> lore;
            case SET_BONUS -> String.format("%s %s",value, color + lore);
            case DEFAULT -> value;
            default -> String.format("+%s%% %s", value, lore);
        } + ChatColor.RESET;
    }

    public String createLore(float value) {
        return createLore(Integer.toString((int) (value * 100f)));
    }

}
