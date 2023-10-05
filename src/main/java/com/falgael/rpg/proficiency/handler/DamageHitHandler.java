package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.tmp.Calculation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class DamageHitHandler implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getDamager() instanceof Player player)) return;
        double baseDamage = event.getDamage();
        double modifiedDamage = Calculation.calculateTotalDamage(baseDamage, player);

        Bukkit.getLogger().info("[" + DamageHitHandler.class.getSimpleName() + "] Base damage: " + baseDamage + " Modified Damage: " + modifiedDamage);

        event.setDamage(modifiedDamage);
    }



}
