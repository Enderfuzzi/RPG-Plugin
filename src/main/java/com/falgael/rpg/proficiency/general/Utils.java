package com.falgael.rpg.proficiency.general;

import com.falgael.rpg.proficiency.Messages;
import com.falgael.rpg.proficiency.blocks.BlockBreak;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfigurationFlag;
import com.falgael.rpg.proficiency.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Utils {


    public static long calculateExperience(CustomTool tool, long baseExperience, ProficiencyType type) {
        if (tool.getProficiencyType() != type) return baseExperience;
        return calculateExperience(tool,baseExperience);
     }

    public static long calculateExperience(CustomTool tool, long baseExperience) {
        if (tool.isNone()) return baseExperience;

        if (tool.getItemConfiguration().hasFlag(ItemConfigurationFlag.EXPERIENCE_Multiplier))
            return baseExperience * Math.round(tool.getItemConfiguration().getValue(ItemConfigurationFlag.EXPERIENCE_Multiplier));

        return baseExperience;
    }


    public static int calculateLoot(CustomTool tool, ProficiencyType type) {
        if (tool.getProficiencyType() != type) return 0;

        return calculateLoot(tool);

    }

    public static int calculateLoot(CustomTool tool) {
        if (tool.isNone()) return 0;

        if (!tool.getItemConfiguration().hasFlag(ItemConfigurationFlag.LOOT_Multiplier)) return 1;

        float lootValue = tool.getItemConfiguration().getValue(ItemConfigurationFlag.LOOT_Multiplier);
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


    public static ItemStack modifyItemAmount(ItemStack itemStack, int amount) {
        ItemStack result = new ItemStack(itemStack);
        result.setAmount(amount);
        return result;
    }


    public static void increaseExperience(Player player, ProficiencyType proficiencyType, long experienceAmount) {
        if (experienceAmount <= 0) return;
        PlayerManager.getProficiencyData(player.getUniqueId()).increaseExperience(proficiencyType,experienceAmount);
        Messages.experienceIncreaseMessage(player,proficiencyType);

    }

    public static String getMaterialName(Material material) {
        String[] split = material.name().toLowerCase().split("_");
        for (int i = 0; i < split.length; i++) split[i] = split[i].substring(0,1).toUpperCase() + split[i].substring(1);
        return String.join(" ", split);
    }

    private static void testCalculation(CustomTool tool) {
        double lootValue = tool.getItemConfiguration().getValue(ItemConfigurationFlag.LOOT_Multiplier);
        Bukkit.getLogger().info("Start Test: Estimated: " + lootValue);
        int iterations = 1000;
        int result_value = 0;
        for (int i = 0; i < iterations; i++) {
            double value = lootValue - Math.floor(lootValue);
            double random = Math.random();
            if (random < value) result_value += Math.ceil(lootValue) - 1;
            else result_value += Math.floor(lootValue) - 1;
        }
        Bukkit.getLogger().info("Result value: " + result_value + "Result:" + (double)result_value/(double) iterations );
    }


}
