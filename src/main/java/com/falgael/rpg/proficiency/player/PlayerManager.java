package com.falgael.rpg.proficiency.player;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        proficiencyData.put(event.getPlayer().getUniqueId(), new PlayerExperience(event.getPlayer().getDisplayName()));
    }

    public static PlayerExperience getByPublicName(String name) {
        for (PlayerExperience playerExperience : proficiencyData.values()) {
            if (playerExperience.getPublicName().equals(name)) return playerExperience;
        }
        return null;
    }

    public static List<String> getPlayerNames() {
        List<String> result = new ArrayList<>();
        for (PlayerExperience playerExperience : proficiencyData.values()) {
            result.add(playerExperience.getPublicName());
        }
        return result;
    }

}
