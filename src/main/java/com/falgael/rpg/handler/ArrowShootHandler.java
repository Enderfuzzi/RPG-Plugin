package com.falgael.rpg.handler;


import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.villager.VillagerManagement;
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
