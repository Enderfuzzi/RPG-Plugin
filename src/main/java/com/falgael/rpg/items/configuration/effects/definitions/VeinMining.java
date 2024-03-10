package com.falgael.rpg.items.configuration.effects.definitions;

import com.falgael.rpg.definitions.stats.BlockStats;
import com.falgael.rpg.items.configuration.effects.IntAction;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import org.bukkit.event.Event;

public class VeinMining extends IntAction {


    public VeinMining(int value) {
        super(value);
    }

    @Override
    public boolean execute(Event e, ProficiencyExperienceCalculation proficiencyExperienceCalculation) {
        return veinHarvest(e, proficiencyExperienceCalculation, value, (start, current) -> {
            BlockStats startBlock = BlockStats.getBlock(start.getType());
            BlockStats currentBlock = BlockStats.getBlock(current.getType());

            if (startBlock.isNone() || currentBlock.isNone()) return false;
            if (!startBlock.veinMining() || !currentBlock.veinMining()) return false;
            if (start.getType() != current.getType()) return false;
            return true;
        });
    }


}
