package com.falgael.rpg.definitions.stonework.items.basics;

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

public class EliteItems extends MainItemDefinition {
    public EliteItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20300,
                        "Miner Pickaxe IV",
                        Material.GOLDEN_PICKAXE,
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        "Elite miner tool",
                        itemSetManager.getItemSetByID(IdSets.MINER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,4)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.VEIN_MINING,8)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
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
                        20301,
                        "Miner Helmet VI",
                        Material.GOLDEN_HELMET,
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        "Elite miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        20302,
                        "Miner Chestplate IV",
                        Material.GOLDEN_CHESTPLATE,
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        "Elite miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 20)
                                .create()
                )
        );

        result.add(
                new Item(
                        20303,
                        "Miner Leggings IV",
                        Material.GOLDEN_LEGGINGS,
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        "Elite miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        20304,
                        "Miner Boots IV",
                        Material.GOLDEN_BOOTS,
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        "Elite miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );

        result.add(
                new Item(
                        20305,
                        "Miner Wings I",
                        Material.ELYTRA,
                        Proficiency.STONEWORK,
                        Rarity.ELITE,
                        "Miner wings",
                        itemSetManager.getItemSetByID(IdSets.MINER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,25)
                                .create()
                )
        );

        return result;
    }
}
