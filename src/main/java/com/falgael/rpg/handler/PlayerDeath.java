package com.falgael.rpg.handler;

import com.falgael.rpg.manager.interfaces.MainManagement;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath extends MainHandler {
    public PlayerDeath(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void PlayerDeath(PlayerDeathEvent event) {
        Bukkit.getLogger().info("Player Death event");
        event.setKeepInventory(true);
        event.setNewTotalExp(0);
        event.getDrops().clear();



    }

}
