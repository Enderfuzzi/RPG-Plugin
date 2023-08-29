package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.blocks.HarvestBlock;
import com.falgael.rpg.proficiency.items.effects.BlockBreakEffect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class HarvestBlockHandler implements Listener {

    @EventHandler
    public void onBlockHarvest(PlayerHarvestBlockEvent event) {
        HarvestBlock block = HarvestBlock.getBlock(event.getHarvestedBlock().getType());
        if (block.isNone()) return;

        long experienceAmount = block.getExperienceAmount();
        int droppedBlocks = 0;
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

        CustomTool customTool = CustomTool.getItem(item);
        if (!customTool.isNone() && customTool.getProficiencyType() == block.getProficiency()) {

            if (customTool.getItemConfiguration().hasBlockBreakEffect()) {
                BlockBreakEffect blockBreakEffect = customTool.getItemConfiguration().getBlockBreakEffect();
                experienceAmount *= blockBreakEffect.getExperienceModifier();
                droppedBlocks = blockBreakEffect.calculateDroppedBlocks();

            }
        }

        if (droppedBlocks != 0) {
            // Get the natural Drops and modify them
            List<ItemStack> toDrop = event.getItemsHarvested();
            for (ItemStack itemStack : toDrop) {
                ItemStack tmp = itemStack.clone();
                tmp.setAmount(droppedBlocks);
                //Override the Drops if an alternative is given
                event.getHarvestedBlock().getWorld().dropItemNaturally(event.getHarvestedBlock().getLocation(),tmp);
            }

        }

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);
    }


}