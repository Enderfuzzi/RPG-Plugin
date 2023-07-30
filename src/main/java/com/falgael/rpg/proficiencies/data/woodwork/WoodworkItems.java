package com.falgael.rpg.proficiencies.data.woodwork;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.items.ItemConfiguration;
import com.falgael.rpg.proficiencies.templates.ProficiencyItems;
import com.falgael.rpg.utility.items.ItemCreation;
import com.falgael.rpg.utility.items.ItemInformation;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * Contains all items by the Woodwork proficiency.
 * Note the storage of all items is contained in {@link com.falgael.rpg.proficiencies.ProficiencyDataHolder}.
 */
public class WoodworkItems implements ProficiencyItems {
    /** local copy of items created by this class */
    private static final HashMap<ItemStack, ItemConfiguration> items  = fillItems();


    /**
     * Creates and fills {@link WoodworkItems#items}. Uses {@link ItemCreation#createItem(Material, String, String...)}
     * for item creation.
     * @return The list with all items
     */
    private static @NotNull HashMap<ItemStack,ItemConfiguration> fillItems() {
        HashMap<ItemStack, ItemConfiguration> result = new HashMap<>();
        result.put(ItemCreation.createAxe(Material.WOODEN_AXE,ItemInformation.SIMPLE_ITEM_COLOR + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME +
                                " Axe", 0.0, 0.5, 0.0, 0.0, ItemInformation.LOOT_MODIFIER_COLOR + "+50% More Wood","Simple tool for harvesting"),
                new ItemConfiguration("simple_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe", 1,1.5f));
        result.put(ItemCreation.createAxe(Material.STONE_AXE, ItemInformation.COMMON_ITEM_COLOR + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME +
                                " Axe", 0.1, 0.6, 0.0, 0.0,ItemInformation.LOOT_MODIFIER_COLOR + "+100% More Wood","Common tool for harvesting"),
                new ItemConfiguration("common_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",1,2.0f));
        result.put(ItemCreation.createAxe(Material.IRON_AXE, ItemInformation.ADVANCED_ITEM_COLOR + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME +
                                " Axe", 0.2, 0.7, 0.0, 0.0,ItemInformation.LOOT_MODIFIER_COLOR + "+150% More Wood",
                        ItemInformation.EXPERIENCE_MODIFIER_COLOR + "+100% Experience", "Advanced tool for Harvesting"),
                new ItemConfiguration("advanced_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",2,2.5f));
        result.put(ItemCreation.createAxe(Material.GOLDEN_AXE, ItemInformation.RARE_ITEM_COLOR + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME +
                                " Axe", 0.3, 0.9,0.0, 0.0,ItemInformation.LOOT_MODIFIER_COLOR + "+200% More Wood",
                        ItemInformation.EXPERIENCE_MODIFIER_COLOR + "+100% Experience", "Forged in the depth"),
                new ItemConfiguration("rare_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",2,3.0f));
        result.put(ItemCreation.createAxe(Material.DIAMOND_AXE, ItemInformation.EPIC_ITEM_COLOR + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME +
                                " Axe", 0.5, 1.0,0.0, 0.0,ItemInformation.LOOT_MODIFIER_COLOR + "+350% More Wood",
                        ItemInformation.EXPERIENCE_MODIFIER_COLOR + "+200% Experience", "Forged to provide huge","bonuses for harvesting"),
                new ItemConfiguration("epic_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",3,4.5f));
        result.put(ItemCreation.createAxe(Material.NETHERITE_AXE, ItemInformation.LEGENDARY_ITEM_COLOR + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME +
                        " Axe", 1.0, 1.5,0.2, 0.2,ItemInformation.LOOT_MODIFIER_COLOR + "+500% More Wood",
                    ItemInformation.EXPERIENCE_MODIFIER_COLOR + "+400% Experience", "Crafted by the Gods", "providing the greatest enhancements"),
                new ItemConfiguration("legendary_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",5,6.0f));
        return result;
    }
    /**
     * Returns the local non-modifiable copy of {@link com.falgael.rpg.proficiencies.data.woodwork.WoodworkItems#items}
     */
    public static HashMap<ItemStack, ItemConfiguration> getItems() {
        return items;
    }
}
