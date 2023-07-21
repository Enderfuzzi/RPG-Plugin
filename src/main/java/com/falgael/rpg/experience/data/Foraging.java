package com.falgael.rpg.experience.data;

import com.falgael.rpg.experience.ExperienceFramework;
import org.bukkit.Material;

import java.util.HashMap;

/**
 * Provides the Foraging proficiency implementation.
 * @author falgael
 * @version 0.0.1
 */
public class Foraging extends ExperienceFramework {

    public Foraging() {

    }

    @Override
    protected void generateNextBorder() {
        currentExperienceBorder += currentExperienceBorder;
    }

    @Override
    protected HashMap<Material, Integer> experienceBlocks() {
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
