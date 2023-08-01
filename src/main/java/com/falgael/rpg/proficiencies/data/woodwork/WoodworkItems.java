package com.falgael.rpg.proficiencies.data.woodwork;

import com.falgael.rpg.proficiencies.ProficiencyDataHolder;
import com.falgael.rpg.proficiencies.items.ItemConfiguration;
import com.falgael.rpg.proficiencies.templates.ProficiencyItems;
import com.falgael.rpg.utility.items.ItemFactory;
import com.falgael.rpg.utility.items.ItemType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;


/**
 * Contains all items by the Woodwork proficiency.
 * Note the storage of all items is contained in {@link com.falgael.rpg.proficiencies.ProficiencyDataHolder}.
 */
public class WoodworkItems implements ProficiencyItems {

    /** local copy of items created by this class */
    private static HashMap<ItemStack, ItemConfiguration> itemConfiguration = new HashMap<>();

    public static final ItemStack COMPRESSED_WOOD = new ItemFactory(Material.OAK_WOOD).setName("Compressed Oak").setCompressed(true).crate();

    public static ItemStack SIMPLE_AXE = new ItemFactory(Material.WOODEN_AXE).setType(ItemType.SIMPLE).setName("Axe")
            .addPrefix(ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME).addLootModifierLore("+50% More Wood").addLore("Simple tool for harvesting")
            .addDamageAttribute(0.5).crate();

    public static ItemStack COMMON_AXE = new ItemFactory(Material.STONE_AXE).setType(ItemType.COMMON).setName("Axe")
            .addPrefix(ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME).addLootModifierLore("+100% More Wood").addLore("Common tool for harvesting").addSpeedAttribute(0.1)
            .addDamageAttribute(0.6).crate();

    public static ItemStack ADVANCED_AXE = new ItemFactory(Material.IRON_AXE).setType(ItemType.ADVANCED).setName("Axe")
            .addPrefix(ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME).addLootModifierLore("+150% More Wood").addExperienceModifierLore("100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.2).addDamageAttribute(0.7).crate();

    public static ItemStack RARE_AXE = new ItemFactory(Material.GOLDEN_AXE).setType(ItemType.RARE).setName("Axe")
            .addPrefix(ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME).addLootModifierLore("+200% More Wood").addExperienceModifierLore("100% Experience")
            .addLore("Advanced tool for harvesting").addSpeedAttribute(0.3).addDamageAttribute(0.9).crate();

    public static ItemStack EPIC_AXE = new ItemFactory(Material.DIAMOND_AXE).setType(ItemType.EPIC).setName("Axe")
            .addPrefix(ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME).addLootModifierLore("+350% More Wood").addExperienceModifierLore("200% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(0.5).addDamageAttribute(1).crate();

    public static ItemStack LEGENDARY_AXE = new ItemFactory(Material.NETHERITE_AXE).setType(ItemType.LEGENDARY).setName("Axe")
            .addPrefix(ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME).addLootModifierLore("+600% More Wood").addExperienceModifierLore("500% Experience")
            .addLore("Forged in the depth").addSpeedAttribute(1.0).addDamageAttribute(1.5)
            .addHealthAttribute(0.2).addArmorAttribute(0.2).crate();


    public static void generateConfiguration() {
        itemConfiguration.put(SIMPLE_AXE, new ItemConfiguration("simple_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe", 1,1.5f));
        itemConfiguration.put(COMMON_AXE, new ItemConfiguration("common_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",1,2.0f));
        itemConfiguration.put(ADVANCED_AXE, new ItemConfiguration("advanced_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",2,2.5f));
        itemConfiguration.put(RARE_AXE, new ItemConfiguration("rare_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",2,3.0f));
        itemConfiguration.put(EPIC_AXE, new ItemConfiguration("epic_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",3,4.5f));
        itemConfiguration.put(LEGENDARY_AXE, new ItemConfiguration("legendary_" + ProficiencyDataHolder.WOODWORK_PROFICIENCY_NAME + "_axe",5,6.0f));

        itemConfiguration.put(COMPRESSED_WOOD,new ItemConfiguration());

    }

    /**
     * Returns the local non-modifiable copy of {@link com.falgael.rpg.proficiencies.data.woodwork.WoodworkItems#itemConfiguration}
     */
    public static HashMap<ItemStack, ItemConfiguration> getItems() {
        return itemConfiguration;
    }
}
