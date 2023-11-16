package com.falgael.rpg.manager;

import com.falgael.rpg.proficiency.Proficiency;

public interface ProficiencyExperienceManagement {

    void increaseExperience(Proficiency proficiency, long value);
    void decreaseExperience(Proficiency proficiency, long value);
    void increaseLevel(Proficiency proficiency, int value);
    void decreaseLevel(Proficiency proficiency, int value);
    int getLevel(Proficiency proficiency);
    long getExperience(Proficiency proficiency);
    long getExperienceBorder(Proficiency proficiency);


}
