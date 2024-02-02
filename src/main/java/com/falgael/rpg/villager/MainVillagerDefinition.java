package com.falgael.rpg.villager;

import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.ItemStackManipulation;

public abstract class MainVillagerDefinition implements VillagerDefinition, ItemStackManipulation {

    protected final ItemManagement itemManager;

    protected MainVillagerDefinition(ItemManagement itemManager) {
        this.itemManager = itemManager;
    }


}
