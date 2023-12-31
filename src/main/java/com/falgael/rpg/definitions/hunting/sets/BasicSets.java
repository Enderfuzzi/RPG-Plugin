package com.falgael.rpg.definitions.hunting.sets;

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
                        4000,
                        "Hunter I",
                        Proficiency.STONEWORK,
                        Rarity.SIMPLE,
                        5,
                        "For hunt specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        4001,
                        "Hunter II",
                        Proficiency.STONEWORK,
                        Rarity.COMMON,
                        5,
                        "For hunt specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        4002,
                        "Hunter III",
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        5,
                        "For hunt specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        4003,
                        "Hunter IV",
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        5,
                        "For hunt specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        4004,
                        "Hunter V",
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        5,
                        "For hunt specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        4005,
                        "Hunter VI",
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        5,
                        "For hunt specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                                .addFlag(ConfigurationFlag.LOOT, 4)
                                .create()

                )
        );

        return result;
    }
}
