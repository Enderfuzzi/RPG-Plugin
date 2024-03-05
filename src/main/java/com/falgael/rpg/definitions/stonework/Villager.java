package com.falgael.rpg.definitions.stonework;

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
                new VillagerInstance.VillagerBuilder("Mason 1", org.bukkit.entity.Villager.Profession.TOOLSMITH)
                        .rarity(Rarity.SIMPLE)
                        .proficiency(Proficiency.STONEWORK)
                        .level(1)

                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COBBLED_DEEPSLATE, 16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                        .addIngredients(new ItemStack(Material.COBBLESTONE, 32)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                        .addIngredients(new ItemStack(Material.DEEPSLATE, 16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                        .addIngredients(new ItemStack(Material.STONE, 32)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                        .addIngredients(new ItemStack(Material.SAND, 64)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.RED_SAND, 64)).create())
                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Mason 2", org.bukkit.entity.Villager.Profession.TOOLSMITH)
                        .rarity(Rarity.COMMON)
                        .proficiency(Proficiency.STONEWORK)
                        .level(5)

                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                        .addIngredients(new ItemStack(Material.IRON_INGOT, 8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                        .addIngredients(new ItemStack(Material.COPPER_INGOT, 8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                        .addIngredients(new ItemStack(Material.GOLD_INGOT, 4)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.LAPIS_LAZULI, 16)).create())
                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Mason 3", org.bukkit.entity.Villager.Profession.TOOLSMITH)
                        .rarity(Rarity.ADVANCED)
                        .proficiency(Proficiency.STONEWORK)
                        .level(10)

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COAL,32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.IRON_INGOT,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COPPER_INGOT,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.GOLD_INGOT,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.LAPIS_LAZULI,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.QUARTZ_BLOCK,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Mason 4", org.bukkit.entity.Villager.Profession.TOOLSMITH)
                        .rarity(Rarity.ELITE)
                        .proficiency(Proficiency.STONEWORK)
                        .level(20)

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COAL_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_COAL_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.IRON_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_IRON_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COPPER_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_COPPER_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.GOLD_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_GOLD_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.REDSTONE_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_REDSTONE_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.EMERALD_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_EMERALD_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.LAPIS_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_LAPIS_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DIAMOND_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DEEPSLATE_DIAMOND_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.NETHER_GOLD_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.NETHER_QUARTZ_ORE, 4))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Jeweler", org.bukkit.entity.Villager.Profession.TOOLSMITH)
                        .rarity(Rarity.ELITE)
                        .proficiency(Proficiency.STONEWORK)
                        .level(20)


                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DIAMOND,8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.EMERALD,8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.AMETHYST_SHARD,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.BUDDING_AMETHYST, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SMALL_AMETHYST_BUD,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.MEDIUM_AMETHYST_BUD,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.LARGE_AMETHYST_BUD,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.AMETHYST_CLUSTER,16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())



                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Mason 5", org.bukkit.entity.Villager.Profession.TOOLSMITH)
                        .rarity(Rarity.EPIC)
                        .proficiency(Proficiency.STONEWORK)
                        .level(35)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Mason 6", org.bukkit.entity.Villager.Profession.TOOLSMITH)
                        .rarity(Rarity.LEGENDARY)
                        .proficiency(Proficiency.STONEWORK)
                        .level(50)

                        .create()
        );

        return result;
    }
}
