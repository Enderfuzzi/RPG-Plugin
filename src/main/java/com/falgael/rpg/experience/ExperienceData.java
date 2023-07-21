package com.falgael.rpg.experience;

import com.falgael.rpg.experience.data.Foraging;

/**
 * Holds all Experience data
 * @author falgael
 * @version 0.0.1
 */
public class ExperienceData {

    private Foraging foraging;

    public ExperienceData() {
        foraging = new Foraging();
    }

    public Foraging getForaging() {
        return foraging;
    }
}
