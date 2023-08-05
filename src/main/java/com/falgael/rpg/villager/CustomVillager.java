package com.falgael.rpg.villager;

import com.falgael.rpg.proficiency.ProficiencyTypes;
import com.falgael.rpg.proficiency.items.CustomBlocks;
import com.falgael.rpg.recipe.MerchantRecipeBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public enum CustomVillager {

    NONE("", ProficiencyTypes.NONE, new Villager.VillagerBuilder("", org.bukkit.entity.Villager.Profession.NONE).create()),

    WOODWORK_TIER_I(ProficiencyTypes.WOODWORK.getName() + "_TIER_I", ProficiencyTypes.WOODWORK,
            new Villager.VillagerBuilder(ProficiencyTypes.WOODWORK.getName() + "_TIER_I", org.bukkit.entity.Villager.Profession.BUTCHER)
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.ACACIA_LOG,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.BIRCH_LOG,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.CHERRY_LOG,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.CRIMSON_STEM,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.JUNGLE_LOG,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.MANGROVE_LOG,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.OAK_LOG,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.SPRUCE_LOG,64)).create())
            .addRecipe(new MerchantRecipeBuilder(CustomBlocks.WOODWORK_COMPRESSED_OAK.getItem()).addIngredients(new ItemStack(Material.WARPED_STEM,64)).create()).create());

    private final String key;

    private final ProficiencyTypes proficiency;

    private final com.falgael.rpg.villager.Villager villager;

    private static final HashMap<String, CustomVillager> villagers = new HashMap<>();
    static {
        for (CustomVillager villager : CustomVillager.values()) {
            villagers.put(villager.key,villager);
        }
    }

    CustomVillager(String key, ProficiencyTypes proficiency , Villager villager) {
        this.key = key;
        this.proficiency = proficiency;
        this.villager = villager;
    }

    public ProficiencyTypes getProficiency() {
        return proficiency;
    }

    public Villager getVillager() {
        return villager;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public static CustomVillager getVillager(String key) {
        return villagers.getOrDefault(key, NONE);
    }

}
