package com.falgael.rpg.proficiencies.data.woodwork;

import com.falgael.rpg.proficiencies.template.ProficiencyItems;
import com.falgael.rpg.utility.ItemCreation;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Contains all items by the Woodwork proficiency.
 * Note the storage of all items is contained in {@link com.falgael.rpg.proficiencies.ProficiencyDataHolder}.
 */
public class WoodworkItems implements ProficiencyItems {
    /** local copy of items created by this class */
    private static final ArrayList<ItemStack> items = fillItems();

    /**
     * Creates and fills {@link WoodworkItems#items}. Uses {@link ItemCreation#createItem(Material, String, String...)}
     * for item creation.
     * @return The list with all items
     */
    private static ArrayList<ItemStack> fillItems() {
        ArrayList<ItemStack> result = new ArrayList<>();
        result.add(ItemCreation.createItem(Material.WOODEN_AXE,"Simple Wooden Axe",
                ChatColor.ITALIC + "" + ChatColor.DARK_GREEN + "+100% More Wood","Crafted by the gods to test your strength"));
        return result;
    }
    /** Returns the local non-modifiable copy of {@link com.falgael.rpg.proficiencies.data.woodwork.WoodworkItems#items} */
    public static ArrayList<ItemStack> getItems() {
        return items;
    }
}
