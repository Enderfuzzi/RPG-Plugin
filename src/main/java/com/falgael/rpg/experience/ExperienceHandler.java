package com.falgael.rpg.experience;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

/**
 * Manages the experience of all Players
 * @author falgael
 * @version 0.0.1
 */
public class ExperienceHandler implements Listener {

    /** Assigns Experience data to each player */
    private static HashMap<Player,ExperienceData> experiences = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!experiences.containsKey(event.getPlayer())) {
            experiences.put(event.getPlayer(), new ExperienceData());
        }
    }

    /**
     * Searches each block break experience of a player when destroying a block
     * @param event describes to {@code blockBreakEvent}
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        for (ExperienceFramework ef : experiences.get(event.getPlayer()).getBlockBreakProficiency()) {
            if (ef.givesExperience(event.getBlock().getType())) {
                ef.increaseExperience(ef.amountOfExperience(event.getBlock().getType()));
                TextComponent message = new TextComponent(ChatColor.GOLD + "" + ChatColor.ITALIC + ef.getProficiencyRepresentation() + ": " + ef.getCurrentExperience() + "/" + ef.getCurrentExperienceBorder() + " Xp");
                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR,message);
            }
        }
    }

}
