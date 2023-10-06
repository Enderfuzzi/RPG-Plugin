package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.tmp.Calculation;
import com.falgael.rpg.tmp.CustomItem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;

public class ItemBurnHandler implements Listener {

    @EventHandler
    public void onItemBurn(FurnaceBurnEvent event) {
        if (event.isCancelled()) return;

        //com.falgael.rpg.tmp.CustomItem customItem = com.falgael.rpg.tmp.CustomItem.getItem(event.getFuel());

        Calculation.performAction(event, CustomItem.getItem(event.getFuel()));

        /**
        if (customItem.hasConfiguration() && customItem.getConfiguration().hasAction()) {
            customItem.getConfiguration().getAction().accept(event);
        }
         */
    }
}
