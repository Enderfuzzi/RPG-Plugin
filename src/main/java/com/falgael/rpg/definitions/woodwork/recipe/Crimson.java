package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Crimson extends CustomRecipes {
    public Crimson(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_CRIMSON"),
                        new ItemStack(Material.CRIMSON_SLAB),
                        Material.CRIMSON_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_CRIMSON"),
                        new ItemStack(Material.CRIMSON_SLAB,2),
                        Material.CRIMSON_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_CRIMSON_STEM"),
                        new ItemStack(Material.STRIPPED_CRIMSON_STEM),
                        Material.CRIMSON_STEM
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_CRIMSON_HYPHAE"),
                        new ItemStack(Material.STRIPPED_CRIMSON_HYPHAE),
                        Material.CRIMSON_HYPHAE
                )
        );


        return result;
    }
}
