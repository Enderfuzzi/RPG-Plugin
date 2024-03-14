package com.falgael.rpg.loottable;

import com.falgael.rpg.definitions.loottable.lootbox.Misc;
import com.falgael.rpg.definitions.loottable.material.CoalOre;
import com.falgael.rpg.items.ItemManagement;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class LootTableManager {

    private final static LootTable DEFAULT = new LootTable();

    public enum Reason {
        BLOCK_BREAK,
        CRAFTING_RESULT,
        KILLED,
        HARVESTED,
        LOOT_BOX
    }

    public record Key(Object object, Reason reason) {}

    private final HashMap<Key, LootTable> lootTables;

    public LootTableManager(ItemManagement itemManager) {
        lootTables = new HashMap<>();
        registeredClasses(itemManager);
    }

    public LootTable getLootTable(Key key) {
        return lootTables.getOrDefault(key, new LootTable());
    }

    private void registeredClasses(ItemManagement itemManager) {
        registerClass(new CoalOre(itemManager));

        registerClass(new Misc(itemManager));
    }

    private void registerClass(LootTableDefinition definition) {
        if (definition.getReasons().isEmpty()) {
            lootTables.put(new Key(definition.getObject(), definition.getReason()), definition.getLootTable());
        } else {
            definition.getReasons().forEach(e -> lootTables.put(new Key(definition.getObject(), e), definition.getLootTable()));
        }
        Bukkit.getLogger().info("Registered Special Loot table for Object: " + definition.getObject());
    }
}
