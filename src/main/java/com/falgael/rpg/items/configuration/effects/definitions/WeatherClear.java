package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.items.configuration.effects.IntAction;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeatherClear extends IntAction {
    public WeatherClear(int value) {
        super(value);
    }

    @Override
    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyExperienceCalculation) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCoolDown(event, value)) return false;
        event.getPlayer().getWorld().setStorm(false);
        event.getPlayer().getWorld().setThundering(false);
        event.getPlayer().getWorld().setClearWeatherDuration(value);
        return true;
    }

}
