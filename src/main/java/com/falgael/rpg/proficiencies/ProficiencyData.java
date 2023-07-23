package com.falgael.rpg.proficiencies;

import com.falgael.rpg.proficiencies.data.woodwork.Woodwork;
import org.bukkit.Material;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contains all Experience data from a player
 * @author falgael
 * @version 0.0.1
 */
public class ProficiencyData implements Serializable {

    @Serial
    private static final long serialVersionUID = 7607691920061618617L;

    private ArrayList<ProficiencyExperienceFramework> blockBreakProficiency = new ArrayList<ProficiencyExperienceFramework>();

    /**
     * Creates a new Experience list for a Player. Each new Class has to be added here
     */
    public ProficiencyData() {
        blockBreakProficiency.add(new Woodwork());
    }

    /**
     *
     * @return the lists of data concerning a player
     */
    public ArrayList<ProficiencyExperienceFramework> getBlockBreakProficiency() {
        return blockBreakProficiency;
    }

    /**
     * Checks if a {@code Player} is allowed to craft an item
     * @param m The {@code Material} to check
     * @return {@code true} if a proficiency forbids to craft an item
     */
    public boolean isForbiddenToCraft(Material m) {
        for (ProficiencyExperienceFramework ef : blockBreakProficiency) {
            if (ef.isForbiddenToCraft(m)) return true;
        }
        return false;
    }

}
