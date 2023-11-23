package com.falgael.rpg.villager;

import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.ItemManagement;

public abstract class MainVillagerDefinition implements VillagerDefinition {

    private final ItemManagement itemManager;

    protected MainVillagerDefinition(ItemManagement itemManager) {
        this.itemManager = itemManager;
    }


}
