package com.falgael.rpg.items.configuration;

public interface PredicateConsumer<T, V> {

    boolean accept(T t, V v);
}

