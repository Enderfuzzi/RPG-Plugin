package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.proficiency.ProficiencyTypes;
import com.falgael.rpg.items.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public enum CustomTools {
    NONE(ProficiencyTypes.NONE, new ItemStack(Material.AIR), new ItemConfiguration()),

    MIGHTY_DEATH(ProficiencyTypes.MISC, new ItemBuilder(Material.NETHERITE_SWORD).setRarity(Rarity.LEGENDARY).setName("Mighty Death")
            .addProficiency(ProficiencyTypes.MISC).addLore("Death is the only solution").addDamageAttribute(10000).addSpeedAttribute(3)
            .addHealthAttribute(10).addArmorAttribute(5.0).create(),
            new ItemConfiguration("legendary_" + ProficiencyTypes.MISC.getName() + "_sword",1,1.0f)),

    MIGHTY_AXE(ProficiencyTypes.WOODWORK, new ItemBuilder(Material.NETHERITE_AXE).setRarity(Rarity.LEGENDARY).setName("Mighty Axe")
            .addProficiency(ProficiencyTypes.WOODWORK).addLootModifierLore("+10000% More Wood").addExperienceModifierLore("+100000% Experience")
            .addLore("Foraging is the only solution").addSpeedAttribute(3).addHealthAttribute(10).addArmorAttribute(5.0).create(),
            new ItemConfiguration("legendary_" + ProficiencyTypes.WOODWORK.getName() + "_axe",10000,10000.0f)),


    MIGHTY_PICKAXE(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.NETHERITE_PICKAXE).setRarity(Rarity.LEGENDARY).setName("Mighty Pickaxe")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+10000% More Stone").addExperienceModifierLore("+100000% Experience")
            .addLore("Mining is the only solution").addSpeedAttribute(3).addHealthAttribute(10).addArmorAttribute(5.0).create(),
            new ItemConfiguration("legendary_" + ProficiencyTypes.STONEWORK.getName() + "_pickaxe",10000,10000.0f)),



    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------


    WOODWORK_SIMPLE_AXE(ProficiencyTypes.WOODWORK, new ItemBuilder(Material.WOODEN_AXE).setRarity(Rarity.SIMPLE).setName("Axe")
            .addProficiency(ProficiencyTypes.WOODWORK).addLootModifierLore("+50% More Wood").addLore("Simple tool for harvesting")
            .addDamageAttribute(0.5).create(),
            new ItemConfiguration("simple_" + ProficiencyTypes.WOODWORK.getName() + "_axe", 1,1.5f)),
    WOODWORK_COMMON_AXE(ProficiencyTypes.WOODWORK, new ItemBuilder(Material.STONE_AXE).setRarity(Rarity.COMMON).setName("Axe")
            .addProficiency(ProficiencyTypes.WOODWORK).addLootModifierLore("+100% More Wood").addLore("Common tool for harvesting").addSpeedAttribute(0.1)
            .addDamageAttribute(0.6).create(),
            new ItemConfiguration("common_" + ProficiencyTypes.WOODWORK.getName() + "_axe",1,2.0f)),

    WOODWORK_ADVANCED_AXE(ProficiencyTypes.WOODWORK, new ItemBuilder(Material.IRON_AXE).setRarity(Rarity.ADVANCED).setName("Axe")
            .addProficiency(ProficiencyTypes.WOODWORK).addLootModifierLore("+150% More Wood").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.2).addDamageAttribute(1.2).create(),
            new ItemConfiguration("advanced_" +  ProficiencyTypes.WOODWORK.getName()+ "_axe",2,2.5f)),

    WOODWORK_ELITE_AXE( ProficiencyTypes.WOODWORK, new ItemBuilder(Material.GOLDEN_AXE).setRarity(Rarity.ELITE).setName("Axe")
            .addProficiency(ProficiencyTypes.WOODWORK).addLootModifierLore("+200% More Wood").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.3).addDamageAttribute(1.3).create(),
            new ItemConfiguration("rare_" + ProficiencyTypes.WOODWORK.getName() + "_axe",2,3.0f)),

    WOODWORK_EPIC_AXE(ProficiencyTypes.WOODWORK, new ItemBuilder(Material.DIAMOND_AXE).setRarity(Rarity.EPIC).setName("Axe")
            .addProficiency(ProficiencyTypes.WOODWORK).addLootModifierLore("+350% More Wood").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(0.5).addDamageAttribute(1.5).create(),
            new ItemConfiguration("epic_" + ProficiencyTypes.WOODWORK.getName() + "_axe",3,4.5f)),

    WOODWORK_LEGENDARY_AXE(ProficiencyTypes.WOODWORK, new ItemBuilder(Material.NETHERITE_AXE).setRarity(Rarity.LEGENDARY).setName("Axe")
            .addProficiency(ProficiencyTypes.WOODWORK).addLootModifierLore("+600% More Wood").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(1.0).addDamageAttribute(2.5)
            .addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration("legendary_" + ProficiencyTypes.WOODWORK.getName() + "_axe",6,7.0f)),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONEWORK_SIMPLE_PICKAXE(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.WOODEN_PICKAXE).setRarity(Rarity.SIMPLE).setName("Pickaxe")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+50% More Stone").addLore("Simple tool for harvesting")
            .addDamageAttribute(0.5).create(),
            new ItemConfiguration("simple_" + ProficiencyTypes.STONEWORK.getName() + "_pickaxe", 1,1.5f)),
    STONEWORK_COMMON_PICKAXE(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.STONE_PICKAXE).setRarity(Rarity.COMMON).setName("Pickaxe")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+100% More Stone").addLore("Common tool for harvesting").addSpeedAttribute(0.1)
            .addDamageAttribute(0.6).create(),
            new ItemConfiguration("common_" + ProficiencyTypes.STONEWORK.getName() + "_pickaxe",1,2.0f)),

    STONEWORK_ADVANCED_PICKAXE(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.IRON_PICKAXE).setRarity(Rarity.ADVANCED).setName("Pickaxe")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+150% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.2).addDamageAttribute(1.2).create(),
            new ItemConfiguration("advanced_" +  ProficiencyTypes.STONEWORK.getName()+ "_pickaxe",2,2.5f)),

    STONEWORK_ELITE_PICKAXE( ProficiencyTypes.STONEWORK, new ItemBuilder(Material.GOLDEN_PICKAXE).setRarity(Rarity.ELITE).setName("Pickaxe")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+200% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.3).addDamageAttribute(1.3).create(),
            new ItemConfiguration("rare_" + ProficiencyTypes.STONEWORK.getName() + "_pickaxe",2,3.0f)),

    STONEWORK_EPIC_PICKAXE(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.DIAMOND_PICKAXE).setRarity(Rarity.EPIC).setName("Pickaxe")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+350% More Stone").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(0.5).addDamageAttribute(1.5).create(),
            new ItemConfiguration("epic_" + ProficiencyTypes.STONEWORK.getName() + "_pickaxe",3,4.5f)),

    STONEWORK_LEGENDARY_PICKAXE(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.NETHERITE_PICKAXE).setRarity(Rarity.LEGENDARY).setName("Pickaxe")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+600% More Stone").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(1.0).addDamageAttribute(2.5)
            .addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration("legendary_" + ProficiencyTypes.STONEWORK.getName() + "_pickaxe",6,7.0f)),



    STONEWORK_SIMPLE_SHOVEL(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.WOODEN_SHOVEL).setRarity(Rarity.SIMPLE).setName("Shovel")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+50% More Stone").addLore("Simple tool for harvesting")
            .addDamageAttribute(0.5).create(),
            new ItemConfiguration("simple_" + ProficiencyTypes.STONEWORK.getName() + "_shovel", 1,1.5f)),
    STONEWORK_COMMON_SHOVEL(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.STONE_SHOVEL).setRarity(Rarity.COMMON).setName("Shovel")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+100% More Stone").addLore("Common tool for harvesting").addSpeedAttribute(0.1)
            .addDamageAttribute(0.6).create(),
            new ItemConfiguration("common_" + ProficiencyTypes.STONEWORK.getName() + "_shovel",1,2.0f)),

    STONEWORK_ADVANCED_SHOVEL(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.IRON_SHOVEL).setRarity(Rarity.ADVANCED).setName("Shovel")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+150% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.2).addDamageAttribute(1.2).create(),
            new ItemConfiguration("advanced_" +  ProficiencyTypes.STONEWORK.getName()+ "_shovel",2,2.5f)),

    STONEWORK_ELITE_SHOVEL( ProficiencyTypes.STONEWORK, new ItemBuilder(Material.GOLDEN_SHOVEL).setRarity(Rarity.ELITE).setName("Shovel")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+200% More Stone").addExperienceModifierLore("+100% Experience")
            .addLore("Elite tool for harvesting").addSpeedAttribute(0.3).addDamageAttribute(1.3).create(),
            new ItemConfiguration("rare_" + ProficiencyTypes.STONEWORK.getName() + "_shovel",2,3.0f)),

    STONEWORK_EPIC_SHOVEL(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.DIAMOND_SHOVEL).setRarity(Rarity.EPIC).setName("Shovel")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+350% More Stone").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(0.5).addDamageAttribute(1.5).create(),
            new ItemConfiguration("epic_" + ProficiencyTypes.STONEWORK.getName() + "_shovel",3,4.5f)),

    STONEWORK_LEGENDARY_SHOVEL(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.NETHERITE_SHOVEL).setRarity(Rarity.LEGENDARY).setName("Shovel")
            .addProficiency(ProficiencyTypes.STONEWORK).addLootModifierLore("+600% More Stone").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(1.0).addDamageAttribute(2.5)
            .addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration("legendary_" + ProficiencyTypes.STONEWORK.getName() + "_shovel",6,7.0f)),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_SIMPLE_HOE(ProficiencyTypes.FARMING, new ItemBuilder(Material.WOODEN_HOE).setRarity(Rarity.SIMPLE).setName("Hoe")
            .addProficiency(ProficiencyTypes.FARMING).addLootModifierLore("+50% More Plants").addLore("Simple tool for harvesting")
            .addSpeedAttribute(0.1).create(),
            new ItemConfiguration("simple_" + ProficiencyTypes.FARMING.getName() + "_hoe", 1, 1.5f)),

    FARMING_COMMON_HOE(ProficiencyTypes.FARMING, new ItemBuilder(Material.STONE_HOE).setRarity(Rarity.COMMON).setName("Hoe")
            .addProficiency(ProficiencyTypes.FARMING).addLootModifierLore("+100% More Plants").addLore("Common tool for harvesting")
            .addSpeedAttribute(0.3).create(),
            new ItemConfiguration("common_" + ProficiencyTypes.FARMING.getName() + "_hoe", 1, 2f)),

    FARMING_ADVANCED_HOE(ProficiencyTypes.FARMING, new ItemBuilder(Material.IRON_HOE).setRarity(Rarity.ADVANCED).setName("Hoe")
            .addProficiency(ProficiencyTypes.FARMING).addLootModifierLore("+150% More Plants").addExperienceModifierLore("+100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.5).create(),
            new ItemConfiguration("advanced_" + ProficiencyTypes.FARMING.getName() + "_hoe", 2, 2.5f)),

    FARMING_ELITE_HOE(ProficiencyTypes.FARMING, new ItemBuilder(Material.GOLDEN_HOE).setRarity(Rarity.ELITE).setName("Hoe")
            .addProficiency(ProficiencyTypes.FARMING).addLootModifierLore("+200% More Plants").addExperienceModifierLore("+100% Experience")
            .addLore("Elite tool for harvesting")
            .addSpeedAttribute(0.75).create(),
            new ItemConfiguration("elite_" + ProficiencyTypes.FARMING.getName() + "_hoe", 2, 3.0f)),

    FARMING_EPIC_HOE(ProficiencyTypes.FARMING, new ItemBuilder(Material.DIAMOND_HOE).setRarity(Rarity.EPIC).setName("Hoe")
            .addProficiency(ProficiencyTypes.FARMING).addLootModifierLore("+350% More Plants").addExperienceModifierLore("+200% Experience")
            .addLore("Forged in the depth")
            .addSpeedAttribute(1.0).create(),
            new ItemConfiguration("epic_" + ProficiencyTypes.FARMING.getName() + "_hoe", 3, 4.5f)),

    FARMING_LEGENDARY_HOE(ProficiencyTypes.FARMING, new ItemBuilder(Material.NETHERITE_HOE).setRarity(Rarity.LEGENDARY).setName("Hoe")
            .addProficiency(ProficiencyTypes.FARMING).addLootModifierLore("+600% More Plants").addExperienceModifierLore("+500% Experience")
            .addLore("Forged in the depth")
            .addSpeedAttribute(1.3).addHealthAttribute(0.2).addArmorAttribute(0.2).create(),
            new ItemConfiguration("legendary_" + ProficiencyTypes.FARMING.getName() + "_hoe", 6, 7.0f)),


    ;




    private final ItemStack itemStack;

    private final ProficiencyTypes proficiencyType;

    private final ItemConfiguration itemConfiguration;

    private static final HashMap<ItemStack, CustomTools> LIST_OF_ITEMS = new HashMap<>();
    static {
        for (final CustomTools customTools : CustomTools.values()) {
            LIST_OF_ITEMS.put(customTools.itemStack, customTools);
        }
    }

    CustomTools(ProficiencyTypes proficiencyType, ItemStack itemStack, ItemConfiguration itemConfiguration) {
        this.proficiencyType = proficiencyType;
        this.itemStack = itemStack;
        this.itemConfiguration = itemConfiguration;
    }

    public ItemStack getItem() {
        return itemStack;
    }

    public ProficiencyTypes getProficiencyType() {
        return proficiencyType;
    }

    public ItemConfiguration getItemConfiguration() {
        return itemConfiguration;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public static HashMap<ItemStack, CustomTools> getItems() {
        return LIST_OF_ITEMS;
    }

    public static CustomTools getItem(ItemStack key) {
        for (CustomTools customTool : CustomTools.values()) {
            if (key.getType() != customTool.itemStack.getType()) continue;

            ItemMeta keyMeta = key.getItemMeta();
            if (keyMeta == null) continue;
            ItemMeta toolMeta = customTool.getItem().getItemMeta();
            if (toolMeta == null) continue;

            if (!keyMeta.hasDisplayName()) continue;
            if (!ChatColor.stripColor(keyMeta.getDisplayName()).equals(ChatColor.stripColor(toolMeta.getDisplayName()))) continue;

            if (keyMeta.hasLore() ^ toolMeta.hasLore()) continue;
            if (!keyMeta.hasLore() && !keyMeta.getLore().equals(toolMeta.getLore())) continue;

            if (keyMeta.hasAttributeModifiers() ^ toolMeta.hasAttributeModifiers()) continue;
            if (!keyMeta.hasAttributeModifiers() && !keyMeta.getAttributeModifiers().equals(toolMeta.getAttributeModifiers())) continue;
            if (!keyMeta.getItemFlags().equals(toolMeta.getItemFlags())) continue;
            return customTool;
        }
        return NONE;
    }

}
