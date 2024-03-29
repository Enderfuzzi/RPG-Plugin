package com.falgael.rpg.proficiency.player;

import com.falgael.rpg.proficiency.Proficiency;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface PlayerMessage {
    default void playerExperienceMessage(@NotNull Player player, @NotNull Proficiency proficiency, long experience, long experienceBorder) {
        TextComponent message = new TextComponent(
                ChatColor.GOLD + "" + ChatColor.ITALIC + proficiency.getName() + ": " + experience + "/" + experienceBorder + " Xp"
        );
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,message);
        Bukkit.getLogger().info(player.getDisplayName() + " has " + experience + " Xp of " + experienceBorder + " from " + proficiency.getName());
    }


    default void denyVillagerInteraction(@NotNull Player player, Proficiency proficiency, int requirement) {
        player.sendMessage(proficiency.getRepresentation() + ChatColor.ITALIC + " Level Requirement: " + requirement);
    }

    default void levelChangeMessage(Player player, Proficiency proficiency, int level) {
        if (player == null) return;
        player.playSound(player, Sound.ENTITY_PLAYER_LEVELUP,0.3f,1f);
        player.sendTitle(proficiency.getRepresentation(),"Level: " + ChatColor.GOLD + level, 10, 70, 20);
    }

}
