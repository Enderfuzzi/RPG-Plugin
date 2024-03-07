package com.falgael.rpg.definitions.farming.items.basics.tools;

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

public class FishingRods extends MainItemDefinition {
    public FishingRods(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        31200,
                        "Farmer fishing rod I",
                        Material.FISHING_ROD,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        itemSetManager.getItemSetByID(IdSets.FARMER_III),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 12)
                                .addPotionEffect(PotionEffectType.LUCK)
                                .create()
                )
        );

        result.add(
                new Item(
                        31201,
                        "Farmer fishing rod II",
                        Material.FISHING_ROD,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        itemSetManager.getItemSetByID(IdSets.FARMER_IV),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 3)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                                .addPotionEffect(PotionEffectType.LUCK)
                                .create()
                )
        );

        result.add(
                new Item(
                        31202,
                        "Farmer fishing rod III",
                        Material.FISHING_ROD,
                        Proficiency.FARMING,
                        Rarity.LEGENDARY,
                        itemSetManager.getItemSetByID(IdSets.FARMER_VI),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 6)
                                .addFlag(ConfigurationFlag.LOOT, 5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 60)
                                .addPotionEffect(PotionEffectType.LUCK, 1)
                                .create()
                )
        );


        return result;
    }
}
