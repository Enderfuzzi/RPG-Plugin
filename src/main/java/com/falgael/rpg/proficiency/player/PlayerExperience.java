package com.falgael.rpg.proficiency.player;

import com.falgael.rpg.proficiency.ExperienceData;
import com.falgael.rpg.proficiency.general.ProficiencyType;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

public class PlayerExperience implements Serializable {


    @Serial
    private static final long serialVersionUID = 5319044698716544152L;

    private final String publicName;

    private HashMap<ProficiencyType, ExperienceData> proficiencyData = new HashMap<>();

    public PlayerExperience(String publicName) {
        this.publicName = publicName;
        for (ProficiencyType p : ProficiencyType.values()) {
            proficiencyData.put(p, new ExperienceData());
        }
    }


    public int getLevel(ProficiencyType proficiency) {
        return proficiencyData.get(proficiency).getCurrentLVL();
    }

    public void increaseExperience(ProficiencyType proficiency, long amount) {
        proficiencyData.get(proficiency).increaseExperience(amount);
    }

    public void decreaseExperience(ProficiencyType proficiency, long amount) {
        proficiencyData.get(proficiency).decreaseExperience(amount);
    }

    public long getCurrentExperience(ProficiencyType proficiency) {
        return proficiencyData.get(proficiency).getCurrentExperience();
    }

    public long getCurrentExperienceBorder(ProficiencyType proficiency) {
        return proficiencyData.get(proficiency).getCurrentExperienceBorder();
    }

    public String getPublicName() {
        return publicName;
    }

}
