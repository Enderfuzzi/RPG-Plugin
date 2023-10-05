package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.blocks.HarvestBlock;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.tmp.Calculation;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.inventory.ItemStack;

public class HarvestBlockHandler implements Listener {

    @EventHandler
    public void onBlockHarvest(PlayerHarvestBlockEvent event) {
        Bukkit.getLogger().info("[" + HarvestBlockHandler.class.getSimpleName() + "]: Harvest Event");

        HarvestBlock block = HarvestBlock.getBlock(event.getHarvestedBlock().getType());
        if (block.isNone()) return;



        long experienceAmount = Calculation.calculateExperience(block.getExperienceAmount(), block.getProficiency(), event.getPlayer());
        int droppedBlocks = Calculation.calculateLoot(block.getProficiency(), event.getPlayer());

        Calculation.dropAdditionalLoot(event.getItemsHarvested(), droppedBlocks, event.getHarvestedBlock().getWorld(), event.getHarvestedBlock().getLocation());

        ItemConfiguration.dropAdditionalLoot(event.getItemsHarvested(),droppedBlocks,event.getHarvestedBlock().getWorld(),event.getHarvestedBlock().getLocation());

        Utils.increaseExperience(event.getPlayer(),block.getProficiency(),experienceAmount);
    }


}
