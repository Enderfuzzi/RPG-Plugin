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

public class SimpleItems extends MainItemDefinition {
    public SimpleItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        10000,
                        "Lumberjack Axe I",
                        Material.WOODEN_AXE,
                        Proficiency.WOODWORK,
                        Rarity.SIMPLE,
                        "Simple lumberjack tool",
                        itemSetManager.getItemSetbyID(1000),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
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
                        10001,
                        "Lumberjack Helmet I",
                        Material.LEATHER_HELMET,
                        Proficiency.WOODWORK,
                        Rarity.SIMPLE,
                        "Simple lumberjack protection",
                        itemSetManager.getItemSetbyID(1000),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD).create()
                )
        );

        result.add(
                new Item(
                        10002,
                        "Lumberjack Chestplate I",
                        Material.LEATHER_CHESTPLATE,
                        Proficiency.WOODWORK,
                        Rarity.SIMPLE,
                        "Simple lumberjack protection",
                        itemSetManager.getItemSetbyID(1000),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST).create()
                )
        );

        result.add(
                new Item(
                        10003,
                        "Lumberjack Leggings I",
                        Material.LEATHER_LEGGINGS,
                        Proficiency.WOODWORK,
                        Rarity.SIMPLE,
                        "Simple lumberjack protection",
                        itemSetManager.getItemSetbyID(1000),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS).create()
                )
        );

        result.add(
                new Item(
                        10004,
                        "Lumberjack Boots I",
                        Material.LEATHER_BOOTS,
                        Proficiency.WOODWORK,
                        Rarity.SIMPLE,
                        "Simple lumberjack protection",
                        itemSetManager.getItemSetbyID(1000),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET).create()
                )
        );


        return result;
    }
}