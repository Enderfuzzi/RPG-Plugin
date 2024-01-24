package com.falgael.rpg.handler;

import com.falgael.rpg.loottable.LootTableManager;
import com.falgael.rpg.manager.MainManagement;

import com.falgael.rpg.definitions.stats.BlockStats;

import org.bukkit.Bukkit;


import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import org.bukkit.inventory.ItemStack;


import java.util.List;

public class BlockBreakHandler extends MainHandler {


    public BlockBreakHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;
        BlockStats block = BlockStats.getBlock(event.getBlock().getType());
        if (block.isNone()) return;


        if (proficiencyAdapter.performAction(event.getPlayer(),event, i -> i.isBreakingTool())) return;



        //TODO double computation of experience
        Bukkit.getLogger().info("Material which is Broken: " + block.getMaterial());
        lootComputation.triggerEvent(event.getPlayer(), block.getMaterial(), LootTableManager.Reason.BlockBreak, event.getBlock().getLocation());


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
