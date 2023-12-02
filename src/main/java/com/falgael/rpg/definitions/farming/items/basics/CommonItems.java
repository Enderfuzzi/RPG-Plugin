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

public class CommonItems extends MainItemDefinition {
    public CommonItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        30100,
                        "Farmer Hoe II",
                        Material.STONE_HOE,
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        "Common farmer tool",
                        itemSetManager.getItemSetbyID(3001),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.CROP_HARVEST)
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
                        30101,
                        "Farmer Helmet II",
                        Material.CHAINMAIL_HELMET,
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        "Common farmer protection",
                        itemSetManager.getItemSetbyID(3001),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        30102,
                        "Farmer Chestplate II",
                        Material.CHAINMAIL_CHESTPLATE,
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        "Common farmer protection",
                        itemSetManager.getItemSetbyID(3001),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5)
                                .create()
                )
        );

        result.add(
                new Item(
                        30103,
                        "Farmer Leggings II",
                        Material.CHAINMAIL_LEGGINGS,
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        "Common farmer protection",
                        itemSetManager.getItemSetbyID(3001),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        30104,
                        "Farmer Boots II",
                        Material.CHAINMAIL_BOOTS,
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        "Common farmer protection",
                        itemSetManager.getItemSetbyID(3001),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        return result;
    }
}
