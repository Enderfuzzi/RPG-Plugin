package com.falgael.rpg.handler;

import com.falgael.rpg.items.DefaultItem;
import com.falgael.rpg.loottable.LootTableManager;
import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.proficiency.Proficiency;
import org.bukkit.Material;
import org.bukkit.block.data.type.Beehive;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerInteractHandler extends MainHandler {
    public PlayerInteractHandler(MainManagement mainManager) {
        super(mainManager);
    }

    //Interaction with LootBox
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (proficiencyAdapter.performAction(event.getPlayer(), event, DefaultItem::isLootBox)) {
            if (event.getItem() != null) {
                lootComputation.triggerEvent(event.getPlayer(), event.getItem().getType(), LootTableManager.Reason.LOOT_BOX, event.getPlayer().getLocation());
            }
        }
    }

    //Interaction with a Block
    @EventHandler
    public void onPlayerInteractWithBlock(PlayerInteractEvent event) {
        if (!event.hasBlock()) return;
        if (proficiencyAdapter.performAction(event.getPlayer(), event, (item) -> !item.isLootBox())) return;

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
