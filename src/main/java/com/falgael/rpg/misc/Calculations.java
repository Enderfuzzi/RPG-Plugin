package com.falgael.rpg.misc;

import com.falgael.rpg.items.Items;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.set.ItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Calculations {

    private static double calculateModifier(ConfigurationFlag flag, Proficiency proficiency, Player player) {
        if (flag == null || proficiency == null || player == null) return 0L;
        double multiplier = 1;

        List<Items> items = getEquippedItems(player);
        for (Items currentItem : items) {
            Bukkit.getLogger().info("Start check");
            if (currentItem.hasProficiency(proficiency)) continue;
            Bukkit.getLogger().info("Proficiency check successful");
            if (!checkLevelRequirement(currentItem, player)) continue;
            Bukkit.getLogger().info("Level check successful");
            if (!currentItem.hasConfiguration()) continue;
            Bukkit.getLogger().info("configuration check successful");

            multiplier += currentItem.getConfiguration().getValue(flag);
        }

        for (ItemSet set : getFulfilledSets(items,proficiency, player)) {
            if (!set.hasProficiency(proficiency)) continue;
            if (!set.hasConfiguration()) continue;
            multiplier += set.getConfiguration().getValue(flag);
        }

        return multiplier;


    }

    private static Items getItem(Player player, EquipmentSlot slot) {
        if (player == null || slot == null) return Items.NONE;
        return Items.getItem(player.getInventory().getItem(slot));
    }
    private static boolean checkLevelRequirement(Items item, Player player) {
        if (item == null || item.isNone() || player == null) return true;
        if (!item.hasConfiguration()) return true;
        if (item.getConfiguration().hasFlag(ConfigurationFlag.LEVEL_REQUIREMENT)) {
            for (Proficiency currentProficiency : item.getProficiencies()) {
                if (!currentProficiency.levelCheck()) continue;
                if (Utils.getPlayerLevel(player, currentProficiency) < item.getConfiguration().getValue(ConfigurationFlag.LEVEL_REQUIREMENT)) return false;
            }
        }
        return true;
    }

    private static List<Items> getEquippedItems(Player player) {
        List<Items> result = new ArrayList<>();
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            Items item = getItem(player, slot);
            if (item.isNone()) continue;
            result.add(item);
        }
        Bukkit.getLogger().info("Equipped Items: " + Arrays.toString(result.toArray()));
        return result;
    }

    private static List<ItemSet> getFulfilledSets(List<Items> equippedItems, Proficiency proficiency ,Player player) {
        List<ItemSet> result = new ArrayList<>();
        HashMap<ItemSet, Integer> setOccurrence = new HashMap<>();
        for (Items currentItem : equippedItems) {
            if (!currentItem.hasProficiency(proficiency)) continue;
            if (!checkLevelRequirement(currentItem, player)) continue;
            if (!currentItem.hasEquipmentSet()) continue;
            if (setOccurrence.containsKey(currentItem.getEquipmentSet())) {
                setOccurrence.put(currentItem.getEquipmentSet(), setOccurrence.get(currentItem.getEquipmentSet()) + 1);
            } else {
                setOccurrence.put(currentItem.getEquipmentSet(),1);
            }
        }
        setOccurrence.forEach((k, v) -> {if (k.getPartNumber() <= v) result.add(k);});
        Bukkit.getLogger().info("Fulfilled Sets: " + result);
        return result;
    }


    public static void calculateExperience(long baseExperience, List<Proficiency> proficiencies, Player player) {
        if (baseExperience <= 0) return;
        for (Proficiency proficiency : proficiencies) {
            long calculatedExperience = baseExperience * (long) calculateModifier(ConfigurationFlag.EXPERIENCE, proficiency, player);
            Utils.increaseExperience(player, proficiency, calculatedExperience);
        }
    }

    public static void calculateExperience(long baseExperience, Proficiency proficiency, Player player) {
        calculateExperience(baseExperience, List.of(proficiency), player);
    }


    public static int calculateLoot(Proficiency proficiency, Player player) {
        double lootValue = calculateModifier(ConfigurationFlag.LOOT, proficiency, player);
        Bukkit.getLogger().info("Loot value: " + lootValue);
        double value = lootValue - Math.floor(lootValue);
        if (value == 0) return (int) lootValue - 1;
        if (Math.random() < value) return (int) Math.ceil(lootValue) - 1;
        return (int) Math.floor(lootValue) - 1;
    }

    public static int calculateLoot(List<Proficiency> proficiencies, Player player) {
        int result = 0;
        for (Proficiency proficiency : proficiencies) result += calculateLoot(proficiency, player);
        return result;
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


    public static double calculateTotalDamage(double base, Player player, List<Proficiency> proficiencies) {
        double result = 0;
        for (Proficiency proficiency : proficiencies) {
            result += base * calculateModifier(ConfigurationFlag.DAMAGE_MULTIPLIER, proficiency, player)
                    + (calculateModifier(ConfigurationFlag.DAMAGE_ADDITIVE, proficiency, player) - 1);
        }
        return result;
    }

    public static double calculateTotalDamage(double base, Player player) {
        return calculateTotalDamage(base, player, List.of(Proficiency.MISC));
    }


    public static boolean performAction(Event e, Items item) {
        if (e == null || item == null) return false;
        if (!item.hasConfiguration() || !item.getConfiguration().hasAction()) return false;
        return item.getConfiguration().getAction().accept(e);
    }

    public static boolean performAction(Event e, Items item, Player player) {
        if (player == null) return false;
        if (!checkLevelRequirement(item, player)) return false;
        Bukkit.getLogger().info("Accepted level requirement");
        return performAction(e, item);
    }

    public static void applyPotionEffects(Player player) {
        List<Items> equippedItems = getEquippedItems(player);
        for (Items item : equippedItems) {
            if (!checkLevelRequirement(item, player)) continue;
            if (!item.hasConfiguration()) continue;
            if (!item.getConfiguration().hasPotionEffect()) continue;
            for (PotionEffect potionEffect : item.getConfiguration().getPotionEffects()) player.addPotionEffect(potionEffect);
        }

        List<ItemSet> fulfilledSets = getFulfilledSets(equippedItems, Proficiency.MISC, player);
        for (ItemSet set : fulfilledSets) {
            if (!set.hasConfiguration() || !set.getConfiguration().hasPotionEffect()) continue;
            for (PotionEffect potionEffect : set.getConfiguration().getPotionEffects()) player.addPotionEffect(potionEffect);
        }

    }



}
