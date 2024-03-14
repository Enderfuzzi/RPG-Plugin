package com.falgael.rpg.proficiency.player;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerMessages {
    public static void denyVillagerInteraction(@NotNull Player player, Proficiency proficiency, int requirement) {
        player.sendMessage(proficiency.getRepresentation() + ChatColor.ITALIC + " Level Requirement: " + requirement);
    }
}
