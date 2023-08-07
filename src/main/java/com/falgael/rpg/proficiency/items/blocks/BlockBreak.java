package com.falgael.rpg.proficiency.items.blocks;

import com.falgael.rpg.proficiency.ProficiencyTypes;
import org.bukkit.Material;

import java.util.HashMap;

public enum BlockBreak {

    NONE(ProficiencyTypes.NONE, Material.AIR, 0,Material.AIR),

    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    ACACIA_LOG(ProficiencyTypes.WOODWORK, Material.ACACIA_LOG, 1,Material.AIR),
    ACACIA_WOOD(ProficiencyTypes.WOODWORK,Material.ACACIA_WOOD,1,Material.AIR),
    STRIPPED_ACACIA_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_ACACIA_LOG, 2,Material.AIR),
    STRIPPED_ACACIA_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_ACACIA_WOOD,2,Material.AIR),


    BIRCH_LOG(ProficiencyTypes.WOODWORK,Material.BIRCH_LOG,1,Material.AIR),
    BIRCH_WOOD(ProficiencyTypes.WOODWORK, Material.BIRCH_WOOD,1,Material.AIR),
    STRIPPED_BIRCH_LOG(ProficiencyTypes.WOODWORK,Material.STRIPPED_BIRCH_LOG,2,Material.AIR),
    STRIPPED_BIRCH_WOOD(ProficiencyTypes.WOODWORK,Material.STRIPPED_BIRCH_WOOD,2,Material.AIR),


    CHERRY_LOG(ProficiencyTypes.WOODWORK,Material.CHERRY_LOG,1,Material.AIR),
    CHERRY_WOOD(ProficiencyTypes.WOODWORK,Material.CHERRY_WOOD,1,Material.AIR),
    STRIPPED_CHERRY_LOG(ProficiencyTypes.WOODWORK,Material.STRIPPED_CHERRY_LOG,2,Material.AIR),
    STRIPPED_CHERRY_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_CHERRY_WOOD,2,Material.AIR),


    CRIMSON_STEM(ProficiencyTypes.WOODWORK, Material.CRIMSON_STEM,2,Material.AIR),
    CRIMSON_HYPHAE(ProficiencyTypes.WOODWORK, Material.CRIMSON_HYPHAE,2,Material.AIR),
    STRIPPED_CRIMSON_STEM(ProficiencyTypes.WOODWORK, Material.STRIPPED_CRIMSON_STEM,4,Material.AIR),
    STRIPPED_CRIMSON_HYPHAE(ProficiencyTypes.WOODWORK, Material.STRIPPED_CRIMSON_HYPHAE, 4,Material.AIR),


    DARK_OAK_LOG(ProficiencyTypes.WOODWORK,Material.DARK_OAK_LOG,1,Material.AIR),
    DARK_OAK_WOOD(ProficiencyTypes.WOODWORK, Material.DARK_OAK_WOOD, 1,Material.AIR),
    STRIPPED_DARK_OAK_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_DARK_OAK_LOG,2,Material.AIR),
    STRIPPED_DARK_OAK_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_DARK_OAK_WOOD, 2,Material.AIR),


    JUNGLE_LOG(ProficiencyTypes.WOODWORK, Material.JUNGLE_LOG, 1,Material.AIR),
    JUNGLE_WOOD(ProficiencyTypes.WOODWORK, Material.JUNGLE_WOOD, 1,Material.AIR),
    STRIPPED_JUNGLE_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2,Material.AIR),
    STRIPPED_JUNGLE_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_JUNGLE_WOOD,2,Material.AIR),


    MANGROVE_LOG(ProficiencyTypes.WOODWORK, Material.MANGROVE_LOG,1,Material.AIR),
    MANGROVE_WOOD(ProficiencyTypes.WOODWORK, Material.MANGROVE_WOOD,1,Material.AIR),
    STRIPPED_MANGROVE_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2,Material.AIR),
    STRIPPED_MANGROVE_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_MANGROVE_WOOD, 2,Material.AIR),


    OAK_LOG(ProficiencyTypes.WOODWORK, Material.OAK_LOG, 1,Material.AIR),
    OAK_WOOD(ProficiencyTypes.WOODWORK, Material.OAK_WOOD, 1,Material.AIR),
    STRIPPED_OAK_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_OAK_LOG, 2,Material.AIR),
    TRIPPED_OAK_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_OAK_WOOD, 2,Material.AIR),


    SPRUCE_LOG(ProficiencyTypes.WOODWORK, Material.SPRUCE_LOG, 1,Material.AIR),
    SPRUCE_WOOD(ProficiencyTypes.WOODWORK, Material.SPRUCE_WOOD, 1,Material.AIR),
    STRIPPED_SPRUCE_LOG(ProficiencyTypes.WOODWORK, Material.STRIPPED_SPRUCE_LOG, 2,Material.AIR),
    STRIPPED_SPRUCE_WOOD(ProficiencyTypes.WOODWORK, Material.STRIPPED_SPRUCE_WOOD, 2,Material.AIR),


    WARPED_STEM(ProficiencyTypes.WOODWORK, Material.WARPED_STEM,2, Material.AIR),
    WARPED_HYPHAE(ProficiencyTypes.WOODWORK, Material.WARPED_HYPHAE, 2, Material.AIR),
    STRIPPED_WARPED_STEM(ProficiencyTypes.WOODWORK, Material.STRIPPED_WARPED_STEM, 4, Material.AIR),
    STRIPPED_WARPED_HYPHAE(ProficiencyTypes.WOODWORK, Material.STRIPPED_WARPED_HYPHAE, 4, Material.AIR),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONE(ProficiencyTypes.STONEWORK, Material.STONE, 1,Material.COBBLESTONE),
    COBBLESTONE(ProficiencyTypes.STONEWORK, Material.COBBLESTONE, 1,Material.AIR),
    COBBLED_DEEPSLATE(ProficiencyTypes.STONEWORK, Material.DEEPSLATE,3, Material.COBBLED_DEEPSLATE),
    COAL_ORE(ProficiencyTypes.STONEWORK, Material.COAL_ORE,2,Material.AIR),
    IRON_ORE(ProficiencyTypes.STONEWORK, Material.IRON_ORE,3,Material.AIR),
    GOLD_ORE(ProficiencyTypes.STONEWORK, Material.GOLD_ORE, 5,Material.AIR),
    REDSTONE_ORE(ProficiencyTypes.STONEWORK, Material.REDSTONE_ORE, 5,Material.AIR),
    DIAMOND_ORE(ProficiencyTypes.STONEWORK, Material.DIAMOND_ORE, 10,Material.AIR),
    EMERALD_ORE(ProficiencyTypes.STONEWORK, Material.EMERALD_ORE,10,Material.AIR),
    ANCIENT_DEBRIS(ProficiencyTypes.STONEWORK, Material.ANCIENT_DEBRIS, 20,Material.NETHERITE_SCRAP),

    SAND(ProficiencyTypes.STONEWORK, Material.SAND,1,Material.AIR),
    GRAVEL(ProficiencyTypes.STONEWORK, Material.GRAVEL,1,Material.AIR),


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

    private final Material alternativeDrop;

    BlockBreak(ProficiencyTypes proficiency, Material material, long experienceAmount, Material alternativeDrop) {
        this.proficiency = proficiency;
        this.material = material;
        this.experienceAmount = experienceAmount;
        this.alternativeDrop = alternativeDrop;
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
        return NONE.alternativeDrop != this.alternativeDrop;
    }

    public Material getAlternativeDrop() {
        return this.alternativeDrop;
    }




}
