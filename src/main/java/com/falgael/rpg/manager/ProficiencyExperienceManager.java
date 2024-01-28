package com.falgael.rpg.manager;

import com.falgael.rpg.manager.interfaces.ProficiencyExperienceManagement;
import com.falgael.rpg.proficiency.Proficiency;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
@Deprecated
public class ProficiencyExperienceManager implements ProficiencyExperienceManagement, Serializable {
    @Serial
    private static final long serialVersionUID = 5319044698716544152L;

    private final String publicName;

    private HashMap<Proficiency, ExperienceData> proficiencyData = new HashMap<>();

    public ProficiencyExperienceManager(String publicName) {
        this.publicName = publicName;
        for (Proficiency p : Proficiency.values()) {
            proficiencyData.put(p, new ExperienceData());
        }
    }

    public void increaseExperience(Proficiency proficiency, long amount) {
        proficiencyData.get(proficiency).increaseExperience(amount);
    }

    public void decreaseExperience(Proficiency proficiency, long amount) {
        proficiencyData.get(proficiency).decreaseExperience(amount);
    }

    @Override
    public void increaseLevel(Proficiency proficiency, int value) {
        if (value < 0) value = Math.abs(value);
        for (int i = 0; i < value;i++) {
            proficiencyData.get(proficiency).increaseLevel();
        }
    }

    @Override
    public void decreaseLevel(Proficiency proficiency, int value) {
        if (value < 0) value = Math.abs(value);
        for (int i = 0; i < value;i++) {
            proficiencyData.get(proficiency).decreaseLevel();
        }
    }

    @Override
    public int getLevel(Proficiency proficiency) {
        return proficiencyData.get(proficiency).getLevel();
    }

    public long getExperience(Proficiency proficiency) {
        return proficiencyData.get(proficiency).getExperience();
    }

    @Override
    public long getExperienceBorder(Proficiency proficiency) {
        return proficiencyData.get(proficiency).getExperienceBorder();
    }

    @Override
    public String getPublicPlayerName() {
        return publicName;
    }

    @Deprecated
    public String getPublicName() {
        return publicName;
    }
}
@Deprecated
class ExperienceData implements Serializable {
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
        while (getExperienceBorder() <= currentExperience) {
            currentExperience -= getExperienceBorder();
            increaseLevel();
        }
        return true;
    }

    public boolean decreaseExperience(long amount) {
        if (amount <= 0) return false;
        while (currentExperience - amount < 0) {
            decreaseLevel();
            amount -= currentExperienceBorder;
        }
        currentExperience -= amount;
        return true;
    }

    public void decreaseLevel() {
        if (currentLVL == MIN_LEVEL) return;
        currentLVL--;
        generateLastBorder();
    }

    public void increaseLevel() {
        if (currentLVL == MAX_LEVEL) return;
        currentLVL++;
        generateNextBorder();
    }

    public long getExperienceBorder() {
        return currentExperienceBorder;
    }

    public long getExperience() {
        return currentExperience;
    }

    public int getLevel() {
        return currentLVL;
    }

    private void generateNextBorder() {
        currentExperienceBorder *= 1.5;
    }

    private void generateLastBorder() {
        currentExperienceBorder /= 1.5;
    }


}
