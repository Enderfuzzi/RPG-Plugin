package com.falgael.rpg.definitions.farming.items.basics;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.MainItemDefinition;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.configuration.effects.definitions.CropHarvest;
import com.falgael.rpg.items.identification.IdSets;
import com.falgael.rpg.items.set.ItemSetManagement;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class EpicItems extends MainItemDefinition {
    public EpicItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        30400,
                        "Farmer Hoe V",
                        Material.DIAMOND_HOE,
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        "Epic farmer tool",
                        itemSetManager.getItemSetByID(IdSets.FARMER_V),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,5)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .addPotionEffect(PotionEffectType.FAST_DIGGING)
                                .addAction(new CropHarvest())
                                .create()
                ) {
                    @Override
                    public boolean isBreakingTool() {
                        return true;
                    }
                }
        );

        result.add(
                new Item(
                        30401,
                        "Farmer Helmet V",
                        Material.DIAMOND_HELMET,
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        "Epic farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_V),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        30402,
                        "Farmer Chestplate V",
                        Material.DIAMOND_CHESTPLATE,
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        "Epic farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_V),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 35)
                                .create()
                )
        );

        result.add(
                new Item(
                        30403,
                        "Farmer Leggings V",
                        Material.DIAMOND_LEGGINGS,
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        "Epic farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_V),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        30404,
                        "Farmer Boots V",
                        Material.DIAMOND_BOOTS,
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        "Epic farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_V),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        30405,
                        "Farmer Wings II",
                        Material.ELYTRA,
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        "Farmer wings",
                        itemSetManager.getItemSetByID(IdSets.FARMER_V),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                                .create()
                )
        );

        return result;
    }
}
