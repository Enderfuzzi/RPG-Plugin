package com.falgael.rpg.proficiencies;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import java.util.ArrayList;

public class ForbiddenToCraft {

    private static ArrayList<Material> forbiddenToCraft = new ArrayList<>();


    public static void addMaterial(Material material) {
        if (material == null) return;
        if (isForbiddenToCraft(material)) return;
        forbiddenToCraft.add(material);
        Bukkit.getLogger().info("Registered Material which is generally forbidden to craft: " + material);
    }

    public static boolean isForbiddenToCraft(Material material) {
        if (material == null) return false;
        return forbiddenToCraft.contains(material);
    }

}
