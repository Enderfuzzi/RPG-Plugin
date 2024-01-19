package com.falgael.rpg.definitions.misc.items;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.MainItemDefinition;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.ItemSetManagement;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Statistics extends MainItemDefinition {


    public Statistics(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                    90010,
                    "Stat-O-Meter",
                    Material.AMETHYST_SHARD,
                    Proficiency.MISC,
                    Rarity.EPIC,
                    itemSetManager.getItemSetByID(0),
                    new ItemConfiguration.Builder()
                            .addFlag(ConfigurationFlag.ENCHANTED)
                            .create()
                )
        );

        return result;
    }
}
