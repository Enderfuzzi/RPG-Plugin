package com.falgael.rpg.loottable;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a single loot table row with entries
 */
public class LootTableRow {

    /**
     * A Result of a loot table entry.
     * @param value The item stack as a result
     * @param amount The amount of items dropped by default
     * @param modifiableAmount defines if the amount of items can be modified or not
     */
    public record Result(ItemStack value, int amount, boolean modifiableAmount) {
        public Result(ItemStack value, int amount, boolean modifiableAmount) {
            this.value = value;
            this.amount = Math.max(0,amount);
            this.modifiableAmount = modifiableAmount;
        }

    }

    /**
     * A loot entry pair which consists of a weight larger than 0 and a result {@link Result}
     * @param weight The weight of this entry
     * @param result The result if this entry is chosen
     */
    public record WeightedPair(double weight, Result result) {
        public WeightedPair(double weight, Result result) {
            this.weight = Math.max(0,weight);
            this.result = result;
        }
    }

    /**
     * A pair which consists of a lower and a higher border. The lower border is the lower value of both values. The upper
     * border is the upper value of both values.
     * @param lowerRange the lower Border
     * @param upperRange the upper Border
     */
    private record RangePair(double lowerRange, double upperRange) {
        RangePair(double lowerRange, double upperRange) {
            this.lowerRange = Math.min(lowerRange, upperRange);
            this.upperRange = Math.max(lowerRange, upperRange);
        }
    }

    private final Proficiency proficiency;
    private final double chance;
    /**
     * List of entries concerning this row with an assigned range
     */
    private final HashMap<RangePair, Result> rowEntries;

    /**
     * The total weight of each entry
     */
    private double totalWeight = 0;
    /**
     * The upper level requirement for this row
     */
    private final int upperLevel;
    /**
     * The lower level requirement for this row
     */
    private final int lowerLevel;

    /**
     * Creates a single Loot row with a percentage to be selected.
     * @param proficiency The Proficiency concerning the row
     * @param lowerLevel The lower level requirement inclusive
     * @param upperLevel The upper level requirement exclusive
     * @param chance The chance of this row to be selected between 0 and 1
     * @param rowEntries The list of all loot entries for this row {@link WeightedPair}
     */
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

    /**
     * Creates a single Loot row with a percentage to be selected.
     * @param proficiency The Proficiency concerning the row
     * @param lowerLevel The lower level requirement inclusive
     * @param upperLevel The upper level requirement exclusive
     * @param chance The chance of this row to be selected between 0 and 1
     * @param rowEntries The loot entries for this row {@link WeightedPair}
     */
    public LootTableRow(
            Proficiency proficiency, int lowerLevel, int upperLevel,
            double chance, WeightedPair... rowEntries) {
        this(proficiency, lowerLevel, upperLevel, chance, Arrays.asList(rowEntries));
    }

    /**
     * Calculates the result of this loot row.
     * @return the calculated result or a result with air if no result is available
     */
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
