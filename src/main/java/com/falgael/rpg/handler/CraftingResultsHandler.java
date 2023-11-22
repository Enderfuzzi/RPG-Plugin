package com.falgael.rpg.handler;

import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.manager.ProficiencyCalculationAdapter;
import com.falgael.rpg.misc.Calculations;
import com.falgael.rpg.stats.CraftingResultStats;
import com.falgael.rpg.villager.VillagerManagement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingResultsHandler extends MainHandler {
    public CraftingResultsHandler(ProficiencyCalculationAdapter proficiencyAdapter, ItemManagement itemAdapter, VillagerManagement villagerAdapter) {
        super(proficiencyAdapter, itemAdapter, villagerAdapter);
    }

    @EventHandler
    public void onPlayerCraft(CraftItemEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getWhoClicked() instanceof Player player)) return;

        CraftingResultStats craftingResult = CraftingResultStats.getResult(event.getInventory().getResult());
        if (craftingResult.isNone()) return;
        if (event.getInventory().getType() != craftingResult.getInventoryType()) return;

        int craftedAmount = 1;
        if (event.isShiftClick()) {
            for (ItemStack itemStack : event.getInventory().getMatrix()) {
                if (itemStack == null) continue;
                if (craftedAmount == 1 || (itemStack.getAmount() > 0 && itemStack.getAmount() < craftedAmount)) {
                    craftedAmount = itemStack.getAmount();
                }
            }
        }
        proficiencyAdapter.calculateExperience(player, craftingResult.getProficiencies(), craftingResult.getExperienceAmount() * craftedAmount);
    }


}
