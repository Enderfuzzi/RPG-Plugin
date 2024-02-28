package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class DarkOak extends CustomRecipes {
    public DarkOak(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STAIR_TO_SLAB_DARK_OAK"),
                        new ItemStack(Material.DARK_OAK_SLAB),
                        Material.DARK_OAK_STAIRS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_PLANK_TO_SLAB_DARK_OAK"),
                        new ItemStack(Material.DARK_OAK_SLAB,2),
                        Material.DARK_OAK_PLANKS
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_DARK_OAK_LOG"),
                        new ItemStack(Material.STRIPPED_DARK_OAK_LOG),
                        Material.DARK_OAK_LOG
                )
        );

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_DARK_OAK_WOOD"),
                        new ItemStack(Material.STRIPPED_DARK_OAK_WOOD),
                        Material.DARK_OAK_WOOD
                )
        );


        return result;
    }
}
