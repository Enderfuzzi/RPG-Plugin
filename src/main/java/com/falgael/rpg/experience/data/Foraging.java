package com.falgael.rpg.experience.data;

import org.bukkit.Material;

import java.io.Serial;
import java.io.Serializable;

import java.util.HashMap;

/**
 * Represents the experience counters of a player
 * @author falgael
 * @version 0.0.1
 */
public class Foraging implements Serializable {
    @Serial
    private static final long serialVersionUID = 8887786846639469719L;

    /** Contains a list of a Material that gives Xp on harvest and the amount of Xp */
    private static HashMap<Material,Integer> BLOCKS = blocksToHarvest();

    /** Current amount of Xp in foraging */
    private int foragingXp = 0;
    /** Current level in foraging */
    private int foragingLVL = 0;
    /** Current Xp needed to reach the next Level */
    private int foragingXpBorder = 10;
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
        if (getCurrentForagingXpBorder() <= foragingXp) {
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

    /**
     *
     * @param m The {@code Material} to check for
     * @return {@code true} when the material is in list
     */
    public boolean givesForagingXp(Material m) {
        return BLOCKS.containsKey(m);
    }

    public int amountOfForagingXp(Material m) {
        if (givesForagingXp(m)) {
            return BLOCKS.get(m);
        }
        return 0;
    }

    /**
     * Filling the Blocks that give xp on break
     * @return the filled hashmap
     */
    private static HashMap<Material,Integer> blocksToHarvest() {
        HashMap<Material,Integer> result = new HashMap<>();
        result.put(Material.ACACIA_LOG,1);
        result.put(Material.ACACIA_WOOD,1);
        result.put(Material.BIRCH_LOG,1);
        result.put(Material.BIRCH_WOOD,1);
        result.put(Material.CHERRY_LOG,1);
        result.put(Material.CHERRY_WOOD,1);
        result.put(Material.DARK_OAK_LOG,1);
        result.put(Material.DARK_OAK_WOOD,1);
        result.put(Material.JUNGLE_LOG,1);
        result.put(Material.JUNGLE_WOOD,1);
        result.put(Material.MANGROVE_LOG,1);
        result.put(Material.MANGROVE_WOOD,1);
        result.put(Material.OAK_LOG,1);
        result.put(Material.OAK_WOOD,1);
        result.put(Material.SPRUCE_LOG,1);
        result.put(Material.SPRUCE_WOOD,1);
        result.put(Material.STRIPPED_ACACIA_LOG,1);
        result.put(Material.STRIPPED_ACACIA_WOOD,1);
        result.put(Material.STRIPPED_BIRCH_LOG,1);
        result.put(Material.STRIPPED_BIRCH_WOOD,1);
        result.put(Material.STRIPPED_CHERRY_LOG,1);
        result.put(Material.STRIPPED_CHERRY_WOOD,1);
        result.put(Material.STRIPPED_DARK_OAK_LOG,1);
        result.put(Material.STRIPPED_DARK_OAK_WOOD,1);
        result.put(Material.STRIPPED_JUNGLE_LOG,1);
        result.put(Material.STRIPPED_JUNGLE_WOOD,1);
        result.put(Material.STRIPPED_MANGROVE_LOG,1);
        result.put(Material.STRIPPED_MANGROVE_WOOD,1);
        result.put(Material.STRIPPED_OAK_LOG,1);
        result.put(Material.STRIPPED_OAK_WOOD,1);
        result.put(Material.STRIPPED_SPRUCE_LOG,1);
        result.put(Material.STRIPPED_SPRUCE_WOOD,1);
        return result;
    }

}
