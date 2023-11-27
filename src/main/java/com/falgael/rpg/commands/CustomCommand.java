package com.falgael.rpg.commands;

import com.falgael.rpg.commands.chest.SpawnItemChest;
import com.falgael.rpg.commands.chest.SpawnItemChestTabComplete;
import com.falgael.rpg.commands.experience.ManipulateExperience;
import com.falgael.rpg.commands.experience.ManipulateExperienceTabComplete;
import com.falgael.rpg.commands.spawner.SpawnerSpawn;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public enum CustomCommand {


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
