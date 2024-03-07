package com.falgael.rpg.definitions.farming.items.basics;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.MainItemDefinition;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.ItemSetManagement;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class LegendaryItems extends MainItemDefinition {
    public LegendaryItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        30500,
                        "Farmer Hoe VI",
                        Material.NETHERITE_HOE,
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        "Legendary farmer tool",
                        itemSetManager.getItemSetByID(3005),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,6)
                                .addFlag(ConfigurationFlag.LOOT, 5)
                                .addFlag(ConfigurationFlag.CROP_HARVEST)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .addPotionEffect(PotionEffectType.FAST_DIGGING,1)
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
                        30501,
                        "Farmer Helmet VI",
                        Material.NETHERITE_HELMET,
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        "Legendary farmer protection",
                        itemSetManager.getItemSetByID(3005),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        30502,
                        "Farmer Chestplate VI",
                        Material.NETHERITE_CHESTPLATE,
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        "Legendary farmer protection",
                        itemSetManager.getItemSetByID(3005),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 4)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 55)
                                .create()
                )
        );

        result.add(
                new Item(
                        30503,
                        "Farmer Leggings VI",
                        Material.NETHERITE_LEGGINGS,
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        "Legendary farmer protection",
                        itemSetManager.getItemSetByID(3005),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        30504,
                        "Farmer Boots VI",
                        Material.NETHERITE_BOOTS,
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        "Legendary farmer protection",
                        itemSetManager.getItemSetByID(3005),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        30505,
                        "Farmer Wings III",
                        Material.ELYTRA,
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        "Farmer wings",
                        itemSetManager.getItemSetByID(3005),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 55)
                                .create()
                )
        );

        return result;
    }
}
