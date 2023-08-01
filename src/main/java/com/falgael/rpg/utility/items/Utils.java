package com.falgael.rpg.utility.items;

import org.bukkit.Material;

public class Utils {

    public static String getMaterialName(Material material) {
        String[] split = material.name().toLowerCase().split("_");
        for (int i = 0; i < split.length; i++) split[i].replace(split[0].charAt(0),Character.toUpperCase(split[0].charAt(0)));
        return String.join(" ", split);
    }


}
