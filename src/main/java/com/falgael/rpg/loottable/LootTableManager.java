package com.falgael.rpg.loottable;

import com.falgael.rpg.definitions.loottable.material.Stone;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.set.ItemSetManagement;
import org.bukkit.Bukkit;

import java.util.HashMap;

public class LootTableManager {

    private final static LootTable DEFAULT = new LootTable();

    public enum Reason {
        BlockBreak,
        CraftingResult,
        Killed,
        Harvested
    }

    public record Key(Object object, Reason reason) {
    }

    private final HashMap<Key, LootTable> lootTables;

    public LootTableManager(ItemManagement itemManager) {
        lootTables = new HashMap<>();
        registeredClasses(itemManager);
    }

    public LootTable getLootTable(Key key) {
        return lootTables.getOrDefault(key, new LootTable());
    }

    private void registeredClasses(ItemManagement itemManager) {
        registerClass(new Stone(itemManager));
    }

    private void registerClass(LootTableDefinition definition) {
        if (definition.getReasons().isEmpty()) {
            lootTables.put(new Key(definition.getObject(), definition.getReason()), definition.getLootTable());
        } else {
            definition.getReasons().forEach(e -> {
                lootTables.put(new Key(definition.getObject(), e), definition.getLootTable());
            });
        }
        Bukkit.getLogger().info("Registered Special Loot table for Object:  " + definition.getObject());
    }
}
