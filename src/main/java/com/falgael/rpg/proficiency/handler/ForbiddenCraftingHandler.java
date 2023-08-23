package com.falgael.rpg.proficiency.handler;


import com.falgael.rpg.proficiency.ForbiddenCrafting;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class ForbiddenCraftingHandler implements Listener {

    @EventHandler
    public void preCrafting(PrepareItemCraftEvent event) {

        if (event.getInventory().getResult() == null) return;

        if (ForbiddenCrafting.isForbidden(event.getInventory().getMatrix(), event.getInventory().getResult())) {
            event.getInventory().setResult(new ItemStack(Material.AIR));
        }
    }


}
