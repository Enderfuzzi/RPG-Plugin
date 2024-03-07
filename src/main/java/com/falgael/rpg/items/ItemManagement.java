package com.falgael.rpg.items;

import com.falgael.rpg.items.identification.ID;
import com.falgael.rpg.items.set.DefaultItemSet;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Set;

public interface ItemManagement {

    DefaultItem getItemByKey(ItemStack item);

    DefaultItem getItemByKey(String key);

    DefaultItem getItemByID(int id);

    default DefaultItem getItemByID(ID id) {
        return getItemByID(id.getId());
    }

    DefaultItem getDefault();

    Set<String> getRegisteredKeys();

    List<DefaultItem> getItemsOfSet(DefaultItemSet set);

}
