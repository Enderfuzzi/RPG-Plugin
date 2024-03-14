package com.falgael.rpg.definitions.loottable.lootbox;

import com.falgael.rpg.definitions.loottable.MainLootTableDefinition;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootTable;
import com.falgael.rpg.loottable.LootTableManager;
import org.bukkit.Material;

public class Woodwork extends MainLootTableDefinition {
    public Woodwork(ItemManagement itemManager) {
        super(itemManager);
    }

    /**
     * @return Material or Entity
     */
    @Override
    public Object getObject() {
        return Material.STICK;
    }

    @Override
    public LootTableManager.Reason getReason() {
        return LootTableManager.Reason.LOOT_BOX;
    }

    @Override
    public LootTable getLootTable() {
        return new LootTable();
    }
}
