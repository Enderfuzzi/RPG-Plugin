package com.falgael.rpg.proficiencies.data.woodwork;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.template.ProficiencyFramework;
import org.bukkit.Material;

import java.io.Serial;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Provides the Woodwork proficiency implementation.
 * @author falgael
 * @version 0.0.1
 */
public class Woodwork extends ProficiencyFramework {

    @Serial
    private static final long serialVersionUID = -3733453141266327941L;

    /** Identifier for this Proficiency */
    private static final String PROFICIENCY_NAME = ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void generateNextBorder() {
        currentExperienceBorder += currentExperienceBorder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getProficiencyRepresentation() {
        return PROFICIENCY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HashMap<Material, Integer> fillBlockBreakingExperience() {
        //Todo Increase Value for woods
        HashMap<Material,Integer> result = new HashMap<>();

        result.put(Material.ACACIA_LOG,1);
        result.put(Material.ACACIA_WOOD,1);
        result.put(Material.BIRCH_LOG,1);
        result.put(Material.BIRCH_WOOD,1);
        result.put(Material.CHERRY_LOG,1);
        result.put(Material.CHERRY_WOOD,1);
        result.put(Material.CRIMSON_HYPHAE,2);
        result.put(Material.CRIMSON_STEM,2);
        result.put(Material.DARK_OAK_LOG,1);
        result.put(Material.DARK_OAK_WOOD,1);
        result.put(Material.JUNGLE_LOG,1);
        result.put(Material.JUNGLE_WOOD,1);
        result.put(Material.MANGROVE_LOG,1);
        result.put(Material.MANGROVE_ROOTS,1);
        result.put(Material.MANGROVE_WOOD,1);
        result.put(Material.OAK_LOG,1);
        result.put(Material.OAK_WOOD,1);
        result.put(Material.SPRUCE_LOG,1);
        result.put(Material.SPRUCE_WOOD,1);
        result.put(Material.WARPED_STEM,2);
        result.put(Material.WARPED_HYPHAE,2);
        result.put(Material.STRIPPED_ACACIA_LOG,1);
        result.put(Material.STRIPPED_ACACIA_WOOD,1);
        result.put(Material.STRIPPED_BIRCH_LOG,1);
        result.put(Material.STRIPPED_BIRCH_WOOD,1);
        result.put(Material.STRIPPED_CHERRY_LOG,1);
        result.put(Material.STRIPPED_CHERRY_WOOD,1);
        result.put(Material.STRIPPED_CRIMSON_HYPHAE,2);
        result.put(Material.STRIPPED_CRIMSON_STEM,2);
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
        result.put(Material.STRIPPED_WARPED_HYPHAE,2);
        result.put(Material.STRIPPED_WARPED_STEM,2);
        result.put(Material.BAMBOO,1);

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HashMap<Material, Integer> fillBlockCraftingExperience() {
        HashMap<Material,Integer> result = new HashMap<>();
        result.put(Material.ACACIA_PLANKS,2);
        result.put(Material.ACACIA_SLAB,3);
        result.put(Material.BAMBOO_BLOCK,3);
        result.put(Material.BAMBOO_MOSAIC,1);
        result.put(Material.BAMBOO_MOSAIC_SLAB,1);
        result.put(Material.BAMBOO_SLAB,3);
        result.put(Material.BAMBOO_PLANKS,1);
        result.put(Material.BIRCH_SLAB,1);
        result.put(Material.BIRCH_PLANKS,2);
        result.put(Material.CHERRY_SLAB,3);
        result.put(Material.CHERRY_PLANKS,2);
        result.put(Material.DARK_OAK_SLAB,3);
        result.put(Material.DARK_OAK_PLANKS,2);
        result.put(Material.JUNGLE_SLAB,2);
        result.put(Material.JUNGLE_PLANKS,2);
        result.put(Material.MANGROVE_SLAB,2);
        result.put(Material.MANGROVE_PLANKS,2);
        result.put(Material.OAK_SLAB,2);
        result.put(Material.OAK_PLANKS,2);
        result.put(Material.SPRUCE_SLAB,2);
        result.put(Material.SPRUCE_PLANKS,2);
        //Todo add further materials
        return result;
    }

    @Override
    protected ArrayList<Material> fillForbiddenCraftingRecipes() {
        ArrayList<Material> result = new ArrayList<>();
        result.add(Material.ACACIA_WOOD);
        result.add(Material.BIRCH_WOOD);
        result.add(Material.CHERRY_WOOD);
        result.add(Material.CRIMSON_HYPHAE);
        result.add(Material.DARK_OAK_WOOD);
        result.add(Material.JUNGLE_WOOD);
        result.add(Material.MANGROVE_WOOD);
        result.add(Material.OAK_WOOD);
        result.add(Material.SPRUCE_WOOD);
        result.add(Material.WARPED_HYPHAE);
        result.add(Material.STRIPPED_ACACIA_WOOD);
        result.add(Material.STRIPPED_BIRCH_WOOD);
        result.add(Material.STRIPPED_CHERRY_WOOD);
        result.add(Material.STRIPPED_CRIMSON_HYPHAE);
        result.add(Material.STRIPPED_DARK_OAK_WOOD);
        result.add(Material.STRIPPED_JUNGLE_WOOD);
        result.add(Material.STRIPPED_MANGROVE_WOOD);
        result.add(Material.STRIPPED_OAK_WOOD);
        result.add(Material.STRIPPED_SPRUCE_WOOD);
        result.add(Material.STRIPPED_WARPED_HYPHAE);
        //Todo add further materials

        return result;
    }

    public void initialize() {
        registerGenerallyForbidden(Material.ACACIA_WOOD);


        registerItemOfThisProficiency(PROFICIENCY_NAME, WoodworkItems.getItems());
    }
}
