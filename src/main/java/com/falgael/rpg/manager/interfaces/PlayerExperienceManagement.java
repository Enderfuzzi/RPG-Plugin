package com.falgael.rpg.manager.interfaces;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface PlayerExperienceManagement {

    void increaseExperience(UUID player, Proficiency proficiency, long value);
    default void increaseExperience(@NotNull Player player, Proficiency proficiency, long value) {
        increaseExperience(player.getUniqueId(), proficiency, value);
    }
    void decreaseExperience(UUID player, Proficiency proficiency, long value);
    default void decreaseExperience(@NotNull Player player, Proficiency proficiency, long value) {
        decreaseExperience(player.getUniqueId(), proficiency, value);
    }
    void increaseLevel(UUID player, Proficiency proficiency, int value);
    default void increaseLevel(@NotNull Player player, Proficiency proficiency, int value) {
        increaseLevel(player.getUniqueId(), proficiency, value);
    }
    void decreaseLevel(UUID player, Proficiency proficiency, int value);
    default void decreaseLevel(@NotNull Player player, Proficiency proficiency, int value) {
        decreaseLevel(player.getUniqueId(), proficiency, value);
    }
    int getLevel(UUID player, Proficiency proficiency);
    default int getLevel(@NotNull Player player, Proficiency proficiency) {
        return getLevel(player.getUniqueId(), proficiency);
    }
    long getExperience(UUID player, Proficiency proficiency);
    default long getExperience(@NotNull Player player, Proficiency proficiency) {
        return getExperience(player.getUniqueId(), proficiency);
    }
    long getExperienceBorder(UUID player, Proficiency proficiency);
    default long getExperienceBorder(@NotNull Player player, Proficiency proficiency) {
        return getExperienceBorder(player.getUniqueId(), proficiency);
    }

    boolean checkUUID(UUID player);

    default boolean checkUUID(Player player) {
        return checkUUID(player.getUniqueId());
    }


}
