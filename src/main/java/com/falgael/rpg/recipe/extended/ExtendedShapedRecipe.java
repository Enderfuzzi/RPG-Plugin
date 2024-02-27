package com.falgael.rpg.recipe.extended;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.recipe.CraftingBookCategory;
import org.jetbrains.annotations.NotNull;

public class ExtendedShapedRecipe extends ShapedRecipe {
    /**
     * Create a shaped recipe to craft the specified ItemStack. The
     * constructor merely determines the result and type; to set the actual
     * recipe, you'll need to call the appropriate methods.
     *
     * @param key    the unique recipe key
     * @param result The item you want the recipe to create.
     * @see ShapedRecipe
     */
    public ExtendedShapedRecipe(@NotNull NamespacedKey key, @NotNull ItemStack result) {
        super(key, result);
    }

    public ExtendedShapedRecipe setCraftingCategory(CraftingBookCategory craftingBookCategory) {
        this.setCategory(craftingBookCategory);
        return this;
    }
}
