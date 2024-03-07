package com.falgael.rpg.definitions.farming.items.basics;

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
                        30200,
                        "Farmer Hoe III",
                        Material.IRON_HOE,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        "Advanced farmer tool",
                        itemSetManager.getItemSetByID(IdSets.FARMER_III),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .addFlag(ConfigurationFlag.CROP_HARVEST)
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
                        30201,
                        "Farmer Helmet III",
                        Material.IRON_HELMET,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        "Advanced farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_III),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        30202,
                        "Farmer Chestplate III",
                        Material.IRON_CHESTPLATE,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        "Advanced farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_III),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                                .create()
                )
        );

        result.add(
                new Item(
                        30203,
                        "Farmer Leggings III",
                        Material.IRON_LEGGINGS,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        "Advanced farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_III),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        30204,
                        "Farmer Boots III",
                        Material.IRON_BOOTS,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        "Advanced farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_III),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        return result;
    }
}
