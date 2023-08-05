package com.falgael.rpg.proficiency;

import com.falgael.rpg.manager.DataStoreManagement;
import com.falgael.rpg.proficiency.player.PlayerManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Messages {

    public static void experienceIncreaseMessage(@NotNull Player player, ProficiencyTypes proficiency) {
        long currentExperience = PlayerManager.getProficiencyData(player.getUniqueId()).getCurrentExperience(proficiency);
        long currentExperienceBorder = PlayerManager.getProficiencyData(player.getUniqueId()).getCurrentExperienceBorder(proficiency);
        TextComponent message = new TextComponent(ChatColor.GOLD + "" + ChatColor.ITALIC + proficiency.getName() + ": " + currentExperience + "/" + currentExperienceBorder + " Xp");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,message);
        Bukkit.getLogger().info(player.getDisplayName() + " has " + currentExperience + " Xp of " + currentExperienceBorder + " from " + proficiency.getName());

        DataStoreManagement.saveProficiencyData();
    }

    public static void denyVillagerInteraction(@NotNull Player player, ProficiencyTypes proficiency, int requirement) {
        player.sendMessage(proficiency.getRepresentation() + ChatColor.ITALIC + " Level Requirement: " + requirement);
    }


}
