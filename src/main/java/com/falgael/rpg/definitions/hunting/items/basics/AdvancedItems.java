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

public class AdvancedItems extends MainItemDefinition {
    public AdvancedItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        40200,
                        "Hunter Sword III",
                        Material.IRON_SWORD,
                        Proficiency.HUNTING,
                        Rarity.ADVANCED,
                        "Advanced hunter tool",
                        itemSetManager.getItemSetbyID(4002),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
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
                        40201,
                        "Hunter Helmet III",
                        Material.IRON_HELMET,
                        Proficiency.HUNTING,
                        Rarity.ADVANCED,
                        "Advanced hunter protection",
                        itemSetManager.getItemSetbyID(4002),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        40202,
                        "Hunter Chestplate III",
                        Material.IRON_CHESTPLATE,
                        Proficiency.HUNTING,
                        Rarity.ADVANCED,
                        "Advanced hunter protection",
                        itemSetManager.getItemSetbyID(4002),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                                .create()
                )
        );

        result.add(
                new Item(
                        40203,
                        "Hunter Leggings III",
                        Material.IRON_LEGGINGS,
                        Proficiency.HUNTING,
                        Rarity.ADVANCED,
                        "Advanced hunter protection",
                        itemSetManager.getItemSetbyID(4002),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        40204,
                        "Hunter Boots III",
                        Material.IRON_BOOTS,
                        Proficiency.HUNTING,
                        Rarity.ADVANCED,
                        "Advanced hunter protection",
                        itemSetManager.getItemSetbyID(4002),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        return result;
    }
}
