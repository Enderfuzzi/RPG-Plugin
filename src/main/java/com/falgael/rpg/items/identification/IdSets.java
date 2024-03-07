package com.falgael.rpg.items.identification;

public enum IdSets implements ID {

    NONE(0),

    LUMBERJACK_I(1000),
    LUMBERJACK_II(1001),
    LUMBERJACK_III(1002),
    LUMBERJACK_IV(1003),
    LUMBERJACK_V(1004),
    LUMBERJACK_VI(1005),

    MINER_I(2000),
    MINER_II(2001),
    MINER_III(2002),
    MINER_IV(2003),
    MINER_V(2004),
    MINER_VI(2005),


    FARMER_I(3000),
    FARMER_II(3001),
    FARMER_III(3002),
    FARMER_IV(3003),
    FARMER_V(3004),
    FARMER_VI(3005),


    HUNTER_I(4000),
    HUNTER_II(4001),
    HUNTER_III(4002),
    HUNTER_IV(4003),
    HUNTER_V(4004),
    HUNTER_VI(4005),



    KING_MIDAS(9000),

    ;

    private final int id;

    IdSets(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
