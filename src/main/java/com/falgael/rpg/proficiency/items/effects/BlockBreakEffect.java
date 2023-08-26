package com.falgael.rpg.proficiency.items.effects;

import com.falgael.rpg.proficiency.items.ItemConfiguration;
import org.bukkit.Bukkit;

public class BlockBreakEffect {


    private final int experienceModifier;

    private final float blockBreakDropRate;


    public BlockBreakEffect(int experienceModifier, float blockBreakDropRate) {
        this.experienceModifier = experienceModifier;
        this.blockBreakDropRate = blockBreakDropRate;
    }


    /**
     * Calculates the amount of blocks been dropped. This works with special percentages.
     * @return A full number of blocks influenced by the percentages
     */
    public int calculateDroppedBlocks() {
        double value = (Math.random()) * Math.ceil(blockBreakDropRate);
        Bukkit.getLogger().info("Item drop value is: " + value + " Ceil is: " + Math.ceil(blockBreakDropRate));
        if (value > blockBreakDropRate) return (int) Math.ceil(blockBreakDropRate) - 1;
        return (int) Math.floor(blockBreakDropRate) - 1;
    }

    public float getPercentageOfDroppedBlocks() {
        return blockBreakDropRate - 1.0f;
    }

    public int getExperienceModifier() {
        return experienceModifier;
    }

    public float getBlockBreakDropRate() {
        return blockBreakDropRate;
    }
}
