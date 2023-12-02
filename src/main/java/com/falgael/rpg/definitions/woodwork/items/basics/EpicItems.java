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

public class EpicItems extends MainItemDefinition {
    public EpicItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        10400,
                        "Lumberjack Axe V",
                        Material.DIAMOND_AXE,
                        Proficiency.WOODWORK,
                        Rarity.EPIC,
                        "Epic lumberjack tool",
                        itemSetManager.getItemSetbyID(1004),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,5)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.TREE_HARVEST,48)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
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
                        10401,
                        "Lumberjack Helmet V",
                        Material.DIAMOND_HELMET,
                        Proficiency.WOODWORK,
                        Rarity.EPIC,
                        "Epic lumberjack protection",
                        itemSetManager.getItemSetbyID(1004),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        10402,
                        "Lumberjack Chestplate V",
                        Material.DIAMOND_CHESTPLATE,
                        Proficiency.WOODWORK,
                        Rarity.EPIC,
                        "Epic lumberjack protection",
                        itemSetManager.getItemSetbyID(1004),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 35)
                                .create()
                )
        );

        result.add(
                new Item(
                        10403,
                        "Lumberjack Leggings V",
                        Material.DIAMOND_LEGGINGS,
                        Proficiency.WOODWORK,
                        Rarity.EPIC,
                        "Epic lumberjack protection",
                        itemSetManager.getItemSetbyID(1004),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        10404,
                        "Lumberjack Boots V",
                        Material.DIAMOND_BOOTS,
                        Proficiency.WOODWORK,
                        Rarity.EPIC,
                        "Epic lumberjack protection",
                        itemSetManager.getItemSetbyID(1004),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        return result;
    }
}
