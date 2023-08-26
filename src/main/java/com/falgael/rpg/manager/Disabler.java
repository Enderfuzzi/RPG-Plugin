package com.falgael.rpg.manager;

import com.falgael.rpg.proficiency.handler.ItemHeldHandler;

public class Disabler {


    public static void disable() {

        ItemHeldHandler.stopCheck();

    }

}
