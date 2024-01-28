package com.falgael.rpg.manager;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.configuration.ConfigurationFlag;
import com.falgael.rpg.manager.interfaces.PlayerExperienceManagement;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.player.PlayerMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;


import java.util.List;

public class ProficiencyExperienceCalculator implements ProficiencyExperienceCalculation, PlayerMessage {

    private final PlayerExperienceManagement playerExperience;

    private final ItemManagement itemManagement;

    public ProficiencyExperienceCalculator(PlayerExperienceManagement playerExperience, ItemManagement itemManagement) {
        this.playerExperience = playerExperience;
        this.itemManagement = itemManagement;
    }

    @Override
    public DefaultItem getItem(Player player, EquipmentSlot slot) {
        if (player == null || slot == null) return itemManagement.getDefault();
        DefaultItem result  = itemManagement.getItemByKey(player.getInventory().getItem(slot));
        if (!result.getConfiguration().compareEquipmentSlot(slot)) return itemManagement.getDefault();
        return result;
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


    @Override
    public void calculateExperience(Player player, List<Proficiency> proficiencies, long baseExperience) {
        if (baseExperience <= 0) return;
        for (Proficiency proficiency : proficiencies) {
            long calculatedExperience = baseExperience * Double.valueOf(calculateMultiplier(player , proficiency, ConfigurationFlag.EXPERIENCE)).longValue();
            Bukkit.getLogger().info("Calculated Experience for " + proficiency + ": " + calculatedExperience);
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

    @Deprecated
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
    @Deprecated
    public void dropAdditionalLoot(ItemStack drop, int dropAmount, World world, Location location) {
        dropAdditionalLoot(List.of(drop), dropAmount, world, location);
    }

}
