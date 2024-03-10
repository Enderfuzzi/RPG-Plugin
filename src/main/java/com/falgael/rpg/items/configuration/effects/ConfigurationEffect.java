package com.falgael.rpg.items.configuration.effects;

import com.falgael.rpg.items.ItemDrop;
import org.bukkit.block.Block;
import org.bukkit.event.Event;

public interface ConfigurationEffect<E extends Event, V> extends ItemDrop {
    default boolean execute(E event, V v) {
        return false;
    }


    interface Predicate {
        boolean accept(Block start, Block current);
    }




}
