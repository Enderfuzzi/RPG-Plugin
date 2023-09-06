package com.falgael.rpg.proficiency.general;

import com.falgael.rpg.proficiency.Messages;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfigurationFlag;
import com.falgael.rpg.proficiency.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Utils {

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
        double lootValue = tool.getItemConfiguration().getValue(ItemConfigurationFlag.LOOT_MULTIPLIER);
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
