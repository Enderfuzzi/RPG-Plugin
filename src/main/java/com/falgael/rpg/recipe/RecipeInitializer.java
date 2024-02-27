package com.falgael.rpg.recipe;

import com.falgael.rpg.definitions.stonework.recipe.Concrete;
import com.falgael.rpg.definitions.woodwork.recipe.Hopper;
import com.falgael.rpg.definitions.woodwork.recipe.Oak;
import org.bukkit.plugin.Plugin;



public class RecipeInitializer {

    public RecipeInitializer(Plugin plugin) {
        new Oak(plugin);
        new Hopper(plugin);
        new Concrete(plugin);


    }



}
