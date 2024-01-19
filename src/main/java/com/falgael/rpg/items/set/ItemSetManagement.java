package com.falgael.rpg.items.set;


import java.util.Set;

public interface ItemSetManagement {

    DefaultItemSet getItemSetByID(int id);

    DefaultItemSet getItemSetByKey(String key);

    DefaultItemSet getItemSetByName(String name);

    Set<String> getRegisteredKeys();

}
