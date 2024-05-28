package net.starfal.kvisuals.Visual;

import net.starfal.kvisuals.Configuration.ConfigManager;
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
            String lang = ConfigManager.getConfig().getString("General.Language");
            var msg = ConfigManager.getMessages(lang);
            var conf = ConfigManager.getConfig();
            if (!sender.hasPermission(ConfigManager.getConfig().getString("Permissions.General.ShowVisual")) || !sender.hasPermission(ConfigManager.getConfig().getString("Permissions.General.Admin"))) {
                String message = msg.getString("General.Errors.No_Permission");
                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                sender.sendMessage(Color.format(message));
            }else {
                if (args[0].equalsIgnoreCase("gradient")){
                    if (args[1].equalsIgnoreCase("fullscreen")){
                        if (args.length == 5){
                            Player player = Bukkit.getPlayer(args[2]);
                            if (player != null){
                                if (conf.getBoolean("General.Visuals.Gradients.Fullscreen")){
                                    VisualsFunction.showFullScreenGradientVisual(player, args[3], "<" + args[4] + ">");
                                    String message = msg.getString("General.Visual_Was_Sent.With_Title");
                                    message = message.replace("%visualtype%", "Fullscreen Gradient");
                                    message = message.replace("%target%", player.getName());
                                    message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%text%", args[3]);
                                    sender.sendMessage(Color.format(message));
                                }else {
                                    String message = msg.getString("General.Errors.Visual_IsDisabled");
                                    message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%type%", "Fullscreen Gradient");
                                    sender.sendMessage(Color.format(message));
                                }
                            }else {
                                String message = msg.getString("General.Errors.Player_Not_Found");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                sender.sendMessage(Color.format(message));
                            }
                        }else {
                            String message = msg.getString("General.Errors.Wrong_Usage.Gradient.With_Title");
                            message = message.replace("%prefix%", msg.getString("General.Prefix"));
                            sender.sendMessage(Color.format(message));
                        }
                    }else if (args[1].equalsIgnoreCase("bottom")){
                        if (args.length == 6){
                            Player player = Bukkit.getPlayer(args[2]);
                            if (player != null){
                                if (conf.getBoolean("General.Visuals.Gradients.Bottom")){
                                    visualsFunction.showBottomGradientVisual(player, args[3], args[4], "<" + args[5] + ">");
                                    String message = msg.getString("General.Visual_Was_Sent.With_Title_And_Subtitle");
                                    message = message.replace("%visualtype%", "Bottom Gradient");
                                    message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%target%", player.getName());
                                    message = message.replace("%title%", args[3]);
                                    message = message.replace("%subtitle%", args[4]);
                                    sender.sendMessage(Color.format(message));
                                }else {
                                    String message = msg.getString("General.Errors.Visual_IsDisabled");
                                    message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%type%", "Bottom Gradient");
                                    sender.sendMessage(Color.format(message));
                                }
                            }else {
                                String message = msg.getString("General.Errors.Player_Not_Found");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                sender.sendMessage(Color.format(message));
                            }
                        }else {
                            String message = msg.getString("General.Errors.Wrong_Usage.Gradient.With_Title_And_Subtitle");
                            message = message.replace("%prefix%", msg.getString("General.Prefix"));
                            message = message.replace("%gradienttype%", "Bottom Gradient");
                            sender.sendMessage(Color.format(message));
                        }
                    }else if (args[1].equalsIgnoreCase("top")){
                        if (args.length == 6){
                            Player player = Bukkit.getPlayer(args[2]);
                            if (player != null){
                                if (conf.getBoolean("General.Visuals.Gradients.Top")){
                                    visualsFunction.showTopGradientVisual(player, args[3], args[4], "<" + args[5] + ">");
                                    String message = msg.getString("General.Visual_Was_Sent.With_Title_And_Subtitle");
                                    message = message.replace("%visualtype%", "Top Gradient");
                                    message = message.replace("%target%", player.getName());
                                    message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%title%", args[3]);
                                    message = message.replace("%subtitle%", args[4]);
                                    sender.sendMessage(Color.format(message));
                                }else {
                                    String message = msg.getString("General.Errors.Visual_IsDisabled");
                                    message =  message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%type%", "Top Gradient");
                                    sender.sendMessage(Color.format(message));
                                }
                            }else {
                                String message = msg.getString("General.Errors.Player_Not_Found");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                sender.sendMessage(Color.format(message));
                            }
                        }else {
                            String message = msg.getString("General.Errors.Wrong_Usage.Gradient.With_Title_And_Subtitle");
                            message = message.replace("%prefix%", msg.getString("General.Prefix"));
                            message = message.replace("%gradienttype%", "Top Gradient");
                            sender.sendMessage(Color.format(message));
                        }
                    }else if (args[1].equalsIgnoreCase("topandbottom")){
                        if (args.length == 6) {
                            Player player = Bukkit.getPlayer(args[2]);
                            if (player != null) {
                                if (conf.getBoolean("General.Visuals.Gradients.TopAndBottom")) {
                                    visualsFunction.showTopAndBottomGradientVisual(player, args[3], args[4], "<" + args[5] + ">");
                                    String message = msg.getString("General.Visual_Was_Sent.With_Title_And_Subtitle");
                                    message = message.replace("%visualtype%", "Top & Bottom Gradient");
                                    message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%target%", player.getName());
                                    message = message.replace("%title%", args[3]);
                                    message = message.replace("%subtitle%", args[4]);
                                    sender.sendMessage(Color.format(message));
                                }else {
                                    String message = msg.getString("General.Errors.Visual_IsDisabled");
                                    message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                    message = message.replace("%type%", "Top & Bottom Gradient");
                                    sender.sendMessage(Color.format(message));
                                }
                            } else {
                                String message = msg.getString("General.Errors.Player_Not_Found");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                sender.sendMessage(Color.format(message));
                            }
                        } else {
                            String message = msg.getString("General.Errors.Wrong_Usage.Gradient.With_Title_And_Subtitle");
                            message = message.replace("%prefix%", msg.getString("General.Prefix"));
                            message = message.replace("%gradienttype%", "Top & Bottom Gradient");
                            sender.sendMessage(Color.format(message));
                        }
                    }
                }else if (args[0].equalsIgnoreCase("fullscreen")) {
                    if (args.length == 4) {
                        Player player = Bukkit.getPlayer(args[1]);
                        if (player != null) {
                            if (conf.getBoolean("General.Visuals.Fullscreen")) {
                                visualsFunction.showFullScreenVisual(player, args[2], "<" + args[3] + ">");
                                String message = msg.getString("General.Visual_Was_Sent.With_Title");
                                message = message.replace("%visualtype%", "Fullscreen");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                message = message.replace("%target%", player.getName());
                                message = message.replace("%text%", args[2]);
                                sender.sendMessage(Color.format(message));
                            }else {
                                String message = msg.getString("General.Errors.Visual_IsDisabled");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                message = message.replace("%type%", "Fullscreen");
                                sender.sendMessage(Color.format(message));
                            }
                        } else {
                            String message = msg.getString("General.Errors.Player_Not_Found");
                            message = message.replace("%prefix%", msg.getString("General.Prefix"));
                            sender.sendMessage(Color.format(message));
                        }
                    } else {
                        String message = msg.getString("General.Errors.Wrong_Usage.Others");
                        message = message.replace("%prefix%", msg.getString("General.Prefix"));
                        message = message.replace("%type%", "Fullscreen");
                        sender.sendMessage(Color.format(message));
                    }
                } else if (args[0].equalsIgnoreCase("transparent")){
                    if (args.length == 4){
                        Player player = Bukkit.getPlayer(args[1]);
                        if (player != null){
                            if (conf.getBoolean("General.Visuals.Transparent")){
                                VisualsFunction.showTransparentVisual(player, args[2], "<" + args[3] + ">");
                                String message = msg.getString("General.Visual_Was_Sent.With_Title");
                                message = message.replace("%visualtype%", "Transparent");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                message = message.replace("%target%", player.getName());
                                message = message.replace("%text%", args[2]);
                                sender.sendMessage(Color.format(message));
                            }else {
                                String message = msg.getString("General.Errors.Visual_IsDisabled");
                                message = message.replace("%prefix%", msg.getString("General.Prefix"));
                                message = message.replace("%type%", "Transparent");
                                sender.sendMessage(Color.format(message));
                            }
                        } else {
                            String message = msg.getString("General.Errors.Player_Not_Found");
                            message = message.replace("%prefix%", msg.getString("General.Prefix"));
                            sender.sendMessage(Color.format(message));
                        }
                    } else {
                        String message = msg.getString("General.Errors.Wrong_Usage.Others");
                        message = message.replace("%prefix%", msg.getString("General.Prefix"));
                        message = message.replace("%type%", "Transparent");
                        sender.sendMessage(Color.format(message));
                    }
                }else {
                    sender.sendMessage(Color.format("<red>Wrong Usage!"));
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
            }else {
                return null;
            }
        }
        return null;
    }
}
