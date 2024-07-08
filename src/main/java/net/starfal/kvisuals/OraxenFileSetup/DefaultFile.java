package net.starfal.kvisuals.OraxenFileSetup;


import java.util.Arrays;


public class DefaultFile {
    public static void setupFile() {
        FileSetup.getConfig().addDefault("fullscreen.texture", "visuals/fullscreen.png");
        FileSetup.getConfig().addDefault("fullscreen.ascent", 512);
        FileSetup.getConfig().addDefault("fullscreen.height", 1024);
        FileSetup.getConfig().addDefault("fullscreen.chat.placeholders", Arrays.asList(":fullscreen:"));
        FileSetup.getConfig().addDefault("fullscreen.chat.permission", "kvisuals.admin");

        FileSetup.getConfig().addDefault("transparent.texture", "visuals/transparent.png");
        FileSetup.getConfig().addDefault("transparent.ascent", 512);
        FileSetup.getConfig().addDefault("transparent.height", 1024);
        FileSetup.getConfig().addDefault("transparent.chat.placeholders", Arrays.asList(":transparent:"));
        FileSetup.getConfig().addDefault("transparent.chat.permission", "kvisuals.admin");

        FileSetup.getConfig().addDefault("fullscreengradient.texture", "visuals/gradient.png");
        FileSetup.getConfig().addDefault("fullscreengradient.ascent", 256);
        FileSetup.getConfig().addDefault("fullscreengradient.height", 765);
        FileSetup.getConfig().addDefault("fullscreengradient.chat.placeholders", Arrays.asList(":fullscreengradient:"));
        FileSetup.getConfig().addDefault("fullscreengradient.chat.permission", "kvisuals.admin");

        FileSetup.getConfig().addDefault("bottomgradient.texture", "visuals/gradient.png");
        FileSetup.getConfig().addDefault("bottomgradient.ascent", 200);
        FileSetup.getConfig().addDefault("bottomgradient.height", 700);
        FileSetup.getConfig().addDefault("bottomgradient.chat.placeholders", Arrays.asList(":bottomgradient:"));
        FileSetup.getConfig().addDefault("bottomgradient.chat.permission", "kvisuals.admin");

        FileSetup.getConfig().addDefault("topgradient.texture", "visuals/topgradient.png");
        FileSetup.getConfig().addDefault("topgradient.ascent", 128);
        FileSetup.getConfig().addDefault("topgradient.height", 325);
        FileSetup.getConfig().addDefault("topgradient.chat.placeholders", Arrays.asList(":topgradient:"));
        FileSetup.getConfig().addDefault("topgradient.chat.permission", "kvisuals.admin");

        FileSetup.getConfig().options().copyDefaults(true);
        FileSetup.saveConfig();
    }
}
