package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Jungle extends CustomRecipes {
    public Jungle(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_JUNGLE"),
                        new ItemStack(Material.JUNGLE_SLAB),
                        Material.JUNGLE_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_JUNGLE"),
                        new ItemStack(Material.JUNGLE_SLAB,2),
                        Material.JUNGLE_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_JUNGLE_LOG"),
                        new ItemStack(Material.STRIPPED_JUNGLE_LOG),
                        Material.JUNGLE_LOG
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_JUNGLE_WOOD"),
                        new ItemStack(Material.STRIPPED_JUNGLE_WOOD),
                        Material.JUNGLE_WOOD
                )
        );


        return result;
    }
}
