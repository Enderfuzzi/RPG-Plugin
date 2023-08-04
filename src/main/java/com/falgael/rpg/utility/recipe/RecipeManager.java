package com.falgael.rpg.utility.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class RecipeManager {

    public static void initialize() {

        //--------------------------------------------------------------------------------------------
        // Shapeless recipes
        //--------------------------------------------------------------------------------------------




        //--------------------------------------------------------------------------------------------
        // Stonecutting recipes
        //--------------------------------------------------------------------------------------------


        addRecipe(new RecipeBuilder(new ItemStack(Material.OAK_SLAB), "OAK_STAIR_TO_SLAB", RecipeType.STONECUTTER)
                .addIngredient(new ItemStack(Material.OAK_STAIRS)).create());
        addRecipe(new RecipeBuilder(new ItemStack(Material.OAK_STAIRS), "OAK_SLAB_TO_STAIR", RecipeType.STONECUTTER)
                .addIngredient(new ItemStack(Material.OAK_SLAB)).create());





    }

    public static void addRecipe(Recipe recipe) {
        Bukkit.addRecipe(recipe);
        Bukkit.getLogger().info("[" + RecipeManager.class.getSimpleName() + "]: Registered Recipe: " + recipe.toString());
    }


}
