package com.falgael.rpg.proficiency.items.effects;

import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeatherChange {

    public static boolean weatherClear(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCooldown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(false);
        event.getPlayer().getWorld().setThundering(false);
        event.getPlayer().getWorld().setClearWeatherDuration(duration);
        return true;
    }

    public static boolean weatherRain(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCooldown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(true);
        event.getPlayer().getWorld().setThundering(false);
        event.getPlayer().getWorld().setWeatherDuration(duration);
        return true;
    }

    public static boolean weatherStorm(Event e, int duration) {
        if (!(e instanceof PlayerInteractEvent event)) return false;
        if (!setItemCooldown(event, duration)) return false;
        event.getPlayer().getWorld().setStorm(true);
        event.getPlayer().getWorld().setThundering(true);
        event.getPlayer().getWorld().setThunderDuration(duration);
        return true;
    }

    private static boolean setItemCooldown(PlayerInteractEvent event, int duration) {
        if (event.getPlayer().hasCooldown(event.getItem().getType())) return false;
        event.getPlayer().setCooldown(event.getItem().getType(),duration);
        return true;
    }


}
