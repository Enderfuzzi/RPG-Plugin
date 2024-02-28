package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Acacia extends CustomRecipes {
    public Acacia(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_ACACIA"),
                        new ItemStack(Material.ACACIA_SLAB),
                        Material.ACACIA_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_ACACIA"),
                        new ItemStack(Material.ACACIA_SLAB,2),
                        Material.ACACIA_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_ACACIA_LOG"),
                        new ItemStack(Material.STRIPPED_ACACIA_LOG),
                        Material.ACACIA_LOG
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_ACACIA_WOOD"),
                        new ItemStack(Material.STRIPPED_ACACIA_WOOD),
                        Material.ACACIA_WOOD
                )
        );


        return result;
    }
}
