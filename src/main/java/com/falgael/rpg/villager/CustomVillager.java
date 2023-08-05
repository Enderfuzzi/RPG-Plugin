package com.falgael.rpg.villager;

import com.falgael.rpg.proficiency.ProficiencyTypes;
import com.falgael.rpg.proficiency.Utils;
import com.falgael.rpg.proficiency.items.CustomBlocks;
import com.falgael.rpg.proficiency.items.CustomTools;
import com.falgael.rpg.proficiency.items.Rarity;
import com.falgael.rpg.recipe.MerchantRecipeBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.HashMap;

public enum CustomVillager {

    NONE("", ProficiencyTypes.NONE, new VillagerInstance.VillagerBuilder("", org.bukkit.entity.Villager.Profession.NONE).create(),0),

    WOODWORK_TIER_I(ProficiencyTypes.WOODWORK.getName() + "_TIER_I", ProficiencyTypes.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.SIMPLE.getRepresentation() + ProficiencyTypes.WOODWORK.getRepresentation(), org.bukkit.entity.Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.ACACIA_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.BIRCH_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.CHERRY_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.CRIMSON_STEM,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.JUNGLE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.MANGROVE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.OAK_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.SPRUCE_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.WARPED_STEM,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTools.WOODWORK_COMMON_AXE.getItem()).addIngredients(CustomTools.WOODWORK_SIMPLE_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomBlocks.MISC_IRON_NUGGET.getItem(),4)).create())
                    .create(),1);

    private final String key;

    private final ProficiencyTypes proficiency;

    private final int levelRequirement;

    private final VillagerInstance villagerInstance;

    private static final HashMap<String, CustomVillager> villagers = new HashMap<>();

    private static final HashMap<VillagerInstance, CustomVillager> villager_Map = new HashMap<>();

    static {
        for (CustomVillager customVillager : CustomVillager.values()) {
            villagers.put(customVillager.key,customVillager);
            villager_Map.put(customVillager.villagerInstance,customVillager);
        }


    }

    CustomVillager(String key, ProficiencyTypes proficiency , VillagerInstance villagerInstance, int levelRequirement) {
        this.key = key;
        this.proficiency = proficiency;
        this.villagerInstance = villagerInstance;
        this.levelRequirement = levelRequirement;
    }

    public ProficiencyTypes getProficiency() {
        return proficiency;
    }

    public VillagerInstance getVillager() {
        return villagerInstance;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public static CustomVillager getVillager(String key) {
        return villagers.getOrDefault(key, NONE);
    }

    public static CustomVillager getVillager(Villager villager) {
        for (CustomVillager customVillager : CustomVillager.values()) {
            if (customVillager.villagerInstance.isSame(villager)) return customVillager;
        }
        return NONE;
    }


    public int getLevelRequirement() {
        return levelRequirement;
    }

}
