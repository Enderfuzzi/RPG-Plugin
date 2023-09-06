package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.effects.BlockBreakEffect;
import com.falgael.rpg.proficiency.items.effects.CustomPotionEffect;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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
            .addProficiency(ProficiencyType.HUNTING).addLore("Death is the only solution").addDamageAttribute(10000).addSpeedAttribute(3)
            .addHealthAttribute(0).addArmorAttribute(5.0).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 1f).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier, 1.0f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION,110,10,false,false)).create()),

    MIGHTY_AXE(ProficiencyType.MISC, new ItemBuilder(Material.NETHERITE_AXE).setRarity(Rarity.LEGENDARY).setName("Mighty Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLootModifierLore("+10000% More Wood").addExperienceModifierLore("+100000% Experience")
            .addLore("Foraging is the only solution").addSpeedAttribute(3).addHealthAttribute(10).addArmorAttribute(5.0).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier, 10000f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 10000f).create()),


    MIGHTY_PICKAXE(ProficiencyType.MISC, new ItemBuilder(Material.NETHERITE_PICKAXE).setRarity(Rarity.LEGENDARY).setName("Mighty Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+10000% More Stone").addExperienceModifierLore("+100000% Experience")
            .addLore("Mining is the only solution").addSpeedAttribute(3).addHealthAttribute(10).addArmorAttribute(5.0).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier, 10000f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 10000f).create()),



    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------


    WOODWORK_SIMPLE_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.WOODEN_AXE).setRarity(Rarity.SIMPLE).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLootModifierLore("+50% More Wood").addLore("Simple tool for harvesting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 1.5f).create()),
    WOODWORK_COMMON_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.STONE_AXE).setRarity(Rarity.COMMON).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLootModifierLore("+100% More Wood").addLore("Common tool for harvesting").addSpeedAttribute(0.1)
            .addDamageAttribute(0.6).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2f).create()),

    WOODWORK_ADVANCED_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.IRON_AXE).setRarity(Rarity.ADVANCED).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLootModifierLore("+150% More Wood").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.2).addDamageAttribute(1.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier, 2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2.5f).create()),

    WOODWORK_ELITE_AXE( ProficiencyType.WOODWORK, new ItemBuilder(Material.GOLDEN_AXE).setRarity(Rarity.ELITE).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLootModifierLore("+200% More Wood").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.3).addDamageAttribute(1.3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier, 2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 3f).create()),

    WOODWORK_EPIC_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.DIAMOND_AXE).setRarity(Rarity.EPIC).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLootModifierLore("+350% More Wood").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(0.5).addDamageAttribute(1.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier, 3f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 4.5f).create()),

    WOODWORK_LEGENDARY_AXE(ProficiencyType.WOODWORK, new ItemBuilder(Material.NETHERITE_AXE).setRarity(Rarity.LEGENDARY).setName("Axe")
            .addProficiency(ProficiencyType.WOODWORK).addLootModifierLore("+600% More Wood").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(1.0).addDamageAttribute(2.5)
            .addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier, 6f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 7f).create()),

    WOODWORK_SHEARS(ProficiencyType.WOODWORK, new ItemBuilder(Material.SHEARS).setRarity(Rarity.ADVANCED).setName("Shears")
            .addProficiency(ProficiencyType.WOODWORK).addLore("Harvest Leaves").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,110,0,true,false)).create()),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONEWORK_SIMPLE_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.WOODEN_PICKAXE).setRarity(Rarity.SIMPLE).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+50% More Stone").addLore("Simple tool for harvesting")
            .addDamageAttribute(0.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 1.5f).create()),
    STONEWORK_COMMON_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE_PICKAXE).setRarity(Rarity.COMMON).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+100% More Stone").addLore("Common tool for harvesting").addSpeedAttribute(0.1)
            .addDamageAttribute(0.6).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2f).create()),

    STONEWORK_ADVANCED_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.IRON_PICKAXE).setRarity(Rarity.ADVANCED).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+150% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.2).addDamageAttribute(1.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f)
                    .addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2.5f).create()),

    STONEWORK_ELITE_PICKAXE( ProficiencyType.STONEWORK, new ItemBuilder(Material.GOLDEN_PICKAXE).setRarity(Rarity.ELITE).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+200% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.3).addDamageAttribute(1.3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 3f).create()),

    STONEWORK_EPIC_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.DIAMOND_PICKAXE).setRarity(Rarity.EPIC).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+350% More Stone").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(0.5).addDamageAttribute(1.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,3f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 4.5f).create()),

    STONEWORK_LEGENDARY_PICKAXE(ProficiencyType.STONEWORK, new ItemBuilder(Material.NETHERITE_PICKAXE).setRarity(Rarity.LEGENDARY).setName("Pickaxe")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+600% More Stone").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(1.0).addDamageAttribute(2.5)
            .addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,6f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 7f).create()),



    STONEWORK_SIMPLE_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.WOODEN_SHOVEL).setRarity(Rarity.SIMPLE).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+50% More Stone").addLore("Simple tool for harvesting")
            .addDamageAttribute(0.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 1.5f).create()),
    STONEWORK_COMMON_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE_SHOVEL).setRarity(Rarity.COMMON).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+100% More Stone").addLore("Common tool for harvesting").addSpeedAttribute(0.1)
            .addDamageAttribute(0.6).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2f).create()),

    STONEWORK_ADVANCED_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.IRON_SHOVEL).setRarity(Rarity.ADVANCED).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+150% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.2).addDamageAttribute(1.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2.5f).create()),

    STONEWORK_ELITE_SHOVEL( ProficiencyType.STONEWORK, new ItemBuilder(Material.GOLDEN_SHOVEL).setRarity(Rarity.ELITE).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+200% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Elite tool for harvesting").addSpeedAttribute(0.3).addDamageAttribute(1.3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 3f).create()),

    STONEWORK_EPIC_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.DIAMOND_SHOVEL).setRarity(Rarity.EPIC).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+350% More Stone").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(0.5).addDamageAttribute(1.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,3f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 4.5f).create()),

    STONEWORK_LEGENDARY_SHOVEL(ProficiencyType.STONEWORK, new ItemBuilder(Material.NETHERITE_SHOVEL).setRarity(Rarity.LEGENDARY).setName("Shovel")
            .addProficiency(ProficiencyType.STONEWORK).addLootModifierLore("+600% More Stone").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(1.0).addDamageAttribute(2.5)
            .addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,6f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 7f).create()),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_SIMPLE_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.WOODEN_HOE).setRarity(Rarity.SIMPLE).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+50% More Plants").addLore("Simple tool for harvesting")
            .addSpeedAttribute(0.1).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 1.5f).create()),

    FARMING_COMMON_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.STONE_HOE).setRarity(Rarity.COMMON).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+100% More Plants").addLore("Common tool for harvesting")
            .addSpeedAttribute(0.3).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2f).create()),

    FARMING_ADVANCED_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.IRON_HOE).setRarity(Rarity.ADVANCED).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+150% More Plants").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2.5f).create()),

    FARMING_ELITE_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.GOLDEN_HOE).setRarity(Rarity.ELITE).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+200% More Plants").addExperienceModifierLore("+100% Experience")
            .addLore("Elite tool for harvesting")
            .addSpeedAttribute(0.75).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 3f).create()),

    FARMING_EPIC_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.DIAMOND_HOE).setRarity(Rarity.EPIC).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+350% More Plants").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth")
            .addSpeedAttribute(1.0).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,3f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 4.5f).create()),

    FARMING_LEGENDARY_HOE(ProficiencyType.FARMING, new ItemBuilder(Material.NETHERITE_HOE).setRarity(Rarity.LEGENDARY).setName("Hoe")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+600% More Plants").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth")
            .addSpeedAttribute(1.3).addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,6f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 7f).create()),

    FARMING_ADVANCED_SHEARS(ProficiencyType.FARMING, new ItemBuilder(Material.SHEARS).setRarity(Rarity.ADVANCED).setName("Shears")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+100% More Wool").addExperienceModifierLore("+300% Experience")
            .addLore("Shears Sheep").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,4f).addFlag(ItemConfigurationFlag.LOOT_Multiplier,2f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,110,0,true,false)).create()),

    FARMING_EPIC_SHEARS(ProficiencyType.FARMING, new ItemBuilder(Material.SHEARS).setRarity(Rarity.EPIC).setName("Shears")
            .addProficiency(ProficiencyType.FARMING).addLootModifierLore("+200% More Wool").addExperienceModifierLore("+500% Experience")
            .addLore("Shears Sheep").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,6f).addFlag(ItemConfigurationFlag.LOOT_Multiplier,3f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING,110,1,true,false))
                    .addPotionEffect(new PotionEffect(PotionEffectType.SPEED,110,0,true,false)).create()),

    //--------------------------------------------------------------------------------------------
    // Hunting
    //--------------------------------------------------------------------------------------------

    HUNTING_SIMPLE_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.WOODEN_SWORD).setRarity(Rarity.SIMPLE).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+50% More Loot").addLore("Simple tool for hunting")
            .addSpeedAttribute(0.1).addDamageAttribute(5).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 1.5f).create()),

    HUNTING_COMMON_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.STONE_SWORD).setRarity(Rarity.COMMON).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+100% More Loot").addLore("Common tool for hunting")
            .addSpeedAttribute(0.3).addDamageAttribute(6).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2f).create()),

    HUNTING_ADVANCED_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.IRON_SWORD).setRarity(Rarity.ADVANCED).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+150% More Loot").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for hunting").addSpeedAttribute(0.5).addDamageAttribute(8).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2.5f).create()),

    HUNTING_ELITE_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.GOLDEN_SWORD).setRarity(Rarity.ELITE).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+200% More Loot").addExperienceModifierLore("+100% Experience")
            .addLore("Elite tool for hunting")
            .addSpeedAttribute(0.6).addDamageAttribute(10).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 3.5f).create()),

    HUNTING_EPIC_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.DIAMOND_SWORD).setRarity(Rarity.EPIC).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+350% More Loot").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth")
            .addSpeedAttribute(0.75).addArmorAttribute(0.2).addDamageAttribute(12).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,3f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 4.5f).create()),

    HUNTING_LEGENDARY_SWORD(ProficiencyType.HUNTING, new ItemBuilder(Material.NETHERITE_SWORD).setRarity(Rarity.LEGENDARY).setName("Sword")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+600% More Loot").addExperienceModifierLore("+500% Experience")
            .addLore("Harvest the Weak").addSpeedAttribute(1.0).addHealthAttribute(0.4).addArmorAttribute(0.4).addDamageAttribute(16).create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,6f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 7f)
                    .addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 110, 0, true, false)).create()),

    HUNTING_COMMON_BOW(ProficiencyType.HUNTING, new ItemBuilder(Material.BOW).setRarity(Rarity.COMMON).setName("Bow")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+100% More Loot").addExperienceModifierLore("+100% Experience")
            .addLore("Common tool for hunting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,2f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 2f)
                    .addFlag(ItemConfigurationFlag.DAMAGE_Multiplier, 1.2f).create()),

    HUNTING_ELITE_BOW(ProficiencyType.HUNTING, new ItemBuilder(Material.BOW).setRarity(Rarity.ELITE).setName("Bow")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+200% More Loot").addExperienceModifierLore("+200% Experience")
            .addLore("Advanced tool for hunting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,3f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 3f)
                    .addFlag(ItemConfigurationFlag.DAMAGE_Multiplier, 1.5f).create()),

    HUNTING_EPIC_BOW(ProficiencyType.HUNTING, new ItemBuilder(Material.BOW).setRarity(Rarity.EPIC).setName("Bow")
            .addProficiency(ProficiencyType.HUNTING).addLootModifierLore("+350% More Loot").addExperienceModifierLore("+300% Experience")
            .addLore("Epic tool for hunting").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier,4f).addFlag(ItemConfigurationFlag.LOOT_Multiplier, 4.5f)
                    .addFlag(ItemConfigurationFlag.DAMAGE_Multiplier, 2f).create()),
    ;



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
                    HUNTING_EPIC_SWORD, HUNTING_LEGENDARY_SWORD, HUNTING_COMMON_BOW, HUNTING_ELITE_BOW, HUNTING_EPIC_BOW -> true;
            default -> false;
        };
    }

}
