package com.falgael.rpg.items;

import com.falgael.rpg.definitions.hunting.items.Narsil;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.items.set.ItemSetManagement;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ItemManager implements ItemManagement{

    private final Item DEFAULT_ITEM;

    private HashMap<String, DefaultItem> items;

    private List<ItemDefinition> registeredClasses;


    public ItemManager(@NotNull ItemSetManagement itemSetManager) {
        items = new HashMap<>();
        registeredClasses = new ArrayList<>();
        DEFAULT_ITEM = new Item(
                0,
                "",
                Material.AIR,
                Proficiency.NONE,
                Rarity.NONE,
                "",
                itemSetManager.getItemSetByID(0),
                new ItemConfiguration.Builder().create()
        ) {
            @Override
            public boolean isDefault() {
                return true;
            }
        };

        registeredClasses(itemSetManager);
        init();
    }

    private void registeredClasses(ItemSetManagement itemSetManager) {
        //Misc
        registerItemClass(new com.falgael.rpg.definitions.misc.items.Currency(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.misc.items.Statistics(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.misc.items.WeatherController(itemSetManager));

        registerItemClass(new com.falgael.rpg.definitions.misc.items.KingMidas(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.misc.items.Jewels(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.misc.items.Rockets(itemSetManager));

        //Woodwork
        registerItemClass(new com.falgael.rpg.definitions.woodwork.items.basics.SimpleItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.woodwork.items.basics.CommonItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.woodwork.items.basics.AdvancedItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.woodwork.items.basics.EliteItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.woodwork.items.basics.EpicItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.woodwork.items.basics.LegendaryItems(itemSetManager));
        //Stonework
        registerItemClass(new com.falgael.rpg.definitions.stonework.items.basics.SimpleItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.stonework.items.basics.CommonItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.stonework.items.basics.AdvancedItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.stonework.items.basics.EliteItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.stonework.items.basics.EpicItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.stonework.items.basics.LegendaryItems(itemSetManager));

        registerItemClass(new com.falgael.rpg.definitions.stonework.items.InfinitiveFuel(itemSetManager));
        //Farming
        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.SimpleItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.CommonItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.AdvancedItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.EliteItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.EpicItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.LegendaryItems(itemSetManager));

        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.tools.FishingRods(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.farming.items.basics.tools.Shears(itemSetManager));

        registerItemClass(new com.falgael.rpg.definitions.farming.items.Baker(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.farming.items.Butcher(itemSetManager));
        //Hunting
        registerItemClass(new com.falgael.rpg.definitions.hunting.items.basics.SimpleItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.hunting.items.basics.CommonItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.hunting.items.basics.AdvancedItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.hunting.items.basics.EliteItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.hunting.items.basics.EpicItems(itemSetManager));
        registerItemClass(new com.falgael.rpg.definitions.hunting.items.basics.LegendaryItems(itemSetManager));

        registerItemClass(new Narsil(itemSetManager));

    }

    private void init() {
        registeredClasses.forEach(c -> c.getItems().forEach(i -> {
                    if (items.put(i.getKey(), i) != null) {
                        Bukkit.getLogger().warning("Multiple Keys detected: " + i.getKey());
                    } else {
                        Bukkit.getLogger().info("Registered item: " + i.getKey() + " set=" + i.getEquipmentSet().getName());
                    }
                }
            )
        );
    }


    private void registerItemClass(ItemDefinition itemDefinition) {
        registeredClasses.add(itemDefinition);
    }


    @Override
    public DefaultItem getItemByKey(ItemStack item) {
        if (item == null) return DEFAULT_ITEM;
        if (!item.hasItemMeta()) return DEFAULT_ITEM;
        ItemMeta meta = item.getItemMeta();
        if (!meta.isUnbreakable()) return DEFAULT_ITEM;
        if (!meta.hasDisplayName()) return DEFAULT_ITEM;
        return getItemByKey(
                ChatColor.stripColor(meta.getDisplayName()).replace(" ", "_").toLowerCase()
                        + "_"
                        + item.getType().toString().toLowerCase());
    }


    public DefaultItem getItemByKey(String key) {
        return items.getOrDefault(key, DEFAULT_ITEM);
    }

    @Override
    public DefaultItem getItemByID(int id) {
        for (DefaultItem current : items.values()) {
            if (current.getId() == id) return current;
        }
        return DEFAULT_ITEM;
    }


    @Override
    public DefaultItem getDefault() {
        return DEFAULT_ITEM;
    }


    @Override
    public Set<String> getRegisteredKeys() {
        return items.keySet();
    }

    @Override
    public List<DefaultItem> getItemsOfSet(DefaultItemSet set) {
        List<DefaultItem> result = new ArrayList<>();
        items.values().forEach(i -> {
            if (i.getEquipmentSet().equals(set)) result.add(i);
        });

        return result;
    }
}
