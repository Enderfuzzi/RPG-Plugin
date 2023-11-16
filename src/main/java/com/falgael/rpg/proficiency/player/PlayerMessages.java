package com.falgael.rpg.proficiency.player;

import com.falgael.rpg.old.PlayerManager;
import com.falgael.rpg.proficiency.Proficiency;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerMessages {
    public static void denyVillagerInteraction(@NotNull Player player, Proficiency proficiency, int requirement) {
        player.sendMessage(proficiency.getRepresentation() + ChatColor.ITALIC + " Level Requirement: " + requirement);
    }
}
