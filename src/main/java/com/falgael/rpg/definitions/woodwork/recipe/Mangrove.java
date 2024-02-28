package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Mangrove extends CustomRecipes {
    public Mangrove(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_MANGROVE"),
                        new ItemStack(Material.MANGROVE_SLAB),
                        Material.MANGROVE_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_MANGROVE"),
                        new ItemStack(Material.MANGROVE_SLAB,2),
                        Material.MANGROVE_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_MANGROVE_LOG"),
                        new ItemStack(Material.STRIPPED_MANGROVE_LOG),
                        Material.MANGROVE_LOG
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_MANGROVE_WOOD"),
                        new ItemStack(Material.STRIPPED_MANGROVE_WOOD),
                        Material.MANGROVE_WOOD
                )
        );


        return result;
    }
}
