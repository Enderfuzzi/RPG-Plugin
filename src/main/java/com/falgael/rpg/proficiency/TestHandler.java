package com.falgael.rpg.proficiency;

import com.falgael.rpg.proficiency.blocks.CustomBlocks;
import com.falgael.rpg.proficiency.items.CustomTools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TestHandler implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (CustomTools customTools : CustomTools.values()) {
            event.getPlayer().getInventory().addItem(customTools.getItem());
        }

        for (CustomBlocks customBlocks : CustomBlocks.values()) {
            event.getPlayer().getInventory().addItem(customBlocks.getItem());
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.getPlayer().getInventory().clear();
    }

}
