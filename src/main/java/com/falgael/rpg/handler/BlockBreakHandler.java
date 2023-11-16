package com.falgael.rpg.handler;

import com.falgael.rpg.items.Items;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.misc.Calculations;

import com.falgael.rpg.stats.BlockStats;

import org.bukkit.Bukkit;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.inventory.ItemStack;


import java.util.List;

public class BlockBreakHandler extends MainHandler {


    public BlockBreakHandler(ProficiencyCalculationAdapter proficiencyAdapter) {
        super(proficiencyAdapter);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;
        BlockStats block = BlockStats.getBlock(event.getBlock().getType());
        if (block.isNone()) return;


        if (proficiencyAdapter.performAction(event.getPlayer(),event, Items::isBreakingTool)) return;

       proficiencyAdapter.calculateExperience(event.getPlayer(),block.getProficiencies(),block.getExperienceAmount());

        int droppedBlocks = proficiencyAdapter.calculateLoot(event.getPlayer(), block.getProficiencies());
        Bukkit.getLogger().info("Calculated drops: " + droppedBlocks);

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        if (BlockStats.getBlock(event.getBlock().getType()).hasAlternativeDrop()) {
            drops = List.of(new ItemStack(BlockStats.getBlock(event.getBlock().getType()).getAlternativeDrop(), droppedBlocks));
            event.setDropItems(false);
        }

        proficiencyAdapter.dropAdditionalLoot(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());
    }
}
