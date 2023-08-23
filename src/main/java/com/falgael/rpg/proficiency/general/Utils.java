package com.falgael.rpg.proficiency.general;

import com.falgael.rpg.proficiency.Messages;
import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.player.PlayerManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Utils {

    public static ItemStack modifyAmount(ItemStack itemStack, int amount) {
        ItemStack result = new ItemStack(itemStack);
        result.setAmount(amount);
        return result;
    }


    public static void increaseExperience(Player player, ProficiencyType proficiencyType, long experienceAmount) {
        PlayerManager.getProficiencyData(player.getUniqueId()).increaseExperience(proficiencyType,experienceAmount);
        Messages.experienceIncreaseMessage(player,proficiencyType);

    }

    public static String getMaterialName(Material material) {
        String[] split = material.name().toLowerCase().split("_");
        for (int i = 0; i < split.length; i++) split[i] = split[i].substring(0,1).toUpperCase() + split[i].substring(1);
        return String.join(" ", split);
    }


}
