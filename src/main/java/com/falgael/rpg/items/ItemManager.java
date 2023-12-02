package com.falgael.rpg.items;

import com.falgael.rpg.definitions.misc.items.Currency;
import com.falgael.rpg.definitions.misc.items.Statistics;
import com.falgael.rpg.definitions.woodwork.items.*;
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
                itemSetManager.getItemSetbyID(0),
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
        registerItemClass(new Currency(itemSetManager));
        registerItemClass(new Statistics(itemSetManager));
        //Woodwork
        registerItemClass(new SimpleItems(itemSetManager));
        registerItemClass(new CommonItems(itemSetManager));
        registerItemClass(new AdvancedItems(itemSetManager));
        registerItemClass(new EliteItems(itemSetManager));
        registerItemClass(new EpicItems(itemSetManager));
        registerItemClass(new LegendaryItems(itemSetManager));
        //Stonework

        //Farming

        //Hunting

    }

    private void init() {
        registeredClasses.forEach(c -> c.getItems().forEach(i -> {
                    items.put(i.getKey(), i);
                    Bukkit.getLogger().info("Registered: " + i.getKey() + " with set " + i.getEquipmentSet().getName());
                }
            )
        );
    }


    private void registerItemClass(ItemDefinition itemDefinition) {
        registeredClasses.add(itemDefinition);
    }


    @Override
    public DefaultItem getItem(ItemStack item) {
        if (item == null) return DEFAULT_ITEM;
        if (!item.hasItemMeta()) return DEFAULT_ITEM;
        ItemMeta meta = item.getItemMeta();
        if (!meta.isUnbreakable()) return DEFAULT_ITEM;
        if (!meta.hasDisplayName()) return DEFAULT_ITEM;
        return getItem(
                item.getType().toString().toLowerCase()
                        + "_"
                        + ChatColor.stripColor(meta.getDisplayName()).replace(" ", "_").toLowerCase());
    }


    public DefaultItem getItem(String key) {
        return items.getOrDefault(key, DEFAULT_ITEM);
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
