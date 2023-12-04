package com.falgael.rpg.loottable;

import com.falgael.rpg.proficiency.Proficiency;

import java.util.List;

public class LootTableEntry {

    public record Result<T>(T value, int amount) {}

    private final Result result;
    private final List<Proficiency> proficiencies;
    private final double dropRate;


    public LootTableEntry(
            Object result,
            int amount,
            double dropRate,
            List<Proficiency> proficiencies
    ) {
        this.result = new Result<>(result, amount);
        this.dropRate = dropRate;
        this.proficiencies = proficiencies;
    }

    public LootTableEntry(
            Object result,
            int amount,
            double dropRate,
            Proficiency proficiency
    ) {
        this(result, amount, dropRate, List.of(proficiency));
    }

    public Result getResult() {
        return result;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
    }

    public boolean hasProficiency(Proficiency proficiency) {
        return proficiency == Proficiency.MISC
                || proficiency == Proficiency.NONE
                || hasExactProficiency(proficiency);
    }

    public boolean hasExactProficiency(Proficiency proficiency) {
        return proficiencies.contains(proficiency);
    }

    public double getDropRate() {
        return dropRate;
    }
}