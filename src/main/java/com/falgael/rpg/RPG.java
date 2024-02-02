package com.falgael.rpg;

import com.falgael.rpg.commands.ExperienceCommand;
import com.falgael.rpg.commands.GetCommand;
import com.falgael.rpg.commands.SpawnCommand;
import com.falgael.rpg.handler.*;
import com.falgael.rpg.items.ItemManagement;
import com.falgael.rpg.items.ItemManager;
import com.falgael.rpg.items.set.ItemSetManagement;
import com.falgael.rpg.items.set.ItemSetManager;
import com.falgael.rpg.loottable.LootComputation;
import com.falgael.rpg.loottable.LootTableManager;
import com.falgael.rpg.manager.*;
import com.falgael.rpg.handler.TestHandler;
import com.falgael.rpg.manager.interfaces.DataStoreManagement;
import com.falgael.rpg.manager.interfaces.MainManagement;
import com.falgael.rpg.manager.interfaces.PlayerExperienceManagement;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceCalculation;
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
    private ProficiencyExperienceCalculation proficiencyAdapter;

    private ItemSetManagement itemSetManager;
    private ItemManagement itemManager;
    private VillagerManagement villagerManager;
    private ItemHeldHandler itemHeldHandler;

    private LootTableManager lootTableManager;

    private LootComputation lootComputation;

    @Override
    public void onEnable() {

        storeManager = new DataStoreManager(this);
        playerExperienceManager = new PlayerExperienceManager(this, storeManager);
        itemSetManager = new ItemSetManager();
        itemManager = new ItemManager(itemSetManager);
        villagerManager = new VillagerManager(itemManager);

        proficiencyAdapter = new ProficiencyExperienceCalculator(playerExperienceManager, itemManager);

        lootTableManager = new LootTableManager(itemManager);
        lootComputation = new LootComputation(proficiencyAdapter, lootTableManager, playerExperienceManager);

        new CustomRecipes(this);

        MainManagement mainManager = new MainManager(proficiencyAdapter, itemManager, villagerManager, lootComputation);


        getLogger().info(this.getName() + " enabled");
        sendMessageToAll("Plugin enabled");


        Bukkit.getPluginManager().registerEvents((Listener) playerExperienceManager, this);


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

        Bukkit.getPluginManager().registerEvents(new EntityTransformHandler(mainManager), this);


        GetCommand getCommand = new GetCommand(itemManager, itemSetManager);
        this.getCommand("get").setExecutor(getCommand);
        this.getCommand("get").setTabCompleter(getCommand);

        SpawnCommand spawnCommand = new SpawnCommand(villagerManager);
        this.getCommand("spawn").setExecutor(spawnCommand);
        this.getCommand("spawn").setTabCompleter(spawnCommand);

        ExperienceCommand experienceCommand = new ExperienceCommand(playerExperienceManager);
        this.getCommand("experience").setExecutor(experienceCommand);
        this.getCommand("experience").setTabCompleter(experienceCommand);


    }


    @Override
    public void onDisable() {

        itemHeldHandler.stopCheck();

        Bukkit.getOnlinePlayers().forEach(player -> player.kickPlayer("Server Shutdown"));

        getLogger().info("RPG disabled");
        sendMessageToAll("Plugin disabled");
    }

    private void sendMessageToAll(String message) {
        for (Player p : Bukkit.getOnlinePlayers()) p.sendMessage(message);
    }
}
