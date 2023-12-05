package com.falgael.rpg.loottable;

import com.falgael.rpg.manager.ProficiencyExperienceCalculation;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LootTableManager{

    private final static LootTable DEFAULT = new LootTable();

    public enum Reason {
        BlockBreak,
        CraftingResult,
        Killed,
        Harvested
    }

    public record EntityKey(Entity entity, Reason reason) {}

    public record MaterialKey(Material material, Reason reason) {}

    public record LootTable(List<LootTableEntry> entries) {
        public LootTable(LootTableEntry... entries) {
            this(Arrays.stream(entries).toList());
        }
    }



    private HashMap<EntityKey, LootTable> entityLootTable;

    private HashMap<MaterialKey, LootTable> materialLootTable;

    public LootTableManager(ProficiencyExperienceCalculation proficiencyCalculator) {

        //TODO add initializing the lists of LootTables
    }


    public List<LootTableEntry> computeLootTable(Player player, Entity entity, Reason reason) {
        // TODO Calculate valid entries for the table
        return null;
    }

    public List<LootTableEntry> computeLootTable(Player player, Material material, Reason reason) {
        // TODO Calculate valid entries for the table
        return null;
    }

    private List<LootTableEntry> getLootTable(Entity entity, Reason reason) {
        return entityLootTable.getOrDefault(new EntityKey(entity, reason), DEFAULT).entries();
    }

    private List<LootTableEntry> getLootTable(Material material, Reason reason) {
        return materialLootTable.getOrDefault(new MaterialKey(material, reason), DEFAULT).entries();
    }




}
