package com.falgael.rpg.utility;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemCreation {


    private static @NotNull ItemStack createItem(Material material, String itemName, String... lore) {
        ItemStack result = new ItemStack(material);
        ItemMeta itemMeta = result.getItemMeta();
        itemMeta.setDisplayName(itemName);
        itemMeta.setUnbreakable(true);
        if (lore != null) {
            List<String> buildLore = new ArrayList<>();
            for (String s : lore) buildLore.add(s);
            itemMeta.setLore(buildLore);
        }
        result.setItemMeta(itemMeta);
        return result;
    }



}
