package com.falgael.rpg.proficiencies.data.woodwork;

import com.falgael.rpg.proficiencies.template.ProficiencyItems;
import com.falgael.rpg.utility.ItemCreation;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class WoodworkItems implements ProficiencyItems {

    private static final ArrayList<ItemStack> items = fillItems();

    private static ArrayList<ItemStack> fillItems() {
        ArrayList<ItemStack> result = new ArrayList<>();
        result.add(ItemCreation.createItem(Material.WOODEN_AXE,"Simple Wooden Axe",
                ChatColor.ITALIC + "" + ChatColor.DARK_GREEN + "+100% More Wood","Crafted by the gods to test your strength"));
        return result;
    }

    public static ArrayList<ItemStack> getItems() {
        return items;
    }
}
