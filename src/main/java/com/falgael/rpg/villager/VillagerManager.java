package com.falgael.rpg.villager;

import org.bukkit.entity.Villager;

import java.util.ArrayList;
import java.util.List;

public class VillagerManager implements VillagerManagement {

    private static final VillagerInstance DEFAULT = new VillagerInstance.VillagerBuilder("None", Villager.Profession.NONE).create();

    private List<VillagerInstance> villagers;

    private List<VillagerDefinition> registeredClasses;

    public VillagerManager() {
        villagers = new ArrayList<>();
        registeredClasses = new ArrayList<>();
        registeredClasses();
        init();
    }


    private void registeredClasses() {
        registerClass(new com.falgael.rpg.woodwork.Villager());
    }

    private void init() {
        registeredClasses.forEach(c -> c.getVillager().forEach(e -> villagers.add(e)));
    }

    private void registerClass(VillagerDefinition villagerDefinition) {
        registeredClasses.add(villagerDefinition);
    }

    public VillagerInstance getVillager(Villager villager) {
        for (VillagerInstance current: villagers) {
            if (current.isSame(villager)) return current;
        }
        return DEFAULT;
    }

    @Override
    public boolean isDefault(VillagerInstance instance) {
        return instance.equals(DEFAULT);
    }


}
