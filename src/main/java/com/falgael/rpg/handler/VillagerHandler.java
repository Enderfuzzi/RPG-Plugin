package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.manager.PlayerExperienceManagement;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.proficiency.player.PlayerMessage;
import com.falgael.rpg.proficiency.player.PlayerMessages;
import com.falgael.rpg.old.PlayerManager;
import com.falgael.rpg.villager.CustomVillager;
import com.falgael.rpg.villager.VillagerInstance;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.MerchantRecipe;

public class VillagerHandler extends MainHandler  implements PlayerMessage {
    private PlayerExperienceManagement playerExperience;

    public VillagerHandler(MainManagement mainManager, PlayerExperienceManagement playerExperience) {
        super(mainManager);
        this.playerExperience = playerExperience;
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        if (!(event.getRightClicked() instanceof org.bukkit.entity.Villager villager)) return;
        Bukkit.getLogger().info("villager interact event");
        VillagerInstance villagerInstance = villagerAdapter.getVillager(villager);
        if (!villagerAdapter.isDefault(villagerInstance)) return;

        for (MerchantRecipe recipe : villager.getRecipes()) {
            Bukkit.getLogger().info("Reset uses: " + recipe.getUses());
            recipe.setUses(0);
        }

        int playerLevel = playerExperience.getLevel(event.getPlayer(), villagerInstance.getProficiency());
        if (playerLevel < villagerInstance.getLevelRequirement()) {
            Bukkit.getLogger().info("villager Deny interaction");
            denyVillagerInteraction(event.getPlayer(),villagerInstance.getProficiency(),villagerInstance.getLevelRequirement());
            event.setCancelled(true);
        }
    }

}
