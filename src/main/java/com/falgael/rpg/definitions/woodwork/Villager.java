package com.falgael.rpg.definitions.woodwork;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import com.falgael.rpg.villager.MainVillagerDefinition;
import com.falgael.rpg.villager.MerchantRecipeBuilder;
import com.falgael.rpg.villager.VillagerInstance;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Villager extends MainVillagerDefinition {

    public Villager(ItemManagement itemManager) {
        super(itemManager);
    }


    @Override
    public List<VillagerInstance> getVillager() {
        List<VillagerInstance> result = new ArrayList<>();
        result.add(
                new VillagerInstance.VillagerBuilder("Carpenter 1", org.bukkit.entity.Villager.Profession.CARTOGRAPHER)
                        .rarity(Rarity.SIMPLE)
                        .proficiency(Proficiency.WOODWORK)
                        .level(1)
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_LOG,16)).addIngredients(new ItemStack(Material.ACACIA_LOG,16)).create())
                        /*
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.ACACIA_LOG,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.BAMBOO,32)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.BIRCH_LOG,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.CHERRY_LOG,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.CRIMSON_STEM,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.JUNGLE_LOG,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.MANGROVE_LOG,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.OAK_LOG,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.SPRUCE_LOG,16)).create())
                        .add(new MerchantRecipeBuilder(Items.SILVER_COIN.getItemByKey()).addIngredients(new ItemStack(Material.WARPED_STEM,16)).create())


                         */
                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Carpenter 2", org.bukkit.entity.Villager.Profession.CARTOGRAPHER)
                  .rarity(Rarity.COMMON)
                  .proficiency(Proficiency.WOODWORK)
                  .level(5)
    /*
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.BONE_MEAL,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.ACACIA_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.BAMBOO,16)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.CHERRY_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_FUNGUS,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.CRIMSON_NYLIUM,16)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.JUNGLE_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.MANGROVE_PROPAGULE,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.OAK_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.SPRUCE_SAPLING,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_FUNGUS,32)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())
                  .add(new MerchantRecipeBuilder(new ItemStack(Material.WARPED_NYLIUM,16)).addIngredients(Items.SILVER_COIN.getItemByKey()).create())


     */
                  .create()
        );


        return result;
    }
}
