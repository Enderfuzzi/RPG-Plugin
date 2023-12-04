package com.falgael.rpg.manager;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.SinglePredicateConsumer;
import com.falgael.rpg.items.set.DefaultItemSet;
import com.falgael.rpg.proficiency.Proficiency;
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
import java.util.HashMap;
import java.util.List;

public interface ProficiencyCalculationAdapter {


    default double calculateMultiplier(Player player, Proficiency proficiency, ConfigurationFlag flag) {
        if (flag == null || proficiency == null || player == null) return 0L;
        double multiplier = 1;

        List<DefaultItem> items = getEquippedItems(player);
        for (DefaultItem currentItem : items) {
            if (!currentItem.hasProficiency(proficiency)) continue;
            multiplier += currentItem.getConfiguration().getValue(flag);
        }

        for (DefaultItemSet set : getFulfilledSets(items)) {
            if (!set.hasProficiency(proficiency)) continue;
            multiplier += set.getConfiguration().getValue(flag);
        }
        Bukkit.getLogger().info("Calculated Modifier: " + multiplier + " for " + proficiency + " and " + flag);
        return multiplier;
    }

    DefaultItem getItem(Player player, EquipmentSlot slot);

    boolean fulfillLevelRequirement(Player player, DefaultItem item);


    default List<DefaultItem> getEquippedItems(Player player) {
        List<DefaultItem> result = new ArrayList<>();
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            DefaultItem item = getItem(player, slot);
            Bukkit.getLogger().info("Checked Item is default: " + item.isDefault());
            if (item.isDefault()) continue;
            if (!fulfillLevelRequirement(player, item)) continue;
            result.add(item);
        }
        Bukkit.getLogger().info("Equipped Items: " + result.stream().map(DefaultItem::getName).toList());
        return result;
    }

    default List<DefaultItemSet> getFulfilledSets(List<DefaultItem> equippedItems) {
        List<DefaultItemSet> result = new ArrayList<>();
        HashMap<DefaultItemSet, Integer> setOccurrence = new HashMap<>();
        for (DefaultItem currentItem : equippedItems) {
            if (setOccurrence.containsKey(currentItem.getEquipmentSet())) {
                setOccurrence.put(currentItem.getEquipmentSet(), setOccurrence.get(currentItem.getEquipmentSet()) + 1);
            } else {
                setOccurrence.put(currentItem.getEquipmentSet(),1);
            }
        }
        setOccurrence.forEach((k, v) -> {if (k.getPartNumber() <= v && !k.isDefault()) result.add(k);});
        Bukkit.getLogger().info("Fulfilled Sets: " + result.stream().map(DefaultItemSet::getName).toList());
        return result;
    }

    void calculateExperience(Player player, List<Proficiency> proficiencies, long baseExperience);

    default void calculateExperience(Player player, Proficiency proficiency , long baseExperience) {
        calculateExperience(player, List.of(proficiency), baseExperience);
    }

    int calculateLoot(Player player, Proficiency proficiency);

    default int calculateLoot(Player player, List<Proficiency> proficiencies) {
        int result = 0;
        for (Proficiency proficiency : proficiencies) result += calculateLoot(player, proficiency);
        return result;
    }


    double calculateTotalDamage(Player player, List<Proficiency> proficiencies, double base);

    default double calculateTotalDamage(Player player,Proficiency proficiency, double base) {
        return calculateTotalDamage(player, List.of(proficiency), base);
    }



    default void dropAdditionalLoot(List<ItemStack> drops, int dropAmount, World world, Location location) {
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

    default void dropAdditionalLoot(ItemStack drop, int dropAmount, World world, Location location) {
        dropAdditionalLoot(List.of(drop), dropAmount, world, location);
    }


    default boolean performAction(Event e, DefaultItem item) {
        if (e == null || item == null) return false;
        if (!item.getConfiguration().hasAction()) return false;
        return item.getConfiguration().getAction().accept(e, this);
    }

    default boolean performAction(Event e, DefaultItem item, Player player) {
        if (player == null) return false;
        Bukkit.getLogger().info("level requirement check");
        if (!fulfillLevelRequirement(player, item)) return false;
        Bukkit.getLogger().info("Accepted level requirement");
        return performAction(e, item);
    }

    default boolean performAction(Player player, Event e, SinglePredicateConsumer<DefaultItem> predicate) {
        DefaultItem item = getItem(player, EquipmentSlot.HAND);
        if (item.isDefault()) return false;
        if (!predicate.accept(item)) return false;
        return performAction(e, item, player);
    }


    default void applyPotionEffects(Player player) {
        List<DefaultItem> equippedItems = getEquippedItems(player);
        for (DefaultItem item : equippedItems) {
            if (!item.getConfiguration().hasPotionEffect()) continue;
            for (PotionEffect potionEffect : item.getConfiguration().getPotionEffects()) player.addPotionEffect(potionEffect);
        }

        List<DefaultItemSet> fulfilledSets = getFulfilledSets(equippedItems);
        for (DefaultItemSet set : fulfilledSets) {
            if (!set.getConfiguration().hasPotionEffect()) continue;
            for (PotionEffect potionEffect : set.getConfiguration().getPotionEffects()) player.addPotionEffect(potionEffect);
        }

    }


}
