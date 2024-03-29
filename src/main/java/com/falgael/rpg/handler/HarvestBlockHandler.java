package com.falgael.rpg.handler;

import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.definitions.stats.BlockHarvestStats;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerHarvestBlockEvent;

public class HarvestBlockHandler extends MainHandler {

    public HarvestBlockHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onBlockHarvest(PlayerHarvestBlockEvent event) {
        Bukkit.getLogger().info("[" + HarvestBlockHandler.class.getSimpleName() + "]: Harvest Event");

        BlockHarvestStats block = BlockHarvestStats.getBlock(event.getHarvestedBlock().getType());
        if (block.isNone()) return;


        proficiencyAdapter.calculateExperience(event.getPlayer(), block.getProficiencies(), block.getExperienceAmount());

        int droppedBlocks = proficiencyAdapter.calculateLoot(event.getPlayer(), block.getProficiencies());

        proficiencyAdapter.dropAdditionalLoot(event.getItemsHarvested(), droppedBlocks, event.getHarvestedBlock().getWorld(), event.getHarvestedBlock().getLocation());
    }


}
