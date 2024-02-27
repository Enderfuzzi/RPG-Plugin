package com.falgael.rpg.definitions.loottable.material;

import com.falgael.rpg.definitions.loottable.MainLootTableDefinition;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootTable;
import com.falgael.rpg.loottable.LootTableManager;
import com.falgael.rpg.loottable.LootTableRow;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;

public class CoalOre extends MainLootTableDefinition {

    public CoalOre(ItemManagement itemManager) {
        super(itemManager);
    }

    /**
     * @return Material or Entity
     */
    @Override
    public Object getObject() {
        return Material.COAL_ORE;
    }

    @Override
    public LootTableManager.Reason getReason() {
        return LootTableManager.Reason.BlockBreak;
    }

    @Override
    public LootTable getLootTable() {
        return new LootTable(
                new LootTableRow(Proficiency.STONEWORK, 0, 15, 0.01,
                        new LootTableRow.WeightedPair(1,
                                new LootTableRow.Result(itemManager.getItemByID(20600).getItemStackRepresentation(),
                                        1, false)
                        )
                ),
                new LootTableRow(Proficiency.STONEWORK, 15, 35, 0.01,
                        new LootTableRow.WeightedPair(1,
                                new LootTableRow.Result(itemManager.getItemByID(20601).getItemStackRepresentation(),
                                        1, false)
                        )
                ),
                new LootTableRow(Proficiency.STONEWORK, 35, 50, 0.01,
                        new LootTableRow.WeightedPair(1,
                                new LootTableRow.Result(itemManager.getItemByID(20602).getItemStackRepresentation(),
                                        1, false)
                        )
                ),
                new LootTableRow(Proficiency.STONEWORK, 50, 100, 0.01,
                        new LootTableRow.WeightedPair(1,
                                new LootTableRow.Result(itemManager.getItemByID(20603).getItemStackRepresentation(),
                                        1, false)
                        )
                )
        );
    }
}
