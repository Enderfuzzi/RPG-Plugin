package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.definitions.stats.BlockStats;
import com.falgael.rpg.items.configuration.effects.IntAction;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.event.Event;

public class TreeHarvest extends IntAction {
    public TreeHarvest(int value) {
        super(value);
    }

    @Override
    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyExperienceCalculation) {
        return veinHarvest(e, proficiencyExperienceCalculation, value, (start, current) -> {
            BlockStats startBlock = BlockStats.getBlock(start.getType());
            BlockStats currentBlock = BlockStats.getBlock(current.getType());

            if (startBlock.isNone() || currentBlock.isNone()) return false;
            if (!startBlock.hasWoodType() || !currentBlock.hasWoodType()) return false;
            if (startBlock.getWoodType() != currentBlock.getWoodType()) return false;
            return true;
        });
    }
}
