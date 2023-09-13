package com.falgael.rpg.proficiency.items.effects;

import com.falgael.rpg.proficiency.blocks.BlockBreak;
import com.falgael.rpg.proficiency.blocks.WoodType;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeHarvest {


    public static boolean effect(Event e, int maxAmount) {
        if (!(e instanceof BlockBreakEvent event)) return false;
        BlockBreak block = BlockBreak.getBlock(event.getBlock().getType());
        CustomTool customTool = CustomTool.getItem(event.getPlayer().getInventory().getItemInMainHand());
        if (customTool.isNone()) return false;
        if (!block.hasWoodType()) return false;
        ArrayList<Location> blocks = getTreeLogs(event.getBlock().getLocation(), block.getWoodType(), maxAmount);
        if (blocks.isEmpty()) return false;

        long experienceAmount = ItemConfiguration.calculateExperience(customTool, block.getExperienceAmount(), block.getProficiency(), event.getPlayer());
        int droppedBlocks = ItemConfiguration.calculateLoot(customTool, block.getProficiency(), event.getPlayer());

        experienceAmount *= blocks.size();
        droppedBlocks *=  blocks.size();

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        ItemConfiguration.dropAdditionalLoot(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

        for (Location location : blocks) {
            Bukkit.getLogger().info("Location to remove: " + location);
            if (event.getBlock().getLocation().equals(location)) continue;
            location.getBlock().setType(Material.AIR);
        }


        return true;
    }

    private static ArrayList<Location> getTreeLogs(Location location, WoodType type, int maxAmount) {
        ArrayList<Location> result = new ArrayList<>();
        Queue<Location> queue = new LinkedList<>();
        queue.add(location);

        while (!queue.isEmpty() && maxAmount > result.size()) {
            Location tmp = queue.remove();
            Bukkit.getLogger().info("Location: " + tmp);
            if (tmp.getBlock().getType() == Material.AIR) continue;
            if (result.contains(tmp)) continue;

            BlockBreak tmpBlockBreak = BlockBreak.getBlock(tmp.getBlock().getType());
            if (tmpBlockBreak.isNone()) continue;
            if (!tmpBlockBreak.hasWoodType()) continue;
            if (tmpBlockBreak.getWoodType() != type) continue;

            result.add(tmp);

            for (int x = -1;x < 2;x++) {
                for (int y = -1; y < 2; y++) {
                    for (int z = -1;z < 2; z++) {
                        if (x == 0 && y == 0 && z == 0) continue;
                        queue.add(tmp.getBlock().getRelative(x,y,z).getLocation());


                    }

                }
            }
        }



        return result;
    }

}
