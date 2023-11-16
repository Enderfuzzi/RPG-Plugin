package com.falgael.rpg.handler;

import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.proficiency.player.PlayerMessages;
import com.falgael.rpg.old.PlayerManager;
import com.falgael.rpg.villager.CustomVillager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.MerchantRecipe;

public class VillagerHandler extends MainHandler {

    public VillagerHandler(ProficiencyCalculationAdapter proficiencyAdapter) {
        super(proficiencyAdapter);
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof org.bukkit.entity.Villager villager)) return;
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
            PlayerMessages.denyVillagerInteraction(event.getPlayer(), customVillager.getProficiency(), customVillager.getLevelRequirement());
            event.setCancelled(true);
        }

    }

}
