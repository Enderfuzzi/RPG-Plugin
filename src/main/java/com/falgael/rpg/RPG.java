package com.falgael.rpg;

import com.falgael.rpg.commands.CustomCommand;
import com.falgael.rpg.commands.VillagerSpawn;
import com.falgael.rpg.commands.VillagerSpawnTabComplete;
import com.falgael.rpg.manager.Initializer;
import com.falgael.rpg.proficiency.ForbiddenCraftingHandler;
import com.falgael.rpg.proficiency.TestHandler;
import com.falgael.rpg.proficiency.handler.BlockBreakHandler;
import com.falgael.rpg.proficiency.handler.CraftingResultsHandler;
import com.falgael.rpg.proficiency.handler.HarvestBlockHandler;
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
        Bukkit.getPluginManager().registerEvents(new CraftingResultsHandler(),this);
        Bukkit.getPluginManager().registerEvents(new ForbiddenCraftingHandler(), this);
        Bukkit.getPluginManager().registerEvents(new HarvestBlockHandler(), this);
        Bukkit.getPluginManager().registerEvents(new TestHandler(), this);


        for (CustomCommand command : CustomCommand.values()) {
            this.getCommand(command.getKey()).setExecutor(command.getCommand());
            this.getCommand(command.getKey()).setTabCompleter(command.getTabCompleter());
            Bukkit.getLogger().info("[" + RPG.class.getSimpleName() + "]: Registered Command: " + command.getKey());
        }

        /*
        this.getCommand("spawn_villager").setExecutor(new VillagerSpawn());
        this.getCommand("spawn_villager").setTabCompleter(new VillagerSpawnTabComplete());
        */
    }


    @Override
    public void onDisable() {
        getLogger().info("RPG disabled");
        sendMessageToAll("Plugin disabled");
    }

    private void sendMessageToAll(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) p.sendMessage(message);
    }
}
