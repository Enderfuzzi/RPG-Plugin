package com.falgael.rpg.loottable;

import com.falgael.rpg.items.ItemDrop;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.manager.PlayerExperienceManagement;
import com.falgael.rpg.manager.ProficiencyExperienceCalculation;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.stats.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;


public class LootComputation implements ItemDrop, DropChanceTranslation {

    private final ProficiencyExperienceCalculation proficiencyCalculator;

    private final PlayerExperienceManagement playerExperienceManagement;

    private final LootTableManager lootTableManager;

    public LootComputation(
            ProficiencyExperienceCalculation proficiencyCalculator, LootTableManager lootTableManager,
            PlayerExperienceManagement playerExperienceManagement) {
        this.proficiencyCalculator = proficiencyCalculator;
        this.playerExperienceManagement = playerExperienceManagement;
        this.lootTableManager = lootTableManager;
    }

    public void triggerEvent(Player player, Object o, LootTableManager.Reason reason, Location location) {
        Bukkit.getLogger().info("Start Loot Computation");
        computeExperience(player, o, reason);
        computeItemLoot(player, location, o, reason);
        Bukkit.getLogger().info("End Loot Computation");
    }

    public void computeExperience(Player player, Object o, LootTableManager.Reason reason) {
        Stats stats = BlockStats.NONE;
        if (o instanceof Material material) {
            stats = switch (reason) {
                case BlockBreak -> BlockStats.getBlock(material);
                case Harvested ->  BlockHarvestStats.getBlock(material);
                case CraftingResult -> CraftingResultStats.getResult(material);
                default -> BlockStats.NONE;
            };
        }
        if (o instanceof Entity entity) {
            stats = switch (reason) {
                case Killed -> EntityStats.getEntity(entity);
                default -> EntityStats.NONE;
            };
        }
        if (stats.isNone()) return;
        proficiencyCalculator.calculateExperience(player, stats.getProficiencies(), stats.getExperienceAmount());
    }


    private int calculateLootModifier(Player player, Proficiency proficiency) {
        double lootValue = proficiencyCalculator.calculateMultiplier(player, proficiency, ConfigurationFlag.LOOT);
        Bukkit.getLogger().info("Loot value: " + lootValue);
        double value = lootValue - Math.floor(lootValue);
        if (value == 0) return (int) lootValue;
        if (Math.random() < value) return (int) Math.ceil(lootValue);
        return (int) Math.floor(lootValue);
    }

    private void computeItemLoot(Player player, Location location, Object o, LootTableManager.Reason reason) {
        LootTable lootTable = lootTableManager.getLootTable(new LootTableManager.Key(o, reason));
        List<LootTableRow> lootRow = lootTable.selectLoot();
        Bukkit.getLogger().info("Row Loot: " + lootRow);
        lootRow.forEach(e -> {
            Bukkit.getLogger().info("Level Requirement: " + e.checkLevelRequirement(playerExperienceManagement.getLevel(player, e.getProficiency())));
            if (e.checkLevelRequirement(playerExperienceManagement.getLevel(player, e.getProficiency()))) {
                Bukkit.getLogger().info("Calculated result: " + e.calculateRowResult());
                dropItemLoot(player, location, e.getProficiency(),
                        e.calculateRowResult());
            }
        });

    }

    private void dropItemLoot(Player player, Location location, Proficiency proficiency, LootTableRow.Result result) {
        int dropMultiplier = 1;
        if (result.modifiableAmount()) {
            dropMultiplier *= calculateLootModifier(player, proficiency);
        }
        dropItem(result.value(),result.amount() * dropMultiplier, player, location);
    }
}
