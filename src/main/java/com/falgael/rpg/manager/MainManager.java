package com.falgael.rpg.manager;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.villager.VillagerManagement;

public class MainManager implements MainManagement {
    private final ProficiencyCalculationAdapter proficiencyAdapter;

    private final ItemManagement itemAdapter;

    private final VillagerManagement villagerAdapter;


    public MainManager(
            ProficiencyCalculationAdapter proficiencyAdapter,
            ItemManagement itemAdapter,
            VillagerManagement villagerAdapter
    ) {
        this.proficiencyAdapter = proficiencyAdapter;
        this.itemAdapter = itemAdapter;
        this.villagerAdapter = villagerAdapter;
    }

    @Override
    public ProficiencyCalculationAdapter getProficiencyAdapter() {
        return proficiencyAdapter;
    }

    @Override
    public ItemManagement getItemAdapter() {
        return itemAdapter;
    }

    @Override
    public VillagerManagement getVillagerAdapter() {
        return villagerAdapter;
    }
}
