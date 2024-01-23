package com.falgael.rpg.proficiency;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public enum Proficiency {

    NONE("") {
        @Override
        public boolean levelCheck() {
            return false;
        }
    },

    MISC("Misc") {
        @Override
        public boolean levelCheck() {
            return false;
        }
    },

    WOODWORK("Woodwork"),

    STONEWORK("Stonework"),

    FARMING("Farming"),

    HUNTING("Hunting");

    private final String representation;

    Proficiency(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return getRepresentationWithoutReset() + ChatColor.RESET;
    }

    public String getRepresentationWithoutReset() {
        return ChatColor.YELLOW + representation;
    }

    public String getName() {
        return representation;
    }

    public static Proficiency isProficiency(String key) {
        for (Proficiency proficiency : Proficiency.values()) {
            if (proficiency.representation.equals(key)) return proficiency;
        }
        return NONE;
    }

    public static List<String> proficiencies() {
        List<String> result = new ArrayList<>();
        for (Proficiency type : Proficiency.values()) {
            result.add(type.getName());
        }
        return result;
    }

    public boolean levelCheck() {
        return true;
    }

    public static List<Proficiency> translate(List<String> list) {
        List<Proficiency> result = new ArrayList<>();
        list.forEach(e -> result.add(Proficiency.valueOf(e)));
        return result;
    }

}
