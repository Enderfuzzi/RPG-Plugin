package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.items.configuration.effects.Action;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class LootBox extends Action {

    @Override
    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyExperienceCalculation) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

        if (item.getAmount() > 1) item.setAmount(item.getAmount() - 1);
        else if (item.getAmount() == 1) event.getPlayer().getInventory().setItemInMainHand(null);

        return true;
    }

}
