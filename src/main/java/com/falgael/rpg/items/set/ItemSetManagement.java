package com.falgael.rpg.items.set;


import com.falgael.rpg.items.identification.ID;

import java.util.Set;

public interface ItemSetManagement {

    DefaultItemSet getItemSetByID(int id);

    default DefaultItemSet getItemSetByID(ID id) {
        return getItemSetByID(id.getId());
    }

    DefaultItemSet getItemSetByKey(String key);

    DefaultItemSet getItemSetByName(String name);

    Set<String> getRegisteredKeys();

}
