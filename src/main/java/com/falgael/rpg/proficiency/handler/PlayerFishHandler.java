package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.ProficiencyType;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishHandler implements Listener {

    @EventHandler
    public void onFishEvent(PlayerFishEvent event) {
        if (event.isCancelled()) return;

        CustomTool customTool = CustomTool.getItem(event.getPlayer().getInventory().getItemInMainHand());

        if (event.getState() == PlayerFishEvent.State.CAUGHT_FISH) {

            if (!customTool.isNone() && customTool.getItemConfiguration().hasAction()) {
                if (customTool.getItemConfiguration().getAction().accept(event)) return;
            }

            if (event.getCaught() instanceof Item item) {


                if (item.getItemStack().getType().equals(Material.COD) || item.getItemStack().getType().equals(Material.SALMON) ||
                        item.getItemStack().getType().equals(Material.TROPICAL_FISH) || item.getItemStack().getType().equals(Material.PUFFERFISH)) {

                    item.getItemStack().setAmount(ItemConfiguration.calculateLoot(customTool, ProficiencyType.FARMING, event.getPlayer()) + 1);

                }


            }

            Utils.increaseExperience(event.getPlayer(),ProficiencyType.FARMING,ItemConfiguration.calculateExperience(customTool,8,ProficiencyType.FARMING, event.getPlayer()) );


        }

    }
}
