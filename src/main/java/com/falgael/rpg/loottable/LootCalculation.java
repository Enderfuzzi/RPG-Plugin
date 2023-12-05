package com.falgael.rpg.loottable;

import com.falgael.rpg.manager.ProficiencyExperienceCalculation;
import com.falgael.rpg.stats.*;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


public class LootCalculation {

    private final ProficiencyExperienceCalculation proficiencyCalculator;

    private final LootTableManager lootTableManager;

    public LootCalculation(ProficiencyExperienceCalculation proficiencyCalculator, LootTableManager lootTableManager) {
        this.proficiencyCalculator = proficiencyCalculator;
        this.lootTableManager = lootTableManager;
    }

    public void triggerEvent(Player player, Entity entity, LootTableManager.Reason reason) {
        computeExperience(player, entity, reason);
        lootTableManager.computeLootTable(player, entity, reason);
    }

    public void triggerEvent(Player player, Material material, LootTableManager.Reason reason) {
        computeExperience(player, material, reason);
        lootTableManager.computeLootTable(player, material, reason);
    }


    private void computeExperience(Player player, Material material, LootTableManager.Reason reason) {
        switch (reason) {
            case BlockBreak -> computeStats(player, BlockStats.getBlock(material));
            case Harvested -> computeStats(player, BlockHarvestStats.getBlock(material));
            case CraftingResult -> computeStats(player, CraftingResultStats.getResult(material));
        }
    }

    private void computeExperience(Player player, Entity entity, LootTableManager.Reason reason) {
        switch (reason) {
            case Killed -> computeStats(player, EntityStats.getEntity(entity));
        }
    }

    private void computeStats(Player player, Stats stats) {
        if (stats.isNone()) return;
        proficiencyCalculator.calculateExperience(player, stats.getProficiencies(), stats.getExperienceAmount());
    }


    private void computeItemLoot() {

    }

}
