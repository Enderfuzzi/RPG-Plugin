package com.falgael.rpg.manager;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootComputation;
import com.falgael.rpg.villager.VillagerManagement;

public interface MainManagement {

    ProficiencyExperienceCalculation getPExperienceCalculator();

    ItemManagement getItemAdapter();

    VillagerManagement getVillagerAdapter();

    LootComputation getLootComputation();

}
