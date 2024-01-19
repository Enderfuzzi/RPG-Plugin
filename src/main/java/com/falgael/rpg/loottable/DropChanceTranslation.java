package com.falgael.rpg.loottable;

public interface DropChanceTranslation {

    default int translateDropChance(double dropRate) {
        // 0.0001 = 0.0001 - 0
        if (dropRate <= 0) return 0;
        double value = dropRate - Math.floor(dropRate);
        if (value == 0) return (int) dropRate;
        // random has to be under 0.0001 to be rounded up
        if (Math.random() < value) return (int) Math.ceil(dropRate);
        return (int) Math.floor(dropRate);
    }
}
