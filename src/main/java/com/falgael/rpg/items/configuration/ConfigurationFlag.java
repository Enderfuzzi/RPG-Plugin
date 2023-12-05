package com.falgael.rpg.items.configuration;

import com.falgael.rpg.old.ItemBuilder;
import com.falgael.rpg.manager.ProficiencyExperienceCalculation;
import org.bukkit.ChatColor;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


/**
 * Provides possible Configuration modifiers for the Lore of an Items created by {@link ItemBuilder}
 * @author falgael
 * @version 0.0.2
 */
public enum ConfigurationFlag implements ItemEffect {

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

    TREE_HARVEST(),
    VEIN_MINING(),
    WEATHER_CLEAR(),
    WEATHER_RAIN(),
    WEATHER_THUNDER(),
    CROP_HARVEST(),
    ENCHANTED(),

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
            case TREE_HARVEST, ENCHANTED, CROP_HARVEST, VEIN_MINING, WEATHER_CLEAR, WEATHER_RAIN, WEATHER_THUNDER -> false;
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

    public PredicateConsumer<Event, ProficiencyExperienceCalculation> getAction(Double value) {
        return switch (this) {
            case VEIN_MINING -> (e,p) -> veinMining(e, p, value.intValue());
            case BURN_TIME -> (e,p) -> furnaceFuelBurn(e, value);
            case TREE_HARVEST -> (e,p) -> treeHarvest(e, p, value.intValue());
            case CROP_HARVEST -> (e,p) -> cropHarvest(e,p);
            case WEATHER_CLEAR -> (e,p) -> weatherClear(e, value.intValue());
            case WEATHER_RAIN -> (e,p) -> weatherRain(e, value.intValue());
            case WEATHER_THUNDER -> (e,p) -> weatherStorm(e, value.intValue());
            default -> null;
        };
    }

    public enum Special {
        BREAKING_TOOL
    }

}
