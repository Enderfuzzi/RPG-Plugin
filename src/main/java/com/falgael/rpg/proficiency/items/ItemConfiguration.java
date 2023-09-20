package com.falgael.rpg.proficiency.items;

import com.falgael.rpg.framework.PredicateConsumer;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Contains special information about an item. Uses a Builder Layout for creating Items.
 * @author falgael
 * @version 0.0.1
 */
public class ItemConfiguration {
    /**
     * The Slot in which the item has an effect
     */
    private EquipmentSlot[] equipmentSlot;

    /**
     * Map of {@link ItemConfigurationFlag} which can be set with a {@link Float}
     */
    private HashMap<ItemConfigurationFlag,Float> flags;

    /**
     * List of Potion effects which are applied when using the item
     */
    private ArrayList<PotionEffect> potionEffects;

    /**
     * A Special Action which can be defined and applied in different situations
     */
    private PredicateConsumer<Event> action;

    private ItemConfiguration(EquipmentSlot[] equipmentSlot, HashMap<ItemConfigurationFlag, Float> flags, ArrayList<PotionEffect> potionEffects, PredicateConsumer<Event> action) {
        this.equipmentSlot = equipmentSlot;
        this.flags = flags;
        this.potionEffects = potionEffects;
        this.action = action;
    }

    /**
     * @return The EquipmentSlot in which the Item is active
     */
    public boolean compareEquipmentSlot(EquipmentSlot toCompare) {
        for (EquipmentSlot slot : equipmentSlot) if (slot == toCompare) return true;
        return false;
    }

    /**
     * @return {@code true} if the Configuration has any {@link ItemConfigurationFlag} set
     */
    public boolean hasFlags() {
        return !flags.isEmpty();
    }

    /**
     * @param flag The flag to check
     * @return {@code true} if the Configuration has the specified {@link ItemConfigurationFlag} set
     */
    public boolean hasFlag(ItemConfigurationFlag flag) {
        return flags.containsKey(flag);
    }

    /**
     * Returns the Value of a specific Flag. Before usage, it is necessary to check that the configuration has this flag set.
     * @param flag The flag to search for
     * @return the float Value of the given {@link ItemConfigurationFlag}
     */
    public Float getValue(ItemConfigurationFlag flag) {
        return flags.getOrDefault(flag, 0.0f);
    }

    /**
     * @return {@code true} if the configuration has at least one potion effect set
     */
    public boolean hasPotionEffect() {
        return !potionEffects.isEmpty();
    }

    /**
     * @return a List of all potion effects set for this configuration
     */
    public ArrayList<PotionEffect> getPotionEffects() {
        return potionEffects;
    }

    /**
     * @return {@code true} if an Action is set for this Configuration
     */
    public boolean hasAction() {
        return action != null;
    }

    /**
     * Gets the action of this configuration. It should be checked that this configuration has an action set before usage.
     * @return the Action if set or {@code null}
     */
    public PredicateConsumer<Event> getAction() {
        return action;
    }

    /**
     * Builder Class for Item creation.
     * @author falgael
     * @version 0.0.1
     */
    public static class Builder {
        private EquipmentSlot[] equipmentSlot;
        private HashMap<ItemConfigurationFlag,Float> flags;
        private ArrayList<PotionEffect> potionEffects;

        private PredicateConsumer<Event> action = null;

        /**
         * Initializes a new Builder for Creating a new Item
         * @param equipmentSlot the equipment slot in which the item should be active
         */
        public Builder(EquipmentSlot... equipmentSlot) {
            this.equipmentSlot = equipmentSlot;
            flags = new HashMap<>();
            potionEffects = new ArrayList<>();
        }

        /**
         * Adds a new {@link ItemConfigurationFlag} with value to the current configuration
         * @param flag the Flag to set
         * @param value the Value which get assigned to the flag
         * @return the current Builder state
         */
        public Builder addFlag(ItemConfigurationFlag flag, Float value) {
            flags.put(flag,value);
            return this;
        }

        /**
         * Adds a new Potion effect to the current configuration
         * @param potionEffect The effect to add
         * @return the current Builder state
         */
        public Builder addPotionEffect(PotionEffect potionEffect) {
            potionEffects.add(potionEffect);
            return this;
        }

