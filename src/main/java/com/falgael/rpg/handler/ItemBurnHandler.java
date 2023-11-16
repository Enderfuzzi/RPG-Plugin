package com.falgael.rpg.handler;

import com.falgael.rpg.items.Items;

import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class ItemBurnHandler extends MainHandler {

    public ItemBurnHandler(ProficiencyCalculationAdapter proficiencyAdapter) {
        super(proficiencyAdapter);
    }

    @EventHandler
    public void onItemBurn(FurnaceBurnEvent event) {
        if (event.isCancelled()) return;
        proficiencyAdapter.performAction(event, Items.getItem(event.getFuel()));
    }
}
