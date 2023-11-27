package com.falgael.rpg.items.configuration;

import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

/**
 * Contains special information about an item. Uses a Builder Layout for creating Items.
 * @author falgael
 * @version 0.0.1
 */
public class ItemConfiguration {

    private final List<EquipmentSlot> equipmentSlot;


    private final HashMap<ConfigurationFlag, Double> flags;

    private final List<ConfigurationFlag.Special> specialFlags;

    private final List<PotionEffect> potionEffects;



    /**
     * A Special Action which can be defined and applied in different situations
     */
    private PredicateConsumer<Event> action;

    private ItemConfiguration(List<EquipmentSlot> equipmentSlot, HashMap<ConfigurationFlag, Double> flags, List<PotionEffect> potionEffects, List<ConfigurationFlag.Special> specialFlags , PredicateConsumer<Event> action) {
        this.equipmentSlot = equipmentSlot;
        this.flags = flags;
        this.specialFlags = specialFlags;
        this.potionEffects = potionEffects;


        if (action != null) {
            this.action = action;
        } else {
            for (ConfigurationFlag flag : ConfigurationFlag.values()) {
                if (flags.containsKey(flag) && flag.getAction(flags.get(flag)) != null) {
                    this.action = flag.getAction(flags.get(flag));
                    break;
                }
            }
        }
    }

    /**
     * @return The EquipmentSlot in which the Items is active
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
    public boolean hasFlag(ConfigurationFlag flag) {
        return hasFlags() && flags.containsKey(flag);
    }

    /**
     * Returns the Value of a specific Flag. Before usage, it is necessary to check that the configuration has this flag set.
     * @param flag The flag to search for
     * @return the float Value of the given {@link ItemConfigurationFlag}
     */
    public Double getValue(ConfigurationFlag flag) {
        return flags.getOrDefault(flag, 0.0);
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
    public List<PotionEffect> getPotionEffects() {
        return potionEffects;
    }

    /**
     * @return {@code true} if an Action is set for this Configuration
     */
    public boolean hasAction() {
        return action != null;
    }


    public boolean hasSpecialFlag(ConfigurationFlag.Special flag) {
        return specialFlags.contains(flag);
    }



    /**
     * Gets the action of this configuration. It should be checked that this configuration has an action set before usage.
     * @return the Action if set or {@code null}
     */
    public PredicateConsumer<Event> getAction() {
        return action;
    }

    /**
     * Builder Class for Items creation.
     * @author falgael
     * @version 0.0.1
     */
    public static class Builder {
        private List<EquipmentSlot> equipmentSlot;
        private HashMap<ConfigurationFlag,Double> flags;

        private List<ConfigurationFlag.Special> specialFlags;
        private List<PotionEffect> potionEffects;


        private PredicateConsumer<Event> action = null;


        public Builder() {
            this(new ArrayList<>());
        }


        /**
         * Initializes a new Builder for Creating a new Items
         * @param equipmentSlot the equipment slot in which the item should be active
         */
        public Builder(EquipmentSlot... equipmentSlot) {
            this(List.of(equipmentSlot));
        }

        public Builder(List<EquipmentSlot> equipmentSlot) {
            this.equipmentSlot = equipmentSlot;

            flags = new HashMap<>();
            specialFlags = new ArrayList<>();
            potionEffects = new ArrayList<>();
        }


        public Builder addFlag(ConfigurationFlag flag, Integer value) {
            return addFlag(flag, value.doubleValue());
        }

        public Builder addFlag(ConfigurationFlag flag) {
            return addFlag(flag, 0);
        }

        public Builder addFlags(Map<ConfigurationFlag, Double> flags) {
            flags.forEach(this::addFlag);
            return this;
        }

        /**
         * Adds a new {@link ItemConfigurationFlag} with value to the current configuration
         * @param flag the Flag to set
         * @param value the Value which get assigned to the flag
         * @return the current Builder state
         */
        public Builder addFlag(ConfigurationFlag flag, Double value) {
            flags.put(flag,value);
            return this;
        }

        public Builder addFlag(ConfigurationFlag.Special flag) {
            this.specialFlags.add(flag);
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

        public Builder addPotionEffect(PotionEffectType potionType, int duration, int amplifier) {
            return addPotionEffect(new PotionEffect(potionType, duration, amplifier, true, false));
        }

        public Builder addPotionEffect(PotionEffectType potionType, int amplifier) {
            return addPotionEffect(potionType,110, amplifier);
        }

        public Builder addPotionEffect(PotionEffectType potionType) {
            return addPotionEffect(potionType, 0);
        }

        public Builder addPotionEffect(Map<PotionEffectType, Integer> map) {
            map.forEach(this::addPotionEffect);
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
            return new ItemConfiguration(equipmentSlot, flags, potionEffects, specialFlags, action);
        }
    }
}
