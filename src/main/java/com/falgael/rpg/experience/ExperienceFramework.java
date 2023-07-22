package com.falgael.rpg.experience;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Provides the framework for experience.
 * @author falgael
 * @version 0.0.1
 */
public abstract class ExperienceFramework implements Serializable {
    @Serial
    private static final long serialVersionUID = 4139975922284126208L;
    /** Contains a list of a Material that gives Experience on destruction and the amount of Experience */
    protected HashMap<Material,Integer> blockBreakingExperience = experienceBlocks();
    /** Current amount of Experience*/
    protected int currentExperience = 0;
    /** The current Level */
    protected int currentLVL = 0;
    /** The Experience to Reach the next level */
    protected int currentExperienceBorder = 10;
    /** The maximum level a player can reach in this skill */
    protected int lvlBorder = 100;


    /**
     * Increases the current {@link ExperienceFramework#currentExperience} by the specified {@code int}.
     * Returns always {@code false} if {@link ExperienceFramework#lvlBorder} is reached or the given amount is zero or less.
     * Calls {@link ExperienceFramework#increaseLVL()} when {@link ExperienceFramework#currentExperienceBorder} is reached.
     * @param amount the experience to add
     * @return {@code true} if the increase is successful
     */
    public boolean increaseExperience(int amount) {
        if (amount <= 0 || currentLVL == lvlBorder) return false;
        currentExperience += amount;
        if (getCurrentExperienceBorder() <= currentExperience) {
            currentExperience -= getCurrentExperienceBorder();
            increaseLVL();
        }
        return true;
    }

    /**
     * Increases the Level by one and calls {@link ExperienceFramework#generateNextBorder()}
     */
    protected void increaseLVL() {
        currentLVL++;
        generateNextBorder();
    }

    /**
     * @return the current experience border
     */
    public int getCurrentExperienceBorder() {
        return currentExperienceBorder;
    }
    /** @return the current amount of experience */
    public int getCurrentExperience() {
        return currentExperience;
    }
    /** @return the current level of the proficiency*/
    public int getCurrentLVL() {
        return currentLVL;
    }
    /**
     * Generates the next border for the next level up
     */
    protected abstract void generateNextBorder();


    /**
     * //Todo Change Signature to Block and overwrite it for Farming
     * @param b The {@code Block} to check for
     * @return {@code true} when the material is in list
     */
    public boolean givesBlockBreakingExperience(Block b) {
        return blockBreakingExperience.containsKey(b.getType());
    }

    /**
     * Gives the number of experience a block gives when broken
     * @param b The {@code Block} to get the experience amount
     * @return the amount of experience assigned to the specified {@code Material}
     */
    public int amountBlockBreakingExperience(Block b) {
        if (givesBlockBreakingExperience(b)) {
            return blockBreakingExperience.get(b.getType());
        }
        return 0;
    }
    /** Holds each Block which gives experience for the proficiency and stores the exact amount */
    protected abstract HashMap<Material,Integer> experienceBlocks();

    /** @return The String representation of this proficiency */
    public abstract String getProficiencyRepresentation();
}
