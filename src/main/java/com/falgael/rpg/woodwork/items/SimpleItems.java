package com.falgael.rpg.woodwork.items;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.ItemDefinition;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.ItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.Material;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class SimpleItems implements ItemDefinition {
    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> results = new ArrayList<>();

        results.add(
                new Item(
                        10000,
                        "Lumberjack Axe I",
                        Material.WOODEN_AXE,
                        Proficiency.WOODWORK,
                        Rarity.SIMPLE,
                        "Simple lumberjack tool",
                        ItemSet.LUMBERJACK_1,
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .addPotionEffect(PotionEffectType.FAST_DIGGING)
                                .create()
                        )
        );



        return results;
    }
}

/*
    LUMBERJACK_AXE_1(Proficiency.WOODWORK, Material.WOODEN_AXE, Rarity.SIMPLE,"Simple lumberjack tool",
            new ItemConfiguration.Builder(EquipmentSlot.HAND)
                    .addFlag(ConfigurationFlag.EXPERIENCE,1)
                            .addFlag(ConfigurationFlag.LOOT, 0.5)
                            .addPotionEffect(PotionEffectType.FAST_DIGGING)
                            .create(),
                            ItemSet.LUMBERJACK_1
                            ),
                            LUMBERJACK_HELMET_1(Proficiency.WOODWORK, Material.LEATHER_HELMET, Rarity.SIMPLE,"Simple lumberjack protection",
                            new ItemConfiguration.Builder(EquipmentSlot.HEAD).create(),
                            ItemSet.LUMBERJACK_1
                            ),
                            LUMBERJACK_CHESTPLATE_1(Proficiency.WOODWORK, Material.LEATHER_CHESTPLATE, Rarity.SIMPLE,"Simple lumberjack protection",
                            new ItemConfiguration.Builder(EquipmentSlot.CHEST).create(),
                            ItemSet.LUMBERJACK_1
                            ),
                            LUMBERJACK_LEGGINGS_1(Proficiency.WOODWORK, Material.LEATHER_LEGGINGS, Rarity.SIMPLE,"Simple lumberjack protection",
                            new ItemConfiguration.Builder(EquipmentSlot.LEGS).create(),
                            ItemSet.LUMBERJACK_1
                            ),
                            LUMBERJACK_BOOTS_1(Proficiency.WOODWORK, Material.LEATHER_BOOTS,Rarity.SIMPLE,"Simple lumberjack protection",
                            new ItemConfiguration.Builder(EquipmentSlot.FEET).create(),
                            ItemSet.LUMBERJACK_1
                            ),
*/