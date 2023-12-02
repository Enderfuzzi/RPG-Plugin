package com.falgael.rpg.nousage;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;

@Deprecated
public class ConfigurationLoader implements ConfigurationLoading {

    private static final int DELOADING_INTERVAL = 20 * 600;

    private final Semaphore sem;

    private Plugin instance;

    private HashMap<String, FileConfiguration> loaded;

    private HashMap<String, Boolean> used;

    private int taskId;

    public ConfigurationLoader(Plugin instance) {
        this.instance = instance;
        loaded = new HashMap<>();
        sem = new Semaphore(1);
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(instance,this::deloading,DELOADING_INTERVAL, DELOADING_INTERVAL);
    }

    public @Nullable FileConfiguration getConfig(@NotNull String name) {
        if (!loaded.containsKey(name)) loadFileConfiguration(name);
        used.put(name, true);
        return loaded.get(name);
    }

    private void loadFileConfiguration(@NotNull String name) {
        Bukkit.getLogger().log(Level.INFO, "Load configuration: " + name);
        if (loaded.containsKey(name)) return;
        try {
            sem.acquireUninterruptibly();
            FileConfiguration result = YamlConfiguration.loadConfiguration(loadFile(name, true));
            Bukkit.getLogger().log(Level.INFO, "Load configuration succeeded");
            loaded.put(name, result);
            used.put(name, true);
            sem.release();
        } catch (FileNotFoundException | IllegalArgumentException e) {
            Bukkit.getLogger().log(Level.WARNING,"Failed loading File", e);
        }
    }


    private @NotNull File loadFile(@NotNull String name, boolean createWhenNotExists) throws FileNotFoundException {
        Bukkit.getLogger().log(Level.INFO, "Loading File: " + name);
        File file = new File(instance.getDataFolder(), name + ".yml");
        if (file.exists()) return file;
        if (createWhenNotExists) {
            if (file.mkdirs()) {
                instance.saveResource(name, false);
                return file;
            }
        }
        throw new FileNotFoundException();
    }

    private void deloading() {
        sem.acquireUninterruptibly();
        for (String name : loaded.keySet()) {
            if (used.getOrDefault(name, false)) {
                used.put(name, false);
                continue;
            }
            Bukkit.getLogger().log(Level.INFO, "Deloading: " + name);
            save(name);
            loaded.remove(name);
            used.remove(name);
        }
        sem.release();
    }

    public void save(@NotNull String name) {
        Bukkit.getLogger().log(Level.INFO, "Start saving: " + name);
        instance.saveResource(name, true);
        Bukkit.getLogger().log(Level.INFO, "Finished saving: " + name);
    }

    public void save() {
        for (String name : loaded.keySet()) save(name);
    }

    public void reload() {
        Bukkit.getLogger().log(Level.INFO, "Start reload config");
        Set<String> toReload = loaded.keySet();
        loaded.clear();
        toReload.forEach(this::loadFileConfiguration);
        Bukkit.getLogger().log(Level.INFO, "Reload completed");
    }


    public void stop() {
        Bukkit.getLogger().log(Level.INFO, "Stopping");
        save();
        Bukkit.getScheduler().cancelTask(taskId);
    }

}
