package com.falgael.rpg.handler;

import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.villager.VillagerInstance;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTransformEvent;

public class EntityTransformHandler extends MainHandler{

    public EntityTransformHandler(MainManagement mainManager) {
        super(mainManager);
    }

    @EventHandler
    public void onEntityTransformEvent(EntityTransformEvent event) {
        if (event.getEntity() instanceof Villager villager) {
            VillagerInstance instance = villagerAdapter.getVillager(villager);
            if (!villagerAdapter.isDefault(instance)) {
                event.setCancelled(true);
            }
        }


    }
}
