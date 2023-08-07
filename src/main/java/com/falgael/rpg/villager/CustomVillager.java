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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


import java.util.HashMap;
import java.util.Set;

public enum CustomVillager {

    NONE("NONE", ProficiencyTypes.NONE, new VillagerInstance.VillagerBuilder("", org.bukkit.entity.Villager.Profession.NONE).create(),0),

    WOODWORK_TIER_I(ProficiencyTypes.WOODWORK.getName() + "_TIER_I", ProficiencyTypes.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.SIMPLE.getRepresentation() + ProficiencyTypes.WOODWORK.getRepresentation(), org.bukkit.entity.Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.ACACIA_LOG,16)).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomBlocks.MISC_IRON_NUGGET.getItem()).addIngredients(new ItemStack(Material.BAMBOO,32)).create())
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
                    .create(),1),
    WOODWORK_TIER_II(ProficiencyTypes.WOODWORK.getName() + "_TIER_II", ProficiencyTypes.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.COMMON.getRepresentation() + ProficiencyTypes.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BONE_MEAL,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_SAPLING,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO,16)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_SAPLING,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_FUNGUS,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_NYLIUM,16)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_SAPLING,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_PROPAGULE,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.OAK_SAPLING,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_SAPLING,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_FUNGUS,32)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_NYLIUM,16)).addIngredients(CustomBlocks.MISC_IRON_NUGGET.getItem()).create())
                    .addRecipe(new MerchantRecipeBuilder(CustomTools.WOODWORK_ADVANCED_AXE.getItem()).addIngredients(CustomTools.WOODWORK_COMMON_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomBlocks.MISC_IRON_NUGGET.getItem(),32)).create())
                    .create(), 5),

    WOODWORK_TIER_III(ProficiencyTypes.WOODWORK.getName() + "_TIER_III", ProficiencyTypes.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.ADVANCED.getRepresentation() + ProficiencyTypes.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)

                    .addRecipe(new MerchantRecipeBuilder(CustomTools.WOODWORK_ELITE_AXE.getItem()).addIngredients(CustomTools.WOODWORK_ADVANCED_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomBlocks.MISC_GOLD_NUGGET.getItem(),8)).create())
            .create(), 10),

    WOODWORK_TIER_IV(ProficiencyTypes.WOODWORK.getName() + "_TIER_IV", ProficiencyTypes.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.ELITE.getRepresentation() + ProficiencyTypes.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)

                    .addRecipe(new MerchantRecipeBuilder(CustomTools.WOODWORK_EPIC_AXE.getItem()).addIngredients(CustomTools.WOODWORK_ELITE_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomBlocks.MISC_GOLD_NUGGET.getItem(),32)).create())
                    .create(), 20),

    WOODWORK_TIER_V(ProficiencyTypes.WOODWORK.getName() + "_TIER_V", ProficiencyTypes.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.EPIC.getRepresentation() + ProficiencyTypes.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)

                    .addRecipe(new MerchantRecipeBuilder(CustomTools.WOODWORK_LEGENDARY_AXE.getItem()).addIngredients(CustomTools.WOODWORK_EPIC_AXE.getItem())
                            .addIngredients(Utils.modifyAmount(CustomBlocks.MISC_GOLD_NUGGET.getItem(),64)).create())
                    .create(), 20),

    WOODWORK_TIER_VI(ProficiencyTypes.WOODWORK.getName() + "_TIER_VI", ProficiencyTypes.WOODWORK,
            new VillagerInstance.VillagerBuilder(Rarity.LEGENDARY.getRepresentation() + ProficiencyTypes.WOODWORK.getRepresentation(), Villager.Profession.BUTCHER)


                    .create(), 40),






    ;
    private final String key;

    private final ProficiencyTypes proficiency;

    private final int levelRequirement;

    private final VillagerInstance villagerInstance;

    private static final HashMap<String, CustomVillager> villagers = new HashMap<>();

    static {
        for (CustomVillager customVillager : CustomVillager.values()) {
            villagers.put(customVillager.key,customVillager);
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

    @Contract(pure = true)
    public static @NotNull Set<String> getVillagerKeys() {
        return villagers.keySet();
    }


}
