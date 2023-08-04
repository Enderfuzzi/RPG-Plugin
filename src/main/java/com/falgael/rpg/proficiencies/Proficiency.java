package com.falgael.rpg.proficiencies;

import com.falgael.rpg.utility.Pair;

public enum Proficiency {

    NONE(""),

    MISC(""),

    WOODWORK("Woodwork"),

    STONEWORK("Stonework");


    private final String representation;

    Proficiency(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

}
