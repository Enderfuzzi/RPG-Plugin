package com.falgael.rpg.quests;

import org.bukkit.entity.Player;

public class Requirement {

    private final RequirementType type;

    private final String proficiency;

    private int value = 0;

    public Requirement(RequirementType type, String proficiency) {
        this.type = type;
        this.proficiency = proficiency;
    }

    public Requirement(RequirementType type, String proficiency, int value) {
        this(type,proficiency);
        this.value = value;
    }

    public void setValue(int newValue) {
        value = Math.max(0, newValue);
    }

    public String getDenyMessage() {
        return type.getDenyMessage();
    }

    public boolean evaluate(Player player) {
        switch (type) {
            case PROFICIENCY_EXPERIENCE:
                //WIP
            case PLAYER_EXPERIENCE:
                return player.getLevel() >= value;
            case ARMOR:
                //WIP
                return false;
            default:
                return false;
        }
    }

}
