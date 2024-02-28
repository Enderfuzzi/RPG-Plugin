package com.falgael.rpg.definitions.farming;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.ItemStackManipulation;
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
                new VillagerInstance.VillagerBuilder("Farmer 1", org.bukkit.entity.Villager.Profession.FARMER)
                        .rarity(Rarity.SIMPLE)
                        .proficiency(Proficiency.FARMING)
                        .level(1)

                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.WHEAT,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.CARROT,32)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.POTATO,32)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.BEETROOT,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.NETHER_WART,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.MELON,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.PUMPKIN,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.HONEY_BLOCK,4)).create())

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Butcher 1", org.bukkit.entity.Villager.Profession.BUTCHER)
                        .rarity(Rarity.SIMPLE)
                        .proficiency(Proficiency.FARMING)
                        .level(1)

                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COOKED_BEEF,8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COOKED_CHICKEN,8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COOKED_PORKCHOP,8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COOKED_MUTTON,8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COOKED_RABBIT,8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COOKED_SALMON,8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.COOKED_COD,8)).create())

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Farmer 2", org.bukkit.entity.Villager.Profession.FARMER)
                        .rarity(Rarity.COMMON)
                        .proficiency(Proficiency.FARMING)
                        .level(5)

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.WHEAT_SEEDS, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.BEETROOT_SEEDS, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.MELON_SEEDS, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.PUMPKIN_SEEDS, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.CARROT, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.POTATO, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.NETHER_WART, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Butcher 2", org.bukkit.entity.Villager.Profession.BUTCHER)
                        .rarity(Rarity.COMMON)
                        .proficiency(Proficiency.FARMING)
                        .level(5)

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.BEE_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 4)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COW_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 4)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.PIG_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 4)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.CHICKEN_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 4)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.RABBIT_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 4)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.SALMON_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 4)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COD_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 4)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.TROPICAL_FISH_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 16)
                                ).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.PUFFERFISH_SPAWN_EGG))
                                .addIngredients(
                                        ItemStackManipulation.modifyItemAmount(itemManager.getItemByID(90000).getItemStackRepresentation(), 16)
                                ).create())


                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Farmer 3", org.bukkit.entity.Villager.Profession.FARMER)
                        .rarity(Rarity.ADVANCED)
                        .proficiency(Proficiency.FARMING)
                        .level(10)

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.FLOWER_POT, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DANDELION, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.POPPY, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.BLUE_ORCHID, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.AZURE_BLUET, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.DANDELION, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.ORANGE_TULIP, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.PINK_TULIP, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.RED_TULIP, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.WHITE_TULIP, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.OXEYE_DAISY, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.CORNFLOWER, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.LILY_OF_THE_VALLEY, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.TORCHFLOWER, 32))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.WITHER_ROSE, 16))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())


                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Butcher 3", org.bukkit.entity.Villager.Profession.BUTCHER)
                        .rarity(Rarity.ADVANCED)
                        .proficiency(Proficiency.FARMING)
                        .level(10)

                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COOKED_BEEF, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COOKED_CHICKEN, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COOKED_PORKCHOP, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COOKED_MUTTON, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COOKED_RABBIT, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COOKED_COD, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())
                        .add(new MerchantRecipeBuilder(new ItemStack(Material.COOKED_SALMON, 8))
                                .addIngredients(itemManager.getItemByID(90000).getItemStackRepresentation()).create())


                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Farmer 4", org.bukkit.entity.Villager.Profession.FARMER)
                        .rarity(Rarity.ELITE)
                        .proficiency(Proficiency.FARMING)
                        .level(20)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Butcher 4", org.bukkit.entity.Villager.Profession.BUTCHER)
                        .rarity(Rarity.ELITE)
                        .proficiency(Proficiency.FARMING)
                        .level(20)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Farmer 5", org.bukkit.entity.Villager.Profession.FARMER)
                        .rarity(Rarity.EPIC)
                        .proficiency(Proficiency.FARMING)
                        .level(35)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Butcher 5", org.bukkit.entity.Villager.Profession.BUTCHER)
                        .rarity(Rarity.EPIC)
                        .proficiency(Proficiency.FARMING)
                        .level(35)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Farmer 6", org.bukkit.entity.Villager.Profession.FARMER)
                        .rarity(Rarity.LEGENDARY)
                        .proficiency(Proficiency.FARMING)
                        .level(50)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Butcher 6", org.bukkit.entity.Villager.Profession.BUTCHER)
                        .rarity(Rarity.LEGENDARY)
                        .proficiency(Proficiency.FARMING)
                        .level(50)

                        .create()
        );


        return result;
    }
}
