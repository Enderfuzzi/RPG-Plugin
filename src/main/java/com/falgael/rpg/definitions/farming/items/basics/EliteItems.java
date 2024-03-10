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

public class EliteItems extends MainItemDefinition {
    public EliteItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        30300,
                        "Farmer Hoe IV",
                        Material.GOLDEN_HOE,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        "Elite farmer tool",
                        itemSetManager.getItemSetByID(IdSets.FARMER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,4)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
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
                        30301,
                        "Farmer Helmet VI",
                        Material.GOLDEN_HELMET,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        "Elite farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        30302,
                        "Farmer Chestplate IV",
                        Material.GOLDEN_CHESTPLATE,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        "Elite farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 20)
                                .create()
                )
        );

        result.add(
                new Item(
                        30303,
                        "Farmer Leggings IV",
                        Material.GOLDEN_LEGGINGS,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        "Elite farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        30304,
                        "Farmer Boots IV",
                        Material.GOLDEN_BOOTS,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        "Elite farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        30305,
                        "Farmer Wings I",
                        Material.ELYTRA,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        "Farmer wings",
                        itemSetManager.getItemSetByID(IdSets.FARMER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
                                .create()
                )
        );

        return result;
    }
}
