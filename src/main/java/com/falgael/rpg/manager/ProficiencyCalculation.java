package com.falgael.rpg.manager;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.Item;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.Items;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.items.configuration.PredicateConsumer;
import com.falgael.rpg.items.set.ItemSet;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.player.PlayerMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProficiencyCalculation implements ProficiencyCalculationAdapter, PlayerMessage {

    private final PlayerExperienceManagement playerExperience;

    private final ItemManagement itemManagement;

    public ProficiencyCalculation(PlayerExperienceManagement playerExperience, ItemManagement itemManagement) {
        this.playerExperience = playerExperience;
        this.itemManagement = itemManagement;
    }

    @Override
    public double calculateMultiplier(Player player, Proficiency proficiency, ConfigurationFlag flag) {
        if (flag == null || proficiency == null || player == null) return 0L;
        double multiplier = 1;

        List<DefaultItem> items = getEquippedItems(player);
        for (DefaultItem currentItem : items) {
            if (currentItem.hasProficiency(proficiency)) continue;
            multiplier += currentItem.getConfiguration().getValue(flag);
        }

        for (ItemSet set : getFulfilledSets(player, items)) {
            if (!set.hasProficiency(proficiency)) continue;
            if (!set.hasConfiguration()) continue;
            multiplier += set.getConfiguration().getValue(flag);
        }

        return multiplier;
    }

    public DefaultItem getItem(Player player, EquipmentSlot slot) {
        if (player == null || slot == null) return itemManagement.getDefault();
        return itemManagement.getItem(player.getInventory().getItem(slot));
    }

    @Override
    public boolean fulfillLevelRequirement(Player player, @NotNull DefaultItem item) {
        if (!item.getConfiguration().hasFlag(ConfigurationFlag.LEVEL_REQUIREMENT)) return true;
        for (Proficiency currentProficiency : item.getProficiencies()) {
            if (!currentProficiency.levelCheck()) continue;
            if (playerExperience.getLevel(player, currentProficiency) < item.getConfiguration().getValue(ConfigurationFlag.LEVEL_REQUIREMENT)) return false;
        }
        return true;
    }

    public List<DefaultItem> getEquippedItems(Player player) {
        List<DefaultItem> result = new ArrayList<>();
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            DefaultItem item = getItem(player, slot);
            if (itemManagement.isDefault(item)) continue;
            if (!fulfillLevelRequirement(player, item)) continue;
            result.add(item);
        }
        Bukkit.getLogger().info("Equipped Items: " + Arrays.toString(result.toArray()));
        return result;
    }

    @Override
    public List<ItemSet> getFulfilledSets(Player player, List<DefaultItem> equippedItems) {
        List<ItemSet> result = new ArrayList<>();
        HashMap<ItemSet, Integer> setOccurrence = new HashMap<>();
        for (DefaultItem currentItem : equippedItems) {
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

    @Override
    public void calculateExperience(Player player, List<Proficiency> proficiencies, long baseExperience) {
        if (baseExperience <= 0) return;
        for (Proficiency proficiency : proficiencies) {
            long calculatedExperience = baseExperience * Double.valueOf(calculateMultiplier(player , proficiency, ConfigurationFlag.EXPERIENCE)).longValue();
            playerExperience.increaseExperience(player,proficiency,calculatedExperience);
            playerExperienceMessage(player, proficiency, playerExperience.getExperience(player, proficiency), playerExperience.getExperienceBorder(player, proficiency));
        }
    }

    @Override
    public double calculateTotalDamage(Player player, List<Proficiency> proficiencies, double base) {
        double result = 0;
        for (Proficiency proficiency : proficiencies) {
            result += base * calculateMultiplier(player, proficiency, ConfigurationFlag.DAMAGE_MULTIPLIER)
                    + (calculateMultiplier(player, proficiency, ConfigurationFlag.DAMAGE_ADDITIVE) - 1);
        }
        return result;
    }

    @Override
    public int calculateLoot(Player player, Proficiency proficiency) {
        double lootValue = calculateMultiplier(player, proficiency, ConfigurationFlag.LOOT);
        Bukkit.getLogger().info("Loot value: " + lootValue);
        double value = lootValue - Math.floor(lootValue);
        if (value == 0) return (int) lootValue - 1;
        if (Math.random() < value) return (int) Math.ceil(lootValue) - 1;
        return (int) Math.floor(lootValue) - 1;
    }


    public void dropAdditionalLoot(List<ItemStack> drops, int dropAmount, World world, Location location) {
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

    public void dropAdditionalLoot(ItemStack drop, int dropAmount, World world, Location location) {
        dropAdditionalLoot(List.of(drop), dropAmount, world, location);
    }


    public boolean performAction(Event e, DefaultItem item) {
        if (e == null || item == null) return false;
        if (!item.getConfiguration().hasAction()) return false;
        return item.getConfiguration().getAction().accept(e);
    }

    public boolean performAction(Event e, DefaultItem item, Player player) {
        if (player == null) return false;
        if (!fulfillLevelRequirement(player, item)) return false;
        Bukkit.getLogger().info("Accepted level requirement");
        return performAction(e, item);
    }

    public boolean performAction(Player player, Event e, PredicateConsumer<DefaultItem> predicate) {
        DefaultItem item = getItem(player, EquipmentSlot.HAND);
        if (itemManagement.isDefault(item)) return false;
        if (!predicate.accept(item)) return false;
        return performAction(e, item, player);
    }


    public void applyPotionEffects(Player player) {
        List<DefaultItem> equippedItems = getEquippedItems(player);
        for (DefaultItem item : equippedItems) {
            if (!item.getConfiguration().hasPotionEffect()) continue;
            for (PotionEffect potionEffect : item.getConfiguration().getPotionEffects()) player.addPotionEffect(potionEffect);
        }

        List<ItemSet> fulfilledSets = getFulfilledSets(player, equippedItems);
        for (ItemSet set : fulfilledSets) {
            if (!set.hasConfiguration() || !set.getConfiguration().hasPotionEffect()) continue;
            for (PotionEffect potionEffect : set.getConfiguration().getPotionEffects()) player.addPotionEffect(potionEffect);
        }

    }



}
