package com.falgael.rpg.handler;


import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;


public class ArrowShootHandler extends MainHandler {


    public ArrowShootHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onArrowShoot(ProjectileLaunchEvent event) {
        if (event.isCancelled()) return;
        if (event.getEntity().getShooter() instanceof Player player) {
            if (event.getEntity() instanceof Arrow arrow) {
                double baseDamage = arrow.getDamage();
                double modifiedDamage = proficiencyAdapter.calculateTotalDamage(player, Proficiency.MISC, arrow.getDamage());
                Bukkit.getLogger().info("[" + DamageHitHandler.class.getSimpleName() + "] Base damage: " + baseDamage + " Modified Damage: " + modifiedDamage);
                arrow.setDamage(modifiedDamage);
            }
        }




    }


}
