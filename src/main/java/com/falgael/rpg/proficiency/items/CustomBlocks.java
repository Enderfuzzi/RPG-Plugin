package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.items.ItemBuilder;
import com.falgael.rpg.proficiency.ProficiencyTypes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum CustomBlocks {

    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------
    WOODWORK_COMPRESSED_OAK(ProficiencyTypes.WOODWORK, new ItemBuilder(Material.OAK_WOOD).addProficiency(ProficiencyTypes.WOODWORK).setCompressed(true).create()),



    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------
    STONEWORK_COMPRESSED_STONE(ProficiencyTypes.STONEWORK, new ItemBuilder(Material.STONE).addProficiency(ProficiencyTypes.STONEWORK).setCompressed(true).create())

    ;

    private final ItemStack itemStack;

    private final ProficiencyTypes type;

    CustomBlocks(ProficiencyTypes type, ItemStack itemStack) {
        this.type = type;
        this.itemStack = itemStack;
    }

    public ItemStack getItem() {
        return itemStack;
    }

    public ProficiencyTypes getType() {
        return type;
    }


}
