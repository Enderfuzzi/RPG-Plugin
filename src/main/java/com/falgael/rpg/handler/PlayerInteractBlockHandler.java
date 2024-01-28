package com.falgael.rpg.handler;

import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerInteractBlockHandler extends MainHandler {

    public PlayerInteractBlockHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onPlayerInteractWithBlock(PlayerInteractEvent event) {
        if (!event.hasBlock()) return;

        if (proficiencyAdapter.performAction(event, itemAdapter.getItemByKey(event.getItem()), event.getPlayer())) return;

        if (event.getClickedBlock().getBlockData() instanceof Beehive beehive) {
            if (beehive.getHoneyLevel() != beehive.getMaximumHoneyLevel()) return;
            long experienceAmount = 0L;
            if (event.getItem() != null) {
                if (event.getItem().isSimilar(new ItemStack(Material.GLASS_BOTTLE))) experienceAmount = 8L;
                if (event.getItem().getType() == Material.SHEARS) experienceAmount = 4L;
            }
            proficiencyAdapter.calculateExperience(event.getPlayer(), List.of(Proficiency.FARMING), experienceAmount);
        }
    }

}
