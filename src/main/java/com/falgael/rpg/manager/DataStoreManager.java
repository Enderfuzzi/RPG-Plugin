package com.falgael.rpg.manager;

import com.falgael.rpg.manager.interfaces.DataStoreManagement;
import com.falgael.rpg.old.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class DataStoreManager implements DataStoreManagement {


    private static final String DATA_PATH = File.separator + "data";

    private static final String DATA_PLAYER_PATH = DATA_PATH + File.separator + "player";

    private static final String DATA_PROFICIENCY_PATH = DATA_PLAYER_PATH + File.separator + "proficiency";


    private Plugin plugin;


    public DataStoreManager(Plugin plugin) {
        this.plugin = plugin;

        Bukkit.getLogger().info("[" + DataStoreManager.class.getSimpleName() + "]: Start initializing");


        checkAndCreateDirectory(plugin.getDataFolder());
        checkAndCreateDirectory(plugin.getDataFolder() + DATA_PATH);
        checkAndCreateDirectory(plugin.getDataFolder() + DATA_PLAYER_PATH);
        checkAndCreateDirectory(plugin.getDataFolder() + DATA_PROFICIENCY_PATH);

        Bukkit.getLogger().info("[" + DataStoreManager.class.getSimpleName() + "]: Finished initializing");
        Bukkit.getLogger().info("[" + DataStoreManager.class.getSimpleName() + "]: Start loading");
        loadProficiencyData();
        Bukkit.getLogger().info("[" + DataStoreManager.class.getSimpleName() + "]: Finished loading");


    }


    private void checkAndCreateDirectory(String path) {
        checkAndCreateDirectory(new File(path));
    }


    private void checkAndCreateDirectory(@NotNull File file) {
        Bukkit.getLogger().info("[" + file.getPath() + "]: Checking File");
        if (!file.exists()) {
            Bukkit.getLogger().info("[" + file.getPath() + "]: Dir does not exist");
            if (file.mkdir()) Bukkit.getLogger().info("[" + file.getPath() + "]: Created directory");
            else Bukkit.getLogger().warning("[" + file.getPath() + "]: Could not been created");
        }
    }


    public @Nullable Object load(File file) {
        if (file == null) {
            Bukkit.getLogger().warning("File to load is null");
            return null;
        }
        Bukkit.getLogger().info("[" + file.getPath() + "]: Loading");
        if (!file.exists()) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: Does not exist");
            return null;
        }
        if (!file.canRead()) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: Can not be Accessed reading");
            return null;
        }

        try {
            BukkitObjectInputStream inputStream = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
            Object result = inputStream.readObject();
            inputStream.close();
            Bukkit.getLogger().info("[" + file.getPath() + "]: Loaded");
            return result;
        } catch (IOException e) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: could not be loaded");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: Class not found");
            e.printStackTrace();
        }
        return null;
    }


    public void save(File file, Object o) {
        if (file == null) {
            Bukkit.getLogger().warning("File to load is null");
            return;
        }
        Bukkit.getLogger().info("[" + file.getPath() + "]: Storing Object");
        if (o == null) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: Object to store is null");
            return;
        }
        if (!(o instanceof Serializable)) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: Object is not Serializable");
            return;
        }
        if (!file.exists()) {
            Bukkit.getLogger().info("[" + file.getPath() + "]: Does not exist");
            if (file.getParentFile().exists()) {
                Bukkit.getLogger().info("[" + file.getPath() + "]: Creating file");
                try {
                    if (file.createNewFile()) Bukkit.getLogger().info("[" + file.getPath() + "]: File existed on creation");
                } catch (IOException e) {
                    Bukkit.getLogger().warning("[" + file.getPath() + "]: Could not be created");
                }
            } else {
                Bukkit.getLogger().warning("[" + file.getPath() + "]: Does not exist and Parent does not exist");
                return;
            }
        }
        if (!file.canWrite()) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: No access to write");
            return;
        }

        try {
            BukkitObjectOutputStream outputStream = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
            outputStream.writeObject(o);
            outputStream.close();
            Bukkit.getLogger().info("[" + file.getPath() + "]: Storing completed");
        } catch (FileNotFoundException e) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: File to store not found");
            e.printStackTrace();
        } catch (IOException e) {
            Bukkit.getLogger().warning("[" + file.getPath() + "]: Error on storing Event");
            e.printStackTrace();
        }
    }


    public void loadProficiencyData() {
        File dir = new File(plugin.getDataFolder() + DATA_PROFICIENCY_PATH + File.separator);
        Bukkit.getLogger().info("[Proficiency Data]: Start loading");
        File[] dirList = dir.listFiles();
        if (dirList == null) {
            Bukkit.getLogger().info("[Proficiency Data]: No data to load found");
            return;
        }
        for (File tmp : dirList) {
            if (!(load(tmp) instanceof ProficiencyExperienceManager proficiencyExperienceManager)) {
                Bukkit.getLogger().warning("[Proficiency Data]: [" + tmp.getPath() + "] is not instance of ExperienceData");
                continue;
            }
            PlayerManager.setProficiencyData(UUID.fromString(tmp.getName()), proficiencyExperienceManager);
            Bukkit.getLogger().info("[Proficiency Data]: Loaded " + tmp.getName());
        }
        Bukkit.getLogger().info("[Proficiency Data]: Finished loading");
    }

    /**
     * Saves the Proficiency Data of all Players as new Task
     */
    public void saveProficiencyData() {
        Bukkit.getScheduler().runTask(plugin, this::saveProficiencyDataThread);
    }

    /**
     * Saves the current Proficiency data
     */
    private void saveProficiencyDataThread() {
        Bukkit.getLogger().info("[Proficiency Data]: Start Saving");
        for (Map.Entry<UUID, ProficiencyExperienceManager> entry : PlayerManager.getProficiencyData().entrySet()) {
            File file = new File(plugin.getDataFolder() + DATA_PROFICIENCY_PATH + File.separator + entry.getKey().toString());
            save(file, entry.getValue());
        }
        Bukkit.getLogger().info("[Proficiency Data]: Finished Saving");
    }


}
