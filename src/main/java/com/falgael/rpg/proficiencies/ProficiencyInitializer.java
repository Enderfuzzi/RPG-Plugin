package com.falgael.rpg.proficiencies;

import com.falgael.rpg.proficiencies.data.woodwork.Woodwork;
import com.falgael.rpg.proficiencies.templates.ProficiencyFramework;
import org.bukkit.Bukkit;

/**
 * Class for handling the initialization of all Proficiencies. This can work as Singleton later.
 * @author falgael
 * @version 0.0.1
 */
public class ProficiencyInitializer {

    /** Indicates if the initialized method has been called already */
    private static boolean initialized = false;

    /** Stores the singleton for Woodwork */
    private static final ProficiencyFramework WOOD_WORK = new Woodwork();



    /**
     * The initialized function to call by {@link com.falgael.rpg.manager.Initializer}. Can't be called more than once.
     */
    public static final void initialize() {
        if (initialized) {
            Bukkit.getLogger().warning("[" + ProficiencyInitializer.class.getSimpleName() + "]: try to initialized more than once");
            return;
        }
        WOOD_WORK.initialize();

        initialized = true;
    }

}
