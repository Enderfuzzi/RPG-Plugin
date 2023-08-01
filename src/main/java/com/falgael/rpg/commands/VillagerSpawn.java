package com.falgael.rpg.commands;

import com.falgael.rpg.villager.VillagerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VillagerSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length != 1) {
            player.sendMessage("Usage: /villager <key>");
            return false;
        }

        VillagerManager.getVillager(args[0]).spawn(player.getWorld(),player.getLocation());

        //Villager.spawnVillager(player, args[0]);
        return true;

    }


}
