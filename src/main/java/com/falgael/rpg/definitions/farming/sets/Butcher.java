package com.falgael.rpg.definitions.farming.sets;

import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.identification.IdSets;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.items.set.ItemSet;
import com.falgael.rpg.items.set.ItemSetDefinition;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;

import java.util.ArrayList;
import java.util.List;

public class Butcher implements ItemSetDefinition {

    @Override
    public List<DefaultItemSet> getItemSets() {
        List<DefaultItemSet> result = new ArrayList<>();

        result.add(
                new ItemSet(
                        IdSets.BUTCHER,
                        "Butcher",
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        2,
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.DAMAGE_ADDITIVE,3)
                                .create()
                )
        );

        return result;
    }
}
