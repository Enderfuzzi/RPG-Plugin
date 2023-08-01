package com.falgael.rpg.villager;

import java.util.HashMap;

public class VillagerManager {

    private static HashMap<String, Villager> villagers = new HashMap<String, Villager>();

    public static void registerVillager(String key, Villager villager) {
        villagers.put(key,villager);
    }

    public static Villager getVillager(String key) {
        return villagers.get(key);
    }
}
