package com.falgael.rpg.definitions.misc.items;

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

public class LootBox extends MainItemDefinition {
    public LootBox(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        ArrayList<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        90400,
                        "Loot Shell",
                        Material.HEART_OF_THE_SEA,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .addAction(new com.falgael.rpg.items.configuration.effects.definitions.LootBox())
                                .create()
                ) {
                    @Override
                    public boolean isLootBox() {
                        return true;
                    }
                }
        );

        return result;
    }
}
