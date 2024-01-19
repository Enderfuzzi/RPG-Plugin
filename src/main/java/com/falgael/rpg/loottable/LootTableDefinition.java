package com.falgael.rpg.loottable;

import java.util.ArrayList;
import java.util.List;

public interface LootTableDefinition {

    /**
     * @return Material or Entity
     */
    Object getObject();

    LootTableManager.Reason getReason();

    default List<LootTableManager.Reason> getReasons() {
        return new ArrayList<>();
    }

    LootTable getLootTable();
}
