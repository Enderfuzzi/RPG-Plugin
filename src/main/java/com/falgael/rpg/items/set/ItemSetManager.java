package com.falgael.rpg.items.set;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import com.falgael.rpg.woodwork.sets.BasicSets;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ItemSetManager implements ItemSetManagement{
    private static final DefaultItemSet DEFAULT = new ItemSet(
            0,
            "None",
            Proficiency.NONE,
            Rarity.NONE,
            0,
            new ItemConfiguration.Builder().create()
    ) {
        @Override
        public boolean isDefault() {
            return true;
        }
    };

    private HashMap<String, DefaultItemSet> itemSets;

    private List<ItemSetDefinition> registeredClasses;


    public ItemSetManager() {
        itemSets = new HashMap<>();
        registeredClasses = new ArrayList<>();
        registeredClasses();
        init();
    }

    private void registeredClasses() {
        registerItemClass(new BasicSets());
    }

    private void init() {
        registeredClasses.forEach(c -> c.getItemSets().forEach(i -> {
            itemSets.put(i.getKey(), i);
            Bukkit.getLogger().info("Registered ItemSet with name: " + i.getName() + " and id: " + i.getId());
        }));
    }

    private void registerItemClass(ItemSetDefinition itemSetDefinition) {
        registeredClasses.add(itemSetDefinition);
    }

    @Override
    public DefaultItemSet getItemSetbyID(int id) {
        for (DefaultItemSet itemSet : itemSets.values()) {
            if (itemSet.getId() == id) return itemSet;
        }
        return DEFAULT;
    }

    @Override
    public DefaultItemSet getItemSet(String key) {
        return itemSets.getOrDefault(key, DEFAULT);
    }

    @Override
    public DefaultItemSet getItemSetByName(String name) {
        return getItemSet(ChatColor.stripColor(name).toLowerCase().replace(" ", "_"));
    }


    @Override
    public Set<String> getRegisteredKeys() {
        return itemSets.keySet();
    }
}
