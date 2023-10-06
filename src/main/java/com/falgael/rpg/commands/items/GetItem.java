package com.falgael.rpg.commands.items;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.tmp.CustomItem;
import com.falgael.rpg.tmp.EquipmentSet;
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

public class GetItem implements CommandExecutor, TabCompleter {

    private static final String ITEM = "item";

    private static final String SET = "set";
    private static final String PROFICIENCY = "proficiency";

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
            player.sendMessage("Usage: /get <item|set|proficiency> <name>");
            return false;
        }

        if (args[0].equals(ITEM)) {
            try {
                CustomItem item = CustomItem.valueOf(args[1]);
                player.getInventory().addItem(item.getItem());
            } catch (IllegalArgumentException e) {
                player.sendMessage("Unknown name: " + ITEM);
                return false;
            }
            return true;
        }


        if (args[0].equals(SET)) {
            try {
                EquipmentSet set = EquipmentSet.valueOf(args[1]);
                CustomItem.getItemsOfSet(set).forEach(v -> player.getInventory().addItem(v.getItem()));
            } catch (IllegalArgumentException e) {
                player.sendMessage("Unknown name: " + SET);
                return false;
            }
            return true;
        }

        if (args[0].equals(PROFICIENCY)) {
            try {
                ProficiencyType type = ProficiencyType.valueOf(args[1]);
                CustomItem.getItemsOfProficiency(type).forEach(v -> player.getInventory().addItem(v.getItem()));
            } catch (IllegalArgumentException e) {
                player.sendMessage("Unknown name: " + PROFICIENCY);
                return false;
            }
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
        if (args.length == 1) return List.of(ITEM,SET,PROFICIENCY);
        if (args.length == 2) {
            List<String> result = new ArrayList<>();
            if (args[0].equals(ITEM)) {
                Bukkit.getLogger().info("Equals item");
                for (CustomItem item : CustomItem.values()) result.add(item.name());
            }
            if (args[0].equals(SET)) {
                for (EquipmentSet set : EquipmentSet.values()) result.add(set.name());
            }
            if (args[0].equals(PROFICIENCY)) {
                for (ProficiencyType type : ProficiencyType.values()) {
                    if (type == ProficiencyType.NONE) continue;
                    result.add(type.name());
                }
            }
            if (!result.isEmpty()) return result;
        }
        return null;
    }
}
