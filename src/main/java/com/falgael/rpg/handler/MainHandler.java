package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.event.Listener;

public class MainHandler implements Listener {

    protected ProficiencyCalculationAdapter proficiencyAdapter;

    protected ItemManagement itemAdapter;

    protected VillagerManagement villagerAdapter;

    protected MainHandler(ProficiencyCalculationAdapter proficiencyAdapter, ItemManagement itemAdapter, VillagerManagement villagerAdapter) {
        this.proficiencyAdapter = proficiencyAdapter;
        this.itemAdapter = itemAdapter;
        this.villagerAdapter = villagerAdapter;
    }



}
