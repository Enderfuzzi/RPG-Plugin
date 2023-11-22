package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.Items;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.misc.Calculations;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.Material;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerInteractBlockHandler extends MainHandler {

    public PlayerInteractBlockHandler(ProficiencyCalculationAdapter proficiencyAdapter, ItemManagement itemAdapter, VillagerManagement villagerAdapter) {
        super(proficiencyAdapter, itemAdapter, villagerAdapter);
    }

    @EventHandler
    public void onPlayerInteractWithBlock(PlayerInteractEvent event) {
        if (!event.hasBlock()) return;

        if (proficiencyAdapter.performAction(event, itemAdapter.getItem(event.getItem()), event.getPlayer())) return;

        if (event.getClickedBlock().getBlockData() instanceof Beehive beehive) {
            if (beehive.getHoneyLevel() != beehive.getMaximumHoneyLevel()) return;
            long experienceAmount = 0L;
            if (event.getItem().isSimilar(new ItemStack(Material.GLASS_BOTTLE))) experienceAmount = 8L;
            if (event.getItem().getType() == Material.SHEARS) experienceAmount = 4L;
            proficiencyAdapter.calculateExperience( event.getPlayer(), List.of(Proficiency.FARMING), experienceAmount);
        }
    }

}
