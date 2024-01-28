package com.falgael.rpg.proficiency.experience;

import com.falgael.rpg.manager.interfaces.ProficiencyExperienceManagement;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.entity.Player;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

public class ExperienceDataHolder implements Serializable, ProficiencyExperienceManagement {

    @Serial
    private static final long serialVersionUID = -2599572836858157444L;
    private final String publicName;

    private HashMap<Proficiency, ExperienceData> experienceData = new HashMap<>();

    public ExperienceDataHolder(Player player) {
        this.publicName = player.getDisplayName();
        for (Proficiency proficiency : Proficiency.values()) {
            experienceData.put(proficiency, new ExperienceData(player.getUniqueId(), proficiency));
        }
    }

    @Override
    public void increaseExperience(Proficiency proficiency, long value) {
        experienceData.get(proficiency).increaseExperience(value);
    }

    @Override
    public void decreaseExperience(Proficiency proficiency, long value) {
        experienceData.get(proficiency).decreaseExperience(value);
    }

    @Override
    public void increaseLevel(Proficiency proficiency, int value) {
        experienceData.get(proficiency).increaseLevel(value);
    }

    @Override
    public void decreaseLevel(Proficiency proficiency, int value) {
        experienceData.get(proficiency).decreaseLevel(value);
    }

    @Override
    public int getLevel(Proficiency proficiency) {
        return experienceData.get(proficiency).getLevel();
    }

    @Override
    public long getExperience(Proficiency proficiency) {
        return experienceData.get(proficiency).getExperience();
    }

    @Override
    public long getExperienceBorder(Proficiency proficiency) {
        return experienceData.get(proficiency).getBorder();
    }

    @Override
    public String getPublicPlayerName() {
        return publicName;
    }
}
