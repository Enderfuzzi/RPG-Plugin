package com.falgael.rpg.proficiency.handler;


import com.falgael.rpg.proficiency.items.ItemConfiguration;

import com.falgael.rpg.tmp.Calculation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;


public class ArrowShootHandler implements Listener {



    @EventHandler
    public void onArrowShoot(ProjectileLaunchEvent event) {
        if (event.isCancelled()) return;
        if (event.getEntity().getShooter() instanceof Player player) {
            if (event.getEntity() instanceof Arrow arrow) {
                double baseDamage = arrow.getDamage();
                double modifiedDamage = Calculation.calculateTotalDamage(arrow.getDamage(), player);
                Bukkit.getLogger().info("[" + DamageHitHandler.class.getSimpleName() + "] Base damage: " + baseDamage + " Modified Damage: " + modifiedDamage);
                arrow.setDamage(modifiedDamage);
            }
        }




    }


}
