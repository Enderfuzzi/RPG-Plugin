package com.falgael.rpg.proficiency.handler;


import com.falgael.rpg.RPG;
import com.falgael.rpg.proficiency.blocks.CustomEntity;
import com.falgael.rpg.proficiency.general.Utils;
import com.falgael.rpg.proficiency.items.CustomTool;
import com.falgael.rpg.proficiency.items.ItemConfiguration;
import com.falgael.rpg.tmp.Calculation;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.atomic.AtomicInteger;


public class EntityDeathHandler implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        if (event.getEntity().getKiller() == null) return;


        if (event.getEntity().getType() == EntityType.CAT) {
            catKill(event.getEntity().getKiller());
            return;
        }

        CustomEntity customEntity = CustomEntity.getEntity(event.getEntity().getType());
        if (customEntity.isNone()) return;

        ItemStack item = event.getEntity().getKiller().getInventory().getItemInMainHand();
        CustomTool customTool = CustomTool.getItem(item);
        Bukkit.getLogger().info("Custom Tool found: " + !customTool.isNone());


        int droppedBlocks =  Calculation.calculateLoot(customEntity.getProficiency(), event.getEntity().getKiller());
        long experienceAmount = Calculation.calculateExperience(customEntity.getExperienceAmount(), customEntity.getProficiency(),event.getEntity().getKiller());
        Calculation.dropAdditionalLoot(event.getDrops(), droppedBlocks, event.getEntity().getWorld(), event.getEntity().getLocation());


        Utils.increaseExperience(event.getEntity().getKiller(), customEntity.getProficiency(), experienceAmount);
    }

    private void catKill(Player killer) {
        AtomicInteger counter = new AtomicInteger();
        BukkitRunnable runnable =  new BukkitRunnable() {
            /**
             * When an object implementing interface {@code Runnable} is used
             * to create a thread, starting the thread causes the object's
             * {@code run} method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method {@code run} is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                counter.getAndIncrement();
                killer.getWorld().strikeLightning(killer.getLocation());
                if (counter.compareAndSet(10, 0)) this.cancel();
            }
        };
        runnable.runTaskTimer(Bukkit.getPluginManager().getPlugin(RPG.PLUGIN_NAME), 0, 5);
    }

}
