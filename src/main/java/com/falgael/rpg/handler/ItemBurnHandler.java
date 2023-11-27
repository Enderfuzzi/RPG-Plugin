package com.falgael.rpg.handler;

import com.falgael.rpg.manager.MainManagement;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class ItemBurnHandler extends MainHandler {

    public ItemBurnHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onItemBurn(FurnaceBurnEvent event) {
        if (event.isCancelled()) return;
        proficiencyAdapter.performAction(event, itemAdapter.getItem(event.getFuel()));
    }
}
