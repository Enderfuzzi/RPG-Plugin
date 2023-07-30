package com.falgael.rpg.quests;

import com.falgael.rpg.proficiencies.ProficiencyManager;
import com.falgael.rpg.proficiencies.templates.ProficiencyFramework;
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
                if (proficiency == null) return false;
                ProficiencyFramework proficiencyFramework = ProficiencyManager.getProficiencyData(player.getUniqueId()).getProficiency(proficiency);
                if (proficiencyFramework == null) return false;
                return proficiencyFramework.getCurrentLVL() >= value;
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
