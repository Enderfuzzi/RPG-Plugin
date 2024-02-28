package com.falgael.rpg.villager;

import com.falgael.rpg.items.ItemManagement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Villager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class VillagerManager implements VillagerManagement {

    private static final VillagerInstance DEFAULT = new VillagerInstance.VillagerBuilder("None", Villager.Profession.NONE).create();

    private HashMap<String,VillagerInstance> villagers;

    private List<VillagerDefinition> registeredClasses;

    public VillagerManager(ItemManagement itemManager) {
        villagers = new HashMap<>();
        registeredClasses = new ArrayList<>();
        registeredClasses(itemManager);
        init();
    }


    private void registeredClasses(ItemManagement itemManager) {
        //misc
        registerClass(new com.falgael.rpg.definitions.misc.Villager(itemManager));
        //woodwork
        registerClass(new com.falgael.rpg.definitions.woodwork.Villager(itemManager));
        //stonework
        registerClass(new com.falgael.rpg.definitions.stonework.Villager(itemManager));
        //farming
        registerClass(new com.falgael.rpg.definitions.farming.Villager(itemManager));
        //hunting
        registerClass(new com.falgael.rpg.definitions.hunting.Villager(itemManager));
    }

    private void init() {
        registeredClasses.forEach(c -> c.getVillager().forEach(e -> {
            if (villagers.containsKey(e.getKey())) {
                Bukkit.getLogger().warning("Duplicated Villager Key detected: " + e.getKey());
                Bukkit.getLogger().warning("Ignoring second villager with this key");
            } else {
                villagers.put(e.getKey(), e);
                Bukkit.getLogger().info("Registered Villager: " + e.getKey());
            }
        }));
    }

    private void registerClass(VillagerDefinition villagerDefinition) {
        registeredClasses.add(villagerDefinition);
    }

    public VillagerInstance getVillager(Villager villager) {
        for (VillagerInstance current: villagers.values()) {
            if (current.isSame(villager)) return current;
        }
        return DEFAULT;
    }

    @Override
    public VillagerInstance getVillager(String key) {
        return villagers.getOrDefault(key, DEFAULT);
    }

    @Override
    public boolean isDefault(VillagerInstance instance) {
        return instance.equals(DEFAULT);
    }

    @Override
    public Set<String> getRegisteredKeys() {
        return villagers.keySet();
    }


}
