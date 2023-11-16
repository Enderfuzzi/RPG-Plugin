package com.falgael.rpg.handler;

import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import org.bukkit.event.Listener;

public class MainHandler implements Listener {

    protected ProficiencyCalculationAdapter proficiencyAdapter;


    protected MainHandler(ProficiencyCalculationAdapter proficiencyAdapter) {
        this.proficiencyAdapter = proficiencyAdapter;
    }



}
