package com.falgael.rpg.items.configuration.effects;

import com.falgael.rpg.definitions.stats.BlockStats;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IntAction extends Action{

    protected final int value;

    protected IntAction(int value) {
        super();
        this.value = value;
    }

    protected boolean veinHarvest(Event e, ProficiencyExperienceCalculation proficiencyAdapter, int maxAmount, Predicate consumer) {
        if (!(e instanceof BlockBreakEvent event)) return false;

        BlockStats block = BlockStats.getBlock(event.getBlock().getType());
        ArrayList<Location> blocks = getSurroundedBlocks(event.getBlock().getLocation(), maxAmount, consumer);
        if (blocks.isEmpty()) return false;
        proficiencyAdapter.calculateExperience(event.getPlayer(), block.getProficiencies(), block.getExperienceAmount() * blocks.size());
        int droppedBlocks = proficiencyAdapter.calculateLoot(event.getPlayer(), block.getProficiencies());
        Bukkit.getLogger().info("Dropped Blocks: " + droppedBlocks + 1);
        Bukkit.getLogger().info("Additional Blocks: " + blocks.size());
        droppedBlocks = ((droppedBlocks + 1) * blocks.size()) - 1;
        Bukkit.getLogger().info("Dropped Blocks modified: " + droppedBlocks);
        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        //proficiencyAdapter.dropAdditionalLoot(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());
        dropItem(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());

        for (Location location : blocks) {
            Bukkit.getLogger().info("Location to remove: " + location);
            if (event.getBlock().getLocation().equals(location)) continue;
            location.getBlock().setType(Material.AIR);
        }
        return true;
    }

    protected ArrayList<Location> getSurroundedBlocks(Location startLocation, int maxBlocks, Predicate consumer) {
        ArrayList<Location> result = new ArrayList<>();
        Queue<Location> queue = new LinkedList<>();
        queue.add(startLocation);
        while (!queue.isEmpty() && maxBlocks > result.size()) {
            Location tmp = queue.remove();
            if (tmp.getBlock().getType() == Material.AIR) continue;
            if (!consumer.accept(startLocation.getBlock(),tmp.getBlock())) continue;
            if (result.contains(tmp)) continue;
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

    protected boolean setItemCoolDown(PlayerInteractEvent event, int duration) {
        if (event.getPlayer().hasCooldown(event.getItem().getType())) return false;
        event.getPlayer().setCooldown(event.getItem().getType(),duration);
        return true;
    }

}
