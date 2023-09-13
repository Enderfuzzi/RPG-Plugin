package com.falgael.rpg.proficiency.handler;


import com.falgael.rpg.proficiency.ForbiddenCrafting;
import com.falgael.rpg.proficiency.items.CustomItem;
import com.falgael.rpg.proficiency.items.CustomTool;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class ForbiddenCraftingHandler implements Listener {

    @EventHandler
    public void preCrafting(PrepareItemCraftEvent event) {

        if (event.getInventory().getResult() == null) return;

        for (ItemStack ingredient : event.getInventory().getMatrix()) {
            if (ingredient == null) continue;
            if (!CustomItem.getItem(ingredient).isNone()) {
                event.getInventory().setResult(new ItemStack(Material.AIR));
                return;
            }
            if (!CustomTool.getItem(ingredient).isNone()) {
                event.getInventory().setResult(new ItemStack(Material.AIR));
                return;
            }
        }


        if (ForbiddenCrafting.isForbidden(event.getInventory().getMatrix(), event.getInventory().getResult())) {
            event.getInventory().setResult(new ItemStack(Material.AIR));
        }
    }


}
