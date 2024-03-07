package com.falgael.rpg.definitions.hunting.items.basics;

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

public class LegendaryItems extends MainItemDefinition {
    public LegendaryItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        40500,
                        "Hunter Sword VI",
                        Material.NETHERITE_SWORD,
                        Proficiency.HUNTING,
                        Rarity.LEGENDARY,
                        "Legendary hunter tool",
                        itemSetManager.getItemSetByID(IdSets.HUNTER_VI),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,6)
                                .addFlag(ConfigurationFlag.LOOT, 5)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .addPotionEffect(PotionEffectType.INCREASE_DAMAGE,1)
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
                        40501,
                        "Hunter Helmet VI",
                        Material.NETHERITE_HELMET,
                        Proficiency.HUNTING,
                        Rarity.LEGENDARY,
                        "Legendary hunter protection",
                        itemSetManager.getItemSetByID(IdSets.HUNTER_VI),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        40502,
                        "Hunter Chestplate VI",
                        Material.NETHERITE_CHESTPLATE,
                        Proficiency.HUNTING,
                        Rarity.LEGENDARY,
                        "Legendary hunter protection",
                        itemSetManager.getItemSetByID(IdSets.HUNTER_VI),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 4)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 55)
                                .create()
                )
        );

        result.add(
                new Item(
                        40503,
                        "Hunter Leggings VI",
                        Material.NETHERITE_LEGGINGS,
                        Proficiency.HUNTING,
                        Rarity.LEGENDARY,
                        "Legendary hunter protection",
                        itemSetManager.getItemSetByID(IdSets.HUNTER_VI),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        40504,
                        "Hunter Boots VI",
                        Material.NETHERITE_BOOTS,
                        Proficiency.HUNTING,
                        Rarity.LEGENDARY,
                        "Legendary hunter protection",
                        itemSetManager.getItemSetByID(IdSets.HUNTER_VI),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        40407,
                        "Hunter Wings III",
                        Material.ELYTRA,
                        Proficiency.HUNTING,
                        Rarity.LEGENDARY,
                        "Wings for the hunt",
                        itemSetManager.getItemSetByID(IdSets.HUNTER_VI),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 55)
                                .create()
                )
        );

        return result;
    }
}
