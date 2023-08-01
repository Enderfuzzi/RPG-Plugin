package com.falgael.rpg;

import com.falgael.rpg.commands.VillagerSpawn;
import com.falgael.rpg.manager.DataStoreManagement;
import com.falgael.rpg.manager.Initializer;
import com.falgael.rpg.proficiencies.ProficiencyHandler;
import com.falgael.rpg.proficiencies.items.SpecialCraftingRecipe;
import com.falgael.rpg.villager.VillagerHandler;
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

    public static final String PLUGIN_NAME = "RPG-0.0.1";

    @Override
    public void onEnable() {
        getLogger().info(this.getName() + " enabled");
        sendMessageToAll("Plugin enabled");
        Initializer.initialize();
        Bukkit.getPluginManager().registerEvents(new ProficiencyHandler(),this);
        Bukkit.getPluginManager().registerEvents(new VillagerHandler(),this);


        this.getCommand("villager").setExecutor(new VillagerSpawn());

        SpecialCraftingRecipe.testRecipe();

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
