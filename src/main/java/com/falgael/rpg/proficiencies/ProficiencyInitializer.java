package com.falgael.rpg.proficiencies;

import com.falgael.rpg.proficiencies.data.woodwork.Woodwork;
import com.falgael.rpg.proficiencies.template.ProficiencyFramework;

public class ProficiencyInitializer {

    private static boolean initialized = false;

    private static final ProficiencyFramework WOOD_WORK = new Woodwork();




    public static final void initialize() {
        if (initialized) return;
        WOOD_WORK.initialize();

        initialized = true;
    }

}
