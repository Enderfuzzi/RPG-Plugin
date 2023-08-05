package com.falgael.rpg.recipe;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class MerchantRecipeBuilder {


    private MerchantRecipe recipe;

    public MerchantRecipeBuilder(ItemStack result) {
        recipe = new MerchantRecipe(result,0,Integer.MAX_VALUE,false,0,0f,0,0);
    }

    public MerchantRecipeBuilder addIngredients(ItemStack item) {
        recipe.addIngredient(item);
        return this;
    }

    public MerchantRecipeBuilder addUses(int value) {
        recipe.setUses(value);
        return this;
    }

    public MerchantRecipeBuilder setExperienceReward(boolean flag) {
        recipe.setExperienceReward(flag);
        return this;
    }

    public MerchantRecipeBuilder setMaxUses(int maxUses) {
        recipe.setMaxUses(maxUses);
        return this;
    }

    public MerchantRecipeBuilder setPriceMultiplier(float priceMultiplier) {
        recipe.setPriceMultiplier(priceMultiplier);
        return this;
    }

    public MerchantRecipeBuilder setSpecialPrice(int specialPrice) {
        recipe.setSpecialPrice(specialPrice);
        return this;
    }

    public MerchantRecipeBuilder setVillagerExperience(int villagerExperience) {
        recipe.setVillagerExperience(villagerExperience);
        return this;
    }

    public MerchantRecipe create() {
        return recipe;
    }

}
