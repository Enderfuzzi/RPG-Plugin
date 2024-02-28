package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Warped extends CustomRecipes {
    public Warped(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_WARPED"),
                        new ItemStack(Material.WARPED_SLAB),
                        Material.WARPED_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_WARPED"),
                        new ItemStack(Material.WARPED_SLAB,2),
                        Material.WARPED_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_WARPED_STEM"),
                        new ItemStack(Material.STRIPPED_WARPED_STEM),
                        Material.WARPED_STEM
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_WARPED_HYPHAE"),
                        new ItemStack(Material.STRIPPED_WARPED_HYPHAE),
                        Material.WARPED_HYPHAE
                )
        );


        return result;
    }
}
