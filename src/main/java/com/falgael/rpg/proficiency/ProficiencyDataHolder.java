package com.falgael.rpg.proficiency;

import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.framework.Pair;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds static information about the proficiency.
 * @author falgael
 * @version 0.0.1
 */
public class ProficiencyDataHolder {

    //--------------------------------------------------------------------------------------------
    // Names of all Proficiencies
    //--------------------------------------------------------------------------------------------
    /** The name of the Woodwork ProficiencyType. Used for global identification *
    public static final String WOODWORK_PROFICIENCY_NAME = "Woodwork";



    //--------------------------------------------------------------------------------------------
    // Generally forbidden results to craft
    //--------------------------------------------------------------------------------------------
    /** A list of general non-craft-able materials. Only adding of {@code Material} is allowed.*
    private static ArrayList<Material> generalForbiddenCraftingResult = new ArrayList<>();

    /**
     * Adds a non-existing {@code Material} to the list. materials which are already stored in list are not added again.
     * @param material The {@code Material} to add to list
     *
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
     *
    public static boolean isForbiddenCraftingResult(Material material) {
        if (material == null) return false;
        return generalForbiddenCraftingResult.contains(material);
    }

    //--------------------------------------------------------------------------------------------
    // List of all items of all proficiency
    //--------------------------------------------------------------------------------------------

    private static HashMap<String,ItemStack> allItemsByRepresentation = new HashMap<>();

    /**
     * List which contains each special items grouped by ProficiencyType.
     *
    private static HashMap<String,HashMap<ItemStack, ItemConfiguration>> itemsOfAllProficiencies = new HashMap<>();

    /**
     * Adds a given List with the specified Key to the list. If the ProficiencyType is already registered nothing is added
     * @param key The representational name of the proficiency
     * @param list The list of {@code ItemStack} to add
     *
    public static void addItemsToAllProficiencies(String key, HashMap<ItemStack, ItemConfiguration> list) {
        if (itemsOfAllProficiencies.containsKey(key)) return;
        itemsOfAllProficiencies.put(key,list);
        for (Map.Entry<ItemStack, ItemConfiguration> item : list.entrySet()) {
            allItemsByRepresentation.put(item.getValue().getName(), item.getKey());
        }

        Bukkit.getLogger().info("[" + ProficiencyDataHolder.class.getSimpleName() + "]: Registered " + key + " items");
    }

    /**
     * Provides a list with all items of all proficiency combined
     * @return The combined list of all items
     *
    public static @NotNull HashMap<ItemStack,ItemConfiguration> getAllItemsByRepresentation() {
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
     *
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

    public static ItemConfiguration getItemConfiguration(ItemStack item) {
        if (!containsItem(item)) return new ItemConfiguration();
        for (HashMap<ItemStack, ItemConfiguration> entry : itemsOfAllProficiencies.values()) {
            if (entry.containsKey(item)) return entry.get(item);
        }
        return new ItemConfiguration();
    }

    public static ItemStack getItemByName(String name) {
        for (String s : allItemsByRepresentation.keySet()) Bukkit.getLogger().info("Key: " + s);
        return allItemsByRepresentation.get(name);
    }

    //--------------------------------------------------------------------------------------------
    // List of all special crafting recipes
    //--------------------------------------------------------------------------------------------

    private static HashMap<Recipe, Pair<String,Integer>> recipes = new HashMap<>();


    public static void registerRecipe(Recipe recipe, Pair<String, Integer> pair) {
        recipes.put(recipe,pair);
    }

    public static Pair<String,Integer> getRecipes(Recipe recipe) {
        return recipes.get(recipe);
    }

    */

}
