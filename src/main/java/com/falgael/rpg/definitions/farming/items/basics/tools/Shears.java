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

import java.util.ArrayList;
import java.util.List;

public class Shears extends MainItemDefinition {
    public Shears(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        32100,
                        "Farmer shears I",
                        Material.SHEARS,
                        Proficiency.FARMING,
                        Rarity.COMMON,
                        itemSetManager.getItemSetByID(IdSets.FARMER_II),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 2)
                                .addFlag(ConfigurationFlag.LOOT, 1)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 8)
                                .create()
                )
        );

        result.add(
                new Item(
                        32101,
                        "Farmer shears II",
                        Material.SHEARS,
                        Proficiency.FARMING,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(IdSets.FARMER_V),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 5)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 40)
                                .create()
                )
        );


        return result;
    }
}
