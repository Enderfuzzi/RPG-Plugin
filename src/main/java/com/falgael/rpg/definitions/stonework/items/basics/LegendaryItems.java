package com.falgael.rpg.definitions.stonework.items.basics;

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

public class LegendaryItems extends MainItemDefinition {
    public LegendaryItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20500,
                        "Miner Pickaxe VI",
                        Material.NETHERITE_PICKAXE,
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        "Legendary miner tool",
                        itemSetManager.getItemSetbyID(2005),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,6)
                                .addFlag(ConfigurationFlag.LOOT, 5)
                                .addFlag(ConfigurationFlag.VEIN_MINING,20)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .addPotionEffect(PotionEffectType.FAST_DIGGING,1)
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
                        20501,
                        "Miner Helmet VI",
                        Material.NETHERITE_HELMET,
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        "Legendary miner protection",
                        itemSetManager.getItemSetbyID(2005),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        20502,
                        "Miner Chestplate VI",
                        Material.NETHERITE_CHESTPLATE,
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        "Legendary miner protection",
                        itemSetManager.getItemSetbyID(2005),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 4)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 55)
                                .create()
                )
        );

        result.add(
                new Item(
                        20503,
                        "Miner Leggings VI",
                        Material.NETHERITE_LEGGINGS,
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        "Legendary miner protection",
                        itemSetManager.getItemSetbyID(2005),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        result.add(
                new Item(
                        20504,
                        "Miner Boots VI",
                        Material.NETHERITE_BOOTS,
                        Proficiency.STONEWORK,
                        Rarity.LEGENDARY,
                        "Legendary miner protection",
                        itemSetManager.getItemSetbyID(2005),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,55)
                                .create()
                )
        );

        return result;
    }
}
