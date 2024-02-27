package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Oak extends CustomRecipes {

    public Oak(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new StonecuttingRecipe(
                        namespacedKey("OAK_STAIR_TO_SLAB"),
                        new ItemStack(Material.OAK_SLAB),
                        Material.OAK_STAIRS
                )
        );
        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_OAK_LOG"),
                        new ItemStack(Material.STRIPPED_OAK_LOG),
                        Material.OAK_LOG
                )
        );
        result.add(
                new StonecuttingRecipe(
                        namespacedKey("STONE_CUTTING_STRIPPED_OAK_WOOD"),
                        new ItemStack(Material.STRIPPED_OAK_WOOD),
                        Material.OAK_WOOD
                )
        );



        return result;
    }
}
