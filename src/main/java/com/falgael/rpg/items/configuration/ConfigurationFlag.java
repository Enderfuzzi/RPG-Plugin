package com.falgael.rpg.items.configuration;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


/**
 * Provides possible Configuration modifiers for the Lore of an Items created
 * @author falgael
 * @version 0.0.2
 */
public enum ConfigurationFlag {

    LEVEL_REQUIREMENT(ChatColor.DARK_AQUA,"Level"),

    EXPERIENCE(ChatColor.GOLD, "More experience"),

    LOOT(ChatColor.DARK_GREEN, "More loot"),

    BURN_TIME(ChatColor.RED, "Burn time"),

    DAMAGE_ADDITIVE(ChatColor.RED, "More Damage"),

    DAMAGE_MULTIPLIER(ChatColor.RED, "More Damage"),

    CURRENCY(ChatColor.DARK_PURPLE, "Currency"),

    SET_BONUS(ChatColor.WHITE, "Set:"),

    SET_PART_NUMBER(ChatColor.GRAY, "Required Parts: "),

    DEFAULT(ChatColor.DARK_PURPLE, ""),

    ENCHANTED(),
    ROCKET_FLIGHT_DURATION(),

    ;
    private final ChatColor color;

    private final String lore;

    ConfigurationFlag() {
        this(ChatColor.RESET,"");
    }

    ConfigurationFlag(ChatColor color, String lore) {
        this.color = color;
        this.lore = lore;
    }

    public boolean hasRepresentation() {
        return switch (this) {
            case ENCHANTED, ROCKET_FLIGHT_DURATION -> false;
            default -> true;
        };
    }

    /**
     * @return the color representation of the Modifier
     */
    @Contract(pure = true)
    public @NotNull String getRepresentation() {
        return ChatColor.ITALIC + "" + color;
    }

    /**
     * Creates the lore of a Items with a given String.
     * @param value String to insert into the modifier
     * @return a fully computed representational String of the modifier
     */
    public @NotNull String createLore(String value) {
        return getRepresentation() + switch (this) {
            case LEVEL_REQUIREMENT, SET_PART_NUMBER -> String.format("%s %s", lore, value);
            case BURN_TIME -> String.format("-%s%% %s", value, lore);
            case DAMAGE_ADDITIVE -> String.format("+%s %s", value, lore);
            case CURRENCY -> lore;
            case SET_BONUS -> String.format("%s %s",color + lore, value);
            case DEFAULT -> value;
            default -> String.format("+%s%% %s", value, lore);
        } + ChatColor.RESET;
    }

    public String createLore(Double value) {
        return switch (this) {
            case LEVEL_REQUIREMENT, DAMAGE_ADDITIVE -> createLore(Integer.toString(value.intValue()));
            default -> createLore(Integer.toString((int) (value * 100f)));
        };
    }

    public enum Special {
        BREAKING_TOOL
    }

}
