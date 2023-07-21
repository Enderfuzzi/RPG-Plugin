package com.falgael.rpg;

import com.falgael.rpg.experience.ExperienceHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPG extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("RPG enabled");
        sendMessageToAll("Plugin enabled");

        Bukkit.getPluginManager().registerEvents(new ExperienceHandler(),this);

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
