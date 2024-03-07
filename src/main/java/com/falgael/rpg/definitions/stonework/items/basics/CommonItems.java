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

public class CommonItems extends MainItemDefinition {
    public CommonItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20100,
                        "Miner Pickaxe II",
                        Material.STONE_PICKAXE,
                        Proficiency.STONEWORK,
                        Rarity.COMMON,
                        "Common miner tool",
                        itemSetManager.getItemSetByID(IdSets.MINER_II),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.VEIN_MINING,3)
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
                        20101,
                        "Miner Helmet II",
                        Material.CHAINMAIL_HELMET,
                        Proficiency.STONEWORK,
                        Rarity.COMMON,
                        "Common miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_II),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        20102,
                        "Miner Chestplate II",
                        Material.CHAINMAIL_CHESTPLATE,
                        Proficiency.STONEWORK,
                        Rarity.COMMON,
                        "Common miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_II),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 5)
                                .create()
                )
        );

        result.add(
                new Item(
                        20103,
                        "Miner Leggings II",
                        Material.CHAINMAIL_LEGGINGS,
                        Proficiency.STONEWORK,
                        Rarity.COMMON,
                        "Common miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_II),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        20104,
                        "Miner Boots II",
                        Material.CHAINMAIL_BOOTS,
                        Proficiency.STONEWORK,
                        Rarity.COMMON,
                        "Common miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_II),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        return result;
    }
}
