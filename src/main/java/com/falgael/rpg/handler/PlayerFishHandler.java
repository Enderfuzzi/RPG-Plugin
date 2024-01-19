package com.falgael.rpg.handler;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.List;

public class PlayerFishHandler extends MainHandler {

    private static final long BASE_EXPERIENCE = 8L;

    public PlayerFishHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onFishEvent(PlayerFishEvent event) {
        if (event.isCancelled()) return;
        DefaultItem handItem = itemAdapter.getItemByKey(event.getPlayer().getInventory().getItemInMainHand());
        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {
            if (proficiencyAdapter.performAction(event, handItem, event.getPlayer())) return;
            if (event.getCaught() instanceof Item item) {
                if (item.getItemStack().getType().equals(Material.COD) ||
                        item.getItemStack().getType().equals(Material.SALMON) ||
                        item.getItemStack().getType().equals(Material.TROPICAL_FISH) ||
                        item.getItemStack().getType().equals(Material.PUFFERFISH)) {

                    int drops = proficiencyAdapter.calculateLoot(event.getPlayer(), Proficiency.FARMING);
                    proficiencyAdapter.dropAdditionalLoot(item.getItemStack(), drops, event.getPlayer().getWorld(), event.getPlayer().getLocation());
                }
            }
            proficiencyAdapter.calculateExperience(event.getPlayer(), List.of(Proficiency.FARMING), BASE_EXPERIENCE);
        }
    }
}
