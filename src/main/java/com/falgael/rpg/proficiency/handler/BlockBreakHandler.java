package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.Utils;

import com.falgael.rpg.proficiency.blocks.BlockBreak;

import com.falgael.rpg.tmp.Calculation;
import com.falgael.rpg.tmp.CustomItem;
import org.bukkit.Bukkit;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.inventory.ItemStack;


import java.util.List;

public class BlockBreakHandler implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;
        BlockBreak block = BlockBreak.getBlock(event.getBlock().getType());
        if (block.isNone()) return;

        CustomItem customItem = CustomItem.getItem(event.getPlayer().getInventory().getItemInMainHand());

        Bukkit.getLogger().info("Custom Item is none: " + customItem.isNone());

        if (customItem.isBreakingTool() && customItem.hasConfiguration() && customItem.getConfiguration().hasAction()) {
            if (customItem.getConfiguration().getAction().accept(event)) return;
        }

        long experienceAmount = Calculation.calculateExperience(block.getExperienceAmount(), block.getProficiency(), event.getPlayer());
        Bukkit.getLogger().info("Calculated experience: " + experienceAmount);
        int droppedBlocks = Calculation.calculateLoot(block.getProficiency(), event.getPlayer());
        Bukkit.getLogger().info("Calculated drops: " + droppedBlocks);

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        if (BlockBreak.getBlock(event.getBlock().getType()).hasAlternativeDrop()) {
            drops = List.of(new ItemStack(BlockBreak.getBlock(event.getBlock().getType()).getAlternativeDrop(), droppedBlocks));
            event.setDropItems(false);
        }

        Calculation.dropAdditionalLoot(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());


        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

    }

}
