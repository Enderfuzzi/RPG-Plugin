package com.falgael.rpg.commands;

import com.falgael.rpg.commands.experience.ManipulateExperience;
import com.falgael.rpg.commands.experience.ManipulateExperienceTabComplete;
import com.falgael.rpg.commands.villager.VillagerSpawn;
import com.falgael.rpg.commands.villager.VillagerSpawnTabComplete;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public enum CustomCommand {

    SPAWN_VILLAGER("spawn_villager", new VillagerSpawn(), new VillagerSpawnTabComplete()),
    EXPERIENCE("experience", new ManipulateExperience(), new ManipulateExperienceTabComplete()),


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