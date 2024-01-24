package com.falgael.rpg.handler;

import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.definitions.stats.EntityStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageHitHandler extends MainHandler {

    public DamageHitHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getDamager() instanceof Player player)) return;

        EntityStats entityStats = EntityStats.getEntity(event.getEntity().getType());
        Bukkit.getLogger().info("[" + DamageHitHandler.class.getSimpleName() + "] Entity type: " + event.getEntity().getType());
        Bukkit.getLogger().info("[" + DamageHitHandler.class.getSimpleName() + "] Entity found: " + !entityStats.isNone());
        if (entityStats.isNone()) return;

        double baseDamage = event.getDamage();
        double modifiedDamage = proficiencyAdapter.calculateTotalDamage(player, entityStats.getProficiencies(),baseDamage);

        Bukkit.getLogger().info("[" + DamageHitHandler.class.getSimpleName() + "] Base damage: " + baseDamage + " Modified Damage: " + modifiedDamage);

        event.setDamage(modifiedDamage);
    }



}
