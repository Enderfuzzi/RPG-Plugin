package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
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
                new CustomRecipes.RecipeBuilder(Material.OAK_SLAB, "OAK_STAIR_TO_SLAB", CustomRecipes.RecipeBuilder.RecipeType.STONECUTTER)
                        .addIngredient(Material.OAK_STAIRS)
                        .create()
        );



        return result;
    }
}
