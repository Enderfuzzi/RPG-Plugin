package com.falgael.rpg.recipe.extended;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.BlastingRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.recipe.CookingBookCategory;
import org.jetbrains.annotations.NotNull;

public class ExtendedBlastingRecipe extends BlastingRecipe {
    public ExtendedBlastingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull Material source, float experience, int cookingTime) {
        super(key, result, source, experience, cookingTime);
    }

    public ExtendedBlastingRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result, @NotNull RecipeChoice input, float experience, int cookingTime) {
        super(key, result, input, experience, cookingTime);
    }

    public ExtendedBlastingRecipe setCookingCategory(CookingBookCategory cookingCategory) {
        this.setCategory(cookingCategory);
        return this;
    }

}
