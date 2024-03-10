package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.items.configuration.effects.IntAction;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeatherStorm extends IntAction {
    public WeatherStorm(int value) {
        super(value);
    }

    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyExperienceCalculation) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCoolDown(event, value)) return false;
        event.getPlayer().getWorld().setStorm(true);
        event.getPlayer().getWorld().setThundering(true);
        event.getPlayer().getWorld().setThunderDuration(value);
        return true;
    }
}
