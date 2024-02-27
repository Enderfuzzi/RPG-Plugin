package com.falgael.rpg.loottable;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Loot table which consists out of a list of table rows. {@link LootTableRow}
 */
public class LootTable {

    /**
     * List of the table rows
     */
    private final List<LootTableRow> rows;


    public LootTable(List<LootTableRow> rows) {
        this.rows = rows;
    }

    public LootTable(LootTableRow...rows) {
        this(List.of(rows));
    }

    /**
     * Selects any number of rows based on their chance to be selected.
     * @return A List of selected table rows as list
     */
    public List<LootTableRow> selectLoot() {
        List<LootTableRow> result = new ArrayList<>();
        rows.forEach(e -> {
                if (e.getChance() >= Math.random()) result.add(e);
        });
        return result;
    }


}