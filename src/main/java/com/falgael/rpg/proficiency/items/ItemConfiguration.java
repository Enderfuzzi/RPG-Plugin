package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static long calculateExperience(CustomTool tool, long baseExperience, ProficiencyType type) {
        if (tool.getProficiencyType() != type) return baseExperience;
        return calculateExperience(tool,baseExperience);
    }

    public static long calculateExperience(CustomTool tool, long baseExperience) {
        if (tool.isNone()) return baseExperience;

        if (tool.getItemConfiguration().hasFlag(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER))
            return baseExperience * Math.round(tool.getItemConfiguration().getValue(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER));

        return baseExperience;
    }


    public static int calculateLoot(CustomTool tool, ProficiencyType type) {
        if (tool.getProficiencyType() != type) return 0;

        return calculateLoot(tool);

    }

    public static int calculateLoot(CustomTool tool) {
        if (tool.isNone()) return 0;

        if (!tool.getItemConfiguration().hasFlag(ItemConfigurationFlag.LOOT_MULTIPLIER)) return 1;

        float lootValue = tool.getItemConfiguration().getValue(ItemConfigurationFlag.LOOT_MULTIPLIER);
        double value = lootValue - Math.floor(lootValue);
        if (value == 0) return (int) lootValue - 1;
        if (Math.random() < value) return (int) Math.ceil(lootValue) - 1;
        return (int) Math.floor(lootValue) - 1;
    }


    public static void dropAdditionalLoot(List<ItemStack> drops, int dropAmount, World world, Location location) {
        if (dropAmount < 1) return;
        if (drops.isEmpty()) return;
        if (world == null || location == null) return;

        for (ItemStack itemStack : drops) {
            if (itemStack.getType() == Material.AIR) continue;
            if (itemStack.getAmount() <= 0) continue;

            ItemStack tmp = itemStack.clone();
            tmp.setAmount(dropAmount);
            world.dropItemNaturally(location,tmp);
        }
    }

    public static void dropAdditionalLoot(ItemStack drop, int dropAmount, World world, Location location) {
        dropAdditionalLoot(List.of(drop), dropAmount, world, location);
    }

    public static double calculateDamage(CustomTool customTool, double baseValue) {
        if (customTool.isNone()) return baseValue;

        double result = baseValue;

        if (customTool.getItemConfiguration().hasFlag(ItemConfigurationFlag.DAMAGE_ADDITIVE)) {
            result += customTool.getItemConfiguration().getValue(ItemConfigurationFlag.DAMAGE_ADDITIVE);
        }

        if (customTool.getItemConfiguration().hasFlag(ItemConfigurationFlag.DAMAGE_MULTIPLIER)) {
            result *= customTool.getItemConfiguration().getValue(ItemConfigurationFlag.DAMAGE_MULTIPLIER);
        }

        return result;
    }


}
