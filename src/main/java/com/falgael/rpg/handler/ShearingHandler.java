package com.falgael.rpg.handler;

import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.misc.Calculations;
import com.falgael.rpg.proficiency.Proficiency;
import com.google.common.collect.ImmutableMap;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;


import java.util.Map;

public class ShearingHandler extends MainHandler {

    private static final long BASE_EXPERIENCE = 4L;

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

    public ShearingHandler(ProficiencyCalculationAdapter proficiencyAdapter) {
        super(proficiencyAdapter);
    }


    @EventHandler
    public void onShear(PlayerShearEntityEvent event) {
        if (event.isCancelled()) return;
        if (event.getEntity() instanceof Sheep sheep) {
            proficiencyAdapter.calculateExperience(event.getPlayer(), Proficiency.FARMING, BASE_EXPERIENCE);

            int droppedBlocks = proficiencyAdapter.calculateLoot(event.getPlayer(), Proficiency.FARMING);

            Material material = WOOL_BY_DYE.getOrDefault(sheep.getColor(), Material.AIR);
            proficiencyAdapter.dropAdditionalLoot(new ItemStack(material, droppedBlocks), 1, sheep.getWorld(), sheep.getLocation());
        }


    }

}
