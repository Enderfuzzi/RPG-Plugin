package com.falgael.rpg.proficiency;

import com.falgael.rpg.proficiency.player.PlayerMessages;

import com.falgael.rpg.old.PlayerManager;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Utils {


    public static void increaseExperience(Player player, Proficiency proficiency, long experienceAmount) {
        if (experienceAmount <= 0) return;
        PlayerManager.getProficiencyData(player.getUniqueId()).increaseExperience(proficiency,experienceAmount);
        PlayerMessages.experienceIncreaseMessage(player, proficiency);
    }

    public static int getPlayerLevel(Player player, Proficiency proficiency) {
        return PlayerManager.getProficiencyData(player.getUniqueId()).getLevel(proficiency);
    }


    public static String getMaterialName(Material material) {
        String[] split = material.name().toLowerCase().split("_");
        for (int i = 0; i < split.length; i++) split[i] = split[i].substring(0,1).toUpperCase() + split[i].substring(1);
        return String.join(" ", split);
    }

    public static int floatToInt(float value) {
        return Math.round(value);
    }
}
