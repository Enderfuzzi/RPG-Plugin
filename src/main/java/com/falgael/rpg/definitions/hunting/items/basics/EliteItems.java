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

public class EliteItems extends MainItemDefinition {
    public EliteItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        40300,
                        "Hunter Sword IV",
                        Material.GOLDEN_SWORD,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter tool",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,4)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
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
                        40301,
                        "Hunter Helmet VI",
                        Material.GOLDEN_HELMET,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter protection",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        40302,
                        "Hunter Chestplate IV",
                        Material.GOLDEN_CHESTPLATE,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter protection",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 20)
                                .create()
                )
        );

        result.add(
                new Item(
                        40303,
                        "Hunter Leggings IV",
                        Material.GOLDEN_LEGGINGS,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter protection",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        40304,
                        "Hunter Boots IV",
                        Material.GOLDEN_BOOTS,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter protection",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        40305,
                        "Hunter Shield II",
                        Material.SHIELD,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter shield",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.OFF_HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                                .create()
                )
        );

        result.add(
                new Item(
                        40306,
                        "Hunter Bow II",
                        Material.BOW,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter bow",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,4)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
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
                        40307,
                        "Hunter Crossbow I",
                        Material.CROSSBOW,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Elite hunter Crossbow",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,4)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
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
                        40308,
                        "Hunter Wings I",
                        Material.ELYTRA,
                        Proficiency.HUNTING,
                        Rarity.ELITE,
                        "Wings for the hunt",
                        itemSetManager.getItemSetByID(4003),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
                                .create()
                )
        );

        return result;
    }
}
