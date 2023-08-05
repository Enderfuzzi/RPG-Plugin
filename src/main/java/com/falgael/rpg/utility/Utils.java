package com.falgael.rpg.utility;

import org.bukkit.Bukkit;
import org.bukkit.Material;

public class Utils {

    public static String getMaterialName(Material material) {
        String[] split = material.name().toLowerCase().split("_");
        for (int i = 0; i < split.length; i++) split[i] = split[i].substring(0,1).toUpperCase() + split[i].substring(1);
        return String.join(" ", split);
    }


}
