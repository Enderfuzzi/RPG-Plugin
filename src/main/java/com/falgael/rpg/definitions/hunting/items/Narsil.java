package com.falgael.rpg.definitions.hunting.items;

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

public class Narsil extends MainItemDefinition {
    public Narsil(ItemSetManagement itemSetManager) {
        super(itemSetManager);
    }

    @Override
    public List<DefaultItem> getItems() {
        ArrayList<DefaultItem> result = new ArrayList<>();
        result.add(
                new Item(
                        49000,
                        "Narsil",
                        Material.NETHERITE_SWORD,
                        Proficiency.HUNTING,
                        Rarity.UNIQUE,
                        "The red and white flame",
                        itemSetManager.getItemSetByID(IdSets.NONE),
                        new ItemConfiguration.Builder(EquipmentSlot.HAND)
                                .addFlag(ConfigurationFlag.EXPERIENCE, 6)
                                .addFlag(ConfigurationFlag.LOOT, 6)
                                .addFlag(ConfigurationFlag.DAMAGE_MULTIPLIER, 2)
                                .addFlag(ConfigurationFlag.LEVEL_REQUIREMENT, 75)
                                .addFlag(ConfigurationFlag.ENCHANTED)
                                .addPotionEffect(PotionEffectType.INCREASE_DAMAGE, 2)
                                .addPotionEffect(PotionEffectType.REGENERATION)
                                .addPotionEffect(PotionEffectType.ABSORPTION)

                                .create()
                )
        );
        return result;
    }
}
