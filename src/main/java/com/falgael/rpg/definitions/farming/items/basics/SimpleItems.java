package com.falgael.rpg.definitions.farming.items.basics;

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
                        30000,
                        "Farmer Hoe I",
                        Material.WOODEN_HOE,
                        Proficiency.FARMING,
                        Rarity.SIMPLE,
                        "Simple farmer tool",
                        itemSetManager.getItemSetByID(IdSets.FARMER_I),
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
                        30001,
                        "Farmer Helmet I",
                        Material.LEATHER_HELMET,
                        Proficiency.FARMING,
                        Rarity.SIMPLE,
                        "Simple farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD).create()
                )
        );

        result.add(
                new Item(
                        30002,
                        "Farmer Chestplate I",
                        Material.LEATHER_CHESTPLATE,
                        Proficiency.FARMING,
                        Rarity.SIMPLE,
                        "Simple farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST).create()
                )
        );

        result.add(
                new Item(
                        30003,
                        "Farmer Leggings I",
                        Material.LEATHER_LEGGINGS,
                        Proficiency.FARMING,
                        Rarity.SIMPLE,
                        "Simple farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS).create()
                )
        );

        result.add(
                new Item(
                        30004,
                        "Farmer Boots I",
                        Material.LEATHER_BOOTS,
                        Proficiency.FARMING,
                        Rarity.SIMPLE,
                        "Simple farmer protection",
                        itemSetManager.getItemSetByID(IdSets.FARMER_I),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET).create()
                )
        );


        return result;
    }
}