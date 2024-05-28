package net.starfal.kvisuals.Configuration;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private static File configFile;
    private static FileConfiguration config;

    private static File enMSGFile;
    private static FileConfiguration enMSG;

    private static File ltMSGFile;
    private static FileConfiguration ltMSG;
    // Setup the config file
    public static void setupConfig() {
        configFile = new File(Bukkit.getServer().getPluginManager().getPlugin("kVisuals").getDataFolder(), "config.yml");
        enMSGFile = new File(Bukkit.getServer().getPluginManager().getPlugin("kVisuals").getDataFolder(), "languages/en.yml");
        // ltMSGFile = new File(Bukkit.getServer().getPluginManager().getPlugin("kVisuals").getDataFolder(), "languages/lt.yml");

        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Could not create the config file");
            }
        }
        if (!enMSGFile.exists()) {
            try {
                enMSGFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Could not create the config file");
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
        enMSG = YamlConfiguration.loadConfiguration(enMSGFile);
        // ltMSG = YamlConfiguration.loadConfiguration(ltMSGFile);

    }

    public static FileConfiguration getConfig() {
        return config;
    }
    public static FileConfiguration getMessages(String lang) {
        switch (lang) {
            case "en":
                return enMSG;
            //case "lt":
            //    return ltMSG;
        }
        return enMSG;
    }

    public static void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            System.out.println("Could not save the config file");
        }
    }
    public static void saveMessages(String lang) {
        try {
            switch (lang) {
                case "en":
                    enMSG.save(enMSGFile);
                    break;
                //case "lt":
                //    ltMSG.save(ltMSGFile);
                //    break;
            }
        } catch (IOException e) {
            System.out.println("Could not save the messages file");
        }
    }

    public static void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        enMSG = YamlConfiguration.loadConfiguration(enMSGFile);
        //ltMSG = YamlConfiguration.loadConfiguration(ltMSGFile);
    }

}
