package com.falgael.rpg.items;

import org.bukkit.inventory.ItemStack;

public interface ItemManagement {

    DefaultItem getItem(ItemStack item);

    DefaultItem getDefault();

    boolean isDefault(DefaultItem item);


}
