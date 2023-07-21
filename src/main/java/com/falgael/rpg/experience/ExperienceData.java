package com.falgael.rpg.experience;

import com.falgael.rpg.experience.data.Foraging;

import java.util.ArrayList;

/**
 * Contains all Experience data from a player
 * @author falgael
 * @version 0.0.1
 */
public class ExperienceData {


    private ArrayList<ExperienceFramework> list = new ArrayList<ExperienceFramework>();

    /**
     * Creates a new Experience list for a Player. Each new Class has to be added here
     */
    public ExperienceData() {
        list.add(new Foraging());
    }

    /**
     *
     * @return the lists of data concerning a player
     */
    public ArrayList<ExperienceFramework> getList() {
        return list;
    }
}
