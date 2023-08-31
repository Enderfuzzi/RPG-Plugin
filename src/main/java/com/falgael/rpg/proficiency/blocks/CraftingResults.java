package com.falgael.rpg.proficiency.blocks;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public enum CraftingResults {

    NONE(ProficiencyType.NONE, Material.AIR,0, InventoryType.CREATIVE),

    //--------------------------------------------------------------------------------------------
    // WOODWORK
    //--------------------------------------------------------------------------------------------
    ACACIA_PLANKS(ProficiencyType.WOODWORK, Material.ACACIA_PLANKS, 4, InventoryType.WORKBENCH),
    ACACIA_SLAB(ProficiencyType.WOODWORK, Material.ACACIA_SLAB, 3, InventoryType.WORKBENCH),
    ACACIA_STAIRS(ProficiencyType.WOODWORK, Material.ACACIA_STAIRS,6, InventoryType.WORKBENCH),
    ACACIA_FENCE(ProficiencyType.WOODWORK, Material.ACACIA_FENCE,6, InventoryType.WORKBENCH),
    ACACIA_FENCE_GATE(ProficiencyType.WOODWORK, Material.ACACIA_FENCE_GATE,4, InventoryType.WORKBENCH),
    ACACIA_SIGN(ProficiencyType.WOODWORK, Material.ACACIA_SIGN,9, InventoryType.WORKBENCH),
    ACACIA_HANGING_SIGN(ProficiencyType.WOODWORK, Material.ACACIA_HANGING_SIGN,12, InventoryType.WORKBENCH),
    ACACIA_DOOR(ProficiencyType.WOODWORK, Material.ACACIA_DOOR,4, InventoryType.WORKBENCH),
    ACACIA_TRAPDOOR(ProficiencyType.WOODWORK, Material.ACACIA_TRAPDOOR,4, InventoryType.WORKBENCH),
    ACACIA_BUTTON(ProficiencyType.WOODWORK, Material.ACACIA_BUTTON,1, InventoryType.WORKBENCH),
    ACACIA_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.ACACIA_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    ACACIA_BOAT(ProficiencyType.WOODWORK, Material.ACACIA_BOAT,5, InventoryType.WORKBENCH),
    ACACIA_CHEST_BOAT(ProficiencyType.WOODWORK, Material.ACACIA_CHEST_BOAT,2, InventoryType.WORKBENCH),


    BAMBOO_PLANKS(ProficiencyType.WOODWORK, Material.BAMBOO_PLANKS,4, InventoryType.WORKBENCH),
    BAMBOO_SLAB(ProficiencyType.WOODWORK, Material.BAMBOO_SLAB,3, InventoryType.WORKBENCH),
    BAMBOO_STAIRS(ProficiencyType.WOODWORK, Material.BAMBOO_STAIRS,6, InventoryType.WORKBENCH),
    BAMBOO_FENCE(ProficiencyType.WOODWORK, Material.BAMBOO_FENCE,6, InventoryType.WORKBENCH),
    BAMBOO_FENCE_GATE(ProficiencyType.WOODWORK, Material.BAMBOO_FENCE_GATE,4, InventoryType.WORKBENCH),
    BAMBOO_SIGN(ProficiencyType.WOODWORK, Material.BAMBOO_SIGN,9, InventoryType.WORKBENCH),
    BAMBOO_HANGING_SIGN(ProficiencyType.WOODWORK, Material.BAMBOO_HANGING_SIGN,12, InventoryType.WORKBENCH),
    BAMBOO_DOOR(ProficiencyType.WOODWORK, Material.BAMBOO_DOOR,4, InventoryType.WORKBENCH),
    BAMBOO_TRAPDOOR(ProficiencyType.WOODWORK, Material.BAMBOO_TRAPDOOR,4, InventoryType.WORKBENCH),
    BAMBOO_BUTTON(ProficiencyType.WOODWORK, Material.BAMBOO_BUTTON,1, InventoryType.WORKBENCH),
    BAMBOO_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.BAMBOO_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    BAMBOO_MOSAIC(ProficiencyType.WOODWORK,Material.BAMBOO_MOSAIC,2, InventoryType.WORKBENCH),
    BAMBOO_MOSAIC_SLAB(ProficiencyType.WOODWORK,Material.BAMBOO_MOSAIC_SLAB,3, InventoryType.WORKBENCH),
    BAMBOO_MOSAIC_STAIRS(ProficiencyType.WOODWORK,Material.BAMBOO_MOSAIC_STAIRS,6, InventoryType.WORKBENCH),


    BIRCH_PLANKS(ProficiencyType.WOODWORK, Material.BIRCH_PLANKS,4,InventoryType.WORKBENCH),
    BIRCH_SLAB(ProficiencyType.WOODWORK, Material.BIRCH_SLAB,3, InventoryType.WORKBENCH),
    BIRCH_STAIRS(ProficiencyType.WOODWORK, Material.BIRCH_STAIRS,6, InventoryType.WORKBENCH),
    BIRCH_FENCE(ProficiencyType.WOODWORK, Material.BIRCH_FENCE,6, InventoryType.WORKBENCH),
    BIRCH_FENCE_GATE(ProficiencyType.WOODWORK, Material.BIRCH_FENCE_GATE,4, InventoryType.WORKBENCH),
    BIRCH_SIGN(ProficiencyType.WOODWORK, Material.BIRCH_SIGN,9, InventoryType.WORKBENCH),
    BIRCH_HANGING_SIGN(ProficiencyType.WOODWORK, Material.BIRCH_HANGING_SIGN,12, InventoryType.WORKBENCH),
    BIRCH_DOOR(ProficiencyType.WOODWORK, Material.BIRCH_DOOR,4, InventoryType.WORKBENCH),
    BIRCH_TRAPDOOR(ProficiencyType.WOODWORK, Material.BIRCH_TRAPDOOR,4, InventoryType.WORKBENCH),
    BIRCH_BUTTON(ProficiencyType.WOODWORK, Material.BIRCH_BUTTON,1, InventoryType.WORKBENCH),
    BIRCH_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.BIRCH_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    BIRCH_BOAT(ProficiencyType.WOODWORK, Material.BIRCH_BOAT,5, InventoryType.WORKBENCH),
    BIRCH_CHEST_BOAT(ProficiencyType.WOODWORK, Material.BIRCH_CHEST_BOAT,2, InventoryType.WORKBENCH),

    CHERRY_PLANKS(ProficiencyType.WOODWORK, Material.CHERRY_PLANKS, 4, InventoryType.WORKBENCH),
    CHERRY_SLAB(ProficiencyType.WOODWORK, Material.CHERRY_SLAB,3, InventoryType.WORKBENCH),
    CHERRY_STAIRS(ProficiencyType.WOODWORK, Material.CHERRY_STAIRS,6, InventoryType.WORKBENCH),
    CHERRY_FENCE(ProficiencyType.WOODWORK, Material.CHERRY_FENCE,6, InventoryType.WORKBENCH),
    CHERRY_FENCE_GATE(ProficiencyType.WOODWORK, Material.CHERRY_FENCE_GATE,4, InventoryType.WORKBENCH),
    CHERRY_SIGN(ProficiencyType.WOODWORK, Material.CHERRY_SIGN,9, InventoryType.WORKBENCH),
    CHERRY_HANGING_SIGN(ProficiencyType.WOODWORK, Material.CHERRY_HANGING_SIGN,12, InventoryType.WORKBENCH),
    CHERRY_DOOR(ProficiencyType.WOODWORK, Material.CHERRY_DOOR,4, InventoryType.WORKBENCH),
    CHERRY_TRAPDOOR(ProficiencyType.WOODWORK, Material.CHERRY_TRAPDOOR,4, InventoryType.WORKBENCH),
    CHERRY_BUTTON(ProficiencyType.WOODWORK, Material.CHERRY_BUTTON,1, InventoryType.WORKBENCH),
    CHERRY_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.CHERRY_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    CHERRY_BOAT(ProficiencyType.WOODWORK, Material.CHERRY_BOAT,5, InventoryType.WORKBENCH),
    CHERRY_CHEST_BOAT(ProficiencyType.WOODWORK, Material.CHERRY_CHEST_BOAT,2, InventoryType.WORKBENCH),

    CRIMSON_PLANKS(ProficiencyType.WOODWORK, Material.CRIMSON_PLANKS,4, InventoryType.WORKBENCH),
    CRIMSON_SLAB(ProficiencyType.WOODWORK, Material.CRIMSON_SLAB,3, InventoryType.WORKBENCH),
    CRIMSON_STAIRS(ProficiencyType.WOODWORK, Material.CRIMSON_STAIRS,6, InventoryType.WORKBENCH),
    CRIMSON_FENCE(ProficiencyType.WOODWORK, Material.CRIMSON_FENCE,6, InventoryType.WORKBENCH),
    CRIMSON_FENCE_GATE(ProficiencyType.WOODWORK, Material.CRIMSON_FENCE_GATE,4, InventoryType.WORKBENCH),
    CRIMSON_SIGN(ProficiencyType.WOODWORK, Material.CRIMSON_SIGN,9, InventoryType.WORKBENCH),
    CRIMSON_HANGING_SIGN(ProficiencyType.WOODWORK, Material.CRIMSON_HANGING_SIGN,12, InventoryType.WORKBENCH),
    CRIMSON_DOOR(ProficiencyType.WOODWORK, Material.CRIMSON_DOOR,4, InventoryType.WORKBENCH),
    CRIMSON_TRAPDOOR(ProficiencyType.WOODWORK, Material.CRIMSON_TRAPDOOR,4, InventoryType.WORKBENCH),
    CRIMSON_BUTTON(ProficiencyType.WOODWORK, Material.CRIMSON_BUTTON,5, InventoryType.WORKBENCH),
    CRIMSON_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.CRIMSON_PRESSURE_PLATE,2, InventoryType.WORKBENCH),


    DARK_OAK_PLANKS(ProficiencyType.WOODWORK, Material.DARK_OAK_PLANKS,4, InventoryType.WORKBENCH),
    DARK_OAK_SLAB(ProficiencyType.WOODWORK, Material.DARK_OAK_SLAB,3, InventoryType.WORKBENCH),
    DARK_OAK_STAIRS(ProficiencyType.WOODWORK, Material.DARK_OAK_STAIRS,6, InventoryType.WORKBENCH),
    DARK_OAK_FENCE(ProficiencyType.WOODWORK, Material.DARK_OAK_FENCE,6, InventoryType.WORKBENCH),
    DARK_OAK_FENCE_GATE(ProficiencyType.WOODWORK, Material.DARK_OAK_FENCE_GATE,4, InventoryType.WORKBENCH),
    DARK_OAK_SIGN(ProficiencyType.WOODWORK, Material.DARK_OAK_SIGN,9, InventoryType.WORKBENCH),
    DARK_OAK_HANGING_SIGN(ProficiencyType.WOODWORK, Material.DARK_OAK_HANGING_SIGN,12, InventoryType.WORKBENCH),
    DARK_DOOR(ProficiencyType.WOODWORK, Material.DARK_OAK_DOOR,4, InventoryType.WORKBENCH),
    DARK_OAK_TRAPDOOR(ProficiencyType.WOODWORK, Material.DARK_OAK_TRAPDOOR,4, InventoryType.WORKBENCH),
    DARK_OAK_BUTTON(ProficiencyType.WOODWORK, Material.DARK_OAK_BUTTON,1, InventoryType.WORKBENCH),
    DARK_OAK_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.DARK_OAK_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    DARK_OAK_BOAT(ProficiencyType.WOODWORK, Material.DARK_OAK_BOAT,5, InventoryType.WORKBENCH),
    DARK_OAK_CHEST_BOAT(ProficiencyType.WOODWORK, Material.DARK_OAK_CHEST_BOAT,2, InventoryType.WORKBENCH),


    JUNGLE_PLANKS(ProficiencyType.WOODWORK, Material.JUNGLE_PLANKS,4, InventoryType.WORKBENCH),
    JUNGLE_SLAB(ProficiencyType.WOODWORK, Material.JUNGLE_SLAB,3, InventoryType.WORKBENCH),
    JUNGLE_STAIRS(ProficiencyType.WOODWORK, Material.JUNGLE_STAIRS,6, InventoryType.WORKBENCH),
    JUNGLE_FENCE(ProficiencyType.WOODWORK, Material.ACACIA_FENCE,6, InventoryType.WORKBENCH),
    JUNGLE_FENCE_GATE(ProficiencyType.WOODWORK, Material.JUNGLE_FENCE_GATE,4, InventoryType.WORKBENCH),
    JUNGLE_SIGN(ProficiencyType.WOODWORK, Material.JUNGLE_SIGN,9, InventoryType.WORKBENCH),
    JUNGLE_HANGING_SIGN(ProficiencyType.WOODWORK, Material.JUNGLE_HANGING_SIGN,12, InventoryType.WORKBENCH),
    JUNGLE_DOOR(ProficiencyType.WOODWORK, Material.JUNGLE_DOOR,4, InventoryType.WORKBENCH),
    JUNGLE_TRAPDOOR(ProficiencyType.WOODWORK, Material.JUNGLE_TRAPDOOR,4, InventoryType.WORKBENCH),
    JUNGLE_BUTTON(ProficiencyType.WOODWORK, Material.JUNGLE_BUTTON,1, InventoryType.WORKBENCH),
    JUNGLE_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.JUNGLE_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    JUNGLE_BOAT(ProficiencyType.WOODWORK, Material.JUNGLE_BOAT,5, InventoryType.WORKBENCH),
    JUNGLE_CHEST_BOAT(ProficiencyType.WOODWORK, Material.JUNGLE_CHEST_BOAT,2, InventoryType.WORKBENCH),

    MANGROVE_PLANKS(ProficiencyType.WOODWORK, Material.MANGROVE_PLANKS, 4, InventoryType.WORKBENCH),
    MANGROVE_SLAB(ProficiencyType.WOODWORK, Material.MANGROVE_SLAB,3, InventoryType.WORKBENCH),
    MANGROVE_STAIRS(ProficiencyType.WOODWORK, Material.BAMBOO_STAIRS,6, InventoryType.WORKBENCH),
    MANGROVE_FENCE(ProficiencyType.WOODWORK, Material.MANGROVE_FENCE,6, InventoryType.WORKBENCH),
    MANGROVE_FENCE_GATE(ProficiencyType.WOODWORK, Material.MANGROVE_FENCE_GATE,4, InventoryType.WORKBENCH),
    MANGROVE_SIGN(ProficiencyType.WOODWORK, Material.MANGROVE_SIGN,9, InventoryType.WORKBENCH),
    MANGROVE_HANGING_SIGN(ProficiencyType.WOODWORK, Material.MANGROVE_HANGING_SIGN,12, InventoryType.WORKBENCH),
    MANGROVE_DOOR(ProficiencyType.WOODWORK, Material.MANGROVE_DOOR,4, InventoryType.WORKBENCH),
    MANGROVE_TRAPDOOR(ProficiencyType.WOODWORK, Material.MANGROVE_TRAPDOOR,4, InventoryType.WORKBENCH),
    MANGROVE_BUTTON(ProficiencyType.WOODWORK, Material.MANGROVE_BUTTON,1, InventoryType.WORKBENCH),
    MANGROVE_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.MANGROVE_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    MANGROVE_BOAT(ProficiencyType.WOODWORK, Material.MANGROVE_BOAT,5, InventoryType.WORKBENCH),
    MANGROVE_CHEST_BOAT(ProficiencyType.WOODWORK, Material.MANGROVE_CHEST_BOAT,2, InventoryType.WORKBENCH),


    OAK_PLANKS(ProficiencyType.WOODWORK,Material.OAK_PLANKS,4,InventoryType.WORKBENCH),
    OAK_SLAB(ProficiencyType.WOODWORK, Material.OAK_SLAB,3, InventoryType.WORKBENCH),
    OAK_STAIRS(ProficiencyType.WOODWORK, Material.OAK_STAIRS,6, InventoryType.WORKBENCH),
    OAK_FENCE(ProficiencyType.WOODWORK, Material.OAK_FENCE,6, InventoryType.WORKBENCH),
    OAK_FENCE_GATE(ProficiencyType.WOODWORK, Material.OAK_FENCE_GATE,4, InventoryType.WORKBENCH),
    OAK_SIGN(ProficiencyType.WOODWORK, Material.OAK_SIGN,9, InventoryType.WORKBENCH),
    OAK_HANGING_SIGN(ProficiencyType.WOODWORK, Material.OAK_HANGING_SIGN,12, InventoryType.WORKBENCH),
    OAK_DOOR(ProficiencyType.WOODWORK, Material.OAK_DOOR,4, InventoryType.WORKBENCH),
    OAK_TRAPDOOR(ProficiencyType.WOODWORK, Material.OAK_TRAPDOOR,4, InventoryType.WORKBENCH),
    OAK_BUTTON(ProficiencyType.WOODWORK, Material.OAK_BUTTON,1, InventoryType.WORKBENCH),
    OAK_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.OAK_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    OAK_BOAT(ProficiencyType.WOODWORK, Material.OAK_BOAT,5, InventoryType.WORKBENCH),
    OAK_CHEST_BOAT(ProficiencyType.WOODWORK, Material.OAK_CHEST_BOAT,2, InventoryType.WORKBENCH),


    SPRUCE_PLANKS(ProficiencyType.WOODWORK, Material.SPRUCE_PLANKS, 4, InventoryType.WORKBENCH),
    SPRUCE_SLAB(ProficiencyType.WOODWORK, Material.SPRUCE_SLAB,3, InventoryType.WORKBENCH),
    SPRUCE_STAIRS(ProficiencyType.WOODWORK, Material.SPRUCE_STAIRS,6, InventoryType.WORKBENCH),
    SPRUCE_FENCE(ProficiencyType.WOODWORK, Material.SPRUCE_FENCE,6, InventoryType.WORKBENCH),
    SPRUCE_FENCE_GATE(ProficiencyType.WOODWORK, Material.SPRUCE_FENCE_GATE,4, InventoryType.WORKBENCH),
    SPRUCE_SIGN(ProficiencyType.WOODWORK, Material.SPRUCE_SIGN,9, InventoryType.WORKBENCH),
    SPRUCE_HANGING_SIGN(ProficiencyType.WOODWORK, Material.SPRUCE_HANGING_SIGN,12, InventoryType.WORKBENCH),
    SPRUCE_DOOR(ProficiencyType.WOODWORK, Material.SPRUCE_DOOR,4, InventoryType.WORKBENCH),
    SPRUCE_TRAPDOOR(ProficiencyType.WOODWORK, Material.SPRUCE_TRAPDOOR,4, InventoryType.WORKBENCH),
    SPRUCE_BUTTON(ProficiencyType.WOODWORK, Material.SPRUCE_BUTTON,1, InventoryType.WORKBENCH),
    SPRUCE_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.SPRUCE_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    SPRUCE_BOAT(ProficiencyType.WOODWORK, Material.SPRUCE_BOAT,5, InventoryType.WORKBENCH),
    SPRUCE_CHEST_BOAT(ProficiencyType.WOODWORK, Material.SPRUCE_CHEST_BOAT,2, InventoryType.WORKBENCH),

    WARPED_PLANKS(ProficiencyType.WOODWORK, Material.WARPED_PLANKS, 4, InventoryType.WORKBENCH),
    WARPED_SLAB(ProficiencyType.WOODWORK, Material.WARPED_SLAB,3, InventoryType.WORKBENCH),
    WARPED_STAIRS(ProficiencyType.WOODWORK, Material.WARPED_STAIRS,6, InventoryType.WORKBENCH),
    WARPED_FENCE(ProficiencyType.WOODWORK, Material.WARPED_FENCE,6, InventoryType.WORKBENCH),
    WARPED_FENCE_GATE(ProficiencyType.WOODWORK, Material.WARPED_FENCE_GATE,4, InventoryType.WORKBENCH),
    WARPED_SIGN(ProficiencyType.WOODWORK, Material.WARPED_SIGN,9, InventoryType.WORKBENCH),
    WARPED_HANGING_SIGN(ProficiencyType.WOODWORK, Material.WARPED_HANGING_SIGN,12, InventoryType.WORKBENCH),
    WARPED_DOOR(ProficiencyType.WOODWORK, Material.WARPED_DOOR,4, InventoryType.WORKBENCH),
    WARPED_TRAPDOOR(ProficiencyType.WOODWORK, Material.WARPED_TRAPDOOR,4, InventoryType.WORKBENCH),
    WARPED_BUTTON(ProficiencyType.WOODWORK, Material.WARPED_BUTTON,1, InventoryType.WORKBENCH),
    WARPED_PRESSURE_PLATE(ProficiencyType.WOODWORK, Material.WARPED_PRESSURE_PLATE,1, InventoryType.WORKBENCH),



    CRAFTING_TABLE(ProficiencyType.WOODWORK, Material.CRAFTING_TABLE, 4, InventoryType.WORKBENCH),
    CARTOGRAPHY_TABLE(ProficiencyType.WOODWORK, Material.CARTOGRAPHY_TABLE, 4, InventoryType.WORKBENCH),
    FLETCHING_TABLE(ProficiencyType.WOODWORK, Material.FLETCHING_TABLE,4, InventoryType.WORKBENCH),
    LOOM(ProficiencyType.WOODWORK, Material.LOOM, 4, InventoryType.WORKBENCH),

    STICK(ProficiencyType.WOODWORK, Material.STICK,1, InventoryType.WORKBENCH),
    SCAFFOLDING(ProficiencyType.WOODWORK, Material.SCAFFOLDING,8, InventoryType.WORKBENCH),
    CHISELED_BOOKSHELF(ProficiencyType.WOODWORK, Material.CHISELED_BOOKSHELF,8, InventoryType.WORKBENCH),
    BOOKSHELF(ProficiencyType.WOODWORK,Material.BOOKSHELF,6, InventoryType.WORKBENCH),
    JUKEBOX(ProficiencyType.WOODWORK, Material.JUKEBOX, 16, InventoryType.WORKBENCH),

    CHEST(ProficiencyType.WOODWORK, Material.CHEST,8, InventoryType.WORKBENCH),
    TRAPPED_CHEST(ProficiencyType.WOODWORK, Material.TRAPPED_CHEST,8, InventoryType.WORKBENCH),
    BARREL(ProficiencyType.WOODWORK, Material.BARREL, 8, InventoryType.WORKBENCH),
    BOWL(ProficiencyType.WOODWORK, Material.BOWL,3, InventoryType.WORKBENCH),


    //--------------------------------------------------------------------------------------------
    // STONEWORK
    //--------------------------------------------------------------------------------------------

    COBBLESTONE_SLAB(ProficiencyType.STONEWORK, Material.COBBLESTONE_SLAB, 3,InventoryType.WORKBENCH),
    COBBLESTONE_STAIRS(ProficiencyType.STONEWORK, Material.COBBLESTONE_STAIRS, 6, InventoryType.WORKBENCH),




    FURNACE(ProficiencyType.STONEWORK, Material.FURNACE, 8, InventoryType.WORKBENCH),
    DROPPER(ProficiencyType.STONEWORK, Material.DROPPER, 16, InventoryType.WORKBENCH),
    DISPENSER(ProficiencyType.STONEWORK, Material.DISPENSER,16, InventoryType.WORKBENCH),
    OBSERVER(ProficiencyType.STONEWORK, Material.OBSERVER,16, InventoryType.WORKBENCH),
    PISTON(ProficiencyType.STONEWORK, Material.PISTON, 8, InventoryType.WORKBENCH),

    ;


    private final ProficiencyType type;
    private final ItemStack result;
    private final long experienceAmount;

    private final InventoryType inventoryType;

    CraftingResults(ProficiencyType type, Material result, long experienceAmount, InventoryType inventoryType) {
        this.type = type;
        this.result = new ItemStack(result);
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
