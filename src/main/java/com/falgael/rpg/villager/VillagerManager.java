package com.falgael.rpg.villager;

import com.falgael.rpg.items.ItemManagement;
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
        registerClass(new com.falgael.rpg.woodwork.Villager(itemManager));
    }

    private void init() {
        registeredClasses.forEach(c -> c.getVillager().forEach(e -> villagers.put(e.getKey(),e)));
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
