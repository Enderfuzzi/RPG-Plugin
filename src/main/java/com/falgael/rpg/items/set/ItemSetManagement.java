package com.falgael.rpg.items.set;

import com.falgael.rpg.villager.VillagerInstance;
import org.bukkit.entity.Villager;

import java.util.Set;

public interface ItemSetManagement {

    Set getItemSet(String key);

    boolean isDefault(Set itemSet);

    Set<String> getRegisteredKeys();

}
