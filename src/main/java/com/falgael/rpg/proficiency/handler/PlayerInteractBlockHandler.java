package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import org.bukkit.Material;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractBlockHandler implements Listener {

    @EventHandler
    public void onPlayerInteractWithBlock(PlayerInteractEvent event) {
        if (!event.hasBlock()) return;
        if (event.getClickedBlock().getBlockData() instanceof Beehive beehive) {
            if (beehive.getHoneyLevel() != beehive.getMaximumHoneyLevel()) return;
            long experienceAmount = 0L;
            if (event.getItem().isSimilar(new ItemStack(Material.GLASS_BOTTLE))) experienceAmount = 8L;
            if (event.getItem().getType() == Material.SHEARS) experienceAmount = 4L;
            CustomTool customTool = CustomTool.getItem(event.getItem());

            experienceAmount = ItemConfiguration.calculateExperience(customTool, experienceAmount,ProficiencyType.FARMING);
            /*
            if (!customTool.isNone() && customTool.getProficiencyType() == ProficiencyType.FARMING) {
                if (customTool.getItemConfiguration().hasBlockBreakEffect())
                experienceAmount *= customTool.getItemConfiguration().getBlockBreakEffect().getExperienceModifier();
            }

             */
            if (experienceAmount != 0) Utils.increaseExperience(event.getPlayer(), ProficiencyType.FARMING, experienceAmount);
        }
    }

}
