package com.falgael.rpg.nousage;

import org.bukkit.configuration.file.FileConfiguration;

@Deprecated
public interface ConfigurationLoading {

    FileConfiguration getConfig(String name);
    void save();
    void reload();
    void stop();
}
