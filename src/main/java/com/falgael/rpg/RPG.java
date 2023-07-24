package com.falgael.rpg;

import com.falgael.rpg.manager.SavingManagement;
import com.falgael.rpg.proficiencies.ProficiencyHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPG extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info(this.getName() + " enabled");
        sendMessageToAll("Plugin enabled");
        SavingManagement.initialize();
        SavingManagement.loadProficiencyData();
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
