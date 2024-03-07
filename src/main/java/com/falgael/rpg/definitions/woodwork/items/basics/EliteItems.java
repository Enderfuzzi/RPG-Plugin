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

public class EliteItems extends MainItemDefinition {
    public EliteItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        10300,
                        "Lumberjack Axe IV",
                        Material.GOLDEN_AXE,
                        Proficiency.WOODWORK,
                        Rarity.ELITE,
                        "Elite lumberjack tool",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,4)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.TREE_HARVEST,32)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
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
                        10301,
                        "Lumberjack Helmet VI",
                        Material.GOLDEN_HELMET,
                        Proficiency.WOODWORK,
                        Rarity.ELITE,
                        "Elite lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        10302,
                        "Lumberjack Chestplate IV",
                        Material.GOLDEN_CHESTPLATE,
                        Proficiency.WOODWORK,
                        Rarity.ELITE,
                        "Elite lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 20)
                                .create()
                )
        );

        result.add(
                new Item(
                        10303,
                        "Lumberjack Leggings IV",
                        Material.GOLDEN_LEGGINGS,
                        Proficiency.WOODWORK,
                        Rarity.ELITE,
                        "Elite lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        10304,
                        "Lumberjack Boots IV",
                        Material.GOLDEN_BOOTS,
                        Proficiency.WOODWORK,
                        Rarity.ELITE,
                        "Elite lumberjack protection",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        10305,
                        "Lumberjack Wings I",
                        Material.ELYTRA,
                        Proficiency.WOODWORK,
                        Rarity.ELITE,
                        "Lumberjack wings",
                        itemSetManager.getItemSetByID(IdSets.LUMBERJACK_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
                                .create()
                )
        );


        return result;
    }
}
