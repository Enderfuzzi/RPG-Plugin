package com.falgael.rpg.loottable;

import java.util.ArrayList;
import java.util.List;

public class LootTable {

    private final List<LootTableRow> rows;


    public LootTable(List<LootTableRow> rows) {
        this.rows = rows;
    }

    public LootTable(LootTableRow...rows) {
        this(List.of(rows));
    }


    public List<LootTableRow> selectLoot() {
        List<LootTableRow> result = new ArrayList<>();
        rows.forEach(e -> {
                if (e.getChance() >= Math.random()) result.add(e);
        });
        return result;
    }


}