package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.items.CustomItem;
import org.bukkit.Bukkit;
import org.bukkit.block.Furnace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceStartSmeltEvent;

public class ItemBurnHandler implements Listener {

    @EventHandler
    public void onItemBurn(FurnaceBurnEvent event) {
        if (event.isCancelled()) return;
        CustomItem customItem = CustomItem.getItem(event.getFuel());
        if (customItem.isNone()) return;
        if (customItem == CustomItem.STONEWORK_INFINITE_COAL) {

            Bukkit.getLogger().info("[" + ItemBurnHandler.class.getSimpleName() + "]: Burn in:" + event.getBlock());



            if (event.getBlock().getState() instanceof Furnace furnace) {
                Bukkit.getLogger().info("[" + ItemBurnHandler.class.getSimpleName() + "]: Is instance");
                furnace.getInventory().setFuel(customItem.getItem());
                event.getBlock().getState().update();

            }   else {
                Bukkit.getLogger().info("[" + ItemBurnHandler.class.getSimpleName() + "]: No instance");
            }


            Bukkit.getLogger().info("[" + ItemBurnHandler.class.getSimpleName() + "]: Burn time in Ticks: " + event.getBurnTime());
            //event.setBurnTime(16000);
        }
    }
}
