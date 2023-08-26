package com.falgael.rpg.proficiency;

import com.falgael.rpg.proficiency.items.CustomItem;
import com.falgael.rpg.proficiency.items.CustomTool;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TestHandler implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        for (CustomTool customTool : CustomTool.values()) {
            event.getPlayer().getInventory().addItem(customTool.getItem());
        }

        for (CustomItem customItem : CustomItem.values()) {
            event.getPlayer().getInventory().addItem(customItem.getItem());
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.getPlayer().getInventory().clear();
    }

}
