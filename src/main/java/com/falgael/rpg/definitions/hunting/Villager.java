package com.falgael.rpg.definitions.hunting;

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
                new VillagerInstance.VillagerBuilder("Huntsman 1", org.bukkit.entity.Villager.Profession.WEAPONSMITH)
                        .rarity(Rarity.SIMPLE)
                        .proficiency(Proficiency.HUNTING)
                        .level(1)

                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.ROTTEN_FLESH,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.GUNPOWDER,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.STRING,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.BONE,16)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.SPIDER_EYE,8)).create())
                        .add(new MerchantRecipeBuilder(itemManager.getItemByID(90000).getItemStackRepresentation())
                                .addIngredients(new ItemStack(Material.ENDER_PEARL,4)).create())

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Huntsman 2", org.bukkit.entity.Villager.Profession.WEAPONSMITH)
                        .rarity(Rarity.COMMON)
                        .proficiency(Proficiency.HUNTING)
                        .level(5)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Huntsman 3", org.bukkit.entity.Villager.Profession.WEAPONSMITH)
                        .rarity(Rarity.ADVANCED)
                        .proficiency(Proficiency.HUNTING)
                        .level(10)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Huntsman 4", org.bukkit.entity.Villager.Profession.WEAPONSMITH)
                        .rarity(Rarity.ELITE)
                        .proficiency(Proficiency.HUNTING)
                        .level(20)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Huntsman 5", org.bukkit.entity.Villager.Profession.WEAPONSMITH)
                        .rarity(Rarity.EPIC)
                        .proficiency(Proficiency.HUNTING)
                        .level(35)

                        .create()
        );

        result.add(
                new VillagerInstance.VillagerBuilder("Huntsman 6", org.bukkit.entity.Villager.Profession.WEAPONSMITH)
                        .rarity(Rarity.LEGENDARY)
                        .proficiency(Proficiency.HUNTING)
                        .level(50)

                        .create()
        );


        return result;
    }
}
