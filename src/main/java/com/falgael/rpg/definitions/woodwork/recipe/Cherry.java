package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Cherry extends CustomRecipes {
    public Cherry(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_CHERRY"),
                        new ItemStack(Material.CHERRY_SLAB),
                        Material.CHERRY_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_CHERRY"),
                        new ItemStack(Material.CHERRY_SLAB,2),
                        Material.CHERRY_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_CHERRY_LOG"),
                        new ItemStack(Material.STRIPPED_CHERRY_LOG),
                        Material.CHERRY_LOG
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_CHERRY_WOOD"),
                        new ItemStack(Material.STRIPPED_CHERRY_WOOD),
                        Material.CHERRY_WOOD
                )
        );


        return result;
    }
}
