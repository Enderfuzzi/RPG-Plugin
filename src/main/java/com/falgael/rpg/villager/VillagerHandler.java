package com.falgael.rpg.villager;

import com.falgael.rpg.proficiency.Messages;
import com.falgael.rpg.proficiency.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.MerchantRecipe;

public class VillagerHandler implements Listener {

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof Villager villager)) return;
        Bukkit.getLogger().info("villager interact event");
        CustomVillager customVillager = CustomVillager.getVillager(villager);
        if (customVillager.isNone()) {
            Bukkit.getLogger().info("villager is not found");
            return;
        }

        for (MerchantRecipe recipe : villager.getRecipes()) {
            Bukkit.getLogger().info("Reset uses: " + recipe.getUses());
            recipe.setUses(0);
        }

        int playerLevel = PlayerManager.getProficiencyData(event.getPlayer().getUniqueId()).getLevel(customVillager.getProficiency());
        if (playerLevel < customVillager.getLevelRequirement()) {
            Bukkit.getLogger().info("villager Deny interaction");
            Messages.denyVillagerInteraction(event.getPlayer(), customVillager.getProficiency(), customVillager.getLevelRequirement());
            event.setCancelled(true);
        }

    }

}
