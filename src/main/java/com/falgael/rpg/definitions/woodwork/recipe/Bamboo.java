package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Bamboo extends CustomRecipes {
    public Bamboo(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_BAMBOO"),
                        new ItemStack(Material.BAMBOO_SLAB),
                        Material.BAMBOO_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_BAMBOO"),
                        new ItemStack(Material.BAMBOO_SLAB,2),
                        Material.BAMBOO_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_BAMBOO_BLOCK"),
                        new ItemStack(Material.STRIPPED_BAMBOO_BLOCK),
                        Material.BAMBOO_BLOCK
                )
        );



        return result;
    }
}
