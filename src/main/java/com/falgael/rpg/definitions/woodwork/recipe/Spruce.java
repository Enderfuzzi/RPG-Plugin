package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Spruce extends CustomRecipes {
    public Spruce(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_SPRUCE"),
                        new ItemStack(Material.SPRUCE_SLAB),
                        Material.SPRUCE_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_SPRUCE"),
                        new ItemStack(Material.SPRUCE_SLAB,2),
                        Material.SPRUCE_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_SPRUCE_LOG"),
                        new ItemStack(Material.STRIPPED_SPRUCE_LOG),
                        Material.SPRUCE_LOG
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_SPRUCE_WOOD"),
                        new ItemStack(Material.STRIPPED_SPRUCE_WOOD),
                        Material.SPRUCE_WOOD
                )
        );


        return result;
    }
}
