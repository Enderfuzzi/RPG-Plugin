package com.falgael.rpg.proficiencies.data.woodwork;

import com.falgael.rpg.utility.ItemCreation;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WoodworkItems {

    public static final ArrayList<ItemStack> items = fillItems();

    private static ArrayList<ItemStack> fillItems() {
        ArrayList<ItemStack> result = new ArrayList<>();
        result.add(ItemCreation.createItem(Material.WOODEN_AXE,"Simple Wooden Axe",
                ChatColor.ITALIC + "" + ChatColor.DARK_GREEN + "+100% More Wood","Crafted by the gods to test your strength"));
        return result;
    }


    private static ItemStack createItem(Material material,String itemName, String... lore) {
        ItemStack result = new ItemStack(material);
        ItemMeta itemMeta = result.getItemMeta();
        itemMeta.setDisplayName(itemName);
        itemMeta.setUnbreakable(true);
        List<String> buildLore = new ArrayList<>();
        for (String s : lore) {
            buildLore.add(s);
        }
        itemMeta.setLore(buildLore);
        result.setItemMeta(itemMeta);
        return result;
    }

}
