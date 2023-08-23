package com.falgael.rpg.proficiency.items.blocks;

import com.falgael.rpg.proficiency.ProficiencyTypes;
import org.bukkit.Material;

import java.util.HashMap;

public enum BlockBreak {

    NONE(ProficiencyTypes.NONE, Material.AIR, 0),

    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    ACACIA_LOG(ProficiencyTypes.WOODWORK, Material.ACACIA_LOG, 1),
    ACACIA_WOOD(ProficiencyTypes.WOODWORK,Material.ACACIA_WOOD,1),
    STRIPPED_ACACIA_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_ACACIA_LOG, 2),
    STRIPPED_ACACIA_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_ACACIA_WOOD,2),


    BIRCH_LOG(ProficiencyTypes.WOODWORK,Material.BIRCH_LOG,1),
    BIRCH_WOOD(ProficiencyTypes.WOODWORK, Material.BIRCH_WOOD,1),
    STRIPPED_BIRCH_LOG(ProficiencyTypes.WOODWORK,Material.STRIPPED_BIRCH_LOG,2),
    STRIPPED_BIRCH_WOOD(ProficiencyTypes.WOODWORK,Material.STRIPPED_BIRCH_WOOD,2),


    CHERRY_LOG(ProficiencyTypes.WOODWORK,Material.CHERRY_LOG,1),
    CHERRY_WOOD(ProficiencyTypes.WOODWORK,Material.CHERRY_WOOD,1),
    STRIPPED_CHERRY_LOG(ProficiencyTypes.WOODWORK,Material.STRIPPED_CHERRY_LOG,2),
    STRIPPED_CHERRY_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_CHERRY_WOOD,2),


    CRIMSON_STEM(ProficiencyTypes.WOODWORK, Material.CRIMSON_STEM,2),
    CRIMSON_HYPHAE(ProficiencyTypes.WOODWORK, Material.CRIMSON_HYPHAE,2),
    STRIPPED_CRIMSON_STEM(ProficiencyTypes.WOODWORK, Material.STRIPPED_CRIMSON_STEM,4),
    STRIPPED_CRIMSON_HYPHAE(ProficiencyTypes.WOODWORK, Material.STRIPPED_CRIMSON_HYPHAE, 4),


    DARK_OAK_LOG(ProficiencyTypes.WOODWORK,Material.DARK_OAK_LOG,1),
    DARK_OAK_WOOD(ProficiencyTypes.WOODWORK, Material.DARK_OAK_WOOD, 1),
    STRIPPED_DARK_OAK_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_DARK_OAK_LOG,2),
    STRIPPED_DARK_OAK_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_DARK_OAK_WOOD, 2),


    JUNGLE_LOG(ProficiencyTypes.WOODWORK, Material.JUNGLE_LOG, 1),
    JUNGLE_WOOD(ProficiencyTypes.WOODWORK, Material.JUNGLE_WOOD, 1),
    STRIPPED_JUNGLE_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2),
    STRIPPED_JUNGLE_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_JUNGLE_WOOD,2),


    MANGROVE_LOG(ProficiencyTypes.WOODWORK, Material.MANGROVE_LOG,1),
    MANGROVE_WOOD(ProficiencyTypes.WOODWORK, Material.MANGROVE_WOOD,1),
    STRIPPED_MANGROVE_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2),
    STRIPPED_MANGROVE_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_MANGROVE_WOOD, 2),


    OAK_LOG(ProficiencyTypes.WOODWORK, Material.OAK_LOG, 1),
    OAK_WOOD(ProficiencyTypes.WOODWORK, Material.OAK_WOOD, 1),
    STRIPPED_OAK_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_OAK_LOG, 2),
    TRIPPED_OAK_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_OAK_WOOD, 2),


    SPRUCE_LOG(ProficiencyTypes.WOODWORK, Material.SPRUCE_LOG, 1),
    SPRUCE_WOOD(ProficiencyTypes.WOODWORK, Material.SPRUCE_WOOD, 1),
    STRIPPED_SPRUCE_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_SPRUCE_LOG, 2),
    STRIPPED_SPRUCE_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_SPRUCE_WOOD, 2),


    WARPED_STEM(ProficiencyTypes.WOODWORK, Material.WARPED_STEM,2),
    WARPED_HYPHAE(ProficiencyTypes.WOODWORK, Material.WARPED_HYPHAE, 2),
    STRIPPED_WARPED_STEM(ProficiencyTypes.WOODWORK, Material.STRIPPED_WARPED_STEM, 4),
    STRIPPED_WARPED_HYPHAE(ProficiencyTypes.WOODWORK, Material.STRIPPED_WARPED_HYPHAE, 4),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONE(ProficiencyTypes.STONEWORK, Material.STONE, 1),
    COBBLESTONE(ProficiencyTypes.STONEWORK, Material.COBBLESTONE, 1),
    COBBLED_DEEPSLATE(ProficiencyTypes.STONEWORK, Material.DEEPSLATE,3),
    COAL_ORE(ProficiencyTypes.STONEWORK, Material.COAL_ORE,2),
    COPPER_ORE(ProficiencyTypes.STONEWORK, Material.COPPER_ORE, 1),
    IRON_ORE(ProficiencyTypes.STONEWORK, Material.IRON_ORE,3),
    GOLD_ORE(ProficiencyTypes.STONEWORK, Material.GOLD_ORE, 5),
    REDSTONE_ORE(ProficiencyTypes.STONEWORK, Material.REDSTONE_ORE, 5),
    DIAMOND_ORE(ProficiencyTypes.STONEWORK, Material.DIAMOND_ORE, 10),
    EMERALD_ORE(ProficiencyTypes.STONEWORK, Material.EMERALD_ORE,10),
    ANCIENT_DEBRIS(ProficiencyTypes.STONEWORK, Material.ANCIENT_DEBRIS, 20),



    SAND(ProficiencyTypes.STONEWORK, Material.SAND,1),
    GRAVEL(ProficiencyTypes.STONEWORK, Material.GRAVEL,1),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    WHEAT(ProficiencyTypes.FARMING, Material.WHEAT, 1),
    CARROT(ProficiencyTypes.FARMING, Material.CARROTS,1),
    POTATO(ProficiencyTypes.FARMING, Material.POTATOES, 1),
    BEETROOT(ProficiencyTypes.FARMING, Material.BEETROOTS, 1),
    SWEET_BERRIES(ProficiencyTypes.FARMING, Material.SWEET_BERRIES, 1),
    PUMPKIN(ProficiencyTypes.FARMING, Material.PUMPKIN, 2),
    MELON(ProficiencyTypes.FARMING, Material.MELON, 2),
    SUGAR_CANE(ProficiencyTypes.FARMING, Material.SUGAR_CANE, 2),
    CACTUS(ProficiencyTypes.FARMING, Material.CACTUS, 2),
    BROWN_MUSHROOM(ProficiencyTypes.FARMING, Material.BROWN_MUSHROOM, 2),
    RED_MUSHROOM(ProficiencyTypes.FARMING, Material.RED_MUSHROOM, 2),
    BROWN_MUSHROOM_BLOCK(ProficiencyTypes.FARMING, Material.BROWN_MUSHROOM_BLOCK,4),
    RED_MUSHROOM_BLOCK(ProficiencyTypes.FARMING, Material.RED_MUSHROOM_BLOCK,4),
    MUSHROOM_STEM(ProficiencyTypes.FARMING, Material.MUSHROOM_STEM, 3),

    NETHER_WART(ProficiencyTypes.FARMING, Material.NETHER_WART,3),
    CHORUS_PLANT(ProficiencyTypes.FARMING, Material.CHORUS_PLANT, 5),
    CHORUS_FLOWER(ProficiencyTypes.FARMING, Material.CHORUS_FLOWER, 5),



    ;

    private static final HashMap<Material, BlockBreak> LIST_OF_BLOCKS = new HashMap<>();

    static {
        for (BlockBreak blocks : BlockBreak.values()) {
            LIST_OF_BLOCKS.put(blocks.material,blocks);
        }
    }
    private final ProficiencyTypes proficiency;

    private final Material material;

    private final long experienceAmount;


    BlockBreak(ProficiencyTypes proficiency, Material material, long experienceAmount) {
        this.proficiency = proficiency;
        this.material = material;
        this.experienceAmount = experienceAmount;
    }

    public ProficiencyTypes getProficiency() {
        return proficiency;
    }

    public Material getMaterial() {
        return material;
    }

    public long getExperienceAmount() {
        return experienceAmount;
    }

    public boolean isNone() {
        return NONE == this;
    }

    public static BlockBreak getBlock(Material material) {
        return LIST_OF_BLOCKS.getOrDefault(material, NONE);
    }

    public boolean hasAlternativeDrop() {
        return !this.getAlternativeDrop().equals(Material.AIR);
    }

    public Material getAlternativeDrop() {
        return switch (this) {
            case ANCIENT_DEBRIS -> Material.NETHERITE_SCRAP;
            default -> Material.AIR;
        };
    }

    public boolean ageable() {
        switch (this) {
            case WHEAT:
            case CARROT:
            case POTATO:
            case BEETROOT:
            case SWEET_BERRIES:
            case NETHER_WART: return true;
            default: return false;
        }
    }




}
