package com.falgael.rpg.manager;

import com.falgael.rpg.proficiencies.ProficiencyData;
import com.falgael.rpg.proficiencies.ProficiencyManager;
import org.bukkit.Bukkit;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SavingManagement {

    private static final File ROOT_DATA_FOLDER = Bukkit.getPluginManager().getPlugin("RPG-0.0.1").getDataFolder();
    private static final String DATA_PATH = File.separator + "data";
    private static final String DATA_PROFICIENCY_PATH = DATA_PATH + File.separator +"proficiencies";


    public static void initialize() {
        Bukkit.getLogger().info("Start initializing of: " + SavingManagement.class.getName());

        checkAndCreateDirectory(ROOT_DATA_FOLDER);
        checkAndCreateDirectory(ROOT_DATA_FOLDER + DATA_PATH);
        checkAndCreateDirectory(ROOT_DATA_FOLDER + DATA_PROFICIENCY_PATH);

    }

    private static void checkAndCreateDirectory(String path) {
        checkAndCreateDirectory(new File(path));
    }

    private static void checkAndCreateDirectory(@NotNull File file) {
        Bukkit.getLogger().info("[" + file.getPath() + "]: Checking File");
        if (!file.exists()) {
            Bukkit.getLogger().info("[" + file.getPath() + "]: Dir does not exist");
            if (file.mkdir()) Bukkit.getLogger().info("[" + file.getPath() + "]: Created directory");
            else Bukkit.getLogger().warning("[" + file.getPath() + "]: Could not been created");
        }
    }

    private static @Nullable Object load(File file) {
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

    private static void save(File file, Object o) {
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
                    file.createNewFile();
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

    public static void loadProficiencyData() {
        File dir = new File(ROOT_DATA_FOLDER + DATA_PROFICIENCY_PATH + File.separator);
        Bukkit.getLogger().info("[Proficiency Data]: Start loading");
        File[] dirList = dir.listFiles();
        if (dirList == null) {
            Bukkit.getLogger().info("[Proficiency Data]: No data to load found");
            return;
        }
        for (File tmp : dirList) {
            if (!(load(tmp) instanceof ProficiencyData pd)) {
                Bukkit.getLogger().warning("[Proficiency Data]: [" + tmp.getPath() + "] is not instance of ProficiencyData");
                continue;
            }
            ProficiencyManager.setProficiencyData(UUID.fromString(tmp.getName()),pd);
            Bukkit.getLogger().info("[Proficiency Data]: Loaded " + tmp.getName());
        }
        Bukkit.getLogger().info("[Proficiency Data]: Finished loading");
    }

    public static void saveProficiencyData() {
        Bukkit.getLogger().info("[Proficiency Data]: Start Saving");
        for (Map.Entry<UUID,ProficiencyData> entry : ProficiencyManager.getProficiencyData().entrySet()) {
            File file = new File(ROOT_DATA_FOLDER + DATA_PROFICIENCY_PATH + File.separator + entry.getKey().toString());
            save(file, entry.getValue());
        }
        Bukkit.getLogger().info("[Proficiency Data]: Finished Saving");
    }

}
