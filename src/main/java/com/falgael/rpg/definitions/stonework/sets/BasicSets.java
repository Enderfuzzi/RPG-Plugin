package com.falgael.rpg.definitions.stonework.sets;

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
                        2000,
                        "Miner I",
                        Proficiency.STONEWORK,
                        Rarity.SIMPLE,
                        5,
                        "For stone specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        2001,
                        "Miner II",
                        Proficiency.STONEWORK,
                        Rarity.COMMON,
                        5,
                        "For stone specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        2002,
                        "Miner III",
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        5,
                        "For stone specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        2003,
                        "Miner IV",
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        5,
                        "For stone specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        2004,
                        "Miner V",
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        5,
                        "For stone specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .create()

                )
        );

        result.add(
                new ItemSet(
                        2005,
                        "Miner VI",
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        5,
                        "For stone specialists",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                                .addFlag(ConfigurationFlag.LOOT, 4)
                                .create()

                )
        );

        return result;
    }
}
