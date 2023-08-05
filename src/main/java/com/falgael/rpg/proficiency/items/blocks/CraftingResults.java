package com.falgael.rpg.proficiency.items.blocks;

import com.falgael.rpg.proficiency.ProficiencyTypes;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public enum CraftingResults {

    NONE(ProficiencyTypes.NONE,new ItemStack(Material.AIR),0, InventoryType.CREATIVE),

    OAK_PLANKS(ProficiencyTypes.WOODWORK,new ItemStack(Material.OAK_PLANKS),4,InventoryType.WORKBENCH),

    ;


    private final ProficiencyTypes type;
    private final ItemStack result;
    private final long experienceAmount;

    private final InventoryType inventoryType;

    CraftingResults(ProficiencyTypes type, ItemStack result, long experienceAmount, InventoryType inventoryType) {
        this.type = type;
        this.result = result;
        this.experienceAmount = experienceAmount;
        this.inventoryType = inventoryType;
    }

    public static CraftingResults getResult(ItemStack toCheck) {
        for (CraftingResults craftingResult : CraftingResults.values()) {
            if (craftingResult.result.isSimilar(toCheck)) return craftingResult;
        }
        return NONE;
    }

    public ProficiencyTypes getType() {
        return type;
    }

    public boolean isNone() {
        return this == NONE;
    }

    public ItemStack getItem() {
        return result;
    }

    public long getExperienceAmount() {
        return experienceAmount;
    }

    public InventoryType getInventoryType() {
        return inventoryType;
    }
}
