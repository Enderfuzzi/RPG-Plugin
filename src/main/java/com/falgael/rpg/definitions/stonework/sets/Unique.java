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

public class Unique implements ItemSetDefinition {
    @Override
    public List<DefaultItemSet> getItemSets() {
        List<DefaultItemSet> result = new ArrayList<>();

        result.add(
                new ItemSet(
                        IdSets.GOTHMOGS_BREATH,
                        "Gothmog's Breath",
                        Proficiency.STONEWORK,
                        Rarity.UNIQUE,
                        1,
                        "Breath of the Lord itself",
                        new ItemConfiguration.Builder()
                                .addPotionEffect(PotionEffectType.FIRE_RESISTANCE)
                                .addPotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        return result;
    }
}
