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
        CustomItem customItem = CustomItem.getItem(event.getFuel());
        if (customItem.isNone()) return;
        if (customItem == CustomItem.STONEWORK_INFINITE_COAL) {
            if (event.getBlock().getState() instanceof Furnace furnace) {
                ItemStack fuel = furnace.getInventory().getFuel();
                furnace.getInventory().setFuel(Utils.modifyItemAmount(CustomItem.STONEWORK_INFINITE_COAL.getItem(), fuel.getAmount() + 1));
                furnace.setCookTime((short) (furnace.getCookTimeTotal() * 0.5));
                furnace.update();
            }
            event.setBurnTime(100);
            event.setBurning(false);
        }
    }
}
