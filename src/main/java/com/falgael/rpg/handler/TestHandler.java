package com.falgael.rpg.handler;

import com.falgael.rpg.manager.interfaces.MainManagement;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TestHandler extends MainHandler {


    public TestHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.getPlayer().getInventory().clear();
    }

    @EventHandler
    public void onHit(EntityDamageEvent event) {
        Bukkit.getLogger().info("Damage: " + event.getDamage());


    }

}
