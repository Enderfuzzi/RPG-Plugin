package com.falgael.rpg.definitions.farming.items;

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

import java.util.ArrayList;
import java.util.List;

public class Butcher extends MainItemDefinition {
    public Butcher(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        39100,
                        "Butcher Knife I",
                        Material.STONE_SWORD,
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        itemSetManager.getItemSetByID(IdSets.BUTCHER),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,5)
                                .create()
                )
        );

        result.add(
                new Item(
                        39101,
                        "Butcher Knife II",
                        Material.IRON_SWORD,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        itemSetManager.getItemSetByID(IdSets.BUTCHER),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,3)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,10)
                                .create()
                )
        );

        result.add(
                new Item(
                        39102,
                        "Butcher Knife III",
                        Material.GOLDEN_SWORD,
                        Proficiency.FARMING,
                        Rarity.ELITE,
                        itemSetManager.getItemSetByID(IdSets.BUTCHER),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,4)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER,5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,20)
                                .create()
                )
        );


        result.add(
                new Item(
                        39103,
                        "Butcher apron",
                        Material.IRON_LEGGINGS,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        itemSetManager.getItemSetByID(IdSets.BUTCHER),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT,15)
                                .create()
                )
        );

        result.add(
                new Item(
                        39104,
                        "Butcher boots",
                        Material.IRON_BOOTS,
                        Proficiency.FARMING,
                        Rarity.ADVANCED,
                        itemSetManager.getItemSetByID(IdSets.BUTCHER),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 1)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15)
                                .create()
                )
        );

        return result;
    }
}
