package com.falgael.rpg.definitions.woodwork.items.basics;

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
                        10500,
                        "Lumberjack Axe VI",
                        Material.NETHERITE_AXE,
                        Proficiency.WOODWORK,
                        Rarity.LEGENDARY,
                        "Legendary lumberjack tool",
                        itemSetManager.getItemSetByID(1005),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,6)
                                .addFlag(ConfigurationFlag.LOOT, 5)
                                .addFlag(ConfigurationFlag.TREE_HARVEST,80)
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
                        10501,
                        "Lumberjack Helmet VI",
                        Material.NETHERITE_HELMET,
                        Proficiency.WOODWORK,
                        Rarity.LEGENDARY,
                        "Legendary lumberjack protection",
                        itemSetManager.getItemSetByID(1005),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        10502,
                        "Lumberjack Chestplate VI",
                        Material.NETHERITE_CHESTPLATE,
                        Proficiency.WOODWORK,
                        Rarity.LEGENDARY,
                        "Legendary lumberjack protection",
                        itemSetManager.getItemSetByID(1005),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 4)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 55)
                                .create()
                )
        );

        result.add(
                new Item(
                        10503,
                        "Lumberjack Leggings VI",
                        Material.NETHERITE_LEGGINGS,
                        Proficiency.WOODWORK,
                        Rarity.LEGENDARY,
                        "Legendary lumberjack protection",
                        itemSetManager.getItemSetByID(1005),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        10504,
                        "Lumberjack Boots VI",
                        Material.NETHERITE_BOOTS,
                        Proficiency.WOODWORK,
                        Rarity.LEGENDARY,
                        "Legendary lumberjack protection",
                        itemSetManager.getItemSetByID(1005),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        10505,
                        "Lumberjack Wings III",
                        Material.ELYTRA,
                        Proficiency.WOODWORK,
                        Rarity.LEGENDARY,
                        "Lumberjack wings",
                        itemSetManager.getItemSetByID(1005),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        return result;
    }
}
