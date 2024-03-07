package com.falgael.rpg.items.identification;

public enum IdItems implements ID{
    ;

    private final int id;

    IdItems(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
