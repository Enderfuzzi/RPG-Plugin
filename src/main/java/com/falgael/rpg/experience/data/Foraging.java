package com.falgael.rpg.experience.data;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents the experience counters of a player
 * @author falgael
 * @version 0.0.1
 */
public class Foraging implements Serializable {
    @Serial
    private static final long serialVersionUID = 8887786846639469719L;

    /** Current amount of Xp in foraging */
    private int foragingXp = 0;
    /** Current level in foraging */
    private int foragingLVL = 0;
    /** Current Xp needed to reach the next Level */
    private int foragingXpBorder = 0;
    /** Current Maximum Level in foraging a Player can achieve */
    private static final int FORAGING_LVL_BORDER = 100;


    /**
     * Increases the current {@link Foraging#foragingXp} by the specified {@code int}.
     * Returns always {@code false} if {@link Foraging#FORAGING_LVL_BORDER} or the given amount is zero or less.
     * Calls {@link Foraging#increaseForagingLVL()} when {@link Foraging#foragingXpBorder} is reached.
     * @param amount the experience to add
     * @return {@code true} if the increase is successful
     */
    public boolean increaseForagingXP(int amount) {
        if (amount <= 0 || foragingLVL == FORAGING_LVL_BORDER) return false;
        foragingXp += amount;
        if (getCurrentForagingXpBorder() >= foragingXp) {
            foragingXp -= getCurrentForagingXpBorder();
            increaseForagingLVL();
        }
        return true;
    }

    /**
     * Increases the Foraging level by one and calls {@link Foraging#generateNextBorder()}.
     */
    private void increaseForagingLVL() {
        foragingLVL++;
        generateNextBorder();
    }
    public int getCurrentForagingXpBorder() {
        return foragingXpBorder;
    }

    public int getCurrentForagingXp() {
        return foragingXp;
    }

    public int getCurrentForagingLVL() {
        return foragingLVL;
    }

    /**
     * Generates the next border for the next level up
     */
    private void generateNextBorder() {
        //Todo Generation of next Xp border
        foragingXpBorder += foragingXpBorder;
    }

}
