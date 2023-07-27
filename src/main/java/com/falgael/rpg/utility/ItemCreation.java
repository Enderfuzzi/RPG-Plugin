package com.falgael.rpg.utility;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Provides methods for creations of different special items.
 * @author falgael
 * @version 0.0.1
 */
public class ItemCreation {

    /**
     * Creates an item with {@code Material}, Name and lore. Lore might be null.
     * Note: the created item is unbreakable
     * @param material The {@code Material} to create the item with
     * @param itemName The item name
     * @param lore The lore to add can be null
     * @return The new created item
     */
    public static @Nullable ItemStack createItem(Material material, String itemName, String... lore) {
        ItemStack result = createItem(material, itemName);
        if (result == null) return null;
        if (lore == null) return result;
        ItemMeta itemMeta = result.getItemMeta();
        itemMeta.setLore(new ArrayList<>(Arrays.asList(lore)));
        result.setItemMeta(itemMeta);
        return result;
    }

    /**
     * Creates an item with material and name.
     * Note: the created item is unbreakable
     * @param material The {@code Material} to create the item with
     * @param itemName The item name
     * @return The new created item
     */
    public static @Nullable ItemStack createItem(Material material, String itemName) {
        ItemStack result = createItem(material);
        if (result == null) return null;
        if (itemName == null) return result;
        ItemMeta itemMeta = result.getItemMeta();
        itemMeta.setDisplayName(itemName);
        itemMeta.setUnbreakable(true);
        result.setItemMeta(itemMeta);
        return result;
    }

    public static ItemStack createItem(Material material) {
        if (material == null) return null;
        return new ItemStack(material);
    }


}
