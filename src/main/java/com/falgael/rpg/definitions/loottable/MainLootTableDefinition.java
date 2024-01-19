package com.falgael.rpg.definitions.loottable;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootTableDefinition;

public abstract class MainLootTableDefinition implements LootTableDefinition {

    protected final ItemManagement itemManager;

    protected MainLootTableDefinition(ItemManagement itemManager) {
            this.itemManager = itemManager;
    }

}
