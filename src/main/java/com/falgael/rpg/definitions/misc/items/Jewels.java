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
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Jewels extends MainItemDefinition {
    public Jewels(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        List<DefaultItem> result = new ArrayList<>();

        result.add(
                new Item(
                        90200,
                        "Sea Brain",
                        Material.HEART_OF_THE_SEA,
                        Proficiency.MISC,
                        Rarity.EPIC,
                        "Used to build Atlantis",
                        itemSetManager.getItemSetByID(0),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .addPotionEffect(PotionEffectType.CONDUIT_POWER,2)
                                .addPotionEffect(PotionEffectType.DOLPHINS_GRACE)
                                .create()
                )
        );


        result.add(
                new Item(
                        90201,
                        "Tear of Speed I",
                        Material.GHAST_TEAR,
                        Proficiency.MISC,
                        Rarity.COMMON,
                        itemSetManager.getItemSetByID(0),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                //.addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 15)
                                .addPotionEffect(PotionEffectType.SPEED)
                                .create()
                )
        );

        result.add(
                new Item(
                        90202,
                        "Tear of Speed II",
                        Material.GHAST_TEAR,
                        Proficiency.MISC,
                        Rarity.ELITE,
                        itemSetManager.getItemSetByID(0),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND, EquipmentSlot.OFF_HAND)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                //.addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 25)
                                .addPotionEffect(PotionEffectType.SPEED, 1)
                                .create()
                )
        );

        return result;
    }
}
