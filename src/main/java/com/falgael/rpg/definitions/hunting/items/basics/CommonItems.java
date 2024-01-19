package com.falgael.rpg.definitions.hunting.items.basics;

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
                        40100,
                        "Hunter Axe II",
                        Material.STONE_AXE,
                        Proficiency.HUNTING,
                        Rarity.COMMON,
                        "Common hunter tool",
                        itemSetManager.getItemSetByID(4001),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,0.5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .addPotionEffect(PotionEffectType.INCREASE_DAMAGE)
                                .create()
                ) {
                    @Override
                    public boolean isWeapon() {
                        return true;
                    }
                }
        );

        result.add(
                new Item(
                        40101,
                        "Hunter Helmet II",
                        Material.CHAINMAIL_HELMET,
                        Proficiency.HUNTING,
                        Rarity.COMMON,
                        "Common hunter protection",
                        itemSetManager.getItemSetByID(4001),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        40102,
                        "Hunter Chestplate II",
                        Material.CHAINMAIL_CHESTPLATE,
                        Proficiency.HUNTING,
                        Rarity.COMMON,
                        "Common hunter protection",
                        itemSetManager.getItemSetByID(4001),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5)
                                .create()
                )
        );

        result.add(
                new Item(
                        40103,
                        "Hunter Leggings II",
                        Material.CHAINMAIL_LEGGINGS,
                        Proficiency.HUNTING,
                        Rarity.COMMON,
                        "Common hunter protection",
                        itemSetManager.getItemSetByID(4001),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        40104,
                        "Hunter Boots II",
                        Material.CHAINMAIL_BOOTS,
                        Proficiency.HUNTING,
                        Rarity.COMMON,
                        "Common hunter protection",
                        itemSetManager.getItemSetByID(4001),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        return result;
    }
}
