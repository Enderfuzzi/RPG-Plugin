package com.falgael.rpg.villager;

import org.bukkit.entity.Villager;

public interface VillagerManagement {

    VillagerInstance getVillager(Villager villager);

    boolean isDefault(VillagerInstance instance);
}
