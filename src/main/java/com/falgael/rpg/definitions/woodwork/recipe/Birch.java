package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Birch extends CustomRecipes {
    public Birch(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_BIRCH"),
                        new ItemStack(Material.BIRCH_SLAB),
                        Material.BIRCH_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_BIRCH"),
                        new ItemStack(Material.BIRCH_SLAB,2),
                        Material.BIRCH_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_BIRCH_LOG"),
                        new ItemStack(Material.STRIPPED_BIRCH_LOG),
                        Material.BIRCH_LOG
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_BIRCH_WOOD"),
                        new ItemStack(Material.STRIPPED_BIRCH_WOOD),
                        Material.BIRCH_WOOD
                )
        );


        return result;
    }
}
