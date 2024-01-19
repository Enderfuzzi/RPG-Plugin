package com.falgael.rpg.definitions.stonework.items;

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

public class InfinitiveFuel extends MainItemDefinition {
    public InfinitiveFuel(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20600,
                        "Infinite Fuel I",
                        Material.OAK_WOOD,
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        itemSetManager.getItemSetByID(0),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.BURN_TIME, 0.1)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        result.add(
                new Item(
                        20601,
                        "Infinite Fuel II",
                        Material.COAL,
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        itemSetManager.getItemSetByID(0),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.BURN_TIME, 0.25)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        result.add(
                new Item(
                        20600,
                        "Infinite Fuel III",
                        Material.CHARCOAL,
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(0),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.BURN_TIME, 0.5)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        result.add(
                new Item(
                        20600,
                        "Infinite Fuel IV",
                        Material.COAL_BLOCK,
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        itemSetManager.getItemSetByID(0),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.BURN_TIME, 0.85)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        return result;
    }
}
