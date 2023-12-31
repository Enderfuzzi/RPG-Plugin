package com.falgael.rpg.definitions.farming.sets;

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
                        3000,
                        "Farmer I",
                        Proficiency.FARMING,
                        Rarity.SIMPLE,
                        5,
                        "For farm specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        3001,
                        "Farmer II",
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        5,
                        "For farm specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        3002,
                        "Farmer III",
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        5,
                        "For farm specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        3003,
                        "Farmer IV",
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        5,
                        "For farm specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        3004,
                        "Farmer V",
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        5,
                        "For farm specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        3005,
                        "Farmer VI",
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        5,
                        "For farm specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                                .addFlag(ConfigurationFlag.LOOT, 4)
                                .create()

                )
        );


        return result;
    }
}
