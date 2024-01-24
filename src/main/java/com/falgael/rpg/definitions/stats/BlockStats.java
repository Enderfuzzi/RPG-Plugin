package com.falgael.rpg.definitions.stats;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;


public enum BlockStats implements Stats {

    NONE(Proficiency.NONE, Material.AIR, 0),

    //--------------------------------------------------------------------------------------------
    // Woodwork
    //--------------------------------------------------------------------------------------------

    ACACIA_LOG(Proficiency.WOODWORK, Material.ACACIA_LOG, 1, WoodType.ACACIA),
    ACACIA_WOOD(Proficiency.WOODWORK,Material.ACACIA_WOOD,1, WoodType.ACACIA),
    STRIPPED_ACACIA_LOG(Proficiency.WOODWORK, Material.STRIPPED_ACACIA_LOG, 2, WoodType.ACACIA),
    STRIPPED_ACACIA_WOOD(Proficiency.WOODWORK, Material.STRIPPED_ACACIA_WOOD,2, WoodType.ACACIA),


    BIRCH_LOG(Proficiency.WOODWORK,Material.BIRCH_LOG,1,  WoodType.BIRCH),
    BIRCH_WOOD(Proficiency.WOODWORK, Material.BIRCH_WOOD,1, WoodType.BIRCH),
    STRIPPED_BIRCH_LOG(Proficiency.WOODWORK,Material.STRIPPED_BIRCH_LOG,2, WoodType.BIRCH),
    STRIPPED_BIRCH_WOOD(Proficiency.WOODWORK,Material.STRIPPED_BIRCH_WOOD,2, WoodType.BIRCH),


    CHERRY_LOG(Proficiency.WOODWORK,Material.CHERRY_LOG,1, WoodType.CHERRY),
    CHERRY_WOOD(Proficiency.WOODWORK,Material.CHERRY_WOOD,1, WoodType.CHERRY),
    STRIPPED_CHERRY_LOG(Proficiency.WOODWORK,Material.STRIPPED_CHERRY_LOG,2, WoodType.CHERRY),
    STRIPPED_CHERRY_WOOD(Proficiency.WOODWORK, Material.STRIPPED_CHERRY_WOOD,2, WoodType.CHERRY),


    CRIMSON_STEM(Proficiency.WOODWORK, Material.CRIMSON_STEM,2, WoodType.CRIMSON),
    CRIMSON_HYPHAE(Proficiency.WOODWORK, Material.CRIMSON_HYPHAE,2, WoodType.CRIMSON),
    STRIPPED_CRIMSON_STEM(Proficiency.WOODWORK, Material.STRIPPED_CRIMSON_STEM,4, WoodType.CRIMSON),
    STRIPPED_CRIMSON_HYPHAE(Proficiency.WOODWORK, Material.STRIPPED_CRIMSON_HYPHAE, 4, WoodType.CRIMSON),


    DARK_OAK_LOG(Proficiency.WOODWORK,Material.DARK_OAK_LOG,1, WoodType.DARK_OAK),
    DARK_OAK_WOOD(Proficiency.WOODWORK, Material.DARK_OAK_WOOD, 1, WoodType.DARK_OAK),
    STRIPPED_DARK_OAK_LOG(Proficiency.WOODWORK, Material.STRIPPED_DARK_OAK_LOG,2, WoodType.DARK_OAK),
    STRIPPED_DARK_OAK_WOOD(Proficiency.WOODWORK, Material.STRIPPED_DARK_OAK_WOOD, 2, WoodType.DARK_OAK),


    JUNGLE_LOG(Proficiency.WOODWORK, Material.JUNGLE_LOG, 1, WoodType.JUNGLE),
    JUNGLE_WOOD(Proficiency.WOODWORK, Material.JUNGLE_WOOD, 1, WoodType.JUNGLE),
    STRIPPED_JUNGLE_LOG(Proficiency.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2, WoodType.JUNGLE),
    STRIPPED_JUNGLE_WOOD(Proficiency.WOODWORK, Material.STRIPPED_JUNGLE_WOOD,2, WoodType.JUNGLE),


