package com.falgael.rpg.definitions.stonework.items;

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

public class Unique extends MainItemDefinition {
    public Unique(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        20900,
                        "Gothmog's Scale",
                        Material.NETHERITE_CHESTPLATE,
                        Proficiency.STONEWORK,
                        Rarity.UNIQUE,
                        itemSetManager.getItemSetByID(IdSets.GOTHMOGS_BREATH),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 4)
                                .addFlag(ConfigurationFlag.LOOT, 4)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 65)
                                .create()
                )
        );

        return result;
    }
}
