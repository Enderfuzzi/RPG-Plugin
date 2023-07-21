package com.falgael.rpg.experience;

import com.falgael.rpg.experience.data.Foraging;

import java.util.ArrayList;

/**
 * Contains all Experience data from a player
 * @author falgael
 * @version 0.0.1
 */
public class ExperienceData {


    private ArrayList<ExperienceFramework> blockBreakProficiency = new ArrayList<ExperienceFramework>();

    /**
     * Creates a new Experience list for a Player. Each new Class has to be added here
     */
    public ExperienceData() {
        blockBreakProficiency.add(new Foraging());
    }

    /**
     *
     * @return the lists of data concerning a player
     */
    public ArrayList<ExperienceFramework> getBlockBreakProficiency() {
        return blockBreakProficiency;
    }
}
