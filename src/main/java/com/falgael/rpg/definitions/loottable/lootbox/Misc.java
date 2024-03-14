package com.falgael.rpg.definitions.loottable.lootbox;

import com.falgael.rpg.definitions.loottable.MainLootTableDefinition;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootTable;
import com.falgael.rpg.loottable.LootTableManager;
import com.falgael.rpg.loottable.LootTableRow;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Misc extends MainLootTableDefinition {
    public Misc(ItemManagement itemManager) {
        super(itemManager);
    }

    /**
     * @return Material or Entity
     */
    @Override
    public Object getObject() {
        return Material.HEART_OF_THE_SEA;
    }

    @Override
    public LootTableManager.Reason getReason() {
        return LootTableManager.Reason.LOOT_BOX;
    }

    @Override
    public LootTable getLootTable() {
        return new LootTable(
                new LootTableRow(Proficiency.MISC, 0, 40, 1,
                        new LootTableRow.WeightedPair(1,
                                new LootTableRow.Result(new ItemStack(Material.STONE),
                                        1, false)
                        )
                )
        );
    }
}
