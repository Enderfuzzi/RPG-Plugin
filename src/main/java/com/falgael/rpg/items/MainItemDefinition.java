package com.falgael.rpg.items;

import com.falgael.rpg.items.set.ItemSetManagement;

public abstract class MainItemDefinition implements ItemDefinition {

    protected final ItemSetManagement itemSetManager;

    protected MainItemDefinition(ItemSetManagement itemSetManager) {
        this.itemSetManager = itemSetManager;
    }

}
