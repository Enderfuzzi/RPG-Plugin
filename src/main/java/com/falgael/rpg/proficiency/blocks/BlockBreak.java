package com.falgael.rpg.proficiency.blocks;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import org.bukkit.Material;

import java.util.HashMap;

public enum BlockBreak {

    NONE(ProficiencyType.NONE, Material.AIR, 0),

    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    ACACIA_LOG(ProficiencyType.WOODWORK, Material.ACACIA_LOG, 1),
    ACACIA_WOOD(ProficiencyType.WOODWORK,Material.ACACIA_WOOD,1),
    STRIPPED_ACACIA_LOG(ProficiencyType.WOODWORK, Material.STRIPPED_ACACIA_LOG, 2),
    STRIPPED_ACACIA_WOOD(ProficiencyType.WOODWORK, Material.STRIPPED_ACACIA_WOOD,2),


    BIRCH_LOG(ProficiencyType.WOODWORK,Material.BIRCH_LOG,1),
    BIRCH_WOOD(ProficiencyType.WOODWORK, Material.BIRCH_WOOD,1),
    STRIPPED_BIRCH_LOG(ProficiencyType.WOODWORK,Material.STRIPPED_BIRCH_LOG,2),
    STRIPPED_BIRCH_WOOD(ProficiencyType.WOODWORK,Material.STRIPPED_BIRCH_WOOD,2),


    CHERRY_LOG(ProficiencyType.WOODWORK,Material.CHERRY_LOG,1),
    CHERRY_WOOD(ProficiencyType.WOODWORK,Material.CHERRY_WOOD,1),
    STRIPPED_CHERRY_LOG(ProficiencyType.WOODWORK,Material.STRIPPED_CHERRY_LOG,2),
    STRIPPED_CHERRY_WOOD(ProficiencyType.WOODWORK, Material.STRIPPED_CHERRY_WOOD,2),


    CRIMSON_STEM(ProficiencyType.WOODWORK, Material.CRIMSON_STEM,2),
    CRIMSON_HYPHAE(ProficiencyType.WOODWORK, Material.CRIMSON_HYPHAE,2),
    STRIPPED_CRIMSON_STEM(ProficiencyType.WOODWORK, Material.STRIPPED_CRIMSON_STEM,4),
    STRIPPED_CRIMSON_HYPHAE(ProficiencyType.WOODWORK, Material.STRIPPED_CRIMSON_HYPHAE, 4),


    DARK_OAK_LOG(ProficiencyType.WOODWORK,Material.DARK_OAK_LOG,1),
    DARK_OAK_WOOD(ProficiencyType.WOODWORK, Material.DARK_OAK_WOOD, 1),
    STRIPPED_DARK_OAK_LOG(ProficiencyType.WOODWORK, Material.STRIPPED_DARK_OAK_LOG,2),
    STRIPPED_DARK_OAK_WOOD(ProficiencyType.WOODWORK, Material.STRIPPED_DARK_OAK_WOOD, 2),


    JUNGLE_LOG(ProficiencyType.WOODWORK, Material.JUNGLE_LOG, 1),
    JUNGLE_WOOD(ProficiencyType.WOODWORK, Material.JUNGLE_WOOD, 1),
    STRIPPED_JUNGLE_LOG(ProficiencyType.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2),
    STRIPPED_JUNGLE_WOOD(ProficiencyType.WOODWORK, Material.STRIPPED_JUNGLE_WOOD,2),


    MANGROVE_LOG(ProficiencyType.WOODWORK, Material.MANGROVE_LOG,1),
    MANGROVE_WOOD(ProficiencyType.WOODWORK, Material.MANGROVE_WOOD,1),
    STRIPPED_MANGROVE_LOG(ProficiencyType.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2),
    STRIPPED_MANGROVE_WOOD(ProficiencyType.WOODWORK, Material.STRIPPED_MANGROVE_WOOD, 2),


    OAK_LOG(ProficiencyType.WOODWORK, Material.OAK_LOG, 1),
    OAK_WOOD(ProficiencyType.WOODWORK, Material.OAK_WOOD, 1),
    STRIPPED_OAK_LOG(ProficiencyType.WOODWORK, Material.STRIPPED_OAK_LOG, 2),
    TRIPPED_OAK_WOOD(ProficiencyType.WOODWORK, Material.STRIPPED_OAK_WOOD, 2),


