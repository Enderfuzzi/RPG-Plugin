package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.manager.ProficiencyExperienceCalculation;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.event.Listener;

public class MainHandler implements Listener {

    protected ProficiencyExperienceCalculation proficiencyAdapter;

    protected ItemManagement itemAdapter;

    protected VillagerManagement villagerAdapter;

    protected MainHandler(MainManagement mainManager) {
        this.proficiencyAdapter = mainManager.getPExperienceCalculator();
        this.itemAdapter = mainManager.getItemAdapter();
        this.villagerAdapter = mainManager.getVillagerAdapter();
    }



}
