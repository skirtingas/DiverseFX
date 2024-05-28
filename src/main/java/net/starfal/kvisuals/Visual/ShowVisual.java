package net.starfal.kvisuals.Visual;

import net.starfal.kvisuals.Functions.Color;
import net.starfal.kvisuals.KVisuals;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ShowVisual implements TabExecutor {
    private final KVisuals plugin;
    private final VisualsFunction visualsFunction;

    public ShowVisual(KVisuals plugin) {
        this.plugin = plugin;
        this.visualsFunction = new VisualsFunction(plugin);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("visual")) {
            if (args[0].equalsIgnoreCase("gradient")){
                if (args[1].equalsIgnoreCase("fullscreen")){
                    if (args.length == 5){
                        Player player = Bukkit.getPlayer(args[2]);
                        if (player != null){
                            VisualsFunction.showFullScreenGradientVisual(player, args[3], "<" + args[4] + ">");
                            sender.sendMessage(Color.format("Fullscreen Gradient visual sent to " + player.getName() + " with text: " + args[2]));

                        }else {
                            sender.sendMessage("<red>Player not found");
                        }
                    }else {
                        sender.sendMessage("<red>Usage: /visual gradient fullscreen <player> <title_text> <color>");
                    }
                }else if (args[1].equalsIgnoreCase("bottom")){
                    if (args.length == 6){
                        Player player = Bukkit.getPlayer(args[2]);
                        if (player != null){
                            VisualsFunction.showBottomGradientVisual(player, args[3], args[4], "<" + args[5] + ">");
                            sender.sendMessage(Color.format("Bottom Gradient visual sent to " + player.getName() + " with text: " + args[3] + " and subtext: " + args[4]));
                        }else {
                            sender.sendMessage("<red>Player not found");
                        }
                    }else {
                        sender.sendMessage("<red>Usage: /visual gradient bottom <player> <title_text> <subtitle_text> <color>");
                    }
                }else if (args[1].equalsIgnoreCase("top")){
                    if (args.length == 6){
                        Player player = Bukkit.getPlayer(args[2]);
                        if (player != null){
                            visualsFunction.showTopGradientVisual(player, args[3], args[4], "<" + args[5] + ">");
                            sender.sendMessage(Color.format("Top Gradient visual sent to " + player.getName() + " with text: " + args[3] + " and subtext: " + args[4]));
                        }else {
                            sender.sendMessage("<red>Player not found");
                        }
                    }else {
                        sender.sendMessage("<red>Usage: /visual gradient top <player> <title_text> <subtitle_text> <color>");
                    }
                }else if (args[1].equalsIgnoreCase("topandbottom")){
                    if (args.length == 6){
                        Player player = Bukkit.getPlayer(args[2]);
                        if (player != null) {
                            visualsFunction.showTopAndBottomGradientVisual(player, args[3], args[4], "<" + args[5] + ">");
                            sender.sendMessage(Color.format("Top & Bottom Gradient visual sent to " + player.getName() + " with text: " + args[3] + " and subtext: " + args[4]));
                        }else {
                            sender.sendMessage("<red>Player not found");
                        }
                    }else {
                        sender.sendMessage("<red>Usage: /visual gradient topandbottom <player> <title_text> <subtitle_text> <color>");
                    }
                }
            }else if (args[0].equalsIgnoreCase("fullscreen")) {
                if (args.length == 4) {
                    Player player = Bukkit.getPlayer(args[1]);
                    if (player != null) {
                        VisualsFunction.showFullScreenVisual(player, args[2], "<" + args[3] + ">");
                        sender.sendMessage(Color.format("Fullscreen visual sent to " + player.getName() + " with text: " + args[2]));
                    } else {
                        sender.sendMessage("<red>Player not found");
                    }
                } else {
                    sender.sendMessage("<red>Usage: /visual fullscreen <player> <text> <color>");
                }
            } else if (args[0].equalsIgnoreCase("transparent")){
                if (args.length == 4){
                    Player player = Bukkit.getPlayer(args[1]);
                    if (player != null){
                        VisualsFunction.showTransparentVisual(player, args[2], "<" + args[3] + ">");
                        sender.sendMessage(Color.format("<green>Transparent visual sent to <u>" + player.getName() + "</u> with text: " + args[2]));
                    }else {
                        sender.sendMessage("<red>Player not found");
                    }
                }else {
                    sender.sendMessage("<red>Usage: /visual transparent <player> <text> <color>");
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("visual")){
            if (args.length == 1){
                return List.of("fullscreen", "gradient", "transparent");
            }else if (args.length == 2){
                if (args[0].equalsIgnoreCase("gradient")){
                    return List.of("fullscreen", "bottom", "top", "topandbottom");
                }else {
                    List<String> players = new java.util.ArrayList<>();
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        players.add(player.getName());
                    }
                    return players;
                }
            }else if (args.length == 3){
                if (args[0].equalsIgnoreCase("gradient")){
                    List<String> players = new java.util.ArrayList<>();
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        players.add(player.getName());
                    }
                    return players;
                }else {
                    return List.of("text");
                }
            }else if (args.length == 4){
                if (args[0].equalsIgnoreCase("gradient")) {
                    return List.of("title_text");
                }else {
                    List<String> colors = new java.util.ArrayList<>();
                    colors.add("#000000");
                    colors.add("#ff0000");
                    colors.add("black");
                    colors.add("white");
                    return colors;
                }
            }else if (args.length == 5){
                if (args[0].equalsIgnoreCase("gradient")) {
                    if (args[1].equalsIgnoreCase("fullscreen")) {
                        List<String> colors = new java.util.ArrayList<>();
                        colors.add("#000000");
                        colors.add("#ff0000");
                        colors.add("black");
                        colors.add("white");
                        return colors;
                    }else {
                        return List.of("subtitle_text");
                    }
                }
            }else if (args.length == 6){
                if (args[0].equalsIgnoreCase("gradient")) {
                    if (args[1].equalsIgnoreCase("fullscreen")) {
                        return null;
                    }
                    List<String> colors = new java.util.ArrayList<>();
                    colors.add("#000000");
                    colors.add("#ff0000");
                    colors.add("black");
                    colors.add("white");
                    return colors;
                }
            }
        }
        return null;
    }
}
