package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.misc.Calculations;
import com.falgael.rpg.stats.EntityStats;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageHitHandler extends MainHandler {

    public DamageHitHandler(ProficiencyCalculationAdapter proficiencyAdapter, ItemManagement itemAdapter, VillagerManagement villagerAdapter) {
        super(proficiencyAdapter, itemAdapter, villagerAdapter);
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
