package com.falgael.rpg.items;

import com.falgael.rpg.woodwork.items.SimpleItems;
import com.falgael.rpg.items.configuration.ItemConfiguration;
import com.falgael.rpg.items.set.OLDItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ItemManager implements ItemManagement{

    private static final String DEFAULT_KEY = "AIR_NONE";

    private static final Item DEFAULT_ITEM = new Item(
            0,
      "",
      Material.AIR,
      Proficiency.NONE,
      Rarity.NONE,
      "",
      OLDItemSet.NONE,
      new ItemConfiguration.Builder().create()
    );

    private HashMap<String, DefaultItem> items;

    private List<ItemDefinition> registeredClasses;


    public ItemManager() {
        items = new HashMap<>();
        registeredClasses = new ArrayList<>();
        registeredClasses();
        init();
    }

    private void registeredClasses() {
        registerItemClass(new SimpleItems());
    }

    private void init() {
        registeredClasses.forEach(c -> c.getItems().forEach(i -> items.put(i.getKey(), i)));
    }


    private void registerItemClass(ItemDefinition itemDefinition) {
        registeredClasses.add(itemDefinition);
    }


    @Override
    public DefaultItem getItem(ItemStack item) {
        if (item == null) return DEFAULT_ITEM;
        if (!item.hasItemMeta()) return DEFAULT_ITEM;
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasDisplayName()) return DEFAULT_ITEM;
        return getItem(item.getType() + "_" + ChatColor.stripColor(meta.getDisplayName()).replace(" ", "_"));
    }


    public DefaultItem getItem(String key) {
        return items.getOrDefault(key, DEFAULT_ITEM);
    }


    @Override
    public DefaultItem getDefault() {
        return DEFAULT_ITEM;
    }

    @Override
    public boolean isDefault(DefaultItem item) {
        return item.equals(DEFAULT_ITEM);
    }

    @Override
    public Set<String> getRegisteredKeys() {
        return items.keySet();
    }
}
