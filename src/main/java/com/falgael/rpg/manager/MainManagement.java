package com.falgael.rpg.manager;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.villager.VillagerManagement;

public interface MainManagement {

    ProficiencyCalculationAdapter getProficiencyAdapter();

    ItemManagement getItemAdapter();

    VillagerManagement getVillagerAdapter();





}
