package net.starfal.kvisuals.OraxenFileSetup;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.getServer;

public class FileSetup {
    private static File configFile;
    private static FileConfiguration config;

    public static void createFileInOraxen(String fileName) {
        PluginManager pluginManager = getServer().getPluginManager();
        String otherPluginName = "Oraxen";
        Plugin otherPlugin = pluginManager.getPlugin(otherPluginName);

        if (otherPlugin != null) {
            File otherPluginDataFolder = otherPlugin.getDataFolder();
            configFile = new File(otherPluginDataFolder, fileName);

            try {
                if (!configFile.exists()) {
                    configFile.createNewFile();
                }
                config = YamlConfiguration.loadConfiguration(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The plugin " + otherPluginName + " is not loaded.");
        }
    }

    public static FileConfiguration getConfig() {
        return config;
    }


    public static void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            System.out.println("Could not save the config file");
        }
    }


    public static void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }
}
