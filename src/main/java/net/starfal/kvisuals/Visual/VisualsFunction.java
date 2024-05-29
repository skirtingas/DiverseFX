package net.starfal.kvisuals.Visual;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import net.starfal.kvisuals.Functions.Color;
import net.starfal.kvisuals.KVisuals;
import net.starfal.kvisuals.OraxenFileSetup.FileSetup;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.time.Duration;


public class VisualsFunction {
    private final KVisuals plugin;
    public VisualsFunction(KVisuals plugin) {
        this.plugin = plugin;
    }

    public static void showFullScreenVisual(Player p, String text, String color, int fadeIn, int stay, int fadeOut){
        String titleChar = FileSetup.getConfig().getString("fullscreen.char");
        text = text.replace("+", " ");
        showCustomTitle(p, text, color + titleChar, fadeIn, stay, fadeOut);
    }
    public static void showTransparentVisual(Player p, String text, String color, int fadeIn, int stay, int fadeOut){
        String titleChar = FileSetup.getConfig().getString("transparent.char");
        text = text.replace("+", " ");
        showCustomTitle(p, text, color + titleChar, fadeIn, stay, fadeOut);
    }
    public static void showFullScreenGradientVisual(Player p, String text, String color, int fadeIn, int stay, int fadeOut){
        String titleChar = FileSetup.getConfig().getString("fullscreengradient.char");
        text = text.replace("+", " ");
        showCustomTitle(p, text, color + titleChar, fadeIn, stay, fadeOut);
    }
    public static void showBottomGradientVisual(Player p, String title, String subtitle, String color, int fadeIn, int stay, int fadeOut){
        String titleChar = FileSetup.getConfig().getString("bottomgradient.char");
        title = title.replace("+", " ");
        subtitle = subtitle.replace("+", " ");
        showCustomTitle(p, title, subtitle, fadeIn, stay, fadeOut);

        p.sendActionBar(Component.text(Color.format(color + titleChar)));
    }
    public void showTopGradientVisual(Player p, String title, String subtitle, String color, int fadeIn, int stay, int fadeOut){
        String titleChar = FileSetup.getConfig().getString("topgradient.char");
        title = title.replace("+", " ");
        subtitle = subtitle.replace("+", " ");
        showCustomTitle(p, title, subtitle, fadeIn, stay, fadeOut);
        BossBar bar = BossBar.bossBar(Component.text(Color.format(color + titleChar)), 0f, BossBar.Color.YELLOW, BossBar.Overlay.PROGRESS);

        p.showBossBar(bar);
        new BukkitRunnable() {
            @Override
            public void run() {
                p.hideBossBar(bar);
            }
        }.runTaskLater(plugin, (fadeIn + stay + fadeOut) / 50);
    }
    public void showTopAndBottomGradientVisual(Player p, String title, String subtitle, String color, int fadeIn, int stay, int fadeOut){
        String bottomChar = FileSetup.getConfig().getString("bottomgradient.char");
        String topChar = FileSetup.getConfig().getString("topgradient.char");
        title = title.replace("+", " ");
        subtitle = subtitle.replace("+", " ");
        showCustomTitle(p, title, subtitle, fadeIn, stay, fadeOut);

        p.sendActionBar(Component.text(Color.format(color + bottomChar)));
        BossBar bar = BossBar.bossBar(Component.text(Color.format(color + topChar)), 0f, BossBar.Color.YELLOW, BossBar.Overlay.PROGRESS);

        p.showBossBar(bar);
        new BukkitRunnable() {
            @Override
            public void run() {
                p.hideBossBar(bar);
            }
        }.runTaskLater(plugin, 56);
    }
    public static void showFrezzingVisual(Player p, String title, String subtitle, int fadeIn, int stay, int fadeOut){
        title = title.replace("+", " ");
        subtitle = subtitle.replace("+", " ");
        p.setFreezeTicks((fadeIn + stay + fadeOut) / 50 * 2);
        showCustomTitle(p, title, subtitle, fadeIn, stay, fadeOut);
    }

    public static void showCustomTitle(final @NonNull Audience target, final @NonNull String titleText, final @NonNull String subtitleText, final int fadeIn, final int stay, final int fadeOut) {
        final Component mainTitle = Component.text(Color.format(titleText));
        final Component subtitle = Component.text(Color.format(subtitleText));

        final Title.Times times = Title.Times.times(Duration.ofMillis(fadeIn), Duration.ofMillis(stay), Duration.ofMillis(fadeOut));
        final Title title = Title.title(mainTitle, subtitle, times);

        target.showTitle(title);
    }

}
