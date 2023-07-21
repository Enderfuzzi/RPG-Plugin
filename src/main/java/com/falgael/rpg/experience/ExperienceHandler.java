package com.falgael.rpg.experience;

import com.falgael.rpg.experience.data.Foraging;
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

    private static HashMap<Player,ExperienceData> experiences = new HashMap<Player,ExperienceData>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (!experiences.containsKey(event.getPlayer())) {
            experiences.put(event.getPlayer(), new ExperienceData());
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Foraging foraging = experiences.get(event.getPlayer()).getForaging();
        if (foraging.givesForagingXp(event.getBlock().getType())) {
            foraging.increaseForagingXP(foraging.amountOfForagingXp(event.getBlock().getType()));
            event.getPlayer().sendMessage("Current xp: " + foraging.getCurrentForagingXp() + "/" + foraging.getCurrentForagingXpBorder());
        }


    }

}
