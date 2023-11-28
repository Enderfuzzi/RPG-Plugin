package com.falgael.rpg.items.set;


import java.util.Set;

public interface ItemSetManagement {

    DefaultItemSet getItemSetbyID(int id);

    DefaultItemSet getItemSet(String key);

    DefaultItemSet getItemSetByName(String name);

    Set<String> getRegisteredKeys();

}
