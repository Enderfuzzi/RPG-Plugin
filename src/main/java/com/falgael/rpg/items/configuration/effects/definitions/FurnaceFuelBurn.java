package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.items.configuration.effects.DoubleAction;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.block.Furnace;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.ItemStack;

public class FurnaceFuelBurn extends DoubleAction {
    
    
    public FurnaceFuelBurn(double value) {
        super(value);
    }

    @Override
    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyExperienceCalculation) {
        if (!(e instanceof FurnaceBurnEvent event)) return false;
        if (!(event.getBlock().getState() instanceof Furnace furnace)) return false;
        ItemStack fuel = furnace.getInventory().getFuel();
        fuel.setAmount(fuel.getAmount() + 1);
        furnace.getInventory().setFuel(fuel);
        if (furnace.getCookTime() < furnace.getCookTimeTotal() * value)
            furnace.setCookTime((short) (furnace.getCookTimeTotal() * value));
        furnace.update();
        event.setBurnTime((short) (furnace.getCookTimeTotal() * (1 - value)));
        event.setBurning(false);
        return true;
    }
    
}
