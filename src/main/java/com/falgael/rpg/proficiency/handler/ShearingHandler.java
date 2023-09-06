package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.proficiency.items.effects.BlockBreakEffect;
import com.google.common.collect.ImmutableMap;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;


import java.util.Map;

public class ShearingHandler implements Listener {

    private static final Map<DyeColor, Material> WOOL_BY_DYE = ImmutableMap.<DyeColor, Material>builder()
            .put(DyeColor.WHITE, Material.WHITE_WOOL)
            .put(DyeColor.ORANGE,Material.ORANGE_WOOL)
            .put(DyeColor.MAGENTA, Material.MAGENTA_WOOL)
            .put(DyeColor.LIGHT_BLUE,Material.LIGHT_BLUE_WOOL)
            .put(DyeColor.YELLOW, Material.YELLOW_WOOL)
            .put(DyeColor.LIME, Material.LIME_WOOL)
            .put(DyeColor.PINK, Material.PINK_WOOL)
            .put(DyeColor.GRAY, Material.GRAY_WOOL)
            .put(DyeColor.LIGHT_GRAY, Material.LIGHT_GRAY_WOOL)
            .put(DyeColor.CYAN, Material.CYAN_WOOL)
            .put(DyeColor.PURPLE, Material.PURPLE_WOOL)
            .put(DyeColor.BLUE, Material.BLUE_WOOL)
            .put(DyeColor.BROWN, Material.BROWN_WOOL)
            .put(DyeColor.GREEN, Material.GREEN_WOOL)
            .put(DyeColor.RED, Material.RED_WOOL)
            .put(DyeColor.BLACK, Material.BLACK_WOOL)
            .build();



    @EventHandler
    public void onShear(PlayerShearEntityEvent event) {
        if (event.isCancelled()) return;

        long experienceAmount = 0L;
        int droppedBlocks = 0;
        if (event.getEntity() instanceof Sheep sheep) {
            /*
            experienceAmount = 4;
            droppedBlocks = 0;


             */
            CustomTool customTool = CustomTool.getItem(event.getItem());
            Bukkit.getLogger().info("Custom Tool None: " + customTool.isNone());

            experienceAmount = ItemConfiguration.calculateExperience(customTool, 4L, ProficiencyType.FARMING);
            droppedBlocks = ItemConfiguration.calculateLoot(customTool, ProficiencyType.FARMING);

            /*
            if (!customTool.isNone()) {

                Bukkit.getLogger().info("Custom Block Break: " + customTool.getItemConfiguration().hasBlockBreakEffect());
                if (customTool.getItemConfiguration().hasBlockBreakEffect()) {
                    BlockBreakEffect blockBreakEffect = customTool.getItemConfiguration().getBlockBreakEffect();
                    experienceAmount *= blockBreakEffect.getExperienceModifier();
                    droppedBlocks = blockBreakEffect.calculateDroppedBlocks();

                }
            }

             */
            /*
            Bukkit.getLogger().info("Sheep Color: " + sheep.getColor());

            Material material = WOOL_BY_DYE.getOrDefault(sheep.getColor(), Material.AIR);
            if (material != Material.AIR && droppedBlocks != 0) {
                sheep.getWorld().dropItemNaturally(sheep.getLocation(), new ItemStack(material, droppedBlocks));
            }


             */
            Bukkit.getLogger().info("Sheep Color: " + sheep.getColor());

            Material material = WOOL_BY_DYE.getOrDefault(sheep.getColor(), Material.AIR);
            ItemConfiguration.dropAdditionalLoot(new ItemStack(material, droppedBlocks), 1, sheep.getWorld(), sheep.getLocation());




        }

        Utils.increaseExperience(event.getPlayer(), ProficiencyType.FARMING, experienceAmount);

    }

}
