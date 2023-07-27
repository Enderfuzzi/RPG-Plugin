package com.falgael.rpg.proficiencies;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

public class ProficiencyDataHolder {

    //--------------------------------------------------------------------------------------------
    // Names of all Proficiencies
    //--------------------------------------------------------------------------------------------

    public static final String WOODWORK_PROFICIENCY_NAME = "Woodwork";



    //--------------------------------------------------------------------------------------------
    // Generally forbidden results to craft
    //--------------------------------------------------------------------------------------------

    private static ArrayList<Material> generalForbiddenCraftingResult = new ArrayList<>();

    public static void addGeneralForbiddenCraftingResult(Material material) {
        if (material == null) return;
        if (isForbiddenCraftingResult(material)) return;
        generalForbiddenCraftingResult.add(material);
        Bukkit.getLogger().info("[" + ProficiencyDataHolder.class.getSimpleName() + "]: Registered Material which is generally forbidden to craft: " + material);
    }

    public static boolean isForbiddenCraftingResult(Material material) {
        if (material == null) return false;
        return generalForbiddenCraftingResult.contains(material);
    }

    //--------------------------------------------------------------------------------------------
    // List of all items of all proficiencies
    //--------------------------------------------------------------------------------------------

    private static HashMap<String,ArrayList<ItemStack>> itemsOfAllProficiencies = new HashMap<>();

    public static void addItemsToAllProficiencies(String key, ArrayList<ItemStack> list) {
        if (itemsOfAllProficiencies.containsKey(key)) return;
        itemsOfAllProficiencies.put(key,list);
        Bukkit.getLogger().info("[" + ProficiencyDataHolder.class.getSimpleName() + "]: Registered " + key + " items");
    }

    public static ArrayList<ItemStack> getAllItems() {
        ArrayList<ItemStack> result = new ArrayList<>();
        for(ArrayList<ItemStack> list : itemsOfAllProficiencies.values()) result.addAll(list);
        return result;
    }

    public static ArrayList<ItemStack> getProficiencyItems(String key) {
        if (itemsOfAllProficiencies.containsKey(key)) return itemsOfAllProficiencies.get(key);
        return new ArrayList<>();
    }



}
