package net.starfal.kvisuals;

import io.th0rgal.oraxen.api.OraxenPack;
import io.th0rgal.oraxen.utils.AdventureUtils;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.starfal.kvisuals.Configuration.ConfigManager;
import net.starfal.kvisuals.Configuration.DefaultConfig;
import net.starfal.kvisuals.Configuration.kVisualsCMD;
import net.starfal.kvisuals.Functions.Color;
import net.starfal.kvisuals.Functions.UpdateChecker;
import net.starfal.kvisuals.OraxenFileSetup.DefaultFile;
import net.starfal.kvisuals.OraxenFileSetup.FileSetup;
import net.starfal.kvisuals.Visual.ShowVisual;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class KVisuals extends JavaPlugin {
    private static KVisuals instance;
    private BukkitAudiences audience;

    @Override
    public void onEnable() {
        instance = this;
        audience = BukkitAudiences.create(this);
        PluginManager pluginManager = getServer().getPluginManager();
        Plugin otherPlugin = pluginManager.getPlugin("Oraxen");

        if (otherPlugin == null) {
            switch (ConfigManager.getConfig().getString("General.Language")) {
                case "en":
                    getLogger().severe(Color.format("<gradient:dark_purple:#8e04dd>kVisuals</gradient> <red>- <u>Oraxen</u> is required for <u>kVisuals</u> to work. Disabling plugin."));
                    break;
                //case "lt":
                //    getLogger().severe(Color.format("<gradient:dark_purple:#8e04dd>kVisuals</gradient> <red>- <u>Oraxen</u> reikalingas, kad <u>kVisuals</u> veiktų. Plugin išjungiamas."));
                //    break;
            }
            pluginManager.disablePlugin(this);
            return;
        }
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        ConfigManager.setupConfig();
        DefaultConfig.setupConfig();
        DefaultConfig.setupMessages();
        FileSetup.createFileInOraxen("/glyphs/visuals.yml");
        DefaultFile.setupFile();
        copyFilesToOraxen();
        OraxenPack.reloadPack();
        FileSetup.reloadConfig();

        enableMessages();
        setupCommands();

    }

    @Override
    public void onDisable() {
        disableMessages();
    }
    public void setupCommands() {
        this.getCommand("visual").setExecutor(new ShowVisual(this));
        this.getCommand("visual").setTabCompleter(new ShowVisual(this));
        this.getCommand("kvisuals").setExecutor(new kVisualsCMD());
        this.getCommand("kvisuals").setTabCompleter(new kVisualsCMD());
    }
    public void enableMessages() {
        String enabled = "<green>(Eɴᴀʙʟᴇᴅ)</green>";
        String disabled = "<red>(Dɪsᴀʙʟᴇᴅ)</red>";
        log("<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient> <gray>|</gray> <#0ffcb9><b><u>Eɴᴀʙʟᴇᴅ</u></b></#0ffcb9> <gray>(V" + this.getDescription().getVersion() + ")</gray>");
        checkForUpdates();
        log("<gradient:#d3b013:#e2d185><i>Vɪsᴜᴀʟs Lɪsᴛ:</i></gradient>");
        if (ConfigManager.getConfig().getBoolean("General.Visuals.Fullscreen")) {
            log("<gradient:#0b9384:#13f4da>Fᴜʟʟsᴄʀᴇᴇɴ</gradient>" + enabled);
        } else {
            log("<gradient:#0b9384:#13f4da>Fᴜʟʟsᴄʀᴇᴇɴ</gradient>" + disabled);
        }
        if (ConfigManager.getConfig().getBoolean("General.Visuals.Transparent")) {
            log("<gradient:#0b9384:#13f4da>Tʀᴀɴsᴘᴀʀᴇɴᴛ</gradient>" + enabled);
        } else {
            log("<gradient:#0b9384:#13f4da>Tʀᴀɴsᴘᴀʀᴇɴᴛ</gradient>" + disabled);
        }
        if (ConfigManager.getConfig().getBoolean("General.Visuals.Freezing")) {
            log("<gradient:#0b9384:#13f4da>Fʀᴇᴇᴢɪɴɢ</gradient>" + enabled);
        } else {
            log("<gradient:#0b9384:#13f4da>Fʀᴇᴇᴢɪɴɢ</gradient>" + disabled);
        }
        log("<gradient:#ff0000:#bc13f4>Gʀᴀᴅɪᴇɴᴛs:</gradient>");
        if (ConfigManager.getConfig().getBoolean("General.Visuals.Gradients.Fullscreen")) {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Fᴜʟʟsᴄʀᴇᴇɴ</gradient>" + enabled);
        } else {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Fᴜʟʟsᴄʀᴇᴇɴ</gradient>" + disabled);
        }
        if (ConfigManager.getConfig().getBoolean("General.Visuals.Gradients.Top")) {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Tᴏᴘ</gradient>" + enabled);
        } else {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Tᴏᴘ</gradient>" + disabled);
        }
        if (ConfigManager.getConfig().getBoolean("General.Visuals.Gradients.Bottom")) {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Bᴏᴛᴛᴏᴍ</gradient>" + enabled);
        } else {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Bᴏᴛᴛᴏᴍ</gradient>" + disabled);
        }
        if (ConfigManager.getConfig().getBoolean("General.Visuals.Gradients.TopAndBottom")) {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Tᴏᴘ & Bᴏᴛᴛᴏᴍ</gradient>" + enabled);
        } else {
            log("<aqua>-</aqua> <gradient:#0b9384:#13f4da>Tᴏᴘ & Bᴏᴛᴛᴏᴍ</gradient>" + disabled);
        }
        log("<gold>Mᴀᴅᴇ ʙʏ</gold> <gradient:#dba736:#bae285>ᴋɪᴛᴏxɪs</gradient>");

    }
    public void disableMessages() {
        log("<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient> <gray>|</gray> <#f4132d><b><u>Dɪsᴀʙʟᴇᴅ</u></b></#f4132d>");
    }
    public void checkForUpdates(){
        new UpdateChecker(this, 117013).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                log("<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient> <gray>|</gray><green> You are using the latest version of kVisuals.</green>");
            } else {
                log("<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient> <gray>|</gray><red> There is a new update available.");
                log("<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient> <gray>|</gray><red> Your version: " + this.getDescription().getVersion());
                log("<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient> <gray>|</gray><red> New version: " + version);
            }
        });
    }
    public void copyFilesToOraxen() {
        // Gradient.png
        InputStream resourceStream = this.getClass().getResourceAsStream("/gradient.png");
        Path destinationPath = Paths.get("plugins/Oraxen/pack/textures/visuals/gradient.png");

        try {
            Files.createDirectories(destinationPath.getParent());
            Files.copy(resourceStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TopGradient.png
        InputStream resourceStream4 = this.getClass().getResourceAsStream("/topgradient.png");
        Path destinationPath4 = Paths.get("plugins/Oraxen/pack/textures/visuals/topgradient.png");

        try {
            Files.createDirectories(destinationPath4.getParent());
            Files.copy(resourceStream4, destinationPath4, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Transparent.png
        InputStream resourceStream2 = this.getClass().getResourceAsStream("/transparent.png");
        Path destinationPath2 = Paths.get("plugins/Oraxen/pack/textures/visuals/transparent.png");

        try {
            Files.createDirectories(destinationPath2.getParent());
            Files.copy(resourceStream2, destinationPath2, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Fullscreen.png
        InputStream resourceStream3 = this.getClass().getResourceAsStream("/fullscreen.png");
        Path destinationPath3 = Paths.get("plugins/Oraxen/pack/textures/visuals/fullscreen.png");

        try {
            Files.createDirectories(destinationPath3.getParent());
            Files.copy(resourceStream3, destinationPath3, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Bars.png
        InputStream resourceStream5 = this.getClass().getResourceAsStream("/bars.png");
        Path destinationPath5 = Paths.get("plugins/Oraxen/pack/assets/minecraft/textures/gui/bars.png");

        try {
            Files.createDirectories(destinationPath5.getParent());
            Files.copy(resourceStream5, destinationPath5, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void log(String msg) {
        this.getAudience().sender(Bukkit.getConsoleSender()).sendMessage(
                AdventureUtils.MINI_MESSAGE.deserialize(msg)
        );
    }
    public BukkitAudiences getAudience() {
        return audience;
    }

}
