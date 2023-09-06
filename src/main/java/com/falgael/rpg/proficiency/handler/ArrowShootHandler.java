package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.items.CustomTool;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ArrowShootHandler implements Listener {

    @EventHandler
    public void onArrowShoot(ProjectileLaunchEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getEntity() instanceof Arrow arrow)) return;
        if (event.getEntity().getShooter() instanceof Player player) {
            CustomTool customTool = CustomTool.getItem(player.getInventory().getItemInMainHand());
            

        }
    }


}
