package com.falgael.rpg.definitions.loottable.material;

import com.falgael.rpg.definitions.loottable.MainLootTableDefinition;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootTable;
import com.falgael.rpg.loottable.LootTableManager;
import com.falgael.rpg.loottable.LootTableRow;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;

public class Stone extends MainLootTableDefinition {

    public Stone(ItemManagement itemManager) {
        super(itemManager);
    }

    /**
     * @return Material or Entity
     */
    @Override
    public Object getObject() {
        return Material.STONE;
    }

    @Override
    public LootTableManager.Reason getReason() {
        return LootTableManager.Reason.BlockBreak;
    }

    @Override
    public LootTable getLootTable() {
        return new LootTable(
                new LootTableRow(Proficiency.STONEWORK, 0, 101, 1,
                        new LootTableRow.WeightedPair(1,
                                new LootTableRow.Result(itemManager.getItemByID(20600).getItemStackRepresentation(),
                                        1, false)
                        )
                )
        );
    }
}
