package com.falgael.rpg.loottable;

import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

    private final ProficiencyCalculationAdapter proficiencyCalculator;

    private HashMap<EntityKey, LootTable> entityLootTable;

    private HashMap<MaterialKey, LootTable> materialLootTable;

    public LootTableManager(ProficiencyCalculationAdapter proficiencyCalculator) {
        this.proficiencyCalculator = proficiencyCalculator;
        //TODO add initializing the lists of LootTables
    }

    public void triggerEvent(Player player, Entity entity, Reason reason) {
        computeLootTable(player, getLootTable(entity, reason));
    }

    public void triggerEvent(Player player, Material material, Reason reason) {
        computeLootTable(player, getLootTable(material, reason));
    }

    private void computeLootTable(Player player, List<LootTableEntry> entries) {
        for (LootTableEntry lootTable : entries) {
            if (lootTable.getResult().value() instanceof ConfigurationFlag flag) {
                if (flag != ConfigurationFlag.EXPERIENCE) continue;
                proficiencyCalculator.calculateExperience(player, lootTable.getProficiencies(), lootTable.getResult().amount());
            } else if (lootTable.getResult().value() instanceof ItemStack itemStack) {
                double chance = 0;
                for (Proficiency proficiency: lootTable.getProficiencies()) {
                    chance += lootTable.getDropRate() * proficiencyCalculator.calculateMultiplier(player, proficiency, ConfigurationFlag.LOOT);
                    //TODO update loot calculation
                    //TODO create new Loot Drop
                    /*
                     if (amount == 1) {
                        increase amount by loot factor
                    } else {
                        increase droprate by loot factor
                        calculate drops
                    }
                    drop loot
                     */
                }
            }
        }
    }

    private List<LootTableEntry> getLootTable(Entity entity, Reason reason) {
        return entityLootTable.getOrDefault(new EntityKey(entity, reason), DEFAULT).entries();
    }

    private List<LootTableEntry> getLootTable(Material material, Reason reason) {
        return materialLootTable.getOrDefault(new MaterialKey(material, reason), DEFAULT).entries();
    }




}
