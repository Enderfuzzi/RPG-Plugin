package com.falgael.rpg.handler;


import com.falgael.rpg.manager.MainManagement;
import com.falgael.rpg.definitions.stats.EntityStats;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.concurrent.atomic.AtomicInteger;


public class EntityDeathHandler extends MainHandler {

    private final Plugin plugin;

    public EntityDeathHandler(MainManagement mainManager, Plugin plugin) {
        super(mainManager);
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() == null) return;

        if (event.getEntity().getType() == EntityType.CAT) {
            catKill(event.getEntity().getKiller());
            return;
        }

        EntityStats entityStats = EntityStats.getEntity(event.getEntity().getType());
        if (entityStats.isNone()) return;

        if (proficiencyAdapter.performAction(event, itemAdapter.getItemByKey(event.getEntity().getKiller().getInventory().getItemInMainHand()))) return;

       proficiencyAdapter.calculateExperience(event.getEntity().getKiller(), entityStats.getProficiencies(), entityStats.getExperienceAmount());

        int droppedBlocks =  proficiencyAdapter.calculateLoot(event.getEntity().getKiller(), entityStats.getProficiencies());
        proficiencyAdapter.dropAdditionalLoot(event.getDrops(), droppedBlocks, event.getEntity().getWorld(), event.getEntity().getLocation());
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
        runnable.runTaskTimer(plugin, 0, 5);
    }

}
