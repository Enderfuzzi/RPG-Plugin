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

public class Rockets extends MainItemDefinition {
    public Rockets(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        90300,
                        "Small Rocket",
                        Material.FIREWORK_ROCKET,
                        Proficiency.MISC,
                        Rarity.ADVANCED,
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ROCKET_FLIGHT_DURATION,1)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        result.add(
                new Item(
                        90301,
                        "Casual Rocket",
                        Material.FIREWORK_ROCKET,
                        Proficiency.MISC,
                        Rarity.ADVANCED,
                        "Can't be cancelled",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ROCKET_FLIGHT_DURATION,3)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        result.add(
                new Item(
                        90302,
                        "Long distance Rocket",
                        Material.FIREWORK_ROCKET,
                        Proficiency.MISC,
                        Rarity.ELITE,
                        "Can't be cancelled",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ROCKET_FLIGHT_DURATION,16)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        result.add(
                new Item(
                        90303,
                        "Moon Rocket",
                        Material.FIREWORK_ROCKET,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        "Can't be cancelled",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ROCKET_FLIGHT_DURATION,32)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );
        result.add(
                new Item(
                        90304,
                        "Unstoppable Moon Rocket",
                        Material.FIREWORK_ROCKET,
                        Proficiency.MISC,
                        Rarity.LEGENDARY,
                        "Can't be cancelled",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder()
                                .addFlag(ConfigurationFlag.ROCKET_FLIGHT_DURATION,127)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .create()
                )
        );

        return result;
    }
}
