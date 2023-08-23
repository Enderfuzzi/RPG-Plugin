package com.falgael.rpg.proficiency;

import com.falgael.rpg.proficiency.blocks.CustomBlocks;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum ForbiddenCrafting {

    NONE(Material.AIR, new ItemStack(Material.AIR)),
    COMPRESSED_OAK_WOOD(Material.AIR, CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()),
    COMPRESSED_STONE(Material.AIR, CustomBlocks.STONEWORK_COMPRESSED_STONE.getItem()),

    ;
    private final ItemStack result;

    private final ItemStack ingredient;

    ForbiddenCrafting(Material result, ItemStack ingredient) {
        this.result = new ItemStack(result);
        this.ingredient = ingredient;
    }

    private static boolean isForbiddenResult(ItemStack toCheck) {
        for (ForbiddenCrafting forbiddenCrafting : ForbiddenCrafting.values()) {
            if (forbiddenCrafting.result.getType() == Material.AIR) continue;
            if (forbiddenCrafting.result.equals(toCheck)) return true;
        }
        return false;
    }

    private static boolean isForbiddenIngredient(ItemStack toCheck) {
        for (ForbiddenCrafting forbiddenCrafting : ForbiddenCrafting.values()) {
            if (forbiddenCrafting.ingredient.getType() == Material.AIR) continue;
            if (forbiddenCrafting.ingredient.equals(toCheck)) return true;
        }
        return false;
    }

    public static boolean isForbidden(ItemStack[] ingredients, ItemStack result) {
        if (isForbiddenResult(result)) return true;
        for (ItemStack itemStack : ingredients) {
            if (isForbiddenIngredient(itemStack)) return true;
        }
        return false;
    }


}
