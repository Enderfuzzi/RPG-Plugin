package com.falgael.rpg.proficiency.blocks;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import org.bukkit.Material;

import java.util.HashMap;

public enum HarvestBlock {

    NONE(ProficiencyType.MISC, Material.AIR,0),

    //--------------------------------------------------------------------------------------------
    // Farming
    //--------------------------------------------------------------------------------------------

    SWEET_BERRIES(ProficiencyType.FARMING, Material.SWEET_BERRY_BUSH, 3),

    GLOW_BERRIES(ProficiencyType.FARMING, Material.CAVE_VINES,6),

    ;
    private static final HashMap<Material, HarvestBlock> LIST_OF_BLOCKS = new HashMap<>();

    static {
        for (HarvestBlock blocks : HarvestBlock.values()) {
            LIST_OF_BLOCKS.put(blocks.material,blocks);
        }
    }
    private final ProficiencyType proficiency;

    private final Material material;

    private final long experienceAmount;


    HarvestBlock(ProficiencyType proficiency, Material material, long experienceAmount) {
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

    public static HarvestBlock getBlock(Material material) {
        return LIST_OF_BLOCKS.getOrDefault(material, NONE);
    }




}
