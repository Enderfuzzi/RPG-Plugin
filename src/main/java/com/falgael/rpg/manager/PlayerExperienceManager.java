package com.falgael.rpg.manager;

import com.falgael.rpg.manager.interfaces.DataStoreManagement;
import com.falgael.rpg.manager.interfaces.PlayerExperienceManagement;
import com.falgael.rpg.manager.interfaces.ProficiencyExperienceManagement;
import com.falgael.rpg.proficiency.Proficiency;
import com.falgael.rpg.proficiency.experience.ExperienceDataHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.*;

public class PlayerExperienceManager implements PlayerExperienceManagement, Listener {

    private Plugin plugin;
    private DataStoreManagement dataManager;

    private HashMap<UUID, ProficiencyExperienceManagement> proficiencyExperience;


    public PlayerExperienceManager(Plugin plugin, DataStoreManagement dataManager) {
        this.plugin = plugin;
        this.dataManager = dataManager;
        proficiencyExperience = new HashMap<>();
        loadProficiencyExperience();
    }

    private void loadProficiencyExperience() {
        File dir = new File(plugin.getDataFolder() + File.separator + "data" + File.separator + "player" + File.separator + "proficiency" + File.separator);
        Bukkit.getLogger().info("[Proficiency Data]: Start loading");
        File[] dirList = dir.listFiles();
        if (dirList == null) {
            Bukkit.getLogger().info("[Proficiency Data]: No data to load found");
            return;
        }
        for (File tmp : dirList) {
            if (!(dataManager.load(tmp) instanceof ExperienceDataHolder experienceProficiencyData)) {
                Bukkit.getLogger().warning("[Proficiency Data]: [" + tmp.getPath() + "] is not instance of ExperienceData");
                continue;
            }
            this.proficiencyExperience.put(UUID.fromString(tmp.getName()), experienceProficiencyData);
        }
    }

    private void saveAllProficiencyExperience() {
        proficiencyExperience.forEach((k,e) -> saveProficiencyExperience(k));
    }

    private void saveProficiencyExperience(UUID player) {
        if (!checkUUID(player)) return;
        Bukkit.getScheduler().runTask(plugin, () -> saveProficiencyExperienceThread(player, proficiencyExperience.get(player)));
    }

    private synchronized void saveProficiencyExperienceThread(UUID player, ProficiencyExperienceManagement data) {
        File file = new File(plugin.getDataFolder() + File.separator + "data" + File.separator + "player" + File.separator + "proficiency" + File.separator + player.toString());
        dataManager.save(file, data);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (proficiencyExperience.containsKey(event.getPlayer().getUniqueId())) return;
        proficiencyExperience.put(event.getPlayer().getUniqueId(), new ExperienceDataHolder(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {

    }

    @Override
    public void increaseExperience(UUID player, Proficiency proficiency, long value) {
        if (!checkUUID(player)) return;
        proficiencyExperience.get(player).increaseExperience(proficiency,value);
        saveProficiencyExperience(player);
    }


    @Override
    public void decreaseExperience(UUID player, Proficiency proficiency, long value) {
        if (!checkUUID(player)) return;
        proficiencyExperience.get(player).decreaseExperience(proficiency, value);
        saveProficiencyExperience(player);
    }


    @Override
    public void increaseLevel(UUID player, Proficiency proficiency, int value) {
        if (!checkUUID(player)) return;
        proficiencyExperience.get(player).increaseLevel(proficiency, value);
        saveProficiencyExperience(player);
    }


    @Override
    public void decreaseLevel(UUID player, Proficiency proficiency, int value) {
        if (!checkUUID(player)) return;
        proficiencyExperience.get(player).decreaseLevel(proficiency, value);
        saveProficiencyExperience(player);
    }

    @Override
    public int getLevel(UUID player, Proficiency proficiency) {
        if (!checkUUID(player)) return 0;
        return proficiencyExperience.get(player).getLevel(proficiency);
    }


    @Override
    public long getExperience(UUID player, Proficiency proficiency) {
        if (!checkUUID(player)) return 0;
        return proficiencyExperience.get(player).getExperience(proficiency);
    }


    @Override
    public long getExperienceBorder(UUID player, Proficiency proficiency) {
        if (!checkUUID(player)) return 0;
        return proficiencyExperience.get(player).getExperienceBorder(proficiency);
    }


    public boolean checkUUID(UUID player) {
        return proficiencyExperience.containsKey(player);
    }



    /*
    public ProficiencyExperienceManager getProficiencyData(UUID player) {
        return proficiencyExperience.get(player);
    }


    public HashMap<UUID, ProficiencyExperienceManager> getProficiencyExperience() {
        return proficiencyExperience;
    }


    public ProficiencyExperienceManager getByPublicName(String name) {
        for (ProficiencyExperienceManager proficiencyExperienceManager : this.proficiencyExperience.values()) {
            if (proficiencyExperienceManager.getPublicName().equals(name)) return proficiencyExperienceManager;
        }
        return null;
    }

    public List<String> getPlayerNames() {
        List<String> result = new ArrayList<>();
        for (ProficiencyExperienceManager proficiencyExperienceManager : this.proficiencyExperience.values()) {
            result.add(proficiencyExperienceManager.getPublicName());
        }
        return result;
    }
    */
}
