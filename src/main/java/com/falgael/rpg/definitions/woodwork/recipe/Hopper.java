package com.falgael.rpg.definitions.woodwork.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Hopper extends CustomRecipes {

    public Hopper(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new CustomRecipes.RecipeBuilder(Material.HOPPER, "ALTERNATIVE_HOPPER", RecipeBuilder.RecipeType.SHAPED)
                        .setCategory(CraftingBookCategory.REDSTONE)
                        .addShape("ILI","ILI"," I ")
                        .addIngredient('I', Material.IRON_INGOT)
                        .addIngredient('L', Material.ACACIA_LOG, Material.BIRCH_LOG, Material.CHERRY_LOG,
                                Material.DARK_OAK_LOG, Material.JUNGLE_LOG, Material.MANGROVE_LOG, Material.OAK_LOG,
                                Material.SPRUCE_LOG, Material.CHERRY_LOG
                        )
                        .create()
        );

        return result;
    }
}
