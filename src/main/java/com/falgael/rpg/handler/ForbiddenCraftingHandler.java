package com.falgael.rpg.handler;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ForbiddenCraftingHandler implements Listener {

    //TODO WIP
    private final List<ItemStack> forbiddenIngredients;

    public ForbiddenCraftingHandler() {
        this.forbiddenIngredients = fillForbiddenIngredients();
    }



    @EventHandler
    public void preCrafting(PrepareItemCraftEvent event) {

        if (event.getInventory().getResult() == null) return;
        /*
        for (ItemStack ingredient : event.getInventory().getMatrix()) {
            if (ingredient == null) continue;
            if (!Items.getItem(ingredient).isNone() || forbiddenIngredients.contains(ingredient)) {
                event.getInventory().setResult(new ItemStack(Material.AIR));
                return;
            }
        }

         */

    }

    private List<ItemStack> fillForbiddenIngredients() {
        List<ItemStack> result = new ArrayList<>();

        return result;
    }

}
