package com.falgael.rpg.definitions.woodwork.items.basics;

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
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class AdvancedItems extends MainItemDefinition {
    public AdvancedItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        10200,
                        "Lumberjack Axe III",
                        Material.IRON_AXE,
                        Proficiency.WOODWORK,
                        Rarity.ADVANCED,
                        "Advanced lumberjack tool",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_III),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .addFlag(ConfigurationFlag.TREE_HARVEST,24)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .addPotionEffect(PotionEffectType.FAST_DIGGING)
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
                        10201,
                        "Lumberjack Helmet III",
                        Material.IRON_HELMET,
                        Proficiency.WOODWORK,
                        Rarity.ADVANCED,
                        "Advanced lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_III),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        10202,
                        "Lumberjack Chestplate III",
                        Material.IRON_CHESTPLATE,
                        Proficiency.WOODWORK,
                        Rarity.ADVANCED,
                        "Advanced lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_III),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                                .create()
                )
        );

        result.add(
                new Item(
                        10203,
                        "Lumberjack Leggings III",
                        Material.IRON_LEGGINGS,
                        Proficiency.WOODWORK,
                        Rarity.ADVANCED,
                        "Advanced lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_III),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        10204,
                        "Lumberjack Boots III",
                        Material.IRON_BOOTS,
                        Proficiency.WOODWORK,
                        Rarity.ADVANCED,
                        "Advanced lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_III),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        return result;
    }
}
