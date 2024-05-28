package net.starfal.kvisuals.Configuration;


import java.io.ObjectInputFilter;
import java.util.Arrays;

public class DefaultConfig {
    public static void setupConfig() {
        ConfigManager.setupConfig();

        ConfigManager.getConfig().addDefault("Comments", Arrays.asList(
                "#########################################################################################################",
                "# kVisuals - The best(and probably the only one) alternative to ItemsAdder's ScreenEffects Addon!",
                "# Encountered an issue?",
                "# Join the discord server for support!",
                "# https://dsc.gg/starfaldev",
                "# Docs: https://docs.starfal.net/kvisuals",
                "#",
                "# Made by kitoxis with love :)",
                "#########################################################################################################"
        ));

        ConfigManager.getConfig().addDefault("General.Language", "en");
        ConfigManager.getConfig().addDefault("General.Visuals.Fullscreen", true);
        ConfigManager.getConfig().addDefault("General.Visuals.Transparent", true);
        ConfigManager.getConfig().addDefault("General.Visuals.Gradients.Fullscreen", true);
        ConfigManager.getConfig().addDefault("General.Visuals.Gradients.Bottom", true);
        ConfigManager.getConfig().addDefault("General.Visuals.Gradients.Top", true);
        ConfigManager.getConfig().addDefault("General.Visuals.Gradients.TopAndBottom", true);

        ConfigManager.getConfig().addDefault("Permissions.General.ShowVisual", "kvisuals.showvisual");
        ConfigManager.getConfig().addDefault("Permissions.General.Admin", "kvisuals.admin");

        ConfigManager.getConfig().options().copyDefaults(true);
        ConfigManager.saveConfig();


    }
    public static void setupMessages() {
        ConfigManager.setupConfig();
        ConfigManager.getMessages("en").addDefault("Comment", Arrays.asList(
                "#####################################################",
                "#",
                "# Welcome to the english translation!",
                "# You can edit the colors, formatting and the whole sentences here.",
                "# You should use only miniMessage format which you can find at \"https://docs.advntr.dev/minimessage/format.html\"!",
                "#",
                "#####################################################"
        ));
        ConfigManager.getMessages("en").addDefault("General.Prefix", "<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient> <dark_gray>|</dark_gray>");
        ConfigManager.getMessages("en").addDefault("General.Reloaded", "%prefix% <green>Reloaded!");
        ConfigManager.getMessages("en").addDefault("General.Visual_Was_Sent.With_Title", "%prefix% <green>%visualtype% visual sent to <u>%target%</u> with text: %text%");
        ConfigManager.getMessages("en").addDefault("General.Visual_Was_Sent.With_Title_And_Subtitle", "%prefix% <green>%visualtype% visual sent to <u>%target%</u> with text: %title% and subtext: %subtitle%");
        ConfigManager.getMessages("en").addDefault("General.Errors.Player_Not_Found", "%prefix% <red>Player not found");
        ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage.Gradient.With_Title", "%prefix% <red>Usage: /visual gradient fullscreen <player> <title_text> <color>");
        ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage.Gradient.With_Title_And_Subtitle", "%prefix% <red>Usage: /visual gradient %gradienttype% <player> <title_text> <subtitle_text> <color>");
        ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage.Others", "%prefix% <red>Usage: /visual %type% <player> <title_text> <color>");
        ConfigManager.getMessages("en").addDefault("General.Errors.Visual_IsDisabled", "%prefix% <red>Visual %type% is disabled");
        ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage_AdminCMD", "%prefix% <red>Usage: /kvisuals reload");
        ConfigManager.getMessages("en").addDefault("General.Errors.No_Permission", "%prefix% <red>You don't have permission.");
        ConfigManager.getMessages("en").options().copyDefaults(true);
        ConfigManager.saveMessages("en");
    }
}
