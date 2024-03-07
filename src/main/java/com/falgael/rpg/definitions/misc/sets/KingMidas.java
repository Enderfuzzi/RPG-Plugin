package com.falgael.rpg.definitions.misc.sets;

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

public class KingMidas implements ItemSetDefinition {
    @Override
    public List<DefaultItemSet> getItemSets() {
        List<DefaultItemSet> result = new ArrayList<>();

        result.add(
                new ItemSet(
                        IdSets.KING_MIDAS,
                        "King Midas",
                        Proficiency.MISC,
                        Rarity.EPIC,
                        2,
                        "From the King itself",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.LOOT, 5)
                                .create()
                )
        );


        return result;
    }
}
