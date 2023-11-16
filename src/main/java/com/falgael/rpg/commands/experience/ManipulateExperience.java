package com.falgael.rpg.commands.experience;

import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.manager.ProficiencyExperienceManager;
import com.falgael.rpg.old.PlayerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ManipulateExperience implements CommandExecutor {

    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length != 4) {
            player.sendMessage("Usage: /experience [Player] [Proficiency] [add|remove] [Value] ");
            return false;
        }

        ProficiencyExperienceManager proficiencyExperienceManager = PlayerManager.getByPublicName(args[0]);
        if (proficiencyExperienceManager == null)  {
            player.sendMessage("Player name: " + args[0] + " is not found");
            return false;
        }

        Proficiency proficiency = Proficiency.isProficiency(args[1]);
        if (proficiency == Proficiency.NONE) {
            player.sendMessage("Unknown proficiency");
            return false;
        }

        Long value;
        try {
            value = Long.valueOf(args[3]);
        } catch (NumberFormatException e) {
            player.sendMessage("Unallowed Number format");
            return false;
        }

        if (args[2].equals("add")) {
            proficiencyExperienceManager.increaseExperience(proficiency,value);
        } else if(args[2].equals("remove")) {
            proficiencyExperienceManager.decreaseExperience(proficiency, value);
        } else {
            player.sendMessage("Only add or remove are allowed");
            return false;
        }



        return true;
    }
}
