package com.falgael.rpg.old;

import java.io.Serial;
import java.io.Serializable;

@Deprecated
public class ExperienceData implements Serializable {
    @Serial
    private static final long serialVersionUID = -6202896916145603976L;
    private long currentExperience = 0;
    private int currentLVL = 0;
    private long currentExperienceBorder = 10;


    private static final int MIN_LEVEL = 0;
    private static final int MAX_LEVEL = 100;


    public boolean increaseExperience(long amount) {
        if (amount <= 0) return false;
        currentExperience += amount;
        while (getCurrentExperienceBorder() <= currentExperience) {
            currentExperience -= getCurrentExperienceBorder();
            increaseLVL();
        }
        return true;
    }

    public boolean decreaseExperience(long amount) {
        if (amount <= 0) return false;
        while (currentExperience - amount < 0) {
            decreaseLVL();
            amount -= currentExperienceBorder;
        }
        currentExperience -= amount;
        return true;
    }

    private void decreaseLVL() {
        if (currentLVL == MIN_LEVEL) return;
        currentLVL--;
        generateLastBorder();
    }

    private void increaseLVL() {
        if (currentLVL == MAX_LEVEL) return;
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
        currentExperienceBorder *= 1.5;
    }

    private void generateLastBorder() {
        currentExperienceBorder /= 1.5;
    }


}
