package com.falgael.rpg.manager;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.ProficiencyInitializer;

public class Initializer {

    private static boolean initialized = false;

    public static void initialize() {
        if (initialized) return;
        DataStoreManagement.initialize();
        ProficiencyInitializer.initialize();
    }

}
