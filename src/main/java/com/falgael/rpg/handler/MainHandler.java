package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.event.Listener;

public class MainHandler implements Listener {

    protected ProficiencyCalculationAdapter proficiencyAdapter;

    protected ItemManagement itemAdapter;

    protected VillagerManagement villagerAdapter;

    protected MainHandler(MainManagement mainManager) {
        this.proficiencyAdapter = mainManager.getProficiencyAdapter();
        this.itemAdapter = mainManager.getItemAdapter();
        this.villagerAdapter = mainManager.getVillagerAdapter();
    }



}
