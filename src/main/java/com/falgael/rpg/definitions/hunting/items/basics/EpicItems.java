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

public class EpicItems extends MainItemDefinition {
    public EpicItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        40400,
                        "Hunter Sword V",
                        Material.DIAMOND_SWORD,
                        Proficiency.HUNTING,
                        Rarity.EPIC,
                        "Epic hunter tool",
                        itemSetManager.getItemSetByID(4004),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,5)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1.5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
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
                        40401,
                        "Hunter Helmet V",
                        Material.DIAMOND_HELMET,
                        Proficiency.HUNTING,
                        Rarity.EPIC,
                        "Epic hunter protection",
                        itemSetManager.getItemSetByID(4004),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        40402,
                        "Hunter Chestplate V",
                        Material.DIAMOND_CHESTPLATE,
                        Proficiency.HUNTING,
                        Rarity.EPIC,
                        "Epic hunter protection",
                        itemSetManager.getItemSetByID(4004),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 35)
                                .create()
                )
        );

        result.add(
                new Item(
                        40403,
                        "Hunter Leggings V",
                        Material.DIAMOND_LEGGINGS,
                        Proficiency.HUNTING,
                        Rarity.EPIC,
                        "Epic hunter protection",
                        itemSetManager.getItemSetByID(4004),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        40404,
                        "Hunter Boots V",
                        Material.DIAMOND_BOOTS,
                        Proficiency.HUNTING,
                        Rarity.EPIC,
                        "Epic hunter protection",
                        itemSetManager.getItemSetByID(4004),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,35)
                                .create()
                )
        );

        result.add(
                new Item(
                        40405,
                        "Hunter Bow III",
                        Material.BOW,
                        Proficiency.HUNTING,
                        Rarity.EPIC,
                        "Epic hunter Bow",
                        itemSetManager.getItemSetByID(4004),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,5)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
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
                        40406,
                        "Hunter Crossbow II",
                        Material.CROSSBOW,
                        Proficiency.HUNTING,
                        Rarity.EPIC,
                        "Epic Hunter Crossbow",
                        itemSetManager.getItemSetByID(4004),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,5)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,40)
                                .create()
                ) {
                    @Override
                    public boolean isWeapon() {
                        return true;
                    }
                }
        );

        return result;
    }
}
