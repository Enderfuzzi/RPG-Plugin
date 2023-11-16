package com.falgael.rpg.old;


import com.falgael.rpg.manager.ProficiencyExperienceManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PlayerManager implements Listener {

    private static HashMap<UUID, ProficiencyExperienceManager> proficiencyData = new HashMap<>();

    public static ProficiencyExperienceManager getProficiencyData(UUID player) {
        return proficiencyData.get(player);
    }

    public static void setProficiencyData(UUID player, ProficiencyExperienceManager proficiencyExperienceManager) {
        proficiencyData.put(player, proficiencyExperienceManager);
    }

    public static HashMap<UUID, ProficiencyExperienceManager> getProficiencyData() {
        return proficiencyData;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (proficiencyData.containsKey(event.getPlayer().getUniqueId())) return;
        proficiencyData.put(event.getPlayer().getUniqueId(), new ProficiencyExperienceManager(event.getPlayer().getDisplayName()));
    }

    public static ProficiencyExperienceManager getByPublicName(String name) {
        for (ProficiencyExperienceManager proficiencyExperienceManager : proficiencyData.values()) {
            if (proficiencyExperienceManager.getPublicName().equals(name)) return proficiencyExperienceManager;
        }
        return null;
    }

    public static List<String> getPlayerNames() {
        List<String> result = new ArrayList<>();
        for (ProficiencyExperienceManager proficiencyExperienceManager : proficiencyData.values()) {
            result.add(proficiencyExperienceManager.getPublicName());
        }
        return result;
    }

}
