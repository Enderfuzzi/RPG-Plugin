package com.falgael.rpg.definitions.misc.items;

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

import java.util.ArrayList;
import java.util.List;

public class KingMidas extends MainItemDefinition {

    public KingMidas(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        90110,
                        "King Midas Crown",
                        Material.GOLDEN_HELMET,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        "A Crown for the richest",
                        itemSetManager.getItemSetbyID(9000),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 50)
                                .create()
                )
        );

        result.add(
                new Item(
                        90111,
                        "King Midas Chest",
                        Material.GOLDEN_CHESTPLATE,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        "Protects with layered Gold",
                        itemSetManager.getItemSetbyID(9000),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.LOOT, 3)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 50)
                                .create()
                )
        );

        result.add(
                new Item(
                        90112,
                        "King Midas Sword",
                        Material.GOLDEN_SWORD,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        "Slaughter the poor",
                        itemSetManager.getItemSetbyID(9000),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.LOOT, 2)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 1.5)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 55)
                                .create()
                )
        );


        return result;
    }
}
