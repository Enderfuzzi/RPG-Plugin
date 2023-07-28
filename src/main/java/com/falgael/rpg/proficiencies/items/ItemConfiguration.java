package com.falgael.rpg.proficiencies.items;

import org.bukkit.Bukkit;

/**
 * Contains special information about an item.
 * @author falgael
 * @version 0.0.1
 */
public class ItemConfiguration {

    /** Indicates if the item has a block break effect */
    private boolean hasBlockBreakEffect;
    /** The rate of items that should have been dropped. Has to be at least 1.0f */
    private float blockBreakDropRate = 1.0f;
    /** The experience multiplier */
    private int experienceModifier;

    /** Creates a default configuration without special modification */
    public ItemConfiguration() {
        hasBlockBreakEffect = false;
        experienceModifier = 1;
    }

    /**
     * Creates a new configuration.
     * @param experienceModifier The experience modifier
     * @param blockBreakDropRate The rate of blocks dropping
     */
    public ItemConfiguration(int experienceModifier, float blockBreakDropRate) {
        hasBlockBreakEffect = true;
        this.blockBreakDropRate = blockBreakDropRate > 1.0f ? blockBreakDropRate : 1.0f;
        this.experienceModifier = experienceModifier;
    }

    /**
     * Calculates the amount of blocks been dropped. This works with special percentages.
     * @return A full number of blocks influenced by the percentages
     */
    public int calculateDroppedBlocks() {
        if (!hasBlockBreakEffect) return 1;
        double value = (Math.random()) * Math.ceil(blockBreakDropRate);
        Bukkit.getLogger().info("Item drop value is: " + value + " Ceil is: " + Math.ceil(blockBreakDropRate));
        if (value > blockBreakDropRate) return (int) Math.ceil(blockBreakDropRate) - 1;
        return (int) Math.floor(blockBreakDropRate) - 1;
    }

    /**
     * @return The percentage of {@link ItemConfiguration#blockBreakDropRate}
     */
    public float getPercentageOfDroppedBlocks() {
        return blockBreakDropRate - 1.0f;
    }

    /** @return the current experience Modifier */
    public int getExperienceModifier() {
        return experienceModifier;
    }



}
