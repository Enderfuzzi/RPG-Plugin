package com.falgael.rpg;

import com.falgael.rpg.commands.CustomCommand;
import com.falgael.rpg.handler.*;
import com.falgael.rpg.manager.*;
import com.falgael.rpg.handler.TestHandler;
import com.falgael.rpg.old.PlayerManager;
import com.falgael.rpg.recipe.CustomRecipes;
import com.falgael.rpg.handler.VillagerHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class RPG extends JavaPlugin {
    
    private DataStoreManagement storeManager;
    private PlayerExperienceManagement playerExperienceManager;
    private ProficiencyCalculationAdapter proficiencyAdapter;
    private ItemHeldHandler itemHeldHandler;

    @Override
    public void onEnable() {

        storeManager = new DataStoreManager(this);
        playerExperienceManager = new PlayerExperienceManager(this, storeManager);


        proficiencyAdapter = new ProficiencyCalculation(playerExperienceManager);


        new CustomRecipes(this);


        getLogger().info(this.getName() + " enabled");
        sendMessageToAll("Plugin enabled");
        Bukkit.getPluginManager().registerEvents(new PlayerManager(),this);
        Bukkit.getPluginManager().registerEvents(new VillagerHandler(proficiencyAdapter),this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakHandler(proficiencyAdapter),this);
        Bukkit.getPluginManager().registerEvents(new CraftingResultsHandler(proficiencyAdapter),this);
        Bukkit.getPluginManager().registerEvents(new ForbiddenCraftingHandler(), this);
        Bukkit.getPluginManager().registerEvents(new HarvestBlockHandler(proficiencyAdapter), this);
        Bukkit.getPluginManager().registerEvents(new TestHandler(proficiencyAdapter), this);

        itemHeldHandler = new ItemHeldHandler(this,playerExperienceManager);
        Bukkit.getPluginManager().registerEvents(itemHeldHandler, this);

        Bukkit.getPluginManager().registerEvents(new ItemBurnHandler(proficiencyAdapter), this);
        Bukkit.getPluginManager().registerEvents(new ShearingHandler(proficiencyAdapter), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractBlockHandler(proficiencyAdapter), this);
        Bukkit.getPluginManager().registerEvents(new EntityDeathHandler(proficiencyAdapter, this), this);
        Bukkit.getPluginManager().registerEvents(new ArrowShootHandler(proficiencyAdapter), this);
        Bukkit.getPluginManager().registerEvents(new DamageHitHandler(proficiencyAdapter), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractHandler(proficiencyAdapter), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFishHandler(proficiencyAdapter), this);

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
