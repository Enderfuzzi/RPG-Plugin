package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.items.CustomItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractHandler implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        CustomItem customItem = CustomItem.getItem(event.getItem());
        if (customItem.isNone()) return;
        if (customItem.hasConfiguration() && customItem.getConfiguration().hasAction())
            if (customItem.getConfiguration().getAction().accept(event)) return;


    }



}
