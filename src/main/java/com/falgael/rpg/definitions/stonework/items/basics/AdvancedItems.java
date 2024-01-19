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

public class AdvancedItems extends MainItemDefinition {
    public AdvancedItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20200,
                        "Miner Pickaxe III",
                        Material.IRON_AXE,
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        "Advanced miner tool",
                        itemSetManager.getItemSetByID(2002),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT, 1.5)
                                .addFlag(ConfigurationFlag.VEIN_MINING,5)
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
                        20201,
                        "Miner Helmet III",
                        Material.IRON_HELMET,
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        "Advanced miner protection",
                        itemSetManager.getItemSetByID(2002),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        20202,
                        "Miner Chestplate III",
                        Material.IRON_CHESTPLATE,
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        "Advanced miner protection",
                        itemSetManager.getItemSetByID(2002),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 10)
                                .create()
                )
        );

        result.add(
                new Item(
                        20203,
                        "Miner Leggings III",
                        Material.IRON_LEGGINGS,
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        "Advanced miner protection",
                        itemSetManager.getItemSetByID(2002),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        20204,
                        "Miner Boots III",
                        Material.IRON_BOOTS,
                        Proficiency.STONEWORK,
                        Rarity.ADVANCED,
                        "Advanced miner protection",
                        itemSetManager.getItemSetByID(2002),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        return result;
    }
}
