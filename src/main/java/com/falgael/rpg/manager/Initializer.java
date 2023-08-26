package com.falgael.rpg.manager;

import com.falgael.rpg.proficiency.CustomRecipe;
import com.falgael.rpg.proficiency.handler.ItemHeldHandler;
import org.bukkit.Bukkit;

/**
 * Holds all initializer and calls them.
 * @author falgael
 * @version 0.0.1
 */
public class Initializer {

    /** Calls each registered initializer. This Function can only be called once*/
    public static void initialize() {
        DataStoreManagement.initialize();
        ItemHeldHandler.startCheck();

        loadRecipes();
    }


    private static void loadRecipes() {
        for (CustomRecipe customRecipe : CustomRecipe.values()) {
            Bukkit.addRecipe(customRecipe.getRecipe());
        }
    }



}