    MANGROVE_LOG(Proficiency.WOODWORK, Material.MANGROVE_LOG,1, WoodType.MANGROVE),
    MANGROVE_WOOD(Proficiency.WOODWORK, Material.MANGROVE_WOOD,1, WoodType.MANGROVE),
    STRIPPED_MANGROVE_LOG(Proficiency.WOODWORK, Material.STRIPPED_JUNGLE_LOG,2, WoodType.MANGROVE),
    STRIPPED_MANGROVE_WOOD(Proficiency.WOODWORK, Material.STRIPPED_MANGROVE_WOOD, 2, WoodType.MANGROVE),
    MANGROVE_ROOTS(Proficiency.WOODWORK, Material.MANGROVE_ROOTS, 2, WoodType.MANGROVE),


    OAK_LOG(Proficiency.WOODWORK, Material.OAK_LOG, 1, WoodType.OAK),
    OAK_WOOD(Proficiency.WOODWORK, Material.OAK_WOOD, 1, WoodType.OAK),
    STRIPPED_OAK_LOG(Proficiency.WOODWORK, Material.STRIPPED_OAK_LOG, 2, WoodType.OAK),
    TRIPPED_OAK_WOOD(Proficiency.WOODWORK, Material.STRIPPED_OAK_WOOD, 2, WoodType.OAK),


    SPRUCE_LOG(Proficiency.WOODWORK, Material.SPRUCE_LOG, 1, WoodType.SPRUCE),
    SPRUCE_WOOD(Proficiency.WOODWORK, Material.SPRUCE_WOOD, 1, WoodType.SPRUCE),
    STRIPPED_SPRUCE_LOG(Proficiency.WOODWORK, Material.STRIPPED_SPRUCE_LOG, 2, WoodType.SPRUCE),
    STRIPPED_SPRUCE_WOOD(Proficiency.WOODWORK, Material.STRIPPED_SPRUCE_WOOD, 2, WoodType.SPRUCE),


    WARPED_STEM(Proficiency.WOODWORK, Material.WARPED_STEM,2, WoodType.WARPED),
    WARPED_HYPHAE(Proficiency.WOODWORK, Material.WARPED_HYPHAE, 2, WoodType.WARPED),
    STRIPPED_WARPED_STEM(Proficiency.WOODWORK, Material.STRIPPED_WARPED_STEM, 4, WoodType.WARPED),
    STRIPPED_WARPED_HYPHAE(Proficiency.WOODWORK, Material.STRIPPED_WARPED_HYPHAE, 4, WoodType.WARPED),


    //--------------------------------------------------------------------------------------------
    // Stonework
    //--------------------------------------------------------------------------------------------

    STONE(Proficiency.STONEWORK, Material.STONE, 1),
    COBBLESTONE(Proficiency.STONEWORK, Material.COBBLESTONE, 1),
    ANDESITE(Proficiency.STONEWORK, Material.ANDESITE,3),
    GRANITE(Proficiency.STONEWORK, Material.GRANITE,3),
    DIORITE(Proficiency.STONEWORK, Material.DIORITE,3),



