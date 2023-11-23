package com.falgael.rpg;

import com.falgael.rpg.commands.CustomCommand;
import com.falgael.rpg.handler.*;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.ItemManager;
import com.falgael.rpg.manager.*;
import com.falgael.rpg.handler.TestHandler;
import com.falgael.rpg.old.PlayerManager;
import com.falgael.rpg.recipe.CustomRecipes;
import com.falgael.rpg.handler.VillagerHandler;
import com.falgael.rpg.villager.VillagerManagement;
import com.falgael.rpg.villager.VillagerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPG extends JavaPlugin {
    
    private DataStoreManagement storeManager;
    private PlayerExperienceManagement playerExperienceManager;
    private ProficiencyCalculationAdapter proficiencyAdapter;

    private ItemManagement itemManager;
    private VillagerManagement villagerManager;
    private ItemHeldHandler itemHeldHandler;

    @Override
    public void onEnable() {

        storeManager = new DataStoreManager(this);
        playerExperienceManager = new PlayerExperienceManager(this, storeManager);
        itemManager = new ItemManager();
        villagerManager = new VillagerManager(itemManager);

        proficiencyAdapter = new ProficiencyCalculation(playerExperienceManager, itemManager);


        new CustomRecipes(this);

        MainManagement mainManager = new MainManager(proficiencyAdapter, itemManager, villagerManager);


        getLogger().info(this.getName() + " enabled");
        sendMessageToAll("Plugin enabled");


        Bukkit.getPluginManager().registerEvents((Listener) playerExperienceManager, this);


        Bukkit.getPluginManager().registerEvents(new PlayerManager(),this);
        Bukkit.getPluginManager().registerEvents(new VillagerHandler(mainManager, playerExperienceManager),this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakHandler(mainManager),this);
        Bukkit.getPluginManager().registerEvents(new CraftingResultsHandler(mainManager),this);
        Bukkit.getPluginManager().registerEvents(new ForbiddenCraftingHandler(), this);
        Bukkit.getPluginManager().registerEvents(new HarvestBlockHandler(mainManager), this);
        Bukkit.getPluginManager().registerEvents(new TestHandler(mainManager), this);

        itemHeldHandler = new ItemHeldHandler(playerExperienceManager, mainManager, this);
        Bukkit.getPluginManager().registerEvents(itemHeldHandler, this);

        Bukkit.getPluginManager().registerEvents(new ItemBurnHandler(mainManager), this);
        Bukkit.getPluginManager().registerEvents(new ShearingHandler(mainManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractBlockHandler(mainManager), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathHandler(mainManager, this), this);
        Bukkit.getPluginManager().registerEvents(new ArrowShootHandler(mainManager), this);
        Bukkit.getPluginManager().registerEvents(new DamageHitHandler(mainManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractHandler(mainManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFishHandler(mainManager), this);

        for (CustomCommand command : CustomCommand.values()) {
            this.getCommand(command.getKey()).setExecutor(command.getCommand());
            Bukkit.getLogger().info("[" + RPG.class.getSimpleName() + "]: Registered Command: " + command.getKey());
            if (command.getTabCompleter() == null) continue;
            this.getCommand(command.getKey()).setTabCompleter(command.getTabCompleter());
        }

    }


    @Override
    public void onDisable() {

        itemHeldHandler.stopCheck();


        getLogger().info("RPG disabled");
        sendMessageToAll("Plugin disabled");
    }

    private void sendMessageToAll(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) p.sendMessage(message);
    }
}
