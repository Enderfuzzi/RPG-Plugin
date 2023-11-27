package com.falgael.rpg.commands;

import com.falgael.rpg.villager.VillagerInstance;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpawnCommand implements CommandExecutor, TabCompleter {


    private final VillagerManagement villagerManager;


    public SpawnCommand(VillagerManagement villagerManager) {
        this.villagerManager = villagerManager;
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
        if (args.length != 2) {
            player.sendMessage("Usage: /spawn <villager> <key>");
            return false;
        }

        if (args[0].equals("villager")) {
            VillagerInstance villager = villagerManager.getVillager(args[1]);
            if (villagerManager.isDefault(villager)) {
                player.sendMessage("Unregistered Key");
                return false;
            }
            villager.spawn(player.getWorld(), player.getLocation());
            return true;
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
        if (!command.getName().equals("spawn")) return null;

        if (args.length == 1) return List.of("villager");
        if (args.length == 2) {
            List<String> result = new ArrayList<>();
            if (args[0].equals("villager")) {
                result.addAll(villagerManager.getRegisteredKeys().stream().filter(e -> e.toLowerCase().startsWith(args[1].toLowerCase())).collect(Collectors.toList()));
            }
            return result;
        }
        return null;
    }
}
