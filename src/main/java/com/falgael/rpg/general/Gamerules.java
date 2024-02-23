package com.falgael.rpg.general;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;

public class Gamerules {

    public void activate() {
        Bukkit.getServer().getWorlds().forEach( w -> {
            w.setGameRule(GameRule.SNOW_ACCUMULATION_HEIGHT, 2);
            w.setGameRule(GameRule.MOB_EXPLOSION_DROP_DECAY, false);
            w.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 0);
            w.setGameRule(GameRule.MOB_EXPLOSION_DROP_DECAY, false);
        });
    }

    public void deactivate() {
        Bukkit.getServer().getWorlds().forEach( w -> {
            w.setGameRule(GameRule.SNOW_ACCUMULATION_HEIGHT, 1);
            w.setGameRule(GameRule.MOB_EXPLOSION_DROP_DECAY, true);
            w.setGameRule(GameRule.PLAYERS_SLEEPING_PERCENTAGE, 100);
            w.setGameRule(GameRule.MOB_EXPLOSION_DROP_DECAY, true);
        });
    }
}
