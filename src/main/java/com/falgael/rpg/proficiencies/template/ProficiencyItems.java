package com.falgael.rpg.proficiencies.template;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public interface ProficiencyItems {

    public default void registerProficiencyItems(String key, ArrayList<ItemStack> items) {
        ProficiencyDataHolder.addItemsToAllProficiencies(key,items);
    };

}
