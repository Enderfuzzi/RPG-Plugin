package com.falgael.rpg.proficiency.player;

import com.falgael.rpg.proficiency.ExperienceData;
import com.falgael.rpg.proficiency.ProficiencyTypes;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

public class PlayerExperience implements Serializable {


    @Serial
    private static final long serialVersionUID = 5319044698716544152L;

    private HashMap<ProficiencyTypes, ExperienceData> proficiencyData = new HashMap<>();

    public PlayerExperience() {
        for (ProficiencyTypes p : ProficiencyTypes.values()) {
            proficiencyData.put(p, new ExperienceData());
        }
    }


    public int getLevel(ProficiencyTypes proficiency) {
        return proficiencyData.get(proficiency).getCurrentLVL();
    }

    public void increaseExperience(ProficiencyTypes proficiency, long amount) {
        proficiencyData.get(proficiency).increaseExperience(amount);
    }

    public long getCurrentExperience(ProficiencyTypes proficiency) {
        return proficiencyData.get(proficiency).getCurrentExperience();
    }

    public long getCurrentExperienceBorder(ProficiencyTypes proficiency) {
        return proficiencyData.get(proficiency).getCurrentExperienceBorder();
    }



}
