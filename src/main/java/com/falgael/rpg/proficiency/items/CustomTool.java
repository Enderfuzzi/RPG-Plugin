package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.items.ItemModifier;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.general.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum CustomTool {
    NONE(ProficiencyType.NONE, new ItemStack(Material.AIR), new ItemConfiguration.Builder(EquipmentSlot.HAND).create()),

    MIGHTY_DEATH(ProficiencyType.MISC, new ItemBuilder(Material.NETHERITE_SWORD).setRarity(Rarity.LEGENDARY).setName("Mighty Death")
            .addProficiency(ProficiencyType.HUNTING).addLore("Death is the only solution").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.4)
            .addAttribute(Attribute.GENERIC_MAX_HEALTH, 20).addAttribute(Attribute.GENERIC_ARMOR, 20).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 10000).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 10000f).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 100000.0f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,110,10,false,false)).create()),

    MIGHTY_AXE(ProficiencyType.MISC, new ItemBuilder(Material.NETHERITE_AXE).setRarity(Rarity.LEGENDARY).setName("Mighty Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLore(ItemModifier.LOOT, "10000").addLore(ItemModifier.EXPERIENCE,"100000")
            .addLore("Foraging is the only solution").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.4).addAttribute(Attribute.GENERIC_MAX_HEALTH, 20)
            .addAttribute(Attribute.GENERIC_ARMOR, 20).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 10000f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 10000f).create()),


    MIGHTY_PICKAXE(ProficiencyType.MISC, new ItemBuilder(Material.NETHERITE_PICKAXE).setRarity(Rarity.LEGENDARY).setName("Mighty Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "10000").addLore(ItemModifier.EXPERIENCE,"100000")
            .addLore("Mining is the only solution").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.4).addAttribute(Attribute.GENERIC_MAX_HEALTH, 20)
            .addAttribute(Attribute.GENERIC_ARMOR, 20).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 10000f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 10000f).create()),



    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------


    WOODWORK_SIMPLE_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.WOODEN_AXE).setRarity(Rarity.SIMPLE).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLore(ItemModifier.LOOT, "50").addLore("Simple tool for harvesting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 1.5f).create()),
    WOODWORK_COMMON_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.STONE_AXE).setRarity(Rarity.COMMON).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLore(ItemModifier.LOOT, "100").addLore("Common tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.005).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 4).addAttribute(Attribute.GENERIC_ATTACK_SPEED, -3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2f).create()),

    WOODWORK_ADVANCED_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.IRON_AXE).setRarity(Rarity.ADVANCED).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLore(ItemModifier.LOOT, "150").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Advanced tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.05).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 6).addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2.7).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2.5f).create()),

    WOODWORK_ELITE_AXE( ProficiencyType.WOODWORK, new ItemBuilder(Material.GOLDEN_AXE).setRarity(Rarity.ELITE).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLore(ItemModifier.LOOT, "200").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Advanced tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.1).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 7).addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 3f).create()),

    WOODWORK_EPIC_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.DIAMOND_AXE).setRarity(Rarity.EPIC).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLore(ItemModifier.LOOT, "350").addLore(ItemModifier.EXPERIENCE,"200")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.15).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 10).addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 3f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4.5f).create()),

    WOODWORK_LEGENDARY_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.NETHERITE_AXE).setRarity(Rarity.LEGENDARY).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLore(ItemModifier.LOOT, "600").addLore(ItemModifier.EXPERIENCE,"500")
            .addLore("Forged in the depth").addLore(ItemModifier.LEVEL_REQUIREMENT,"50")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.2).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 14)
            .addAttribute(Attribute.GENERIC_MAX_HEALTH, 8).addAttribute(Attribute.GENERIC_ARMOR, 3).addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, 0.1)
            .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 6f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 7f)
                    .addFlag(ItemConfigurationFlag.LEVEL_REQUIREMENT,50.f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,110,0, true,false)).create()),

    WOODWORK_SHEARS(ProficiencyType.WOODWORK, new ItemBuilder(Material.SHEARS).setRarity(Rarity.ADVANCED).setName("Shears")
            .addProficiency(ProficiencyType.WOODWORK).addLore("Harvest Leaves")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.1).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).create()),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONEWORK_SIMPLE_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.WOODEN_PICKAXE).setRarity(Rarity.SIMPLE).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "50").addLore("Simple tool for harvesting")
            .create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 1.5f).create()),
    STONEWORK_COMMON_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE_PICKAXE).setRarity(Rarity.COMMON).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "100").addLore("Common tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.005).addAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2f).create()),

    STONEWORK_ADVANCED_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.IRON_PICKAXE).setRarity(Rarity.ADVANCED).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "150").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Advanced tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.05).addAttribute(Attribute.GENERIC_MAX_HEALTH, 1.0).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f)
                    .addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2.5f).create()),

    STONEWORK_ELITE_PICKAXE( ProficiencyType.STONEWORK, new ItemBuilder(Material.GOLDEN_PICKAXE).setRarity(Rarity.ELITE).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "200").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Advanced tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.1).addAttribute(Attribute.GENERIC_MAX_HEALTH, 1.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 3f).create()),

    STONEWORK_EPIC_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.DIAMOND_PICKAXE).setRarity(Rarity.EPIC).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "350").addLore(ItemModifier.EXPERIENCE,"200")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.15).addAttribute(Attribute.GENERIC_MAX_HEALTH, 3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,3f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4.5f).create()),

    STONEWORK_LEGENDARY_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.NETHERITE_PICKAXE).setRarity(Rarity.LEGENDARY).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "600").addLore(ItemModifier.EXPERIENCE,"500")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.2).addAttribute(Attribute.GENERIC_MAX_HEALTH, 16)
            .addAttribute(Attribute.GENERIC_ARMOR, 6).addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, 1).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,6f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 7f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,110,0, true,false)).create()),



    STONEWORK_SIMPLE_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.WOODEN_SHOVEL).setRarity(Rarity.SIMPLE).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "50").addLore("Simple tool for harvesting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 1.5f).create()),
    STONEWORK_COMMON_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE_SHOVEL).setRarity(Rarity.COMMON).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "100").addLore("Common tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.005).addAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2f).create()),

    STONEWORK_ADVANCED_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.IRON_SHOVEL).setRarity(Rarity.ADVANCED).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "150").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Advanced tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.05).addAttribute(Attribute.GENERIC_MAX_HEALTH, 1.0).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2.5f).create()),

    STONEWORK_ELITE_SHOVEL( ProficiencyType.STONEWORK, new ItemBuilder(Material.GOLDEN_SHOVEL).setRarity(Rarity.ELITE).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "200").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Elite tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.1).addAttribute(Attribute.GENERIC_MAX_HEALTH, 1.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 3f).create()),

    STONEWORK_EPIC_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.DIAMOND_SHOVEL).setRarity(Rarity.EPIC).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "350").addLore(ItemModifier.EXPERIENCE,"200")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.15).addAttribute(Attribute.GENERIC_MAX_HEALTH, 3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,3f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4.5f).create()),

    STONEWORK_LEGENDARY_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.NETHERITE_SHOVEL).setRarity(Rarity.LEGENDARY).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLore(ItemModifier.LOOT, "600").addLore(ItemModifier.EXPERIENCE,"500")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.2).addAttribute(Attribute.GENERIC_MAX_HEALTH, 16)
                    .addAttribute(Attribute.GENERIC_ARMOR, 6).addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, 1).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,6f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 7f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,110,0, true,false))
                    .create()),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_SIMPLE_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.WOODEN_HOE).setRarity(Rarity.SIMPLE).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "50").addLore("Simple tool for harvesting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 1.5f).create()),

    FARMING_COMMON_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.STONE_HOE).setRarity(Rarity.COMMON).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "100").addLore("Common tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.005).addAttribute(Attribute.GENERIC_MAX_HEALTH, 0.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2f).create()),

    FARMING_ADVANCED_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.IRON_HOE).setRarity(Rarity.ADVANCED).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "150").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Advanced tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.05).addAttribute(Attribute.GENERIC_MAX_HEALTH, 1.0).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2.5f).create()),

    FARMING_ELITE_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.GOLDEN_HOE).setRarity(Rarity.ELITE).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "200").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Elite tool for harvesting")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.1).addAttribute(Attribute.GENERIC_MAX_HEALTH, 1.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 3f).create()),

    FARMING_EPIC_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.DIAMOND_HOE).setRarity(Rarity.EPIC).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "350").addLore(ItemModifier.EXPERIENCE,"200")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.15).addAttribute(Attribute.GENERIC_MAX_HEALTH, 3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,3f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4.5f).create()),

    FARMING_LEGENDARY_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.NETHERITE_HOE).setRarity(Rarity.LEGENDARY).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "600").addLore(ItemModifier.EXPERIENCE,"500")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.2).addAttribute(Attribute.GENERIC_MAX_HEALTH, 16)
            .addAttribute(Attribute.GENERIC_ARMOR, 6).addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, 0.1).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,6f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 7f).create()),

    FARMING_ADVANCED_SHEARS(ProficiencyType.FARMING, new ItemBuilder(Material.SHEARS).setRarity(Rarity.ADVANCED).setName("Shears")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "100").addLore(ItemModifier.EXPERIENCE,"300")
            .addLore("Shears Sheep").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.1).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,4f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER,2f)
                   .create()),

    FARMING_EPIC_SHEARS(ProficiencyType.FARMING, new ItemBuilder(Material.SHEARS).setRarity(Rarity.EPIC).setName("Shears")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT, "200").addLore(ItemModifier.EXPERIENCE,"500")
            .addLore("Shears Sheep").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, 0.15).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,6f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER,3f)
                   .create()),

    FARMING_COMMON_SWORD(ProficiencyType.FARMING, new ItemBuilder(Material.STONE_SWORD).setRarity(Rarity.SIMPLE).setName("Sword")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT,"100").addLore(ItemModifier.EXPERIENCE, "100")
            .addLore("Common tool for killing Animals").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.01).addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2)
            .addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 10).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2f).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 2f)
                    .addFlag(ItemConfigurationFlag.LEVEL_REQUIREMENT, 5f).create()),

    FARMING_ADVANCED_SWORD(ProficiencyType.FARMING, new ItemBuilder(Material.IRON_SWORD).setRarity(Rarity.ADVANCED).setName("Sword")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT,"300").addLore(ItemModifier.EXPERIENCE, "300")
            .addLore("Common tool for killing Animals").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.01).addAttribute(Attribute.GENERIC_ATTACK_SPEED, -1.7)
            .addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 15).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4f).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 4f)
                    .addFlag(ItemConfigurationFlag.LEVEL_REQUIREMENT, 15f).create()),

    FARMING_ELITE_SWORD(ProficiencyType.FARMING, new ItemBuilder(Material.GOLDEN_SWORD).setRarity(Rarity.ELITE).setName("Sword")
            .addProficiency(ProficiencyType.FARMING).addLore(ItemModifier.LOOT,"500").addLore(ItemModifier.EXPERIENCE, "500")
            .addLore("Common tool for killing Animals").addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.01).addAttribute(Attribute.GENERIC_ATTACK_SPEED, -1.5)
            .addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 25).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4f).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER, 4f)
                    .addFlag(ItemConfigurationFlag.LEVEL_REQUIREMENT, 30f).create()),

    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------

    HUNTING_SIMPLE_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.WOODEN_SWORD).setRarity(Rarity.SIMPLE).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "50").addLore("Simple tool for hunting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 1.5f).create()),

    HUNTING_COMMON_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.STONE_SWORD).setRarity(Rarity.COMMON).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "100").addLore("Common tool for hunting")
            .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2.3).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 7).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2f).create()),

    HUNTING_ADVANCED_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.IRON_SWORD).setRarity(Rarity.ADVANCED).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "150").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Advanced tool for hunting")
            .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -2).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 8).addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.0005).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2.5f).create()),

    HUNTING_ELITE_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.GOLDEN_SWORD).setRarity(Rarity.ELITE).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "200").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Elite tool for hunting")
            .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -1.7).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 10).addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.005).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 3.5f).create()),

    HUNTING_EPIC_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.DIAMOND_SWORD).setRarity(Rarity.EPIC).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "350").addLore(ItemModifier.EXPERIENCE,"200")
            .addLore("Forged in the depth")
            .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -1.5).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 12).addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.05)
            .addAttribute(Attribute.GENERIC_MAX_HEALTH, 4).addAttribute(Attribute.GENERIC_ARMOR, 0.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,3f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4.5f).create()),

    HUNTING_LEGENDARY_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.NETHERITE_SWORD).setRarity(Rarity.LEGENDARY).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "600").addLore(ItemModifier.EXPERIENCE,"500")
            .addLore("Harvest the Weak")
            .addAttribute(Attribute.GENERIC_ATTACK_SPEED, -1.3).addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, 20).addAttribute(Attribute.GENERIC_MOVEMENT_SPEED,0.1)
            .addAttribute(Attribute.GENERIC_MAX_HEALTH, 12).addAttribute(Attribute.GENERIC_ARMOR, 3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,6f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 7f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 110, 0, true, false)).create()),

    HUNTING_COMMON_BOW(ProficiencyType.HUNTING, new ItemBuilder(Material.BOW).setRarity(Rarity.COMMON).setName("Bow")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "100").addLore(ItemModifier.EXPERIENCE,"100")
            .addLore("Common tool for hunting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,2f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 2f)
                    .addFlag(ItemConfigurationFlag.DAMAGE_MULTIPLIER, 1.3f).create()),

    HUNTING_ELITE_BOW(ProficiencyType.HUNTING, new ItemBuilder(Material.BOW).setRarity(Rarity.ELITE).setName("Bow")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "200").addLore(ItemModifier.EXPERIENCE,"200")
            .addLore("Advanced tool for hunting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,3f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 3f)
                    .addFlag(ItemConfigurationFlag.DAMAGE_MULTIPLIER, 1.7f).create()),

    HUNTING_EPIC_BOW(ProficiencyType.HUNTING, new ItemBuilder(Material.BOW).setRarity(Rarity.EPIC).setName("Bow")
            .addProficiency(ProficiencyType.HUNTING).addLore(ItemModifier.LOOT, "350").addLore(ItemModifier.EXPERIENCE,"400")
            .addLore("Epic tool for hunting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER,5f).addFlag(ItemConfigurationFlag.LOOT_MULTIPLIER, 4.5f)
                    .addFlag(ItemConfigurationFlag.DAMAGE_MULTIPLIER, 2.5f).create()),
    ;


    //TODO Add Level Requirements
    //TODO Change Attribute Values


    private final ItemStack itemStack;

    private final ProficiencyType proficiencyType;

    private final ItemConfiguration itemConfiguration;

    private static final HashMap<ItemStack, CustomTool> LIST_OF_ITEMS = new HashMap<>();
    static {
        for (final CustomTool customTool : CustomTool.values()) {
            LIST_OF_ITEMS.put(customTool.itemStack, customTool);
        }
    }

    CustomTool(ProficiencyType proficiencyType, ItemStack itemStack, ItemConfiguration itemConfiguration) {
        this.proficiencyType = proficiencyType;
        this.itemStack = itemStack;
        this.itemConfiguration = itemConfiguration;
    }

    public ItemStack getItem() {
        return itemStack;
    }

    public ProficiencyType getProficiencyType() {
        return proficiencyType;
    }

    public ItemConfiguration getItemConfiguration() {
        return itemConfiguration;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public static HashMap<ItemStack, CustomTool> getItems() {
        return LIST_OF_ITEMS;
    }

    public static List<CustomTool> getItemsOfProficiency(ProficiencyType type) {
        return  Arrays.stream(CustomTool.values()).filter(customTool -> customTool.proficiencyType == type).toList();
    }

    public static CustomTool getItem(ItemStack key) {
        for (CustomTool customTool : CustomTool.values()) {
            if (key.getType() != customTool.itemStack.getType()) continue;

            ItemMeta keyMeta = key.getItemMeta();
            if (keyMeta == null) continue;
            ItemMeta toolMeta = customTool.getItem().getItemMeta();
            if (toolMeta == null) continue;

            if (!keyMeta.hasDisplayName()) continue;
            if (!ChatColor.stripColor(keyMeta.getDisplayName()).equals(ChatColor.stripColor(toolMeta.getDisplayName()))) continue;

            if (keyMeta.hasLore() ^ toolMeta.hasLore()) continue;
            if (keyMeta.hasLore() && !keyMeta.getLore().equals(toolMeta.getLore())) continue;

            if (keyMeta.hasAttributeModifiers() ^ toolMeta.hasAttributeModifiers()) continue;
            //if (!keyMeta.hasAttributeModifiers() && !keyMeta.getAttributeModifiers().equals(toolMeta.getAttributeModifiers())) continue;
            //if (!keyMeta.getItemFlags().equals(toolMeta.getItemFlags())) continue;
            return customTool;
        }
        return NONE;
    }

    public boolean isWeapon() {
        return switch (this) {

            case HUNTING_SIMPLE_SWORD, HUNTING_COMMON_SWORD, HUNTING_ADVANCED_SWORD, HUNTING_ELITE_SWORD,
                    HUNTING_EPIC_SWORD, HUNTING_LEGENDARY_SWORD, HUNTING_COMMON_BOW, HUNTING_ELITE_BOW, HUNTING_EPIC_BOW,
                    FARMING_COMMON_SWORD, FARMING_ADVANCED_SWORD, FARMING_ELITE_SWORD -> true;
            default -> false;
        };
    }

}
