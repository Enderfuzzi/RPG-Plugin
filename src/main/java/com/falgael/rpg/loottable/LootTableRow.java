package com.falgael.rpg.loottable;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LootTableRow {

    public record Result(ItemStack value, int amount, boolean modifiableAmount) {
        public Result(ItemStack value, int amount, boolean modifiableAmount) {
            this.value = value;
            this.amount = Math.max(0,amount);
            this.modifiableAmount = modifiableAmount;
        }

    }
    public record WeightedPair(double weight, Result result) {
        public WeightedPair(double weight, Result result) {
            this.weight = Math.max(0,weight);
            this.result = result;
        }
    }

    private record RangePair(Double lowerRange, Double upperRange) {}

    private final Proficiency proficiency;

    private final double chance;

    private final HashMap<RangePair, Result> rowEntries;

    private double totalWeight = 0;
    private final int upperLevel;
    private final int lowerLevel;

    public LootTableRow(
            Proficiency proficiency, int lowerLevel, int upperLevel,
            double chance, List<WeightedPair> rowEntries) {
        this.proficiency = proficiency;
        this.chance = chance;

        this.rowEntries = new HashMap<>();
        rowEntries.forEach(e -> {
            this.rowEntries.put(
                    new RangePair(totalWeight, totalWeight + e.weight),e.result);
            totalWeight += e.weight;
        });
        this.lowerLevel = Math.min(lowerLevel, upperLevel);
        this.upperLevel = Math.max(lowerLevel, upperLevel);
    }

    public LootTableRow(
            Proficiency proficiency, int lowerLevel, int upperLevel,
            double chance, WeightedPair... rowEntries) {
        this(proficiency, lowerLevel, upperLevel, chance, Arrays.asList(rowEntries));
    }

    public Result calculateRowResult() {
        double randomValue = Math.random() * totalWeight;
        for (Map.Entry<RangePair, Result> entry : rowEntries.entrySet()) {
            if (entry.getKey().lowerRange <= randomValue && entry.getKey().upperRange > randomValue) {
                return entry.getValue();
            }
        }
        return new Result(new ItemStack(Material.AIR),0, false);
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public double getChance() {
        return chance;
    }

    public boolean checkLevelRequirement(int playerLevel) {
        return playerLevel >= lowerLevel && playerLevel < upperLevel;
    }


    @Override
    public String toString() {
        return "[Proficiency=" + proficiency + ", Chance=" + chance + ", Entries=" + rowEntries + "]";
    }
}
