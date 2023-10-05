package com.falgael.rpg.proficiency.handler;

import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.blocks.CraftingResults;
import com.falgael.rpg.tmp.Calculation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftingResultsHandler implements Listener {
    @EventHandler
    public void onPlayerCraft(CraftItemEvent event) {
        if (event.isCancelled()) return;
        if (!(event.getWhoClicked() instanceof Player player)) return;

        CraftingResults craftingResult = CraftingResults.getResult(event.getInventory().getResult());
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

        Utils.increaseExperience(player,craftingResult.getType(),Calculation.calculateExperience(craftingResult.getExperienceAmount() * craftedAmount, craftingResult.getType(), player));
    }


}
