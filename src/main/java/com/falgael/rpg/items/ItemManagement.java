package com.falgael.rpg.items;

import org.bukkit.inventory.ItemStack;

import java.util.Set;

public interface ItemManagement {

    DefaultItem getItem(ItemStack item);

    DefaultItem getItem(String key);

    DefaultItem getDefault();

    Set<String> getRegisteredKeys();

}
