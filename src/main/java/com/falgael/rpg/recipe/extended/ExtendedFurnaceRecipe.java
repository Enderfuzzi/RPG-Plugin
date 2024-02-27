package com.falgael.rpg.recipe.extended;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CookingBookCategory;
import org.jetbrains.annotations.NotNull;

public class ExtendedFurnaceRecipe extends FurnaceRecipe {
    /**
     * Create a furnace recipe to craft the specified ItemStack.
     *
     * @param key         The unique recipe key
     * @param result      The item you want the recipe to create.
     * @param source      The input material.
     * @param experience  The experience given by this recipe
     * @param cookingTime The cooking time (in ticks)
     */
    public ExtendedFurnaceRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull Material source, float experience, int cookingTime) {
        super(key, result, source, experience, cookingTime);
    }

    /**
     * Create a furnace recipe to craft the specified ItemStack.
     *
     * @param key         The unique recipe key
     * @param result      The item you want the recipe to create.
     * @param input       The input choices.
     * @param experience  The experience given by this recipe
     * @param cookingTime The cooking time (in ticks)
     */
    public ExtendedFurnaceRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input, float experience, int cookingTime) {
        super(key, result, input, experience, cookingTime);
    }

    public ExtendedFurnaceRecipe setCookingCategory(CookingBookCategory cookingCategory) {
        this.setCategory(cookingCategory);
        return this;
    }
}
