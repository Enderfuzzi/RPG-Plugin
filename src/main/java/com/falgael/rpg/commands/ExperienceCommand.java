package com.falgael.rpg.commands;

import com.falgael.rpg.manager.PlayerExperienceManagement;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ExperienceCommand implements CommandExecutor, TabCompleter {

    private final PlayerExperienceManagement experienceManger;


    public ExperienceCommand(PlayerExperienceManagement experienceManger) {
        this.experienceManger = experienceManger;
    }


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
        if (args.length < 3 || args.length > 4) {
            player.sendMessage("Usage: /experience <add|remove> <Proficiency> <value> [level]");
            return false;
        }

        Proficiency proficiency = Proficiency.isProficiency(args[1]);


        Long value;
        try {
            value = Long.valueOf(args[2]);
        } catch (NumberFormatException e) {
            player.sendMessage("Unallowed Number format");
            return false;
        }


        if (args[0].equals("add")) {
            if (args.length == 3) {
                experienceManger.increaseExperience(player, proficiency, value);
                return true;
            } else if (args.length == 4) {
                if (args[3].equals("level")) {
                    experienceManger.increaseLevel(player, proficiency, value.intValue());
                    return true;
                }
            }
        } else if (args[0].equals("remove")) {
            if (args.length == 3) {
                experienceManger.decreaseExperience(player, proficiency, value);
                return true;
            } else if (args.length == 4) {
                if (args[3].equals("level")) {
                    experienceManger.decreaseLevel(player, proficiency, value.intValue());
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Requests a list of possible completions for a command argument.
     *
     * @param sender  Source of the command.  For players tab-completing a
     *                command inside of a command block, this will be the player, not
     *                the command block.
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    The arguments passed to the command, including final
     *                partial argument to be completed
     * @return A List of possible completions for the final argument, or null
     * to default to the command executor
     */
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return null;
        if (!command.getName().equals("experience")) return null;

        if (args.length == 1) return List.of("add", "remove");
        if (args.length == 2)  return Proficiency.proficiencies();
        if (args.length == 4) return List.of("level");

        return null;
    }
}
