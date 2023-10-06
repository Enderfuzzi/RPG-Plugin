package com.falgael.rpg.tmp;

import com.falgael.rpg.items.ConfigurationFlag;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class Calculation {

    private static float calculateModifier(ConfigurationFlag flag, ProficiencyType type, Player player) {
        if (flag == null || type == null || player == null) return 0L;
        float multiplier = 1f;

        Set<com.falgael.rpg.tmp.CustomItem> itemSet = getEquippedItems(player);
        for (com.falgael.rpg.tmp.CustomItem customItem : itemSet) {
            if (!checkProficiency(customItem, type)) continue;
            if (!checkLevelRequirement(customItem, player)) continue;
            if (!customItem.hasConfiguration()) continue;

            multiplier += customItem.getConfiguration().getValue(flag);
        }

        for (EquipmentSet set : getFulfilledSets(itemSet, player)) {
            if (!checkProficiency(set, type)) continue;
            if (!set.hasConfiguration()) continue;
            multiplier += set.getConfiguration().getValue(flag);
        }

        return multiplier;
    }



    public static long calculateExperience(long baseExperience, ProficiencyType type, Player player) {
        if (baseExperience <= 0) return 0L;
        return baseExperience * (long) calculateModifier(ConfigurationFlag.EXPERIENCE, type, player);
    }

    private static com.falgael.rpg.tmp.CustomItem getItem(Player player, EquipmentSlot slot) {
        if (player == null || slot == null) return com.falgael.rpg.tmp.CustomItem.NONE;
        return com.falgael.rpg.tmp.CustomItem.getItem(player.getInventory().getItem(slot));
    }

    private static boolean checkProficiency(com.falgael.rpg.tmp.CustomItem item, ProficiencyType type) {
        return item.getProficiency() == type || item.getProficiency() == ProficiencyType.MISC || item.getProficiency() == ProficiencyType.NONE;
    }

    private static boolean checkProficiency(EquipmentSet set, ProficiencyType type) {
        return set.getProficiencyType() == type || set.getProficiencyType() == ProficiencyType.MISC || set.getProficiencyType() == ProficiencyType.NONE;
    }

    private static boolean checkLevelRequirement(com.falgael.rpg.tmp.CustomItem item, Player player) {
        if (item == null || item == com.falgael.rpg.tmp.CustomItem.NONE || player == null) return true;
        if (!item.hasConfiguration()) return true;

        if (item.getConfiguration().hasFlag(ConfigurationFlag.LEVEL_REQUIREMENT)) {
            return Utils.getPlayerLevel(player, item.getProficiency()) >= item.getConfiguration().getValue(ConfigurationFlag.LEVEL_REQUIREMENT);
        }
        return true;
    }

    private static Set<com.falgael.rpg.tmp.CustomItem> getEquippedItems(Player player) {
        Set<com.falgael.rpg.tmp.CustomItem> result = new HashSet<>();
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            com.falgael.rpg.tmp.CustomItem item = getItem(player, slot);
            if (item == com.falgael.rpg.tmp.CustomItem.NONE) continue;
            result.add(item);
        }
        return result;
    }

    private static Set<EquipmentSet> getFulfilledSets(Set<com.falgael.rpg.tmp.CustomItem> equippedItems, Player player) {
        Set<EquipmentSet> result = new HashSet<>();
        HashMap<EquipmentSet, Integer> setOccurrence = new HashMap<>();
        for (com.falgael.rpg.tmp.CustomItem customItem : equippedItems) {
            if (!checkLevelRequirement(customItem, player)) continue;
            if (!customItem.hasEquipmentSet()) continue;
            if (setOccurrence.containsKey(customItem.getEquipmentSet())) {
                setOccurrence.put(customItem.getEquipmentSet(), setOccurrence.get(customItem.getEquipmentSet()) + 1);
            } else {
                setOccurrence.put(customItem.getEquipmentSet(),1);
            }
        }
        setOccurrence.forEach((k, v) -> {if (k.getNumberOfParts() <= v) result.add(k);});
        Bukkit.getLogger().info("Fulfilled Sets: " + result);
        return result;
    }

    public static int calculateLoot(ProficiencyType type, Player player) {
        float lootValue = calculateModifier(ConfigurationFlag.LOOT, type, player);
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


    public static double calculateTotalDamage(double base, Player player) {
        return base * calculateModifier(ConfigurationFlag.DAMAGE_MULTIPLIER,ProficiencyType.MISC,player) + calculateModifier(ConfigurationFlag.DAMAGE_ADDITIVE, ProficiencyType.MISC, player);
    }

    public static boolean performAction(Event e, CustomItem item) {
        if (e == null || item == null) return false;
        if (!item.hasConfiguration() || !item.getConfiguration().hasAction()) return false;
        return item.getConfiguration().getAction().accept(e);
    }

    public static boolean performAction(Event e,CustomItem item, Player player) {
        if (player == null) return false;
        if (!checkLevelRequirement(item, player)) return false;
        Bukkit.getLogger().info("Accepted level requirement");
        return performAction(e, item);
    }

}
