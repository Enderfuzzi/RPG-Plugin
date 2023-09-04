package com.falgael.rpg.proficiency.handler;


import com.falgael.rpg.proficiency.blocks.CustomEntities;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.effects.BlockBreakEffect;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;



public class EntityDeathHandler implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        CustomEntities customEntity = CustomEntities.getEntity(event.getEntity().getType());
        if (!customEntity.isNone()) return;

        long experienceAmount = customEntity.getExperienceAmount();
        int droppedBlocks = 0;

        ItemStack item = event.getEntity().getKiller().getInventory().getItemInMainHand();

        CustomTool customTool = CustomTool.getItem(item);
        Bukkit.getLogger().info("Custom Tool not found: " + customTool.isNone());
        if (!customTool.isNone() && customTool.isWeapon()) {

            if (customTool.getItemConfiguration().hasBlockBreakEffect()) {
                BlockBreakEffect blockBreakEffect = customTool.getItemConfiguration().getBlockBreakEffect();
                experienceAmount *= blockBreakEffect.getExperienceModifier();
                droppedBlocks = blockBreakEffect.calculateDroppedBlocks();
            }

            if (droppedBlocks != 0) {
                // Get the natural Drops and modify them
                for (ItemStack drop : event.getDrops()) {
                    ItemStack tmp = drop.clone();
                    tmp.setAmount(droppedBlocks);
                    //Override the Drops if an alternative is given
                    event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(),tmp);
                }
            }
        }

        Utils.increaseExperience(event.getEntity().getKiller(), customEntity.getProficiency(), experienceAmount);
    }

}