    COBBLED_DEEPSLATE(Proficiency.STONEWORK, Material.DEEPSLATE,3),
    COAL_ORE(Proficiency.STONEWORK, Material.COAL_ORE,2),
    DEEPSLATE_COAL_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_COAL_ORE,3),
    COPPER_ORE(Proficiency.STONEWORK, Material.COPPER_ORE, 1),
    DEEPSLATE_COPPER_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_COPPER_ORE,2),
    IRON_ORE(Proficiency.STONEWORK, Material.IRON_ORE,3),
    DEEPSLATE_IRON_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_IRON_ORE,4),
    GOLD_ORE(Proficiency.STONEWORK, Material.GOLD_ORE, 5),
    DEEPSLATE_GOLD_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_GOLD_ORE,6),
    REDSTONE_ORE(Proficiency.STONEWORK, Material.REDSTONE_ORE, 5),
    DEEPSLATE_REDSTONE_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_REDSTONE_ORE,6),
    LAPIS_ORE(Proficiency.STONEWORK, Material.LAPIS_ORE, 5),
    DEEPSLATE_LAPIS_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_LAPIS_ORE,6),
    DIAMOND_ORE(Proficiency.STONEWORK, Material.DIAMOND_ORE, 10),
    DEEPSLATE_DIAMOND_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_DIAMOND_ORE,11),
    EMERALD_ORE(Proficiency.STONEWORK, Material.EMERALD_ORE,10),
    DEEPSLATE_EMERALD_ORE(Proficiency.STONEWORK, Material.DEEPSLATE_EMERALD_ORE,11),


    ANCIENT_DEBRIS(Proficiency.STONEWORK, Material.ANCIENT_DEBRIS, 20),


    OBSIDIAN(Proficiency.STONEWORK, Material.OBSIDIAN,15),
    END_STONE(Proficiency.STONEWORK, Material.END_STONE,5),

    SAND(Proficiency.STONEWORK, Material.SAND,1),
    RED_SAND(Proficiency.STONEWORK, Material.RED_SAND, 1),
    GRAVEL(Proficiency.STONEWORK, Material.GRAVEL,1),
    TUFF(Proficiency.STONEWORK, Material.TUFF, 1),
    CLAY(Proficiency.STONEWORK, Material.CLAY, 1),

    NETHERRACK(Proficiency.STONEWORK, Material.NETHERRACK, 1),
    SOUL_SAND(Proficiency.STONEWORK, Material.SOUL_SAND,2),
    SOUL_SOIL(Proficiency.STONEWORK, Material.SOUL_SOIL,2),
    BASALT(Proficiency.STONEWORK, Material.BASALT, 2),
    NETHER_QUARTZ_ORE(Proficiency.STONEWORK, Material.NETHER_QUARTZ_ORE,8),
    NETHER_GOLD_ORE(Proficiency.STONEWORK, Material.NETHER_GOLD_ORE, 8),


    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    WHEAT(Proficiency.FARMING, Material.WHEAT, 1),
    CARROT(Proficiency.FARMING, Material.CARROTS,1),
    POTATO(Proficiency.FARMING, Material.POTATOES, 1),
    BEETROOT(Proficiency.FARMING, Material.BEETROOTS, 1),
    PUMPKIN(Proficiency.FARMING, Material.PUMPKIN, 2),
    MELON(Proficiency.FARMING, Material.MELON, 2),
    SUGAR_CANE(Proficiency.FARMING, Material.SUGAR_CANE, 2),
    CACTUS(Proficiency.FARMING, Material.CACTUS, 2),
    BROWN_MUSHROOM(Proficiency.FARMING, Material.BROWN_MUSHROOM, 2),
    RED_MUSHROOM(Proficiency.FARMING, Material.RED_MUSHROOM, 2),
    BROWN_MUSHROOM_BLOCK(Proficiency.FARMING, Material.BROWN_MUSHROOM_BLOCK,4),
    RED_MUSHROOM_BLOCK(Proficiency.FARMING, Material.RED_MUSHROOM_BLOCK,4),
    MUSHROOM_STEM(Proficiency.FARMING, Material.MUSHROOM_STEM, 3),
    CRIMSON_FUNGUS(Proficiency.FARMING, Material.CRIMSON_FUNGUS, 6),
    WARPED_FUNGUS(Proficiency.FARMING, Material.WARPED_FUNGUS, 6),


    TORCH_FLOWER(Proficiency.FARMING, Material.TORCHFLOWER, 3),
    SUNFLOWER(Proficiency.FARMING, Material.SUNFLOWER,2),
    CORN_FLOWER(Proficiency.FARMING, Material.CORNFLOWER, 2),
    AZALEA(Proficiency.FARMING,Material.AZALEA, 2),
    FLOWERING_AZALEA(Proficiency.FARMING, Material.FLOWERING_AZALEA, 4),

    DANDELION(Proficiency.FARMING, Material.DANDELION, 1),
    POPPY(Proficiency.FARMING, Material.POPPY,1),
    BLUE_ORCHID(Proficiency.FARMING, Material.BLUE_ORCHID,1),
    ALLIUM(Proficiency.FARMING, Material.ALLIUM,1),
    AZURE_BLUET(Proficiency.FARMING, Material.AZURE_BLUET,1),
    RED_TULIP(Proficiency.FARMING, Material.RED_TULIP,1),
    ORANGE_TULIP(Proficiency.FARMING, Material.ORANGE_TULIP, 1),
    WHITE_TULIP(Proficiency.FARMING, Material.WHITE_TULIP, 1),
    PINK_TULIP(Proficiency.FARMING, Material.PINK_TULIP,1),
    OXEYE_DAISY(Proficiency.FARMING, Material.OXEYE_DAISY,1),
    LILY_OF_THE_VALLEY(Proficiency.FARMING, Material.LILY_OF_THE_VALLEY, 1),
    VINES(Proficiency.FARMING, Material.VINE,1),
    WEEPING_VINES(Proficiency.FARMING, Material.WEEPING_VINES, 3),
    TWISTING_VINES(Proficiency.FARMING, Material.TWISTING_VINES, 3),

    TALL_GRASS(Proficiency.FARMING, Material.TALL_GRASS, 4),
    LARGE_FERN(Proficiency.FARMING, Material.LARGE_FERN, 4),
    LILAC(Proficiency.FARMING, Material.LILAC, 4),
    ROSE_BUSH(Proficiency.FARMING, Material.ROSE_BUSH, 4),
    PEONY(Proficiency.FARMING, Material.PEONY,4),
    PITCHER_PLANT(Proficiency.FARMING, Material.PITCHER_PLANT,2),

    SEA_PICKLE(Proficiency.FARMING, Material.SEA_PICKLE, 6),
    KELP(Proficiency.FARMING, Material.KELP, 6),


    NETHER_WART(Proficiency.FARMING, Material.NETHER_WART,6),
    CHORUS_PLANT(Proficiency.FARMING, Material.CHORUS_PLANT, 10),
    CHORUS_FLOWER(Proficiency.FARMING, Material.CHORUS_FLOWER, 10),

    COCOA(Proficiency.FARMING, Material.COCOA, 2),


    ;

    private static final HashMap<Material, BlockStats> LIST_OF_BLOCKS = new HashMap<>();

    static {
        for (BlockStats blocks : BlockStats.values()) {
            LIST_OF_BLOCKS.put(blocks.material,blocks);
        }
    }
    private final List<Proficiency> proficiencies;

    private final Material material;

    private final long experienceAmount;

    private final WoodType woodType;



    BlockStats(Proficiency proficiency, Material material, long experienceAmount, WoodType woodType) {
        this(List.of(proficiency), material, experienceAmount, woodType);
    }

    BlockStats(Proficiency proficiency, Material material, long experienceAmount) {
        this(proficiency, material, experienceAmount, null);
    }

    BlockStats(List<Proficiency> proficiencies, Material material, long experienceAmount, WoodType woodType) {
        this.proficiencies = proficiencies;
        this.material = material;
        this.experienceAmount = experienceAmount;
        this.woodType = woodType;
    }

    public List<Proficiency> getProficiencies() {
        return proficiencies;
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

    public static BlockStats getBlock(Material material) {
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
        return switch (this) {
            case WHEAT, CARROT, POTATO, BEETROOT, NETHER_WART, COCOA -> true;
            default -> false;
        };
    }

    public Material getCrops() {
        return switch (this) {
            case WHEAT -> Material.WHEAT_SEEDS;
            case POTATO -> Material.POTATO;
            case CARROT -> Material.CARROT;
            case BEETROOT -> Material.BEETROOT;
            case COCOA -> Material.COCOA_BEANS;
            default -> getMaterial();
        };
    }

    public boolean specialHarvest() {
        return switch (this) {
            case SUGAR_CANE, CACTUS -> true;
            default -> false;
        };
    }

    public boolean hasWoodType() {
        return this.woodType != null;
    }

    public WoodType getWoodType() {
        return woodType;
    }

    public boolean veinMining() {
        return switch (this) {
            case COAL_ORE, DEEPSLATE_COAL_ORE, COPPER_ORE, DEEPSLATE_COPPER_ORE, IRON_ORE, DEEPSLATE_IRON_ORE,GOLD_ORE, DEEPSLATE_GOLD_ORE, NETHER_GOLD_ORE,DIAMOND_ORE, DEEPSLATE_DIAMOND_ORE,
                    EMERALD_ORE, DEEPSLATE_EMERALD_ORE -> true;
            default -> false;
        };
    }

}
enum WoodType {
    ACACIA,
    BIRCH,
    CHERRY,
    CRIMSON,
    DARK_OAK,
    JUNGLE,
    MANGROVE,
    OAK,
    SPRUCE,
    WARPED,
}