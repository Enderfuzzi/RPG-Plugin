package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootComputation;
import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.event.Listener;

public class MainHandler implements Listener {

    protected ProficiencyExperienceCalculation proficiencyAdapter;

    protected ItemManagement itemAdapter;

    protected VillagerManagement villagerAdapter;

    protected LootComputation lootComputation;

    protected MainHandler(MainManagement mainManager) {
        this.proficiencyAdapter = mainManager.getPExperienceCalculator();
        this.itemAdapter = mainManager.getItemAdapter();
        this.villagerAdapter = mainManager.getVillagerAdapter();
        this.lootComputation = mainManager.getLootComputation();
    }



}
