package com.falgael.rpg.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

import java.util.*;

public abstract class CustomRecipes {
    // Note Loading these Recipes is placed in initializer


    private Plugin plugin;


    public CustomRecipes(Plugin plugin) {
        this.plugin = plugin;
        getRecipes().forEach(r -> {
            Bukkit.addRecipe(r);
            if (r instanceof Keyed k) Bukkit.getLogger().info("Registered Recipe: " + k.getKey());
        });
    }

    protected NamespacedKey namespacedKey(String key) {
        return new NamespacedKey(plugin, key);
    }

    protected abstract List<Recipe> getRecipes();
}