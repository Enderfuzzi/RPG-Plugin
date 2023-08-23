package com.falgael.rpg.commands.villager;

import com.falgael.rpg.villager.CustomVillager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VillagerSpawn implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length != 1) {
            player.sendMessage("Usage: /spawn_villager <key>");
            return false;
        }

        CustomVillager.getVillager(args[0]).getVillager().spawn(player.getWorld(),player.getLocation());

        return true;

    }


}
