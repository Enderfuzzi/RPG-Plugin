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

public class SimpleItems extends MainItemDefinition {
    public SimpleItems(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20000,
                        "Miner Pickaxe I",
                        Material.WOODEN_PICKAXE,
                        Proficiency.STONEWORK,
                        Rarity.SIMPLE,
                        "Simple miner tool",
                        itemSetManager.getItemSetByID(IdSets.MINER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
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
                        20001,
                        "Miner Helmet I",
                        Material.LEATHER_HELMET,
                        Proficiency.STONEWORK,
                        Rarity.SIMPLE,
                        "Simple miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD).create()
                )
        );

        result.add(
                new Item(
                        20002,
                        "Miner Chestplate I",
                        Material.LEATHER_CHESTPLATE,
                        Proficiency.STONEWORK,
                        Rarity.SIMPLE,
                        "Simple miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST).create()
                )
        );

        result.add(
                new Item(
                        20003,
                        "Miner Leggings I",
                        Material.LEATHER_LEGGINGS,
                        Proficiency.STONEWORK,
                        Rarity.SIMPLE,
                        "Simple miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS).create()
                )
        );

        result.add(
                new Item(
                        20004,
                        "Miner Boots I",
                        Material.LEATHER_BOOTS,
                        Proficiency.STONEWORK,
                        Rarity.SIMPLE,
                        "Simple miner protection",
                        itemSetManager.getItemSetByID(IdSets.MINER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET).create()
                )
        );


        return result;
    }
}