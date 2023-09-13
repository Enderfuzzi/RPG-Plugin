package com.falgael.rpg.proficiency.items;


import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.items.ItemModifier;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import com.falgael.rpg.proficiency.items.effects.CropPlant;
import com.falgael.rpg.proficiency.items.effects.FurnaceBurn;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum CustomItem {

    NONE(ProficiencyType.NONE, new ItemStack(Material.AIR)),

    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------
    MISC_IRON_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.IRON_NUGGET).setName("Silver Coin").setCurrency().setRarity(Rarity.NONE).create()),
    MISC_GOLD_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.GOLD_NUGGET).setName("Gold Coin").setCurrency().setRarity(Rarity.NONE).create()),

    MISC_STAT_O_METER(ProficiencyType.MISC, new ItemBuilder(Material.AMETHYST_SHARD).setName("Stat-O-Meter").visibleEnchanted().setRarity(Rarity.LEGENDARY).create()),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------
    WOODWORK_COMPRESSED_OAK(ProficiencyType.WOODWORK, new ItemBuilder(Material.OAK_WOOD).addProficiency(ProficiencyType.WOODWORK).setCompressed().create()),



    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------
    STONEWORK_COMPRESSED_STONE(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE).addProficiency(ProficiencyType.STONEWORK).setCompressed().create()),


    STONEWORK_INFINITE_COAL_TIER_I(ProficiencyType.STONEWORK, new ItemBuilder(Material.COAL).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.ADVANCED).visibleEnchanted()
            .addLore(ItemModifier.BURN_TIME, "10").addLore("Burns until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND)
            .addAction(e -> FurnaceBurn.effect(e, 0.1))
            .create()),
    STONEWORK_INFINITE_COAL_TIER_II(ProficiencyType.STONEWORK, new ItemBuilder(Material.CHARCOAL).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.ELITE).visibleEnchanted()
            .addLore(ItemModifier.BURN_TIME, "50").addLore("Burning until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND)
            .addAction(e -> FurnaceBurn.effect(e, 0.5))
            .create()),

    STONEWORK_INFINITE_COAL_TIER_III(ProficiencyType.STONEWORK, new ItemBuilder(Material.COAL_BLOCK).addProficiency(ProficiencyType.STONEWORK).setRarity(Rarity.EPIC).visibleEnchanted()
            .addLore(ItemModifier.BURN_TIME, "75").addLore("Burns until end of time").setName("Infinite Fuel").create(), new ItemConfiguration.Builder(EquipmentSlot.HAND)
            .addAction(e -> FurnaceBurn.effect(e, 0.75))
            .create()),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_COMPRESSED_WHEAT(ProficiencyType.FARMING, new ItemBuilder(Material.HAY_BLOCK).addProficiency(ProficiencyType.FARMING).setCompressed().create()),

    FARMING_SEED_PLANTER(ProficiencyType.FARMING, new ItemBuilder(Material.ECHO_SHARD).addProficiency(ProficiencyType.FARMING).visibleEnchanted().setRarity(Rarity.ADVANCED).setName("Planter").create(),
            new ItemConfiguration.Builder(EquipmentSlot.HAND).addAction(e -> CropPlant.effect(e, 5, Material.WHEAT, Material.FARMLAND))
                    .create()),

    ;

    private final ItemConfiguration configuration;


    private final ItemStack itemStack;

    private final ProficiencyType type;

    CustomItem(ProficiencyType type, ItemStack itemStack) {
        this(type, itemStack, null);
    }

    CustomItem(ProficiencyType type, ItemStack itemStack, ItemConfiguration itemConfiguration) {
        this.type = type;
        this.itemStack = itemStack;
        this.configuration = itemConfiguration;
    }

    public ItemStack getItem() {
        return itemStack;
    }

    public ProficiencyType getType() {
        return type;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public boolean hasConfiguration() {
        return configuration != null;
    }

    public ItemConfiguration getConfiguration() {
        return configuration;
    }

    public static boolean isStatOMeter(ItemStack heldItem) {
        if (heldItem == null) return false;
        if (MISC_STAT_O_METER.getItem().getType() != heldItem.getType()) return false;
        ItemMeta heldItemMeta = heldItem.getItemMeta();
        ItemMeta statItemMeta = MISC_STAT_O_METER.itemStack.getItemMeta();
        if (statItemMeta == null || heldItemMeta == null) return false;
        if (!statItemMeta.getDisplayName().equals(heldItemMeta.getDisplayName())) return false;
        if (!statItemMeta.isUnbreakable() || !heldItemMeta.isUnbreakable()) return false;
        return true;
    }

    public static CustomItem getItem(ItemStack key) {
        if (key == null) return NONE;
        for (CustomItem customItem : CustomItem.values()) {
            if (key.getType() != customItem.itemStack.getType()) continue;

            ItemMeta keyMeta = key.getItemMeta();
            if (keyMeta == null) continue;
            ItemMeta toolMeta = customItem.getItem().getItemMeta();
            if (toolMeta == null) continue;

            if (!keyMeta.hasDisplayName()) continue;
            if (!ChatColor.stripColor(keyMeta.getDisplayName()).equals(ChatColor.stripColor(toolMeta.getDisplayName()))) continue;

            if (keyMeta.hasLore() ^ toolMeta.hasLore()) continue;
            if (!keyMeta.hasLore() && !keyMeta.getLore().equals(toolMeta.getLore())) continue;

            if (keyMeta.hasAttributeModifiers() ^ toolMeta.hasAttributeModifiers()) continue;
            //if (!keyMeta.hasAttributeModifiers() && !keyMeta.getAttributeModifiers().equals(toolMeta.getAttributeModifiers())) continue;
            //if (!keyMeta.getItemFlags().equals(toolMeta.getItemFlags())) continue;
            return customItem;
        }
        return NONE;
    }



}
