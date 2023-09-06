package com.falgael.rpg.proficiency.items;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains special information about an items.
 * @author falgael
 * @version 0.0.1
 */
public class ItemConfiguration {
    /*
    /** Indicates if the items has a block break effect *
    private boolean hasBlockBreakEffect;

    private BlockBreakEffect blockBreakEffect = null;

    private boolean hasHeldEffect;

    private CustomPotionEffect customPotionEffect;


    /** Creates a default configuration without special modification *
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
    */
    private EquipmentSlot equipmentSlot;

    private HashMap<ItemConfigurationFlag,Float> flags;

    private ArrayList<PotionEffect> potionEffects;

    private ItemConfiguration(EquipmentSlot equipmentSlot, HashMap<ItemConfigurationFlag, Float> flags, ArrayList<PotionEffect> potionEffects) {
        this.equipmentSlot = equipmentSlot;
        this.flags = flags;
        this.potionEffects = potionEffects;
    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public boolean hasFlags() {
        return !flags.isEmpty();
    }

    public boolean hasFlag(ItemConfigurationFlag flag) {
        return flags.containsKey(flag);
    }

    public Float getValue(ItemConfigurationFlag flag) {
        return flags.getOrDefault(flag, 0.0f);
    }

    public boolean hasPotionEffect() {
        return !potionEffects.isEmpty();
    }

    public ArrayList<PotionEffect> getPotionEffects() {
        return potionEffects;
    }



    public static class Builder {
        private EquipmentSlot equipmentSlot;
        private HashMap<ItemConfigurationFlag,Float> flags;
        private ArrayList<PotionEffect> potionEffects;

        public Builder(EquipmentSlot equipmentSlot) {
            this.equipmentSlot = equipmentSlot;
            flags = new HashMap<ItemConfigurationFlag, Float>();
            potionEffects = new ArrayList<>();
        }

        public Builder addFlag(ItemConfigurationFlag flag, Float value) {
            flags.put(flag,value);
            return this;
        }

        public Builder addPotionEffect(PotionEffect potionEffect) {
            potionEffects.add(potionEffect);
            return this;
        }

        public ItemConfiguration create() {
            return new ItemConfiguration(equipmentSlot, flags, potionEffects);
        }
    }

}
