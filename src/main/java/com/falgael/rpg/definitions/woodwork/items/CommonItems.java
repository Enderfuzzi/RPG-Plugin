package com.falgael.rpg.definitions.woodwork.items;

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

public class CommonItems extends MainItemDefinition {
    public CommonItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        10100,
                        "Lumberjack Axe II",
                        Material.STONE_AXE,
                        Proficiency.WOODWORK,
                        Rarity.COMMON,
                        "Common lumberjack tool",
                        itemSetManager.getItemSetbyID(1001),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.TREE_HARVEST,16)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
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
                        10101,
                        "Lumberjack Helmet II",
                        Material.CHAINMAIL_HELMET,
                        Proficiency.WOODWORK,
                        Rarity.COMMON,
                        "Common lumberjack protection",
                        itemSetManager.getItemSetbyID(1001),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        10102,
                        "Lumberjack Chestplate II",
                        Material.CHAINMAIL_CHESTPLATE,
                        Proficiency.WOODWORK,
                        Rarity.COMMON,
                        "Common lumberjack protection",
                        itemSetManager.getItemSetbyID(1001),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5)
                                .create()
                )
        );

        result.add(
                new Item(
                        10103,
                        "Lumberjack Leggings II",
                        Material.CHAINMAIL_LEGGINGS,
                        Proficiency.WOODWORK,
                        Rarity.COMMON,
                        "Common lumberjack protection",
                        itemSetManager.getItemSetbyID(1001),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        10104,
                        "Lumberjack Boots II",
                        Material.CHAINMAIL_BOOTS,
                        Proficiency.WOODWORK,
                        Rarity.COMMON,
                        "Common lumberjack protection",
                        itemSetManager.getItemSetbyID(1001),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        return result;
    }
}
