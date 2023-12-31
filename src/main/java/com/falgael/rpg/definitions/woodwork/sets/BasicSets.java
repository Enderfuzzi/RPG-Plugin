package com.falgael.rpg.definitions.woodwork.sets;

import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.items.set.ItemSet;
import com.falgael.rpg.items.set.ItemSetDefinition;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;

import java.util.ArrayList;
import java.util.List;

public class BasicSets implements ItemSetDefinition {
    @Override
    public List<DefaultItemSet> getItemSets() {
        List<DefaultItemSet> result = new ArrayList<>();

        result.add(
                new ItemSet(
                1000,
                "Lumberjack I",
                Proficiency.WOODWORK,
                Rarity.SIMPLE,
                5,
                "For wood specialists",
                new ItemConfiguration.Builder()
                        .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                        .addFlag(ConfigurationFlag.LOOT, 0.5)
                        .create()

                )
        );

        result.add(
                new ItemSet(
                        1001,
                        "Lumberjack II",
                        Proficiency.WOODWORK,
                        Rarity.COMMON,
                        5,
                        "For wood specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        1002,
                        "Lumberjack III",
                        Proficiency.WOODWORK,
                        Rarity.ADVANCED,
                        5,
                        "For wood specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        1003,
                        "Lumberjack IV",
                        Proficiency.WOODWORK,
                        Rarity.ELITE,
                        5,
                        "For wood specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        1004,
                        "Lumberjack V",
                        Proficiency.WOODWORK,
                        Rarity.EPIC,
                        5,
                        "For wood specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        1005,
                        "Lumberjack VI",
                        Proficiency.WOODWORK,
                        Rarity.LEGENDARY,
                        5,
                        "For wood specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                                .addFlag(ConfigurationFlag.LOOT, 4)
                                .create()

                )
        );

        return result;
    }
}