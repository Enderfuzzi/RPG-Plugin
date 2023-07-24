package com.falgael.rpg;

import com.falgael.rpg.manager.DataStoreManagement;
import com.falgael.rpg.proficiencies.ProficiencyHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public final class RPG extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info(this.getName() + " enabled");
        sendMessageToAll("Plugin enabled");
        DataStoreManagement.initialize();
        Bukkit.getPluginManager().registerEvents(new ProficiencyHandler(),this);

    }

    @Override
    public void onDisable() {
        getLogger().info("RPG disabled");
        sendMessageToAll("Plugin disabled");
    }

    private final void sendMessageToAll(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) p.sendMessage(message);
    }
}
