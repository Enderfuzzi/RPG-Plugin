package com.falgael.rpg.definitions.hunting.items.basics;

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
                        40000,
                        "Hunter Sword I",
                        Material.WOODEN_SWORD,
                        Proficiency.HUNTING,
                        Rarity.SIMPLE,
                        "Simple hunter tool",
                        itemSetManager.getItemSetbyID(4000),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE,1)
                                .addFlag(ConfigurationFlag.LOOT, 0.5)
                                .addPotionEffect(PotionEffectType.INCREASE_DAMAGE)
                                .create()
                ) {
                    @Override
                    public boolean isWeapon() {
                        return true;
                    }
                }
        );

        result.add(
                new Item(
                        40001,
                        "Hunter Helmet I",
                        Material.LEATHER_HELMET,
                        Proficiency.HUNTING,
                        Rarity.SIMPLE,
                        "Simple hunter protection",
                        itemSetManager.getItemSetbyID(4000),
                        new ItemConfiguration.Builder(EquipmentSlot.HEAD).create()
                )
        );

        result.add(
                new Item(
                        40002,
                        "Hunter Chestplate I",
                        Material.LEATHER_CHESTPLATE,
                        Proficiency.HUNTING,
                        Rarity.SIMPLE,
                        "Simple hunter protection",
                        itemSetManager.getItemSetbyID(4000),
                        new ItemConfiguration.Builder(EquipmentSlot.CHEST).create()
                )
        );

        result.add(
                new Item(
                        40003,
                        "Hunter Leggings I",
                        Material.LEATHER_LEGGINGS,
                        Proficiency.HUNTING,
                        Rarity.SIMPLE,
                        "Simple hunter protection",
                        itemSetManager.getItemSetbyID(4000),
                        new ItemConfiguration.Builder(EquipmentSlot.LEGS).create()
                )
        );

        result.add(
                new Item(
                        40004,
                        "Hunter Boots I",
                        Material.LEATHER_BOOTS,
                        Proficiency.HUNTING,
                        Rarity.SIMPLE,
                        "Simple hunter protection",
                        itemSetManager.getItemSetbyID(4000),
                        new ItemConfiguration.Builder(EquipmentSlot.FEET).create()
                )
        );


        return result;
    }
}