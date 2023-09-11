package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.RPG;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.proficiency.items.ItemConfigurationFlag;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class ArrowShootHandler implements Listener {



    @EventHandler
    public void onArrowShoot(ProjectileLaunchEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getEntity() instanceof Arrow arrow)) return;
        if (event.getEntity().getShooter() instanceof Player player) {
            CustomTool customTool = CustomTool.getItem(player.getInventory().getItemInMainHand());
            if (customTool.isNone()) return;
            arrow.setDamage(ItemConfiguration.calculateDamage(customTool,arrow.getDamage(), player));
            arrow.setMetadata(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER.name(), new FixedMetadataValue(Bukkit.getPluginManager().getPlugin(RPG.PLUGIN_NAME),
                    customTool.getItemConfiguration().getValue(ItemConfigurationFlag.EXPERIENCE_MULTIPLIER)));
        }
    }


}
