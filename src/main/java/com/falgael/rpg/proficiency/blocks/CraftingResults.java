package com.falgael.rpg.proficiency.blocks;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public enum CraftingResults {

    NONE(ProficiencyType.NONE,new ItemStack(Material.AIR),0, InventoryType.CREATIVE),

    OAK_PLANKS(ProficiencyType.WOODWORK,new ItemStack(Material.OAK_PLANKS),4,InventoryType.WORKBENCH),

    ;


    private final ProficiencyType type;
    private final ItemStack result;
    private final long experienceAmount;

    private final InventoryType inventoryType;

    CraftingResults(ProficiencyType type, ItemStack result, long experienceAmount, InventoryType inventoryType) {
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

    public ProficiencyType getType() {
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
