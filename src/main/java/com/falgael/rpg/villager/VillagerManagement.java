package com.falgael.rpg.villager;

import org.bukkit.entity.Villager;

import java.util.Collection;
import java.util.Set;

public interface VillagerManagement {

    VillagerInstance getVillager(Villager villager);

    VillagerInstance getVillager(String key);

    boolean isDefault(VillagerInstance instance);

    Set<String> getRegisteredKeys();
}
