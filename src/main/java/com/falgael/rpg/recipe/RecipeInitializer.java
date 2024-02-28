package com.falgael.rpg.recipe;

import com.falgael.rpg.definitions.stonework.recipe.Concrete;
import com.falgael.rpg.definitions.woodwork.recipe.*;
import org.bukkit.plugin.Plugin;



public class RecipeInitializer {

    public RecipeInitializer(Plugin plugin) {

        new Concrete(plugin);

        //Woodwork
        new Acacia(plugin);
        new Bamboo(plugin);
        new Birch(plugin);
        new Cherry(plugin);
        new Crimson(plugin);
        new DarkOak(plugin);
        new Hopper(plugin);
        new Jungle(plugin);
        new Mangrove(plugin);
        new Oak(plugin);
        new Spruce(plugin);
        new Warped(plugin);
    }



}
