package com.falgael.rpg.definitions.stonework.recipe;

import com.falgael.rpg.recipe.CustomRecipes;
import com.falgael.rpg.recipe.extended.ExtendedBlastingRecipe;
import com.falgael.rpg.recipe.extended.ExtendedFurnaceRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.recipe.CookingBookCategory;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class Concrete extends CustomRecipes {


    private static final float EXPERIENCE = 0.7f;
    private static final int COOKING_TIME = 200;
    private static final int EXTENDED_COOKING_TIME = COOKING_TIME / 2;

    public Concrete(Plugin plugin) {
        super(plugin);
    }

    @Override
    public List<Recipe> getRecipes() {
        List<Recipe> result = new ArrayList<>();

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_WHITE_CONCRETE_BURNING"),
                        new ItemStack(Material.WHITE_CONCRETE),
                        Material.WHITE_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_WHITE_CONCRETE_BURNING"),
                        new ItemStack(Material.WHITE_CONCRETE),
                        Material.WHITE_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_ORANGE_CONCRETE_BURNING"),
                        new ItemStack(Material.ORANGE_CONCRETE),
                        Material.ORANGE_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_ORANGE_CONCRETE_BURNING"),
                        new ItemStack(Material.ORANGE_CONCRETE),
                        Material.ORANGE_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_MAGENTA_CONCRETE_BURNING"),
                        new ItemStack(Material.ORANGE_CONCRETE),
                        Material.MAGENTA_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_MAGENTA_CONCRETE_BURNING"),
                        new ItemStack(Material.ORANGE_CONCRETE),
                        Material.MAGENTA_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_LIGHT_BLUE_CONCRETE_BURNING"),
                        new ItemStack(Material.LIGHT_BLUE_CONCRETE),
                        Material.LIGHT_BLUE_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_LIGHT_BLUE_CONCRETE_BURNING"),
                        new ItemStack(Material.LIGHT_BLUE_CONCRETE),
                        Material.LIGHT_BLUE_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_YELLOW_CONCRETE_BURNING"),
                        new ItemStack(Material.YELLOW_CONCRETE),
                        Material.YELLOW_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_YELLOW_CONCRETE_BURNING"),
                        new ItemStack(Material.YELLOW_CONCRETE),
                        Material.YELLOW_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_LIME_CONCRETE_BURNING"),
                        new ItemStack(Material.LIME_CONCRETE),
                        Material.LIME_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_LIME_CONCRETE_BURNING"),
                        new ItemStack(Material.LIME_CONCRETE),
                        Material.LIME_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_PINK_CONCRETE_BURNING"),
                        new ItemStack(Material.PINK_CONCRETE),
                        Material.PINK_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_PINK_CONCRETE_BURNING"),
                        new ItemStack(Material.PINK_CONCRETE),
                        Material.PINK_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_GRAY_CONCRETE_BURNING"),
                        new ItemStack(Material.GRAY_CONCRETE),
                        Material.GRAY_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_GRAY_CONCRETE_BURNING"),
                        new ItemStack(Material.GRAY_CONCRETE),
                        Material.GRAY_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_LIGHT_GRAY_CONCRETE_BURNING"),
                        new ItemStack(Material.LIGHT_GRAY_CONCRETE),
                        Material.LIGHT_GRAY_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_LIGHT_GRAY_CONCRETE_BURNING"),
                        new ItemStack(Material.LIGHT_GRAY_CONCRETE),
                        Material.LIGHT_GRAY_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_CYAN_CONCRETE_BURNING"),
                        new ItemStack(Material.CYAN_CONCRETE),
                        Material.CYAN_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_CYAN_CONCRETE_BURNING"),
                        new ItemStack(Material.CYAN_CONCRETE),
                        Material.CYAN_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_PURPLE_CONCRETE_BURNING"),
                        new ItemStack(Material.PURPLE_CONCRETE),
                        Material.PURPLE_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_PURPLE_CONCRETE_BURNING"),
                        new ItemStack(Material.PURPLE_CONCRETE),
                        Material.PURPLE_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_BLUE_CONCRETE_BURNING"),
                        new ItemStack(Material.BLUE_CONCRETE),
                        Material.BLUE_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_BLUE_CONCRETE_BURNING"),
                        new ItemStack(Material.BLUE_CONCRETE),
                        Material.BLUE_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_BROWN_CONCRETE_BURNING"),
                        new ItemStack(Material.BROWN_CONCRETE),
                        Material.BROWN_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_BROWN_CONCRETE_BURNING"),
                        new ItemStack(Material.BROWN_CONCRETE),
                        Material.BROWN_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_GREEN_CONCRETE_BURNING"),
                        new ItemStack(Material.GREEN_CONCRETE),
                        Material.GREEN_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_GREEN_CONCRETE_BURNING"),
                        new ItemStack(Material.GREEN_CONCRETE),
                        Material.GREEN_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_RED_CONCRETE_BURNING"),
                        new ItemStack(Material.RED_CONCRETE),
                        Material.RED_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_RED_CONCRETE_BURNING"),
                        new ItemStack(Material.RED_CONCRETE),
                        Material.RED_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedFurnaceRecipe(
                        namespacedKey("FURNACE_BLACK_CONCRETE_BURNING"),
                        new ItemStack(Material.BLACK_CONCRETE),
                        Material.BLACK_CONCRETE_POWDER,
                        EXPERIENCE,
                        COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        result.add(
                new ExtendedBlastingRecipe(
                        namespacedKey("BLASTING_BLACK_CONCRETE_BURNING"),
                        new ItemStack(Material.BLACK_CONCRETE),
                        Material.BLACK_CONCRETE_POWDER,
                        EXPERIENCE,
                        EXTENDED_COOKING_TIME
                ).setCookingCategory(CookingBookCategory.BLOCKS)
        );

        return result;
    }
}
