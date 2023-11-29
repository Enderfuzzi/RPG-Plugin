package com.falgael.rpg.commands;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.items.set.ItemSetManagement;
import org.bukkit.Bukkit;
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

public class GetCommand implements CommandExecutor, TabCompleter {

    private final ItemManagement itemManager;
    private final ItemSetManagement itemSetManager;

    public GetCommand(ItemManagement itemManager, ItemSetManagement itemSetManager) {
        this.itemManager = itemManager;
        this.itemSetManager = itemSetManager;
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

        for (String tmp : args) {
            Bukkit.getLogger().info(tmp);
        }


        if (args.length != 2) {
            player.sendMessage("Usage: /get <item|set> <key>");
            return false;
        }

        if (args[0].equals("item")) {
            DefaultItem item = itemManager.getItem(args[1]);
            if (item.isDefault()) {
                player.sendMessage("Unregistered Key");
                return false;
            }
            player.getInventory().addItem(item.getItemStackRepresentation());
            return true;
        }

        if (args[0].equals("set")) {
            DefaultItemSet itemSet = itemSetManager.getItemSet(args[1]);
            if (itemSet.isDefault()) {
                player.sendMessage("Unregistered Key");
                return false;
            }
            itemManager.getItemsOfSet(itemSet).forEach(i -> player.getInventory().addItem(i.getItemStackRepresentation()));
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
        if (!command.getName().equals("get")) return null;

        if (args.length == 1) return List.of("item","set");
        if (args.length == 2) {
            List<String> result = new ArrayList<>();
            if (args[0].equals("item")) {

                result.addAll(
                        itemManager.getRegisteredKeys().stream().filter(
                                e -> e.toLowerCase().startsWith(args[1].toLowerCase())).toList()
                );

                //result.addAll(itemManager.getRegisteredKeys());
            } else if (args[0].equals("set")) {
                result.addAll(
                        itemSetManager.getRegisteredKeys().stream().filter(
                                e -> e.toLowerCase().startsWith(args[1].toLowerCase())).toList()
                );
            }


            return result;
        }


        return null;
    }
}
