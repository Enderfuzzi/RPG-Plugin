package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.blocks.BlockBreak;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.proficiency.items.ItemConfigurationFlag;
import com.falgael.rpg.proficiency.items.effects.BlockBreakEffect;
import org.bukkit.Bukkit;

import org.bukkit.block.data.Ageable;
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

        Bukkit.getLogger().info("[" + BlockBreakHandler.class.getSimpleName() + "]: Block to harvest: " + event.getBlock().getType().name());

        //Check if block is a crop which is fully grown
        if (block.ageable() && event.getBlock().getBlockData() instanceof Ageable cropAge) {
            Bukkit.getLogger().info("[" + BlockBreakHandler.class.getSimpleName() + "]: Ageable: " + event.getBlock().getType().name());
            if (cropAge.getAge() != cropAge.getMaximumAge()) return;
        }



        //long experienceAmount = block.getExperienceAmount();
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

        CustomTool customTool = CustomTool.getItem(item);
        Bukkit.getLogger().info("Custom Tool found: " + !customTool.isNone());

        long experienceAmount = ItemConfiguration.calculateExperience(customTool, block.getExperienceAmount(), block.getProficiency(), event.getPlayer());
        int droppedBlocks = ItemConfiguration.calculateLoot(customTool, block.getProficiency(), event.getPlayer());


        /*
        if (!customTool.isNone() && customTool.getProficiencyType() == block.getProficiency()) {
            if (customTool.getItemConfiguration().hasBlockBreakEffect()) {
                BlockBreakEffect blockBreakEffect = customTool.getItemConfiguration().getBlockBreakEffect();
                experienceAmount *= blockBreakEffect.getExperienceModifier();
                droppedBlocks = blockBreakEffect.calculateDroppedBlocks();

            }
        }
        */
        /*
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
            */

        List<ItemStack> drops = event.getBlock().getDrops(event.getPlayer().getInventory().getItemInMainHand()).stream().toList();
        if (BlockBreak.getBlock(event.getBlock().getType()).hasAlternativeDrop()) {
            drops = List.of(new ItemStack(BlockBreak.getBlock(event.getBlock().getType()).getAlternativeDrop(), droppedBlocks));
            event.setDropItems(false);
        }

        ItemConfiguration.dropAdditionalLoot(drops, droppedBlocks, event.getBlock().getWorld(), event.getBlock().getLocation());



            /*
            Old Code
            Material toDrop = event.getBlock().getType();
            if (BlockBreak.getBlock(toDrop).hasAlternativeDrop()) {
                toDrop = BlockBreak.getBlock(toDrop).getAlternativeDrop();
            }
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(toDrop, droppedBlocks));
            */

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);

    }

}
