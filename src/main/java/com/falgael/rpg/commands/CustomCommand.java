package com.falgael.rpg.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

import java.util.HashMap;

public enum CustomCommand {

    SPAWN_VILLAGER("Spawn_Villager", new VillagerSpawn(), new VillagerSpawnTabComplete()),

    ;

    private final String key;

    private final CommandExecutor command;

    private final TabCompleter tabCompleter;

    CustomCommand(String key, CommandExecutor command, TabCompleter tabCompleter) {
        this.key = key;
        this.command = command;
        this.tabCompleter = tabCompleter;
    }

    public String getKey() {
        return key;
    }

    public CommandExecutor getCommand() {
        return command;
    }

    public TabCompleter getTabCompleter() {
        return tabCompleter;
    }

}
