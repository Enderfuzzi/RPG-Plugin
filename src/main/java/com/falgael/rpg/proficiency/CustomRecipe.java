package com.falgael.rpg.proficiency;

import com.falgael.rpg.recipe.RecipeBuilder;
import com.falgael.rpg.recipe.RecipeType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public enum CustomRecipe {

    OAK_STAIR_TO_SLAB(new RecipeBuilder(new ItemStack(Material.OAK_SLAB), "OAK_STAIR_TO_SLAB", RecipeType.STONECUTTER)
            .addIngredient(new ItemStack(Material.OAK_STAIRS)).create()),

    ;

    static {
        for (CustomRecipe recipes : CustomRecipe.values()) {
            Bukkit.addRecipe(recipes.recipe);
        }
    }

    private final Recipe recipe;

    CustomRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


}