        /**
         * Adds an Action to the current configuration
         * @param action the action to add
         * @return the current Builder state
         */
        public Builder addAction(PredicateConsumer<Event> action) {
            this.action = action;
            return this;
        }

        /**
         * Creates the configuration with the defined arguments.
         * @return the new Created ItemConfiguration
         */
        public ItemConfiguration create() {
            return new ItemConfiguration(equipmentSlot, flags, potionEffects, action);
        }
    }

    //TODO Add Further Java doc

    public static long calculateExperience(CustomTool tool, long baseExperience, ProficiencyType type, Player player) {
        if (matchLevelRequirement(tool, player)) return calculateExperience(tool, baseExperience, type);
        return baseExperience;
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

    public static int calculateLoot(CustomTool tool, ProficiencyType type, Player player) {
        if (matchLevelRequirement(tool,player)) return calculateLoot(tool, type);
        return 0;
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
            int tmpAmount = dropAmount;
            while (tmpAmount - 64 > 0) {
                world.dropItemNaturally(location,new ItemStack(itemStack.getType(), 64));
                tmpAmount -= 64;
            }
            world.dropItemNaturally(location, new ItemStack(itemStack.getType(), tmpAmount));
        }
    }

    public static void dropAdditionalLoot(ItemStack drop, int dropAmount, World world, Location location) {
        dropAdditionalLoot(List.of(drop), dropAmount, world, location);
    }

    public static double calculateTotalDamage(Player player, double baseValue) {
        double result = baseValue;
        result += calculateDamage(player.getInventory().getItemInMainHand(), baseValue, player, EquipmentSlot.HAND);
        result += calculateDamage(player.getInventory().getItemInOffHand(), baseValue, player, EquipmentSlot.OFF_HAND);
        result += calculateDamage(player.getInventory().getHelmet(), baseValue, player, EquipmentSlot.HEAD);
        result += calculateDamage(player.getInventory().getChestplate(), baseValue, player, EquipmentSlot.CHEST);
        result += calculateDamage(player.getInventory().getLeggings(), baseValue, player, EquipmentSlot.LEGS);
        result += calculateDamage(player.getInventory().getBoots(), baseValue, player, EquipmentSlot.FEET);

        return result;
    }

    public static double calculateDamage(ItemStack item, double baseValue, Player player, EquipmentSlot equipmentSlot) {
        return calculateDamage(CustomTool.getItem(item), baseValue, player, equipmentSlot);
    }

    public static double calculateDamage(CustomTool customTool, double baseValue, Player player, EquipmentSlot equipmentSlot) {
        if (!matchLevelRequirement(customTool, player)) return 0;
        if (!customTool.getItemConfiguration().compareEquipmentSlot(equipmentSlot)) return 0;

        double result = 0;

        if (customTool.getItemConfiguration().hasFlag(ItemConfigurationFlag.DAMAGE_ADDITIVE)) {
            result += customTool.getItemConfiguration().getValue(ItemConfigurationFlag.DAMAGE_ADDITIVE);
        }

        if (customTool.getItemConfiguration().hasFlag(ItemConfigurationFlag.DAMAGE_MULTIPLIER)) {
            result += (customTool.getItemConfiguration().getValue(ItemConfigurationFlag.DAMAGE_MULTIPLIER) - 1) * baseValue;
        }

        return result;
    }

    public static boolean matchLevelRequirement(CustomTool tool, Player player) {
        if (tool == null || tool.isNone() || player == null) return false;
        if (tool.getItemConfiguration().hasFlag(ItemConfigurationFlag.LEVEL_REQUIREMENT)) {
            return Utils.getPlayerLevel(player, tool.getProficiencyType()) >= tool.getItemConfiguration().getValue(ItemConfigurationFlag.LEVEL_REQUIREMENT);
        }
        return false;
    }

    public static boolean matchLevelRequirement(CustomItem item, Player player) {
        if (item == null || item.isNone() || player == null) return true;
        if (!item.hasConfiguration()) return true;
        if (item.getConfiguration().hasFlag(ItemConfigurationFlag.LEVEL_REQUIREMENT)) {
            return Utils.getPlayerLevel(player, item.getType()) >= item.getConfiguration().getValue(ItemConfigurationFlag.LEVEL_REQUIREMENT);
        }
        return true;
    }


}
