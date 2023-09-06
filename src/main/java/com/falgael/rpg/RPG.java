package com.falgael.rpg;

import com.falgael.rpg.commands.CustomCommand;
import com.falgael.rpg.manager.Disabler;
import com.falgael.rpg.manager.Initializer;
import com.falgael.rpg.proficiency.handler.*;
import com.falgael.rpg.proficiency.TestHandler;
import com.falgael.rpg.proficiency.player.PlayerManager;
import com.falgael.rpg.villager.VillagerHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
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
        Bukkit.getPluginManager().registerEvents(new ItemHeldHandler(), this);
        Bukkit.getPluginManager().registerEvents(new ItemBurnHandler(), this);
        Bukkit.getPluginManager().registerEvents(new ShearingHandler(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractBlockHandler(), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathHandler(), this);
        Bukkit.getPluginManager().registerEvents(new ArrowShootHandler(), this);

        for (CustomCommand command : CustomCommand.values()) {
            this.getCommand(command.getKey()).setExecutor(command.getCommand());
            Bukkit.getLogger().info("[" + RPG.class.getSimpleName() + "]: Registered Command: " + command.getKey());
            if (command.getTabCompleter() == null) continue;
            this.getCommand(command.getKey()).setTabCompleter(command.getTabCompleter());
        }

    }


    @Override
    public void onDisable() {

        Disabler.disable();


        getLogger().info("RPG disabled");
        sendMessageToAll("Plugin disabled");
    }

    private void sendMessageToAll(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) p.sendMessage(message);
    }
}
