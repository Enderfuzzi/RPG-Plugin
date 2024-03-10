package com.falgael.rpg.nousage;

import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.configuration.PredicateConsumer;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.old.ItemBuilder;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import com.falgael.rpg.old.OLDItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Deprecated
public class CustomItems {

    private static final String FILE_NAME = "items";
    private static final ItemKey DEFAULT_KEY = new ItemKey(Material.AIR, "");
    private static final CustomItem DEFAULT_ITEM = new CustomItem(
            new ItemStack(Material.AIR),
            new ItemConfiguration.Builder().create()
    );


    public static HashMap<ItemKey,CustomItem> items;
    static {
        items = new HashMap<>();
        items.put(DEFAULT_KEY, DEFAULT_ITEM);
    }



    public static void load(ConfigurationLoading loader) {
        FileConfiguration configuration = loader.getConfig(FILE_NAME);

        for (String sectionKey : configuration.getKeys(false)) {
            Material material = Material.valueOf(configuration.getString(sectionKey + ".material"));
            String name =  configuration.getString(sectionKey + ".name");
            ItemKey key = new ItemKey(material, name);

            HashMap<ConfigurationFlag, Double> config = new HashMap<>();
            for (String subSectionKey : configuration
                    .getConfigurationSection(sectionKey + ".configuration")
                    .getKeys(false)) {
                ConfigurationFlag configurationKey = null;
                try {
                    configurationKey = ConfigurationFlag.valueOf(subSectionKey.toUpperCase());
                } catch (IllegalArgumentException e) {
                    continue;
                }
                config.put(
                        configurationKey,
                        configuration.getDouble(sectionKey + ".configuration." + subSectionKey)
                );
            }

            List<EquipmentSlot> slots = new ArrayList<>();
            configuration.getStringList(sectionKey + ".equipment_slots").forEach(e -> slots.add(EquipmentSlot.valueOf(e)));


            HashMap<PotionEffectType, Integer> potions = new HashMap<>();
            for (String subSectionKey : configuration
                    .getConfigurationSection(sectionKey + ".potions")
                    .getKeys(false)) {
                PotionEffectType potionKey = PotionEffectType.getByName(subSectionKey.toUpperCase());
                if (potionKey == null) continue;

                potions.put(
                        potionKey,
                        configuration.getInt(sectionKey + ".potions." + subSectionKey)
                );
            }

            PredicateConsumer<Event, ProficiencyExperienceCalculation> action = null;
            for (Map.Entry<ConfigurationFlag, Double> entry: config.entrySet()) {
                /*
                if (entry.getKey().getAction(entry.getValue()) != null) {
                    action = entry.getKey().getAction(entry.getValue());
                }
                 */
            }

            ItemConfiguration RPGConfiguration = new ItemConfiguration.Builder(slots)
                    .addFlags(config)
                    .addPotionEffect(potions)
                    .addAction(action)
                    .create();

            CustomItem item = new CustomItem(
                    new ItemBuilder(material)
                            .setName(name)
                            .setRarity(Rarity.valueOf(configuration.getString(sectionKey + ".name")))
                            .addProficiency(Proficiency.translate(configuration.getStringList(sectionKey + ".proficiency")))
                            .addLore(configuration.getStringList(sectionKey + ".lore"))
                            .setEquipmentSet(OLDItemSet.valueOf(configuration.getString(sectionKey + ".equipment_set")))
                            .setConfiguration(RPGConfiguration)
                            .create(),
                    RPGConfiguration
            );

            items.put(key,item);
        }


    }



    public static void reload() {

    }


    private static ItemKey buildItemKey(ItemStack item) {
        if (item == null) return DEFAULT_KEY;
        if (!item.hasItemMeta()) return DEFAULT_KEY;
        ItemMeta itemMeta = item.getItemMeta();
        if (!itemMeta.hasDisplayName()) return DEFAULT_KEY;
        return new ItemKey(item.getType(), itemMeta.getDisplayName());
    }

    public static ItemStack getItem(Material material, String name) {
        return items.get(new ItemKey(material, name)).item();
    }

    public static ItemConfiguration getConfiguration(ItemStack item) {
        return items.get(buildItemKey(item)).configuration();
    }
}

@Deprecated
record ItemKey(Material material, String name) {
}
@Deprecated
record CustomItem(ItemStack item, ItemConfiguration configuration) {
}