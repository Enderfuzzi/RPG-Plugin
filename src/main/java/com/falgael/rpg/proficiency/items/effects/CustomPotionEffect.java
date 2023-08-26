package com.falgael.rpg.proficiency.items.effects;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;

public class CustomPotionEffect {

    private final EquipmentSlot slot;

    private final ArrayList<PotionEffect> list;

    public CustomPotionEffect(EquipmentSlot slot, ArrayList<PotionEffect> list) {
        this.slot = slot;
        this.list = list;
    }

    public EquipmentSlot getSlot() {
        return slot;
    }

    public ArrayList<PotionEffect> getPotionEffects() {
        return list;
    }


    public static class CustomPotionEffectBuilder {

        private final EquipmentSlot slot;

        private ArrayList<PotionEffect> list;

        public CustomPotionEffectBuilder(EquipmentSlot slot) {
            this.slot = slot;
            list = new ArrayList<>();
        }

        public CustomPotionEffectBuilder addPotionEffect(PotionEffect potionEffect) {
            list.add(potionEffect);
            return this;
        }

        public CustomPotionEffect create() {
            return new CustomPotionEffect(slot,list);
        }

    }

}
