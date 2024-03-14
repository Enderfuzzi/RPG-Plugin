package com.falgael.rpg.definitions.stonework.items;

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
import org.bukkit.inventory.EquipmentSlot;

import java.util.ArrayList;
import java.util.List;

public class DeepMiner extends MainItemDefinition {
    public DeepMiner(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20610,
                        "Deep mining Helmet",
                        Material.DIAMOND_HELMET,
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(IdSets.DEEP_MINER),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                                .create()
                )
        );

        result.add(
                new Item(
                        20611,
                        "Deep mining Chestplate",
                        Material.DIAMOND_CHESTPLATE,
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(IdSets.DEEP_MINER),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                                .create()
                )
        );

        result.add(
                new Item(
                        20612,
                        "Deep mining Leggings",
                        Material.DIAMOND_LEGGINGS,
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(IdSets.DEEP_MINER),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                                .create()
                )
        );

        result.add(
                new Item(
                        20613,
                        "Deep mining Boots",
                        Material.DIAMOND_BOOTS,
                        Proficiency.STONEWORK,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(IdSets.DEEP_MINER),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                                .create()
                )
        );

        return result;
    }
}
