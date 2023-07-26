package com.falgael.rpg.proficiencies;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.ArrayList;

public class ForbiddenCraftingResults {

    private static ArrayList<Material> forbiddenCraftingResults = new ArrayList<>();


    public static void addMaterial(Material material) {
        if (material == null) return;
        if (isForbiddenCraftingResult(material)) return;
        forbiddenCraftingResults.add(material);
        Bukkit.getLogger().info("Registered Material which is generally forbidden to craft: " + material);
    }

    public static boolean isForbiddenCraftingResult(Material material) {
        if (material == null) return false;
        return forbiddenCraftingResults.contains(material);
    }

}
