package com.falgael.rpg.quests;

public enum RequirementType {


    PROFICIENCY_EXPERIENCE("Deny_Message_1"),
    PLAYER_EXPERIENCE("Deny_Message_2"),
    ARMOR("Deny_Message_3");

    private final String deny_message;

    RequirementType(String deny_message) {
        this.deny_message = deny_message;
    }

    public String getDeny_message() {
        return deny_message;
    }
}
