package com.falgael.rpg.proficiencies;

import com.falgael.rpg.proficiencies.player.ProficiencyData;

import java.util.HashMap;
import java.util.UUID;

/**
 * Manages each proficiency for each {@code Player}.
 * @author falgael
 * @version 0.0.1
 */
public class ProficiencyManager {
    /** Assigns Experience data to each player */
    private static HashMap<UUID, ProficiencyData> proficiencies = new HashMap<>();

    /**
     * Provides the {@link ProficiencyData} for the specified {@code Player}.
     * If the specified Player does not exist in the list then a new entry is created and returned.
     * This registers a new {@code Player} to the experience list.
     * @param player The identification of the Player to search
     * @return The Proficiency data of the Player
     */
    public static ProficiencyData getProficiencyData(UUID player) {
        if (!proficiencies.containsKey(player)) {
            setProficiencyData(player, new ProficiencyData());
        }
        return proficiencies.get(player);
    }

    /**
     * Provides the complete stored Map.
     * @return The Map of all stored Proficiencies of all {@code Player}
     */
    public static HashMap<UUID, ProficiencyData> getProficiencyData() {
        return proficiencies;
    }

    /**
     * Sets the Proficiency data of a given Player.
     * Note: This will overwrite the old data if the Player already existed in list.
     * @param player The identification of the Player
     * @param proficiencyData The data to set
     */
    public static void setProficiencyData(UUID player, ProficiencyData proficiencyData) {
        proficiencies.put(player,proficiencyData);
    }

}
