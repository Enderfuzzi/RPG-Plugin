package com.falgael.rpg.proficiency;

import java.io.Serial;
import java.io.Serializable;

public class ExperienceData implements Serializable {
    @Serial
    private static final long serialVersionUID = -6202896916145603976L;
    private long currentExperience = 0;
    private int currentLVL = 0;
    private long currentExperienceBorder = 10;
    private static int lvlBorder = 100;


    public boolean increaseExperience(long amount) {
        if (amount <= 0 || currentLVL == lvlBorder) return false;
        currentExperience += amount;
        while (getCurrentExperienceBorder() <= currentExperience) {
            currentExperience -= getCurrentExperienceBorder();
            increaseLVL();
        }
        return true;
    }


    private void increaseLVL() {
        currentLVL++;
        generateNextBorder();
    }

    public long getCurrentExperienceBorder() {
        return currentExperienceBorder;
    }

    public long getCurrentExperience() {
        return currentExperience;
    }

    public int getCurrentLVL() {
        return currentLVL;
    }

    private void generateNextBorder() {
        currentExperienceBorder = currentExperienceBorder + currentExperienceBorder / 2;
    }



}
