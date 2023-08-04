package com.falgael.rpg.manager;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.ProficiencyInitializer;
import com.falgael.rpg.utility.recipe.RecipeManager;
import org.bukkit.Bukkit;

/**
 * Holds all initializer and calls them.
 * @author falgael
 * @version 0.0.1
 */
public class Initializer {
    /** indicates if initialized was already used */
    private static boolean initialized = false;

    /** Calls each registered initializer. This Function can only be called once*/
    public static void initialize() {
        if (initialized) {
            Bukkit.getLogger().warning("[" + Initializer.class.getSimpleName() + "]: try to call the initialization more than once");
            return;
        }
        DataStoreManagement.initialize();
        ProficiencyInitializer.initialize();
        RecipeManager.initialize();
    }

}
