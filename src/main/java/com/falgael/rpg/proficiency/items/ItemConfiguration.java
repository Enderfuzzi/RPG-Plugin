package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.proficiency.items.effects.BlockBreakEffect;
import com.falgael.rpg.proficiency.items.effects.CustomPotionEffect;

/**
 * Contains special information about an items.
 * @author falgael
 * @version 0.0.1
 */
public class ItemConfiguration {

    /** Indicates if the items has a block break effect */
    private boolean hasBlockBreakEffect;

    private BlockBreakEffect blockBreakEffect = null;

    private boolean hasHeldEffect;

    private CustomPotionEffect customPotionEffect;


    /** Creates a default configuration without special modification */
    public ItemConfiguration() {
        this(null,null);
    }

    public ItemConfiguration(BlockBreakEffect blockBreakEffect) {
        this(blockBreakEffect, null);
    }

    public ItemConfiguration(CustomPotionEffect customPotionEffect) {
        this(null, customPotionEffect);
    }

    public ItemConfiguration(BlockBreakEffect blockBreakEffect, CustomPotionEffect customPotionEffect) {
        hasBlockBreakEffect = blockBreakEffect != null;
        hasHeldEffect = customPotionEffect != null;
        this.blockBreakEffect = blockBreakEffect;
        this.customPotionEffect = customPotionEffect;
    }

    public boolean hasBlockBreakEffect() {
        return hasBlockBreakEffect;
    }

    public BlockBreakEffect getBlockBreakEffect() {
        return blockBreakEffect;
    }

    public boolean hasCustomPotionEffect() {
        return hasHeldEffect;
    }

    public CustomPotionEffect getCustomPotionEffect() {
        return customPotionEffect;
    }



}
