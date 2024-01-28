package com.falgael.rpg.proficiency.experience;

import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.player.PlayerMessage;
import org.bukkit.Bukkit;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

public class ExperienceData implements Serializable, PlayerMessage {

    @Serial
    private static final long serialVersionUID = -8100268803539354307L;
    private long experience = 0L;
    private Level level = Level.ZERO;
    private final Proficiency proficiency;
    private final UUID player;

    ExperienceData(UUID player, Proficiency proficiency) {
        this.player = player;;
        this.proficiency = proficiency;
    }

    public long getExperience() {
        return experience;
    }

    public int getLevel() {
        return level.getRepresentation();
    }

    public long getBorder() {
        if (level.hasNext()) {
            return level.getNextLevel().getExperienceNeeded();
        }
        return 0;
    }


    public void increaseExperience(long amount) {
        if (amount == 0) return;
        if (amount < 0) amount = Math.abs(amount);
        experience += amount;
        while (level.hasNext() &&  level.getNextLevel().getExperienceNeeded() <= experience) {
            experience -= level.getNextLevel().getExperienceNeeded();
            increaseLevel();
        }
    }

    public void decreaseExperience(long amount) {
        if (amount == 0) return;
        if (amount < 0) amount = Math.abs(amount);
        while (experience - amount < 0) {
            decreaseLevel();
            if (!level.hasPrevious()) {
                experience = 0;
                return;
            }
            amount -= level.getPrevious().getExperienceNeeded();
        }
        experience -= amount;
    }

    public void decreaseLevel() {
        if (!level.hasPrevious()) return;
        level = level.getPrevious();
        levelChangeMessage(Bukkit.getPlayer(player),proficiency, level.getRepresentation());
    }

    public void decreaseLevel(int level) {
        level = Math.abs(level);
        for (int i = 0;i<level;i++) {
            decreaseLevel();
        }
    }

    public void increaseLevel() {
        if (!level.hasNext()) return;
        level = level.getNextLevel();
        levelChangeMessage(Bukkit.getPlayer(player),proficiency, level.getRepresentation());
    }

    public void increaseLevel(int level) {
        level = Math.abs(level);
        for (int i = 0;i<level;i++) {
            increaseLevel();
        }
    }


}
