package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.Items;

import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class ItemBurnHandler extends MainHandler {

    public ItemBurnHandler(ProficiencyCalculationAdapter proficiencyAdapter, ItemManagement itemAdapter, VillagerManagement villagerAdapter) {
        super(proficiencyAdapter, itemAdapter, villagerAdapter);
    }

    @EventHandler
    public void onItemBurn(FurnaceBurnEvent event) {
        if (event.isCancelled()) return;
        proficiencyAdapter.performAction(event, itemAdapter.getItem(event.getFuel()));
    }
}
