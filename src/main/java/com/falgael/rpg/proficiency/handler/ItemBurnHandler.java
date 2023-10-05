package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomItem;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.ItemStack;

public class ItemBurnHandler implements Listener {

    @EventHandler
    public void onItemBurn(FurnaceBurnEvent event) {
        if (event.isCancelled()) return;

        com.falgael.rpg.tmp.CustomItem customItem = com.falgael.rpg.tmp.CustomItem.getItem(event.getFuel());

        if (customItem.hasConfiguration() && customItem.getConfiguration().hasAction()) {
            customItem.getConfiguration().getAction().accept(event);
        }
    }
}
