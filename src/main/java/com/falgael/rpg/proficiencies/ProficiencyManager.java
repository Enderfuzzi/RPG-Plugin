package com.falgael.rpg.proficiencies;

import com.falgael.rpg.proficiencies.player.ProficiencyData;

import java.util.HashMap;
import java.util.UUID;

public class ProficiencyManager {
    /** Assigns Experience data to each player */
    public static HashMap<UUID, ProficiencyData> proficiencies = new HashMap<>();


    public static ProficiencyData getProficiencyData(UUID player) {
        if (!proficiencies.containsKey(player)) {
            proficiencies.put(player,new ProficiencyData());
        }
        return proficiencies.get(player);
    }

    public static HashMap<UUID, ProficiencyData> getProficiencyData() {
        return proficiencies;
    }


    public static void setProficiencyData(UUID player, ProficiencyData proficiencyData) {
        proficiencies.put(player,proficiencyData);
    }

    public static void save() {

    }

    public static void load() {

    }


}
