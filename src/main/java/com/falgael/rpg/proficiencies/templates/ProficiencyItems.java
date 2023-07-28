package com.falgael.rpg.proficiencies.templates;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.items.ItemConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Unsure about usability. Currently not used.
 * @author falgael
 * @version 0.0.1
 */
public interface ProficiencyItems {

    default void registerProficiencyItems(String key, HashMap<ItemStack, ItemConfiguration> items) {
        ProficiencyDataHolder.addItemsToAllProficiencies(key,items);
    }

}
