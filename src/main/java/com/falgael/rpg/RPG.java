package com.falgael.rpg;

import com.falgael.rpg.commands.VillagerSpawn;
import com.falgael.rpg.manager.Initializer;
import com.falgael.rpg.proficiency.items.blocks.BlockBreakHandler;
import com.falgael.rpg.proficiency.player.PlayerManager;
import com.falgael.rpg.villager.VillagerHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPG extends JavaPlugin {

    public static final String PLUGIN_NAME = "RPG-0.0.1";

    @Override
    public void onEnable() {
        getLogger().info(this.getName() + " enabled");
        sendMessageToAll("Plugin enabled");
        Initializer.initialize();
        Bukkit.getPluginManager().registerEvents(new PlayerManager(),this);
        Bukkit.getPluginManager().registerEvents(new VillagerHandler(),this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakHandler(),this);

        this.getCommand("villager").setExecutor(new VillagerSpawn());

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
