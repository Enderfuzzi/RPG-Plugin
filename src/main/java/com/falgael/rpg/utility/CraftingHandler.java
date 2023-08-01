package com.falgael.rpg.utility;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;

public class CraftingHandler implements Listener {


    @EventHandler
    public void inventoryMoveItemEvent(InventoryMoveItemEvent event) {
        Bukkit.getLogger().info("Event triggered");
        //if (event.getInventory().getType() != InventoryType.STONECUTTER) return;

        Bukkit.getLogger().info("Is stonecutter");

    }


}
