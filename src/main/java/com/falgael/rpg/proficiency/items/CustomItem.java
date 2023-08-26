package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum CustomItem {
    //--------------------------------------------------------------------------------------------
    // Misc
    //--------------------------------------------------------------------------------------------
    MISC_IRON_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.IRON_NUGGET).setName("Silver Coin").setCurrency(true).setRarity(Rarity.NONE).create()),
    MISC_GOLD_NUGGET(ProficiencyType.MISC, new ItemBuilder(Material.GOLD_NUGGET).setName("Gold Coin").setCurrency(true).setRarity(Rarity.NONE).create()),

    MISC_STAT_O_METER(ProficiencyType.MISC, new ItemBuilder(Material.AMETHYST_SHARD).setName("Stat-O-Meter").visibleEnchanted(true).setRarity(Rarity.LEGENDARY).create()),


    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------
    WOODWORK_COMPRESSED_OAK(ProficiencyType.WOODWORK, new ItemBuilder(Material.OAK_WOOD).addProficiency(ProficiencyType.WOODWORK).setCompressed(true).create()),



    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------
    STONEWORK_COMPRESSED_STONE(ProficiencyType.STONEWORK, new ItemBuilder(Material.STONE).addProficiency(ProficiencyType.STONEWORK).setCompressed(true).create()),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    FARMING_COMPRESSED_WHEAT(ProficiencyType.FARMING, new ItemBuilder(Material.HAY_BLOCK).addProficiency(ProficiencyType.FARMING).setCompressed(true).create()),


    ;

    private final ItemStack itemStack;

    private final ProficiencyType type;

    CustomItem(ProficiencyType type, ItemStack itemStack) {
        this.type = type;
        this.itemStack = itemStack;
    }

    public ItemStack getItem() {
        return itemStack;
    }

    public ProficiencyType getType() {
        return type;
    }

    public static boolean isStatOMeter(ItemStack heldItem) {
        if (heldItem == null) return false;
        Bukkit.getLogger().info("Not NULL");
        ItemMeta heldItemMeta = heldItem.getItemMeta();
        Bukkit.getLogger().info("held Item: " + heldItem.getType());
        if (!MISC_STAT_O_METER.getItem().getType().equals(heldItem.getType())) return false;
        Bukkit.getLogger().info("Type is same");
        ItemMeta statItemMeta = MISC_STAT_O_METER.itemStack.getItemMeta();
        if (statItemMeta == null || heldItemMeta == null) return false;
        Bukkit.getLogger().info("Stats not null");
        if (!statItemMeta.getDisplayName().equals(heldItemMeta.getDisplayName())) return false;
        Bukkit.getLogger().info("Names Equal");
        if (!statItemMeta.isUnbreakable() || !heldItemMeta.isUnbreakable()) return false;
        Bukkit.getLogger().info("Both unbreakable");
        return true;
    }
}
