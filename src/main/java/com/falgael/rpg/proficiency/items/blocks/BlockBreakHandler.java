package com.falgael.rpg.proficiency.items.blocks;

import com.falgael.rpg.proficiency.Utils;
import com.falgael.rpg.proficiency.items.CustomBlocks;
import com.falgael.rpg.proficiency.items.CustomTools;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakHandler implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.isCancelled()) return;
        BlockBreak block = BlockBreak.getBlock(event.getBlock().getType());
        if (block.isNone()) return;

        long experienceAmount = block.getExperienceAmount();
        int droppedBlocks = 0;
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

        CustomTools customTools = CustomTools.getItem(item);
        Bukkit.getLogger().info("Custom Tool not found: " + customTools.isNone());
        if (!customTools.isNone() && customTools.getProficiencyType() == block.getProficiency()) {
                experienceAmount *= customTools.getItemConfiguration().getExperienceModifier();
                droppedBlocks = customTools.getItemConfiguration().calculateDroppedBlocks();
        }

        if (droppedBlocks != 0) {
            Material toDrop = event.getBlock().getType();
            if (BlockBreak.getBlock(toDrop).hasAlternativeDrop()) {
                toDrop = BlockBreak.getBlock(toDrop).getAlternativeDrop();
            }
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(toDrop, droppedBlocks));
        }

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

    }

}
