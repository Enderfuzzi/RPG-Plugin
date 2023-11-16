package com.falgael.rpg.handler;

import com.falgael.rpg.items.Items;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.misc.Calculations;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractHandler extends MainHandler {
    public PlayerInteractHandler(ProficiencyCalculationAdapter proficiencyAdapter) {
        super(proficiencyAdapter);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Calculations.performAction(event, Items.getItem(event.getItem()), event.getPlayer());
    }
}
