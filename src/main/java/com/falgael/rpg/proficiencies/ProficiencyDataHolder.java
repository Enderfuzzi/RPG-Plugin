package com.falgael.rpg.proficiencies;

import com.falgael.rpg.proficiencies.items.ItemConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Holds static information about the proficiencies.
 * @author falgael
 * @version 0.0.1
 */
public class ProficiencyDataHolder {

    //--------------------------------------------------------------------------------------------
    // Names of all Proficiencies
    //--------------------------------------------------------------------------------------------
    /** The name of the Woodwork Proficiency. Used for global identification */
    public static final String WOODWORK_PROFICIENCY_NAME = "Woodwork";



    //--------------------------------------------------------------------------------------------
    // Generally forbidden results to craft
    //--------------------------------------------------------------------------------------------
    /** A list of general non-craft-able materials. Only adding of {@code Material} is allowed.*/
    private static ArrayList<Material> generalForbiddenCraftingResult = new ArrayList<>();

    /**
     * Adds a non-existing {@code Material} to the list. materials which are already stored in list are not added again.
     * @param material The {@code Material} to add to list
     */
    public static void addGeneralForbiddenCraftingResult(Material material) {
        if (material == null) return;
        if (isForbiddenCraftingResult(material)) return;
        generalForbiddenCraftingResult.add(material);
        Bukkit.getLogger().info("[" + ProficiencyDataHolder.class.getSimpleName() + "]: Registered Material which is generally forbidden to craft: " + material);
    }

    /**
     * Checks if the given {@code Material} is legal to craft.
     * @param material The {@code Material} to check
     * @return {@code True} if the Material is in the list
     */
    public static boolean isForbiddenCraftingResult(Material material) {
        if (material == null) return false;
        return generalForbiddenCraftingResult.contains(material);
    }

    //--------------------------------------------------------------------------------------------
    // List of all items of all proficiencies
    //--------------------------------------------------------------------------------------------

    /**
     * List which contains each special item grouped by Proficiency.
     */
    private static HashMap<String,HashMap<ItemStack, ItemConfiguration>> itemsOfAllProficiencies = new HashMap<>();

    /**
     * Adds a given List with the specified Key to the list. If the Proficiency is already registered nothing is added
     * @param key The representational name of the proficiency
     * @param list The list of {@code ItemStack} to add
     */
    public static void addItemsToAllProficiencies(String key, HashMap<ItemStack, ItemConfiguration> list) {
        if (itemsOfAllProficiencies.containsKey(key)) return;
        itemsOfAllProficiencies.put(key,list);
        Bukkit.getLogger().info("[" + ProficiencyDataHolder.class.getSimpleName() + "]: Registered " + key + " items");
    }

    /**
     * Provides a list with all items of all proficiencies combined
     * @return The combined list of all items
     */
    public static @NotNull HashMap<ItemStack,ItemConfiguration> getAllItems() {
        HashMap<ItemStack, ItemConfiguration> result = new HashMap<>();
        for(HashMap<ItemStack, ItemConfiguration> list : itemsOfAllProficiencies.values()) {
            result.putAll(list);
        }
        return result;
    }

    /**
     * Provides a list of items by a specified proficiency
     * @param key The representational name of the proficiency
     * @return The list of items by the proficiency. If the proficiency does not exist return a empty list.
     */
    public static HashMap<ItemStack,ItemConfiguration> getProficiencyItems(String key) {
        if (itemsOfAllProficiencies.containsKey(key)) return itemsOfAllProficiencies.get(key);
        return new HashMap<>();
    }


    public static boolean containsItem(ItemStack item) {
        for (HashMap<ItemStack, ItemConfiguration> entry : itemsOfAllProficiencies.values()) {
            if (entry.containsKey(item)) return true;
        }
        return false;
    }

    public static @Nullable ItemConfiguration getItemConfiguration(ItemStack item) {
        if (!containsItem(item)) return null;
        for (HashMap<ItemStack, ItemConfiguration> entry : itemsOfAllProficiencies.values()) {
            if (entry.containsKey(item)) return entry.get(item);
        }
        return null;
    }


}
