package com.falgael.rpg.definitions.stonework.sets;

import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.identification.IdSets;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.items.set.ItemSet;
import com.falgael.rpg.items.set.ItemSetDefinition;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class DeepMiner implements ItemSetDefinition {
    @Override
    public List<DefaultItemSet> getItemSets() {
        List<DefaultItemSet> result = new ArrayList<>();

        result.add(
                new ItemSet(
                        IdSets.DEEP_MINER,
                        "Deep Miner",
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        3,
                        "Mine to the core",
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addPotionEffect(PotionEffectType.NIGHT_VISION)
                                .addPotionEffect(PotionEffectType.FAST_DIGGING, 1)
                                .create()
                )
        );

        return result;
    }
}