    SPRUCE_LOG(ProficiencyType.WOODWORK, Material.SPRUCE_LOG, 1),
    SPRUCE_WOOD(ProficiencyType.WOODWORK, Material.SPRUCE_WOOD, 1),
    STRIPPED_SPRUCE_LOG(ProficiencyType.WOODWORK, Material.STRIPPED_SPRUCE_LOG, 2),
    STRIPPED_SPRUCE_WOOD(ProficiencyType.WOODWORK, Material.STRIPPED_SPRUCE_WOOD, 2),


    WARPED_STEM(ProficiencyType.WOODWORK, Material.WARPED_STEM,2),
    WARPED_HYPHAE(ProficiencyType.WOODWORK, Material.WARPED_HYPHAE, 2),
    STRIPPED_WARPED_STEM(ProficiencyType.WOODWORK, Material.STRIPPED_WARPED_STEM, 4),
    STRIPPED_WARPED_HYPHAE(ProficiencyType.WOODWORK, Material.STRIPPED_WARPED_HYPHAE, 4),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONE(ProficiencyType.STONEWORK, Material.STONE, 1),
    COBBLESTONE(ProficiencyType.STONEWORK, Material.COBBLESTONE, 1),
    COBBLED_DEEPSLATE(ProficiencyType.STONEWORK, Material.DEEPSLATE,3),
    COAL_ORE(ProficiencyType.STONEWORK, Material.COAL_ORE,2),
    COPPER_ORE(ProficiencyType.STONEWORK, Material.COPPER_ORE, 1),
    IRON_ORE(ProficiencyType.STONEWORK, Material.IRON_ORE,3),
    GOLD_ORE(ProficiencyType.STONEWORK, Material.GOLD_ORE, 5),
    REDSTONE_ORE(ProficiencyType.STONEWORK, Material.REDSTONE_ORE, 5),
    DIAMOND_ORE(ProficiencyType.STONEWORK, Material.DIAMOND_ORE, 10),
    EMERALD_ORE(ProficiencyType.STONEWORK, Material.EMERALD_ORE,10),
    ANCIENT_DEBRIS(ProficiencyType.STONEWORK, Material.ANCIENT_DEBRIS, 20),



    SAND(ProficiencyType.STONEWORK, Material.SAND,1),
    GRAVEL(ProficiencyType.STONEWORK, Material.GRAVEL,1),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    WHEAT(ProficiencyType.FARMING, Material.WHEAT, 1),
    CARROT(ProficiencyType.FARMING, Material.CARROTS,1),
    POTATO(ProficiencyType.FARMING, Material.POTATOES, 1),
    BEETROOT(ProficiencyType.FARMING, Material.BEETROOTS, 1),
    PUMPKIN(ProficiencyType.FARMING, Material.PUMPKIN, 2),
    MELON(ProficiencyType.FARMING, Material.MELON, 2),
    SUGAR_CANE(ProficiencyType.FARMING, Material.SUGAR_CANE, 2),
    CACTUS(ProficiencyType.FARMING, Material.CACTUS, 2),
    BROWN_MUSHROOM(ProficiencyType.FARMING, Material.BROWN_MUSHROOM, 2),
    RED_MUSHROOM(ProficiencyType.FARMING, Material.RED_MUSHROOM, 2),
    BROWN_MUSHROOM_BLOCK(ProficiencyType.FARMING, Material.BROWN_MUSHROOM_BLOCK,4),
    RED_MUSHROOM_BLOCK(ProficiencyType.FARMING, Material.RED_MUSHROOM_BLOCK,4),
    MUSHROOM_STEM(ProficiencyType.FARMING, Material.MUSHROOM_STEM, 3),

    TORCH_FLOWER(ProficiencyType.FARMING, Material.TORCHFLOWER, 3),

    NETHER_WART(ProficiencyType.FARMING, Material.NETHER_WART,3),
    CHORUS_PLANT(ProficiencyType.FARMING, Material.CHORUS_PLANT, 5),
    CHORUS_FLOWER(ProficiencyType.FARMING, Material.CHORUS_FLOWER, 5),



    ;

    private static final HashMap<Material, BlockBreak> LIST_OF_BLOCKS = new HashMap<>();

    static {
        for (BlockBreak blocks : BlockBreak.values()) {
            LIST_OF_BLOCKS.put(blocks.material,blocks);
        }
    }
    private final ProficiencyType proficiency;

    private final Material material;

    private final long experienceAmount;


    BlockBreak(ProficiencyType proficiency, Material material, long experienceAmount) {
        this.proficiency = proficiency;
        this.material = material;
        this.experienceAmount = experienceAmount;
    }

    public ProficiencyType getProficiency() {
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
            case NETHER_WART: return true;
            default: return false;
        }
    }




}
