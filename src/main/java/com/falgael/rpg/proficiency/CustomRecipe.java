package com.falgael.rpg.proficiency;

import com.falgael.rpg.proficiency.blocks.CustomBlocks;
import com.falgael.rpg.recipe.RecipeBuilder;
import com.falgael.rpg.recipe.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public enum CustomRecipe {
    // Note Loading these Recipes is placed in initializer

    TEST(new RecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem(), "TEST_Recipe", RecipeType.SHAPELESS)
            .addIngredient(new ItemStack(Material.LIGHT, 64)).create()),


    OAK_STAIR_TO_SLAB(new RecipeBuilder(new ItemStack(Material.OAK_SLAB), "OAK_STAIR_TO_SLAB", RecipeType.STONECUTTER)
            .addIngredient(new ItemStack(Material.OAK_STAIRS)).create()),

    ;

    private final Recipe recipe;

    CustomRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }
}
