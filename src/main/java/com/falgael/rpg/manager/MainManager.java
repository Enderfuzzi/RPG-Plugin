package com.falgael.rpg.manager;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.loottable.LootComputation;
import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import com.falgael.rpg.villager.VillagerManagement;


public record MainManager(
        ProficiencyExperienceCalculation pExperienceCalculator,
        ItemManagement itemAdapter,
        VillagerManagement villagerAdapter,
        LootComputation lootComputation
) implements MainManagement {
    @Override
    public ProficiencyExperienceCalculation getPExperienceCalculator() {
        return pExperienceCalculator;
    }

    @Override
    public ItemManagement getItemAdapter() {
        return itemAdapter;
    }

    @Override
    public VillagerManagement getVillagerAdapter() {
        return villagerAdapter;
    }
    @Override
    public LootComputation getLootComputation() {
        return lootComputation;
    }
}
/*
public class MainManager implements MainManagement {
    private final ProficiencyExperienceCalculation pExperienceCalculator;

    private final ItemManagement itemAdapter;

    private final VillagerManagement villagerAdapter;


    public MainManager(
            ProficiencyExperienceCalculation PExperienceCalculator,
            ItemManagement itemAdapter,
            VillagerManagement villagerAdapter,
    ) {
        this.pExperienceCalculator = PExperienceCalculator;
        this.itemAdapter = itemAdapter;
        this.villagerAdapter = villagerAdapter;
    }

    @Override
    public ProficiencyExperienceCalculation getPExperienceCalculator() {
        return pExperienceCalculator;
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


 */