package com.falgael.rpg.proficiency.items.effects;

import org.bukkit.block.Furnace;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceBurn {

    public static boolean effect(Event e, double speedIncrease) {
        if (!(e instanceof FurnaceBurnEvent event)) return false;
        if (!(event.getBlock().getState() instanceof Furnace furnace)) return false;


        ItemStack fuel = furnace.getInventory().getFuel();
        fuel.setAmount(fuel.getAmount() + 1);
        furnace.getInventory().setFuel(fuel);

        if (furnace.getCookTime() < furnace.getCookTimeTotal() * speedIncrease)
            furnace.setCookTime((short) (furnace.getCookTimeTotal() * speedIncrease));

        furnace.update();

        event.setBurnTime((short) (furnace.getCookTimeTotal() * (1 - speedIncrease)));
        event.setBurning(false);

        return true;
    }

}
