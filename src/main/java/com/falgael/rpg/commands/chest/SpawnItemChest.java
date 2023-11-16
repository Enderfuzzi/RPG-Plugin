package com.falgael.rpg.commands.chest;

import com.falgael.rpg.items.Items;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;


public class SpawnItemChest implements CommandExecutor {
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

        if (args.length != 1) {
            player.sendMessage("Usage: /spawn_chest <Proficiency>");
            return false;
        }

        Proficiency proficiency = Proficiency.isProficiency(args[0]);
        if (proficiency == Proficiency.NONE) {
            player.sendMessage("Unknown proficiency");
            return false;
        }

        Block block = player.getLocation().getBlock();
        block.setType(Material.CHEST);
        if (block.getState() instanceof Chest chest) {
            Inventory inventory = chest.getBlockInventory();
            for (Items item : Items.getItemsOfProficiency(proficiency)) {
                inventory.addItem(item.getItem());
            }
        }


        return true;
    }
}
