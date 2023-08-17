package com.falgael.rpg.proficiency.items.blocks;

import com.falgael.rpg.proficiency.Utils;
import com.falgael.rpg.proficiency.items.CustomTools;
import org.bukkit.Bukkit;

import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
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

        //Check if block is a crop which is fully grown
        if (event.getBlock().getBlockData() instanceof Ageable cropAge) {
            if (cropAge.getAge() != cropAge.getMaximumAge()) return;
        }



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
            // Get the natural Drops and modify them
            List<ItemStack> toDrop = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
            for (ItemStack itemStack : toDrop) {
                ItemStack tmp = itemStack.clone();
                tmp.setAmount(droppedBlocks);
                //Override the Drops if an alternative is given
                if (BlockBreak.getBlock(event.getBlock().getType()).hasAlternativeDrop()) {
                   tmp = new ItemStack(BlockBreak.getBlock(event.getBlock().getType()).getAlternativeDrop(),droppedBlocks + 1);
                   event.setDropItems(false);
                }
                event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(),tmp);
            }


            /*
            Old Code
            Material toDrop = event.getBlock().getType();
            if (BlockBreak.getBlock(toDrop).hasAlternativeDrop()) {
                toDrop = BlockBreak.getBlock(toDrop).getAlternativeDrop();
            }
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(toDrop, droppedBlocks));
            */

        }

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

    }

}
