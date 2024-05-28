package net.starfal.kvisuals.Configuration;


import java.io.ObjectInputFilter;
import java.util.Arrays;

public class DefaultConfig {
    public static void setupConfig() {
        // Config - Resources

        ConfigManager.setupConfig();

        ConfigManager.getConfig().addDefault("Comments", Arrays.asList(
                "#########################################################################################################",
                "# kVisuals - The best(and probably the only one) alternative to ItemsAdder's ScreenEffects Addon!",
                "# Encountered an issue?",
                "# Join the discord server for support!",
                "# https://dsc.gg/starfaldev",
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
        // Config - Permissions

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
        ConfigManager.getMessages("en").addDefault("General.Prefix", "<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient>");
        ConfigManager.getMessages("en").addDefault("General.Reloaded", "%prefix% <gray>| <green>Reloaded!");
        //ConfigManager.getMessages("en").addDefault("General.Visual_Was_Sent.With_Title.Comment", Arrays.asList(
        //        "# The visual was sent message for the player who sent the visual.",
        //        "# This is for: fullscreen, transparent and the fullscreen gradient.",
        //        "# Placeholders:",
        //        "# %visualtype% - The type of visual that was sent(e. g. Transparent)",
        //        "# %target% - The targetted player",
        //        "# %text% - The text that was sent to that player"
        //));
        ConfigManager.getMessages("en").addDefault("General.Visual_Was_Sent.With_Title", "%prefix% <green>%visualtype% visual sent to <u>%target%</u> with text: %text%");
        //ConfigManager.getMessages("en").addDefault("General.Visual_Was_Sent.With_Title_And_Subtitle.Comment", Arrays.asList(
        //        "# The visual was sent message for the player who sent the visual.",
        //        "# This is for: all gradients except the fullscreen gradient.",
        //        "# Placeholders:",
        //        "# %visualtype% - The type of visual that was sent(e. g. Transparent)",
        //        "# %target% - The targetted player",
        //        "# %title% - The title text that was sent to that player",
        //        "# %subtitle% - The subtitle text that was sent to that player"
        //));
        ConfigManager.getMessages("en").addDefault("General.Visual_Was_Sent.With_Title_And_Subtitle", "%prefix% <green>%visualtype% visual sent to <u>%target%</u> with text: %title% and subtext: %subtitle%");
        //ConfigManager.getMessages("en").addDefault("General.Errors.Player_Not_Found.Comment", Arrays.asList(
        //        "# The message sent when the targetted player was not found or is not in the server!",
        //        "# Placeholders:",
        //        "# %prefix% - The plugin prefix"
        //));
        ConfigManager.getMessages("en").addDefault("General.Errors.Player_Not_Found", "%prefix% <red>Player not found");
        //ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage_Gradient.With_Title.Comment", "# The message sent when someone uses /visual with incorrect arguments for the gradient which uses titles. (Only fullscreen)");
        ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage_Gradient.With_Title", "%prefix% <red>Usage: /visual gradient fullscreen <player> <title_text> <color>");
        //ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage_Gradient.With_Title_And_Subtitle.Comment", Arrays.asList(
        //        "# The message sent when someone uses /visual with the incorrect arguments for the gradient which uses titles with subtitles. (Every one, except fullscreen)",
        //        "# Placeholders:",
        //        "# %gradienttype% - the gradient type which was used(e. g. TopAndBottom)"
        //));
        ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage_Gradient.With_Title_And_Subtitle", "%prefix% <red>Usage: /visual gradient %gradienttype% <player> <title_text> <subtitle_text> <color>");
        //ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage_Gradient.Others.Comment", Arrays.asList(
        //        "# The message sent when someone uses /visual with the incorrect arguments for the gradient which uses only one text. (Bottom, Top, TopAndBottom)",
        //        "# Placeholders:",
        //        "# %type% - the gradient type which was used(e. g. Bottom)"
        //));
        ConfigManager.getMessages("en").addDefault("General.Errors.Wrong_Usage_Gradient.Others", "%prefix% <red>Usage: /visual %type% <player> <title_text> <color>");

        ConfigManager.getMessages("en").options().copyDefaults(true);
        ConfigManager.saveMessages("en");
        ConfigManager.getMessages("lt").addDefault("General.Prefix", "<gradient:#c466b7:#770868>ᴋVɪsᴜᴀʟs</gradient>");

        ConfigManager.getMessages("lt").options().copyDefaults(true);
        ConfigManager.saveMessages("lt");
    }
}
