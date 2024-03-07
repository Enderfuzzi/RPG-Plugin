package com.falgael.rpg.definitions.misc.items;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.MainItemDefinition;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.identification.IdSets;
import com.falgael.rpg.items.set.ItemSetManagement;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public class Currency extends MainItemDefinition {


    public Currency(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        90000,
                        "Silver Coin",
                        Material.IRON_NUGGET,
                        Proficiency.MISC,
                        Rarity.ADVANCED,
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.CURRENCY)
                                .create()
                )
        );

        result.add(
                new Item(
                        90001,
                        "Gold Coin",
                        Material.GOLD_NUGGET,
                        Proficiency.MISC,
                        Rarity.ELITE,
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.CURRENCY)
                                .create()
                )
        );

        result.add(
                new Item(
                        90002,
                        "Crystal Coin",
                        Material.DIAMOND,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.CURRENCY)
                                .create()
                )
        );


        return result;
    }
}
