package com.falgael.rpg.stats;

import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.List;

public enum BlockHarvestStats implements Stats {

    NONE(Proficiency.MISC, Material.AIR,0),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    SWEET_BERRIES(Proficiency.FARMING, Material.SWEET_BERRY_BUSH, 3),

    GLOW_BERRIES(Proficiency.FARMING, Material.CAVE_VINES,6),

    ;
    private static final HashMap<Material, BlockHarvestStats> LIST_OF_BLOCKS = new HashMap<>();

    static {
        for (BlockHarvestStats blocks : BlockHarvestStats.values()) {
            LIST_OF_BLOCKS.put(blocks.material,blocks);
        }
    }
    private final List<Proficiency> proficiencies;

    private final Material material;

    private final long experienceAmount;


    BlockHarvestStats(Proficiency proficiency, Material material, long experienceAmount) {
        this(List.of(proficiency),material,experienceAmount);
    }

    BlockHarvestStats(List<Proficiency> proficiencies, Material material, long experienceAmount) {
        this.proficiencies = proficiencies;
        this.material = material;
        this.experienceAmount = experienceAmount;
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

    public static BlockHarvestStats getBlock(Material material) {
        return LIST_OF_BLOCKS.getOrDefault(material, NONE);
    }




}
