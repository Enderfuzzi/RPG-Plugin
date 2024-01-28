package com.falgael.rpg.handler;

import com.falgael.rpg.manager.interfaces.MainManagement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractHandler extends MainHandler {
    public PlayerInteractHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        proficiencyAdapter.performAction(event, itemAdapter.getItemByKey(event.getItem()), event.getPlayer());
    }
}
