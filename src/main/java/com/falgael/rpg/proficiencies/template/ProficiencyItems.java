package com.falgael.rpg.proficiencies.template;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Unsure about usability. Currently not used.
 * @author falgael
 * @version 0.0.1
 */
public interface ProficiencyItems {

    public default void registerProficiencyItems(String key, ArrayList<ItemStack> items) {
        ProficiencyDataHolder.addItemsToAllProficiencies(key,items);
    };

}
