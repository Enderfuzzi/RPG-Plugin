package com.falgael.rpg.proficiency.player;

import com.falgael.rpg.RPG;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager implements Listener {

    private static HashMap<UUID, PlayerExperience> proficiencyData = new HashMap<>();

    public static PlayerExperience getProficiencyData(UUID player) {
        return proficiencyData.get(player);
    }

    public static void setProficiencyData(UUID player, PlayerExperience playerExperience) {
        proficiencyData.put(player, playerExperience);
    }

    public static HashMap<UUID, PlayerExperience> getProficiencyData() {
        return proficiencyData;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (proficiencyData.containsKey(event.getPlayer().getUniqueId())) return;
        proficiencyData.put(event.getPlayer().getUniqueId(), new PlayerExperience());
    }
}
