package com.falgael.rpg.definitions.misc;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.ItemStackManipulation;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import com.falgael.rpg.villager.MainVillagerDefinition;
import com.falgael.rpg.villager.MerchantRecipeBuilder;
import com.falgael.rpg.villager.VillagerInstance;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

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
                new VillagerInstance.VillagerBuilder(
                        "Illuminator 1", org.bukkit.entity.Villager.Profession.CARTOGRAPHER
                )
                        .proficiency(Proficiency.MISC)
                        .rarity(Rarity.COMMON)
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.GLOWSTONE, 4)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.LANTERN, 8)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.OCHRE_FROGLIGHT, 8)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.PEARLESCENT_FROGLIGHT, 8)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.REDSTONE_LAMP, 4)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SOUL_LANTERN, 8)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SEA_LANTERN, 8)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SHROOMLIGHT, 8)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.VERDANT_FROGLIGHT, 8)).addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .create());

        result.add(
                new VillagerInstance.VillagerBuilder(
                        "Illuminator 2", org.bukkit.entity.Villager.Profession.CARTOGRAPHER
                )
                        .proficiency(Proficiency.MISC)
                        .rarity(Rarity.ADVANCED)
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.GLOWSTONE, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),16)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.LANTERN, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),8)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.OCHRE_FROGLIGHT, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),8)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.PEARLESCENT_FROGLIGHT, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),8)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.REDSTONE_LAMP, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),16)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SOUL_LANTERN, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),8)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SEA_LANTERN, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),8)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SHROOMLIGHT, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),8)).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.VERDANT_FROGLIGHT, 64)).addIngredients(
                                ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(),8)).create())
                        .create());


        return result;
    }
}
