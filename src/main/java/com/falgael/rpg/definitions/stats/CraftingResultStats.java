package com.falgael.rpg.definitions.stats;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public enum CraftingResultStats implements Stats {

    NONE(Proficiency.NONE, Material.AIR,0, InventoryType.CREATIVE),

    //--------------------------------------------------------------------------------------------
    // WOODWORK
    //--------------------------------------------------------------------------------------------
    ACACIA_PLANKS(Proficiency.WOODWORK, Material.ACACIA_PLANKS, 4, InventoryType.WORKBENCH),
    ACACIA_SLAB(Proficiency.WOODWORK, Material.ACACIA_SLAB, 3, InventoryType.WORKBENCH),
    ACACIA_STAIRS(Proficiency.WOODWORK, Material.ACACIA_STAIRS,6, InventoryType.WORKBENCH),
    ACACIA_FENCE(Proficiency.WOODWORK, Material.ACACIA_FENCE,6, InventoryType.WORKBENCH),
    ACACIA_FENCE_GATE(Proficiency.WOODWORK, Material.ACACIA_FENCE_GATE,4, InventoryType.WORKBENCH),
    ACACIA_SIGN(Proficiency.WOODWORK, Material.ACACIA_SIGN,9, InventoryType.WORKBENCH),
    ACACIA_HANGING_SIGN(Proficiency.WOODWORK, Material.ACACIA_HANGING_SIGN,12, InventoryType.WORKBENCH),
    ACACIA_DOOR(Proficiency.WOODWORK, Material.ACACIA_DOOR,4, InventoryType.WORKBENCH),
    ACACIA_TRAPDOOR(Proficiency.WOODWORK, Material.ACACIA_TRAPDOOR,4, InventoryType.WORKBENCH),
    ACACIA_BUTTON(Proficiency.WOODWORK, Material.ACACIA_BUTTON,1, InventoryType.WORKBENCH),
    ACACIA_PRESSURE_PLATE(Proficiency.WOODWORK, Material.ACACIA_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    ACACIA_BOAT(Proficiency.WOODWORK, Material.ACACIA_BOAT,5, InventoryType.WORKBENCH),
    ACACIA_CHEST_BOAT(Proficiency.WOODWORK, Material.ACACIA_CHEST_BOAT,2, InventoryType.WORKBENCH),


    BAMBOO_PLANKS(Proficiency.WOODWORK, Material.BAMBOO_PLANKS,4, InventoryType.WORKBENCH),
    BAMBOO_SLAB(Proficiency.WOODWORK, Material.BAMBOO_SLAB,3, InventoryType.WORKBENCH),
    BAMBOO_STAIRS(Proficiency.WOODWORK, Material.BAMBOO_STAIRS,6, InventoryType.WORKBENCH),
    BAMBOO_FENCE(Proficiency.WOODWORK, Material.BAMBOO_FENCE,6, InventoryType.WORKBENCH),
    BAMBOO_FENCE_GATE(Proficiency.WOODWORK, Material.BAMBOO_FENCE_GATE,4, InventoryType.WORKBENCH),
    BAMBOO_SIGN(Proficiency.WOODWORK, Material.BAMBOO_SIGN,9, InventoryType.WORKBENCH),
    BAMBOO_HANGING_SIGN(Proficiency.WOODWORK, Material.BAMBOO_HANGING_SIGN,12, InventoryType.WORKBENCH),
    BAMBOO_DOOR(Proficiency.WOODWORK, Material.BAMBOO_DOOR,4, InventoryType.WORKBENCH),
    BAMBOO_TRAPDOOR(Proficiency.WOODWORK, Material.BAMBOO_TRAPDOOR,4, InventoryType.WORKBENCH),
    BAMBOO_BUTTON(Proficiency.WOODWORK, Material.BAMBOO_BUTTON,1, InventoryType.WORKBENCH),
    BAMBOO_PRESSURE_PLATE(Proficiency.WOODWORK, Material.BAMBOO_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    BAMBOO_MOSAIC(Proficiency.WOODWORK,Material.BAMBOO_MOSAIC,2, InventoryType.WORKBENCH),
    BAMBOO_MOSAIC_SLAB(Proficiency.WOODWORK,Material.BAMBOO_MOSAIC_SLAB,3, InventoryType.WORKBENCH),
    BAMBOO_MOSAIC_STAIRS(Proficiency.WOODWORK,Material.BAMBOO_MOSAIC_STAIRS,6, InventoryType.WORKBENCH),


    BIRCH_PLANKS(Proficiency.WOODWORK, Material.BIRCH_PLANKS,4,InventoryType.WORKBENCH),
    BIRCH_SLAB(Proficiency.WOODWORK, Material.BIRCH_SLAB,3, InventoryType.WORKBENCH),
    BIRCH_STAIRS(Proficiency.WOODWORK, Material.BIRCH_STAIRS,6, InventoryType.WORKBENCH),
    BIRCH_FENCE(Proficiency.WOODWORK, Material.BIRCH_FENCE,6, InventoryType.WORKBENCH),
    BIRCH_FENCE_GATE(Proficiency.WOODWORK, Material.BIRCH_FENCE_GATE,4, InventoryType.WORKBENCH),
    BIRCH_SIGN(Proficiency.WOODWORK, Material.BIRCH_SIGN,9, InventoryType.WORKBENCH),
    BIRCH_HANGING_SIGN(Proficiency.WOODWORK, Material.BIRCH_HANGING_SIGN,12, InventoryType.WORKBENCH),
    BIRCH_DOOR(Proficiency.WOODWORK, Material.BIRCH_DOOR,4, InventoryType.WORKBENCH),
    BIRCH_TRAPDOOR(Proficiency.WOODWORK, Material.BIRCH_TRAPDOOR,4, InventoryType.WORKBENCH),
    BIRCH_BUTTON(Proficiency.WOODWORK, Material.BIRCH_BUTTON,1, InventoryType.WORKBENCH),
    BIRCH_PRESSURE_PLATE(Proficiency.WOODWORK, Material.BIRCH_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    BIRCH_BOAT(Proficiency.WOODWORK, Material.BIRCH_BOAT,5, InventoryType.WORKBENCH),
    BIRCH_CHEST_BOAT(Proficiency.WOODWORK, Material.BIRCH_CHEST_BOAT,2, InventoryType.WORKBENCH),

    CHERRY_PLANKS(Proficiency.WOODWORK, Material.CHERRY_PLANKS, 4, InventoryType.WORKBENCH),
    CHERRY_SLAB(Proficiency.WOODWORK, Material.CHERRY_SLAB,3, InventoryType.WORKBENCH),
    CHERRY_STAIRS(Proficiency.WOODWORK, Material.CHERRY_STAIRS,6, InventoryType.WORKBENCH),
    CHERRY_FENCE(Proficiency.WOODWORK, Material.CHERRY_FENCE,6, InventoryType.WORKBENCH),
    CHERRY_FENCE_GATE(Proficiency.WOODWORK, Material.CHERRY_FENCE_GATE,4, InventoryType.WORKBENCH),
    CHERRY_SIGN(Proficiency.WOODWORK, Material.CHERRY_SIGN,9, InventoryType.WORKBENCH),
    CHERRY_HANGING_SIGN(Proficiency.WOODWORK, Material.CHERRY_HANGING_SIGN,12, InventoryType.WORKBENCH),
    CHERRY_DOOR(Proficiency.WOODWORK, Material.CHERRY_DOOR,4, InventoryType.WORKBENCH),
    CHERRY_TRAPDOOR(Proficiency.WOODWORK, Material.CHERRY_TRAPDOOR,4, InventoryType.WORKBENCH),
    CHERRY_BUTTON(Proficiency.WOODWORK, Material.CHERRY_BUTTON,1, InventoryType.WORKBENCH),
    CHERRY_PRESSURE_PLATE(Proficiency.WOODWORK, Material.CHERRY_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    CHERRY_BOAT(Proficiency.WOODWORK, Material.CHERRY_BOAT,5, InventoryType.WORKBENCH),
    CHERRY_CHEST_BOAT(Proficiency.WOODWORK, Material.CHERRY_CHEST_BOAT,2, InventoryType.WORKBENCH),

    CRIMSON_PLANKS(Proficiency.WOODWORK, Material.CRIMSON_PLANKS,4, InventoryType.WORKBENCH),
    CRIMSON_SLAB(Proficiency.WOODWORK, Material.CRIMSON_SLAB,3, InventoryType.WORKBENCH),
    CRIMSON_STAIRS(Proficiency.WOODWORK, Material.CRIMSON_STAIRS,6, InventoryType.WORKBENCH),
    CRIMSON_FENCE(Proficiency.WOODWORK, Material.CRIMSON_FENCE,6, InventoryType.WORKBENCH),
    CRIMSON_FENCE_GATE(Proficiency.WOODWORK, Material.CRIMSON_FENCE_GATE,4, InventoryType.WORKBENCH),
    CRIMSON_SIGN(Proficiency.WOODWORK, Material.CRIMSON_SIGN,9, InventoryType.WORKBENCH),
    CRIMSON_HANGING_SIGN(Proficiency.WOODWORK, Material.CRIMSON_HANGING_SIGN,12, InventoryType.WORKBENCH),
    CRIMSON_DOOR(Proficiency.WOODWORK, Material.CRIMSON_DOOR,4, InventoryType.WORKBENCH),
    CRIMSON_TRAPDOOR(Proficiency.WOODWORK, Material.CRIMSON_TRAPDOOR,4, InventoryType.WORKBENCH),
    CRIMSON_BUTTON(Proficiency.WOODWORK, Material.CRIMSON_BUTTON,5, InventoryType.WORKBENCH),
    CRIMSON_PRESSURE_PLATE(Proficiency.WOODWORK, Material.CRIMSON_PRESSURE_PLATE,2, InventoryType.WORKBENCH),


    DARK_OAK_PLANKS(Proficiency.WOODWORK, Material.DARK_OAK_PLANKS,4, InventoryType.WORKBENCH),
    DARK_OAK_SLAB(Proficiency.WOODWORK, Material.DARK_OAK_SLAB,3, InventoryType.WORKBENCH),
    DARK_OAK_STAIRS(Proficiency.WOODWORK, Material.DARK_OAK_STAIRS,6, InventoryType.WORKBENCH),
    DARK_OAK_FENCE(Proficiency.WOODWORK, Material.DARK_OAK_FENCE,6, InventoryType.WORKBENCH),
    DARK_OAK_FENCE_GATE(Proficiency.WOODWORK, Material.DARK_OAK_FENCE_GATE,4, InventoryType.WORKBENCH),
    DARK_OAK_SIGN(Proficiency.WOODWORK, Material.DARK_OAK_SIGN,9, InventoryType.WORKBENCH),
    DARK_OAK_HANGING_SIGN(Proficiency.WOODWORK, Material.DARK_OAK_HANGING_SIGN,12, InventoryType.WORKBENCH),
    DARK_DOOR(Proficiency.WOODWORK, Material.DARK_OAK_DOOR,4, InventoryType.WORKBENCH),
    DARK_OAK_TRAPDOOR(Proficiency.WOODWORK, Material.DARK_OAK_TRAPDOOR,4, InventoryType.WORKBENCH),
    DARK_OAK_BUTTON(Proficiency.WOODWORK, Material.DARK_OAK_BUTTON,1, InventoryType.WORKBENCH),
    DARK_OAK_PRESSURE_PLATE(Proficiency.WOODWORK, Material.DARK_OAK_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    DARK_OAK_BOAT(Proficiency.WOODWORK, Material.DARK_OAK_BOAT,5, InventoryType.WORKBENCH),
    DARK_OAK_CHEST_BOAT(Proficiency.WOODWORK, Material.DARK_OAK_CHEST_BOAT,2, InventoryType.WORKBENCH),


    JUNGLE_PLANKS(Proficiency.WOODWORK, Material.JUNGLE_PLANKS,4, InventoryType.WORKBENCH),
    JUNGLE_SLAB(Proficiency.WOODWORK, Material.JUNGLE_SLAB,3, InventoryType.WORKBENCH),
    JUNGLE_STAIRS(Proficiency.WOODWORK, Material.JUNGLE_STAIRS,6, InventoryType.WORKBENCH),
    JUNGLE_FENCE(Proficiency.WOODWORK, Material.ACACIA_FENCE,6, InventoryType.WORKBENCH),
    JUNGLE_FENCE_GATE(Proficiency.WOODWORK, Material.JUNGLE_FENCE_GATE,4, InventoryType.WORKBENCH),
    JUNGLE_SIGN(Proficiency.WOODWORK, Material.JUNGLE_SIGN,9, InventoryType.WORKBENCH),
    JUNGLE_HANGING_SIGN(Proficiency.WOODWORK, Material.JUNGLE_HANGING_SIGN,12, InventoryType.WORKBENCH),
    JUNGLE_DOOR(Proficiency.WOODWORK, Material.JUNGLE_DOOR,4, InventoryType.WORKBENCH),
    JUNGLE_TRAPDOOR(Proficiency.WOODWORK, Material.JUNGLE_TRAPDOOR,4, InventoryType.WORKBENCH),
    JUNGLE_BUTTON(Proficiency.WOODWORK, Material.JUNGLE_BUTTON,1, InventoryType.WORKBENCH),
    JUNGLE_PRESSURE_PLATE(Proficiency.WOODWORK, Material.JUNGLE_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    JUNGLE_BOAT(Proficiency.WOODWORK, Material.JUNGLE_BOAT,5, InventoryType.WORKBENCH),
    JUNGLE_CHEST_BOAT(Proficiency.WOODWORK, Material.JUNGLE_CHEST_BOAT,2, InventoryType.WORKBENCH),

    MANGROVE_PLANKS(Proficiency.WOODWORK, Material.MANGROVE_PLANKS, 4, InventoryType.WORKBENCH),
    MANGROVE_SLAB(Proficiency.WOODWORK, Material.MANGROVE_SLAB,3, InventoryType.WORKBENCH),
    MANGROVE_STAIRS(Proficiency.WOODWORK, Material.BAMBOO_STAIRS,6, InventoryType.WORKBENCH),
    MANGROVE_FENCE(Proficiency.WOODWORK, Material.MANGROVE_FENCE,6, InventoryType.WORKBENCH),
    MANGROVE_FENCE_GATE(Proficiency.WOODWORK, Material.MANGROVE_FENCE_GATE,4, InventoryType.WORKBENCH),
    MANGROVE_SIGN(Proficiency.WOODWORK, Material.MANGROVE_SIGN,9, InventoryType.WORKBENCH),
    MANGROVE_HANGING_SIGN(Proficiency.WOODWORK, Material.MANGROVE_HANGING_SIGN,12, InventoryType.WORKBENCH),
    MANGROVE_DOOR(Proficiency.WOODWORK, Material.MANGROVE_DOOR,4, InventoryType.WORKBENCH),
    MANGROVE_TRAPDOOR(Proficiency.WOODWORK, Material.MANGROVE_TRAPDOOR,4, InventoryType.WORKBENCH),
    MANGROVE_BUTTON(Proficiency.WOODWORK, Material.MANGROVE_BUTTON,1, InventoryType.WORKBENCH),
    MANGROVE_PRESSURE_PLATE(Proficiency.WOODWORK, Material.MANGROVE_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    MANGROVE_BOAT(Proficiency.WOODWORK, Material.MANGROVE_BOAT,5, InventoryType.WORKBENCH),
    MANGROVE_CHEST_BOAT(Proficiency.WOODWORK, Material.MANGROVE_CHEST_BOAT,2, InventoryType.WORKBENCH),


    OAK_PLANKS(Proficiency.WOODWORK,Material.OAK_PLANKS,4,InventoryType.WORKBENCH),
    OAK_SLAB(Proficiency.WOODWORK, Material.OAK_SLAB,3, InventoryType.WORKBENCH),
    OAK_STAIRS(Proficiency.WOODWORK, Material.OAK_STAIRS,6, InventoryType.WORKBENCH),
    OAK_FENCE(Proficiency.WOODWORK, Material.OAK_FENCE,6, InventoryType.WORKBENCH),
    OAK_FENCE_GATE(Proficiency.WOODWORK, Material.OAK_FENCE_GATE,4, InventoryType.WORKBENCH),
    OAK_SIGN(Proficiency.WOODWORK, Material.OAK_SIGN,9, InventoryType.WORKBENCH),
    OAK_HANGING_SIGN(Proficiency.WOODWORK, Material.OAK_HANGING_SIGN,12, InventoryType.WORKBENCH),
    OAK_DOOR(Proficiency.WOODWORK, Material.OAK_DOOR,4, InventoryType.WORKBENCH),
    OAK_TRAPDOOR(Proficiency.WOODWORK, Material.OAK_TRAPDOOR,4, InventoryType.WORKBENCH),
    OAK_BUTTON(Proficiency.WOODWORK, Material.OAK_BUTTON,1, InventoryType.WORKBENCH),
    OAK_PRESSURE_PLATE(Proficiency.WOODWORK, Material.OAK_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    OAK_BOAT(Proficiency.WOODWORK, Material.OAK_BOAT,5, InventoryType.WORKBENCH),
    OAK_CHEST_BOAT(Proficiency.WOODWORK, Material.OAK_CHEST_BOAT,2, InventoryType.WORKBENCH),


    SPRUCE_PLANKS(Proficiency.WOODWORK, Material.SPRUCE_PLANKS, 4, InventoryType.WORKBENCH),
    SPRUCE_SLAB(Proficiency.WOODWORK, Material.SPRUCE_SLAB,3, InventoryType.WORKBENCH),
    SPRUCE_STAIRS(Proficiency.WOODWORK, Material.SPRUCE_STAIRS,6, InventoryType.WORKBENCH),
    SPRUCE_FENCE(Proficiency.WOODWORK, Material.SPRUCE_FENCE,6, InventoryType.WORKBENCH),
    SPRUCE_FENCE_GATE(Proficiency.WOODWORK, Material.SPRUCE_FENCE_GATE,4, InventoryType.WORKBENCH),
    SPRUCE_SIGN(Proficiency.WOODWORK, Material.SPRUCE_SIGN,9, InventoryType.WORKBENCH),
    SPRUCE_HANGING_SIGN(Proficiency.WOODWORK, Material.SPRUCE_HANGING_SIGN,12, InventoryType.WORKBENCH),
    SPRUCE_DOOR(Proficiency.WOODWORK, Material.SPRUCE_DOOR,4, InventoryType.WORKBENCH),
    SPRUCE_TRAPDOOR(Proficiency.WOODWORK, Material.SPRUCE_TRAPDOOR,4, InventoryType.WORKBENCH),
    SPRUCE_BUTTON(Proficiency.WOODWORK, Material.SPRUCE_BUTTON,1, InventoryType.WORKBENCH),
    SPRUCE_PRESSURE_PLATE(Proficiency.WOODWORK, Material.SPRUCE_PRESSURE_PLATE,1, InventoryType.WORKBENCH),
    SPRUCE_BOAT(Proficiency.WOODWORK, Material.SPRUCE_BOAT,5, InventoryType.WORKBENCH),
    SPRUCE_CHEST_BOAT(Proficiency.WOODWORK, Material.SPRUCE_CHEST_BOAT,2, InventoryType.WORKBENCH),

    WARPED_PLANKS(Proficiency.WOODWORK, Material.WARPED_PLANKS, 4, InventoryType.WORKBENCH),
    WARPED_SLAB(Proficiency.WOODWORK, Material.WARPED_SLAB,3, InventoryType.WORKBENCH),
    WARPED_STAIRS(Proficiency.WOODWORK, Material.WARPED_STAIRS,6, InventoryType.WORKBENCH),
    WARPED_FENCE(Proficiency.WOODWORK, Material.WARPED_FENCE,6, InventoryType.WORKBENCH),
    WARPED_FENCE_GATE(Proficiency.WOODWORK, Material.WARPED_FENCE_GATE,4, InventoryType.WORKBENCH),
    WARPED_SIGN(Proficiency.WOODWORK, Material.WARPED_SIGN,9, InventoryType.WORKBENCH),
    WARPED_HANGING_SIGN(Proficiency.WOODWORK, Material.WARPED_HANGING_SIGN,12, InventoryType.WORKBENCH),
    WARPED_DOOR(Proficiency.WOODWORK, Material.WARPED_DOOR,4, InventoryType.WORKBENCH),
    WARPED_TRAPDOOR(Proficiency.WOODWORK, Material.WARPED_TRAPDOOR,4, InventoryType.WORKBENCH),
    WARPED_BUTTON(Proficiency.WOODWORK, Material.WARPED_BUTTON,1, InventoryType.WORKBENCH),
    WARPED_PRESSURE_PLATE(Proficiency.WOODWORK, Material.WARPED_PRESSURE_PLATE,1, InventoryType.WORKBENCH),



    CRAFTING_TABLE(Proficiency.WOODWORK, Material.CRAFTING_TABLE, 4, InventoryType.WORKBENCH),
    CARTOGRAPHY_TABLE(Proficiency.WOODWORK, Material.CARTOGRAPHY_TABLE, 4, InventoryType.WORKBENCH),
    FLETCHING_TABLE(Proficiency.WOODWORK, Material.FLETCHING_TABLE,4, InventoryType.WORKBENCH),
    LOOM(Proficiency.WOODWORK, Material.LOOM, 4, InventoryType.WORKBENCH),

    STICK(Proficiency.WOODWORK, Material.STICK,1, InventoryType.WORKBENCH),
    SCAFFOLDING(Proficiency.WOODWORK, Material.SCAFFOLDING,8, InventoryType.WORKBENCH),
    CHISELED_BOOKSHELF(Proficiency.WOODWORK, Material.CHISELED_BOOKSHELF,8, InventoryType.WORKBENCH),
    BOOKSHELF(Proficiency.WOODWORK,Material.BOOKSHELF,6, InventoryType.WORKBENCH),
    JUKEBOX(Proficiency.WOODWORK, Material.JUKEBOX, 16, InventoryType.WORKBENCH),

    CHEST(Proficiency.WOODWORK, Material.CHEST,8, InventoryType.WORKBENCH),
    TRAPPED_CHEST(Proficiency.WOODWORK, Material.TRAPPED_CHEST,8, InventoryType.WORKBENCH),
    BARREL(Proficiency.WOODWORK, Material.BARREL, 8, InventoryType.WORKBENCH),
    BOWL(Proficiency.WOODWORK, Material.BOWL,3, InventoryType.WORKBENCH),
    BEEHIVE(Proficiency.WOODWORK, Material.BEEHIVE, 6, InventoryType.WORKBENCH),

    //--------------------------------------------------------------------------------------------
    // STONEWORK
    //--------------------------------------------------------------------------------------------

    MOSSY_COBBLESTONE(Proficiency.STONEWORK, Material.MOSSY_COBBLESTONE, 2, InventoryType.WORKBENCH),

    ANDESITE(Proficiency.STONEWORK, Material.ANDESITE, 4, InventoryType.WORKBENCH),
    DIORITE(Proficiency.STONEWORK, Material.DIORITE, 4, InventoryType.WORKBENCH),
    GRANITE(Proficiency.STONEWORK, Material.GRANITE, 4, InventoryType.WORKBENCH),

    BRICKS(Proficiency.STONEWORK, Material.BRICKS, 8, InventoryType.WORKBENCH),
    QUARTZ_BLOCK(Proficiency.STONEWORK, Material.QUARTZ_BLOCK, 8, InventoryType.WORKBENCH),

    WHITE_CONCRETE_POWDER(Proficiency.STONEWORK, Material.WHITE_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    ORANGE_CONCRETE_POWDER(Proficiency.STONEWORK, Material.ORANGE_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    MAGENTA_CONCRETE_POWDER(Proficiency.STONEWORK, Material.MAGENTA_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    LIGHT_BLUE_CONCRETE_POWDER(Proficiency.STONEWORK, Material.LIGHT_BLUE_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    YELLOW_CONCRETE_POWDER(Proficiency.STONEWORK, Material.YELLOW_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    LIME_CONCRETE_POWDER(Proficiency.STONEWORK, Material.LIME_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    PINK_CONCRETE_POWDER(Proficiency.STONEWORK, Material.PINK_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    GRAY_CONCRETE_POWDER(Proficiency.STONEWORK, Material.GRAY_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    LIGHT_GRAY_CONCRETE_POWDER(Proficiency.STONEWORK, Material.LIGHT_GRAY_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    CYAN_CONCRETE_POWDER(Proficiency.STONEWORK, Material.CYAN_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    PURPLE_CONCRETE_POWDER(Proficiency.STONEWORK, Material.PURPLE_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    BLUE_CONCRETE_POWDER(Proficiency.STONEWORK, Material.BLUE_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    BROWN_CONCRETE_POWDER(Proficiency.STONEWORK, Material.BROWN_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    GREEN_CONCRETE_POWDER(Proficiency.STONEWORK, Material.GREEN_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    RED_CONCRETE_POWDER(Proficiency.STONEWORK, Material.RED_CONCRETE_POWDER,8,InventoryType.WORKBENCH),
    BLACK_CONCRETE_POWDER(Proficiency.STONEWORK, Material.BLACK_CONCRETE_POWDER,8,InventoryType.WORKBENCH),

    FURNACE(Proficiency.STONEWORK, Material.FURNACE, 8, InventoryType.WORKBENCH),
    DROPPER(Proficiency.STONEWORK, Material.DROPPER, 16, InventoryType.WORKBENCH),
    DISPENSER(Proficiency.STONEWORK, Material.DISPENSER,16, InventoryType.WORKBENCH),
    OBSERVER(Proficiency.STONEWORK, Material.OBSERVER,16, InventoryType.WORKBENCH),
    PISTON(Proficiency.STONEWORK, Material.PISTON, 8, InventoryType.WORKBENCH),

    NETHER_BRICKS(Proficiency.STONEWORK, Material.NETHER_BRICKS, 4),
    RED_NETHER_BRICKS(Proficiency.STONEWORK, Material.RED_NETHER_BRICKS, 4),
    NETHER_BRICK_FENCE(Proficiency.STONEWORK, Material.NETHER_BRICK_FENCE, 8),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    HONEY_BLOCK(Proficiency.FARMING, Material.HONEY_BLOCK, 8, InventoryType.WORKBENCH),
    SUGAR(Proficiency.FARMING, Material.SUGAR, 3, InventoryType.WORKBENCH),
    GOLDEN_APPLE(Proficiency.FARMING, Material.GOLDEN_APPLE, 16, InventoryType.WORKBENCH),
    GOLDEN_CARROT(Proficiency.FARMING, Material.GOLDEN_CARROT, 8, InventoryType.WORKBENCH),
    BREAD(Proficiency.FARMING, Material.BREAD, 3, InventoryType.WORKBENCH),
    COOKIE(Proficiency.FARMING, Material.COOKIE, 8, InventoryType.WORKBENCH),
    PUMPKIN_PIE(Proficiency.FARMING, Material.PUMPKIN_PIE,8,InventoryType.WORKBENCH),
    CAKE(Proficiency.FARMING, Material.CAKE,16, InventoryType.WORKBENCH),

    NETHER_WART_BLOCK(Proficiency.FARMING, Material.NETHER_WART_BLOCK, 9, InventoryType.WORKBENCH),
    HONEYCOMB_BLOCK(Proficiency.FARMING, Material.HONEYCOMB_BLOCK, 8, InventoryType.WORKBENCH),
    CANDLE(Proficiency.FARMING, Material.CANDLE, 2, InventoryType.WORKBENCH),

    WAXED_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_COPPER_BLOCK,2),
    WAXED_EXPOSED_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_EXPOSED_COPPER,2),
    WAXED_WEATHERED_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_WEATHERED_COPPER,2),
    WAXED_OXIDIZED_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_OXIDIZED_COPPER,2),
    WAXED_CUT_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_CUT_COPPER,2),
    WAXED_EXPOSED_CUT_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_EXPOSED_CUT_COPPER,2),
    WAXED_WEATHERED_CUT_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_WEATHERED_CUT_COPPER,2),
    WAXED_OXIDIZED_CUT_COPPER_BLOCK(Proficiency.FARMING, Material.WAXED_OXIDIZED_CUT_COPPER,2),
    WAXED_CUT_COPPER_SLAB(Proficiency.FARMING, Material.WAXED_CUT_COPPER_SLAB,2),
    WAXED_EXPOSED_CUT_COPPER_SLAB(Proficiency.FARMING, Material.WAXED_EXPOSED_CUT_COPPER_SLAB,2),
    WAXED_WEATHERED_CUT_COPPER_SLAB(Proficiency.FARMING, Material.WAXED_WEATHERED_CUT_COPPER_SLAB,2),
    WAXED_OXIDIZED_CUT_COPPER_SLAB(Proficiency.FARMING, Material.WAXED_OXIDIZED_CUT_COPPER_SLAB,2),
    WAXED_CUT_COPPER_STAIRS(Proficiency.FARMING, Material.WAXED_CUT_COPPER_STAIRS,2),
    WAXED_EXPOSED_CUT_COPPER_STAIRS(Proficiency.FARMING, Material.WAXED_EXPOSED_CUT_COPPER_STAIRS,2),
    WAXED_WEATHERED_CUT_COPPER_STAIRS(Proficiency.FARMING, Material.WAXED_WEATHERED_CUT_COPPER_STAIRS,2),
    WAXED_OXIDIZED_CUT_COPPER_STAIRS(Proficiency.FARMING, Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS,2),


    WHITE_DYE(Proficiency.FARMING, Material.WHITE_DYE, 2),
    LIGHT_GRAY_DYE(Proficiency.FARMING, Material.LIGHT_GRAY_DYE, 2),
    GRAY_DYE(Proficiency.FARMING, Material.GRAY_DYE, 2),
    BLACK_DYE(Proficiency.FARMING, Material.BLACK_DYE, 2),
    BROWN_DYE(Proficiency.FARMING, Material.BROWN_DYE, 2),
    RED_DYE(Proficiency.FARMING, Material.RED_DYE, 2),
    ORANGE_DYE(Proficiency.FARMING, Material.ORANGE_DYE, 2),
    YELLOW_DYE(Proficiency.FARMING, Material.YELLOW_DYE, 2),
    LIME_DYE(Proficiency.FARMING, Material.LIME_DYE, 2),
    GREEN_DYE(Proficiency.FARMING, Material.GREEN_DYE, 2),
    CYAN_DYE(Proficiency.FARMING, Material.CYAN_DYE, 2),
    LIGHT_BLUE_DYE(Proficiency.FARMING, Material.LIGHT_BLUE_DYE, 2),
    BLUE_DYE(Proficiency.FARMING, Material.BLUE_DYE, 2),
    PURPLE_DYE(Proficiency.FARMING, Material.PURPLE_DYE, 2),
    MAGENTA_DYE(Proficiency.FARMING, Material.MAGENTA_DYE, 2),
    PINK_DYE(Proficiency.FARMING, Material.PINK_DYE, 2),

    LEATHER_HELMET(Proficiency.FARMING, Material.LEATHER_HELMET, 5),
    LEATHER_CHESTPLATE(Proficiency.FARMING, Material.LEATHER_CHESTPLATE,8),
    LEATHER_LEGGINS(Proficiency.FARMING, Material.LEATHER_LEGGINGS, 7),
    LEATHER_BOOTS(Proficiency.FARMING, Material.LEATHER_BOOTS,4),



    ;


    private final List<Proficiency> proficiencies;
    private final ItemStack result;
    private final long experienceAmount;

    private final InventoryType inventoryType;

    CraftingResultStats(Proficiency proficiency, Material result, long experienceAmount, InventoryType inventoryType) {
        this(List.of(proficiency), result, experienceAmount, inventoryType);
    }

    CraftingResultStats(Proficiency proficiency, Material result, long experienceAmount) {
        this(proficiency,result,experienceAmount,InventoryType.WORKBENCH);
    }

    CraftingResultStats(List<Proficiency> proficiencies, Material result, long experienceAmount, InventoryType inventoryType) {
        this.proficiencies = proficiencies;
        this.result = new ItemStack(result);
        this.experienceAmount = experienceAmount;
        this.inventoryType = inventoryType;
    }

    public static CraftingResultStats getResult(ItemStack toCheck) {
        for (CraftingResultStats craftingResult : CraftingResultStats.values()) {
            if (craftingResult.result.isSimilar(toCheck)) return craftingResult;
        }
        return NONE;
    }

    public static CraftingResultStats getResult(Material material) {
        return getResult(new ItemStack(material));
    }


    public List<Proficiency> getProficiencies() {
        return proficiencies;
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
