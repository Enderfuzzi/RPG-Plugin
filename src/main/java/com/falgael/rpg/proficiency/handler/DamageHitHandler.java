package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.items.CustomItem;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageHitHandler implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getDamager() instanceof Player player)) return;
        CustomTool customTool = CustomTool.getItem(player.getInventory().getItemInMainHand());
        event.setDamage(ItemConfiguration.calculateDamage(customTool, event.getDamage(), player));
    }



}
