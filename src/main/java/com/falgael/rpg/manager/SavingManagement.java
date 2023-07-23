package com.falgael.rpg.manager;

import com.falgael.rpg.proficiencies.ProficiencyData;
import com.falgael.rpg.proficiencies.ProficiencyManager;
import org.bukkit.Bukkit;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class SavingManagement {

    private static final File mainPath = Bukkit.getPluginManager().getPlugin("RPG-0.0.1").getDataFolder();

    public static boolean save(String path, Object ob) {
        Bukkit.getLogger().info("Path to store: " + mainPath.getName());
        Bukkit.getLogger().info("Path to store: " + File.pathSeparator);
        Bukkit.getLogger().info("Path to store: " + path);
        path = mainPath + "\\" + path;
        Bukkit.getLogger().info("Path to store: " + path);
        try {
            File tmp = new File(mainPath + "\\data\\proficiencies\\","135df0de-60e7-4624-8a0b-4e7c3f6027e3");
            if (!tmp.exists()) {
                if (!tmp.createNewFile()) {
                    Bukkit.getLogger().warning("Could not create File");
                    return false;
                }
            }

            BukkitObjectOutputStream outputStream = new BukkitObjectOutputStream(new GZIPOutputStream(new FileOutputStream(path)));
            outputStream.writeObject(ob);
            outputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            Bukkit.getLogger().warning("File to store not found: " + path);
            e.printStackTrace();
        } catch (IOException e) {
            Bukkit.getLogger().warning("Error on storing Event");
            e.printStackTrace();
        }
        return false;
    }

    public static @Nullable Object load(String path) {
        Bukkit.getLogger().info("Path to load: " + mainPath);
        Bukkit.getLogger().info("Path to load: " + File.pathSeparator);
        Bukkit.getLogger().info("Path to load: " + path);
        path = mainPath + "\\" + path;
        Bukkit.getLogger().info("Path to load: " + path);
        try {
            BukkitObjectInputStream inputStream = new BukkitObjectInputStream(new GZIPInputStream(new FileInputStream(path)));
            Object result = (Object) inputStream.readObject();
            inputStream.close();
            return result;
        } catch (IOException e) {
            Bukkit.getLogger().warning("File not found while loading: " + path);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Bukkit.getLogger().warning("Class not found while loading: " + path);
            e.printStackTrace();
        }
        return null;
    }

    public static void loadProficiencyData() {
        File dir = new File(mainPath + "\\data\\proficiencies\\");
        File[] dirList = dir.listFiles();
        if (dirList == null) return;
        for (File tmp : dirList) {
            if (!(load("\\data\\proficiencies\\" + tmp.getName()) instanceof ProficiencyData pd)) continue;
            ProficiencyManager.setProficiencyData(UUID.fromString(tmp.getName()),pd);
            Bukkit.getLogger().info("Loaded Proficiency data of: " + tmp.getName());
        }
    }

    public static void saveProficiencyData() {
        String path = "data" + File.separator + "proficiencies" + File.separator;
        for (Map.Entry<UUID,ProficiencyData> entry : ProficiencyManager.getProficiencyData().entrySet()) {
            save(path + entry.getKey().toString(), entry.getValue());
        }
    }

}
