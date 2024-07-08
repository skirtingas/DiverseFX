package net.starfal.kvisuals.Visual;

import net.starfal.kvisuals.Configuration.ConfigManager;
import net.starfal.kvisuals.Functions.Color;
import net.starfal.kvisuals.KVisuals;
import net.starfal.kvisuals.OraxenFileSetup.FileSetup;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static org.bukkit.Bukkit.getOnlinePlayers;

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
            var conf = ConfigManager.getInstance();
            if (!sender.hasPermission(ConfigManager.getInstance().getString("Permissions.General.ShowVisual")) || !sender.hasPermission(ConfigManager.getInstance().getString("Permissions.General.Admin"))) {
                String message = (String) ConfigManager.getInstance().getLang("General.Errors.No_Permission");
                message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                sender.sendMessage(Color.format(message));
            }else {
                if (args.length == 0){
                    sender.sendMessage(Color.format("<red>Wrong Usage!"));
                }else {
                    if (args[0].equalsIgnoreCase("gradient")){
                        if (args.length == 1){
                            sender.sendMessage(Color.format("<red>Wrong Usage!"));
                        }else {
                            if (args[1].equalsIgnoreCase("fullscreen")) {
                                if (args.length == 8) {
                                    Player player = Bukkit.getPlayer(args[2]);
                                    if (player != null) {
                                        if (conf.getBoolean("General.Visuals.Gradients.Fullscreen")) {
                                            int fadeIn = Integer.parseInt(args[5]);
                                            int stay = Integer.parseInt(args[6]);
                                            int fadeOut = Integer.parseInt(args[7]);
                                            String titleChar = FileSetup.getConfig().getString("fullscreengradient.char");
                                            visualsFunction.showFullScreenGradientVisual(player, args[3], "<" + args[4] + ">", fadeIn, stay, fadeOut, titleChar);
                                            String message = (String)ConfigManager.getInstance().getLang("General.Visual_Was_Sent.With_Title");
                                            message = message.replace("%visualtype%", "Fullscreen Gradient");
                                            message = message.replace("%target%", player.getName());
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%text%", args[3]);
                                            sender.sendMessage(Color.format(message));
                                        } else {
                                            String message = (String)ConfigManager.getInstance().getLang("General.Errors.Visual_IsDisabled");
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%type%", "Fullscreen Gradient");
                                            sender.sendMessage(Color.format(message));
                                        }
                                    } else {
                                        String message = (String)ConfigManager.getInstance().getLang("General.Errors.Player_Not_Found");
                                        message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                        sender.sendMessage(Color.format(message));
                                    }
                                } else {
                                    String message = (String)ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage.Gradient.With_Title");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    sender.sendMessage(Color.format(message));
                                }
                            } else if (args[1].equalsIgnoreCase("bottom")) {
                                if (args.length == 6) {
                                    Player player = Bukkit.getPlayer(args[2]);
                                    if (player != null) {
                                        if (conf.getBoolean("General.Visuals.Gradients.Bottom")) {
                                            String titleChar = FileSetup.getConfig().getString("bottomgradient.char");
                                            visualsFunction.showBottomGradientVisual(player, args[3], args[4], "<" + args[5] + ">", 500, 1760, 500, titleChar);
                                            String message = (String)ConfigManager.getInstance().getLang("General.Visual_Was_Sent.With_Title_And_Subtitle");
                                            message = message.replace("%visualtype%", "Bottom Gradient");
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%target%", player.getName());
                                            message = message.replace("%title%", args[3]);
                                            message = message.replace("%subtitle%", args[4]);
                                            sender.sendMessage(Color.format(message));
                                        } else {
                                            String message = (String)ConfigManager.getInstance().getLang("General.Errors.Visual_IsDisabled");
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%type%", "Bottom Gradient");
                                            sender.sendMessage(Color.format(message));
                                        }
                                    } else {
                                        String message = (String)ConfigManager.getInstance().getLang("General.Errors.Player_Not_Found");
                                        message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                        sender.sendMessage(Color.format(message));
                                    }
                                } else {
                                    String message = (String)ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage.Gradient.With_Title_And_Subtitle");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%gradienttype%", "Bottom Gradient");
                                    sender.sendMessage(Color.format(message));
                                }
                            } else if (args[1].equalsIgnoreCase("top")) {
                                if (args.length == 6) {
                                    Player player = Bukkit.getPlayer(args[2]);
                                    if (player != null) {
                                        if (conf.getBoolean("General.Visuals.Gradients.Top")) {
                                            String titleChar = FileSetup.getConfig().getString("topgradient.char");
                                            visualsFunction.showTopGradientVisual(player, args[3], args[4], "<" + args[5] + ">", 500, 1760, 500, titleChar);
                                            String message = (String)ConfigManager.getInstance().getLang("General.Visual_Was_Sent.With_Title_And_Subtitle");
                                            message = message.replace("%visualtype%", "Top Gradient");
                                            message = message.replace("%target%", player.getName());
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%title%", args[3]);
                                            message = message.replace("%subtitle%", args[4]);
                                            sender.sendMessage(Color.format(message));
                                        } else {
                                            String message = (String)ConfigManager.getInstance().getLang("General.Errors.Visual_IsDisabled");
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%type%", "Top Gradient");
                                            sender.sendMessage(Color.format(message));
                                        }
                                    } else {
                                        String message = (String)ConfigManager.getInstance().getLang("General.Errors.Player_Not_Found");
                                        message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                        sender.sendMessage(Color.format(message));
                                    }
                                } else {
                                    String message = (String)ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage.Gradient.With_Title_And_Subtitle");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%gradienttype%", "Top Gradient");
                                    sender.sendMessage(Color.format(message));
                                }
                            } else if (args[1].equalsIgnoreCase("topandbottom")) {
                                if (args.length == 6) {
                                    Player player = Bukkit.getPlayer(args[2]);
                                    if (player != null) {
                                        if (conf.getBoolean("General.Visuals.Gradients.TopAndBottom")) {
                                            String bottomChar = FileSetup.getConfig().getString("bottomgradient.char");
                                            String topChar = FileSetup.getConfig().getString("topgradient.char");
                                            visualsFunction.showTopAndBottomGradientVisual(player, args[3], args[4], "<" + args[5] + ">", 500, 1760, 500, topChar, bottomChar);
                                            String message = (String)ConfigManager.getInstance().getLang("General.Visual_Was_Sent.With_Title_And_Subtitle");
                                            message = message.replace("%visualtype%", "Top & Bottom Gradient");
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%target%", player.getName());
                                            message = message.replace("%title%", args[3]);
                                            message = message.replace("%subtitle%", args[4]);
                                            sender.sendMessage(Color.format(message));
                                        } else {
                                            String message = (String)ConfigManager.getInstance().getLang("General.Errors.Visual_IsDisabled");
                                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                            message = message.replace("%type%", "Top & Bottom Gradient");
                                            sender.sendMessage(Color.format(message));
                                        }
                                    } else {
                                        String message = (String)ConfigManager.getInstance().getLang("General.Errors.Player_Not_Found");
                                        message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                        sender.sendMessage(Color.format(message));
                                    }
                                } else {
                                    String message = (String)ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage.Gradient.With_Title_And_Subtitle");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%gradienttype%", "Top & Bottom Gradient");
                                    sender.sendMessage(Color.format(message));
                                }
                            }
                        }
                    }else if (args[0].equalsIgnoreCase("fullscreen")) {
                        if (args.length == 7) {
                            Player player = Bukkit.getPlayer(args[1]);
                            if (player != null) {
                                if (conf.getBoolean("General.Visuals.Fullscreen")) {
                                    int fadeIn = Integer.parseInt(args[4]);
                                    int stay = Integer.parseInt(args[5]);
                                    int fadeOut = Integer.parseInt(args[6]);
                                    String titleChar = FileSetup.getConfig().getString("fullscreen.char");
                                    visualsFunction.showFullScreenVisual(player, args[2], "<" + args[3] + ">", fadeIn, stay, fadeOut, titleChar);
                                    String message = (String)ConfigManager.getInstance().getLang("General.Visual_Was_Sent.With_Title");
                                    message = message.replace("%visualtype%", "Fullscreen");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%target%", player.getName());
                                    message = message.replace("%text%", args[2]);
                                    sender.sendMessage(Color.format(message));
                                }else {
                                    String message = (String)ConfigManager.getInstance().getLang("General.Errors.Visual_IsDisabled");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%type%", "Fullscreen");
                                    sender.sendMessage(Color.format(message));
                                }
                            } else {
                                String message = (String)ConfigManager.getInstance().getLang("General.Errors.Player_Not_Found");
                                message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                sender.sendMessage(Color.format(message));
                            }
                        } else {
                            String message = (String)ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage.Others");
                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                            message = message.replace("%type%", "Fullscreen");
                            sender.sendMessage(Color.format(message));
                        }
                    } else if (args[0].equalsIgnoreCase("transparent")) {
                        if (args.length == 7) {
                            Player player = Bukkit.getPlayer(args[1]);
                            if (player != null) {
                                if (conf.getBoolean("General.Visuals.Transparent")) {
                                    int fadeIn = Integer.parseInt(args[4]);
                                    int stay = Integer.parseInt(args[5]);
                                    int fadeOut = Integer.parseInt(args[6]);
                                    String titleChar = FileSetup.getConfig().getString("transparent.char");
                                    visualsFunction.showTransparentVisual(player, args[2], "<" + args[3] + ">", fadeIn, stay, fadeOut, titleChar);
                                    String message = (String)ConfigManager.getInstance().getLang("General.Visual_Was_Sent.With_Title");
                                    message = message.replace("%visualtype%", "Transparent");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%target%", player.getName());
                                    message = message.replace("%text%", args[2]);
                                    sender.sendMessage(Color.format(message));
                                } else {
                                    String message = (String)ConfigManager.getInstance().getLang("General.Errors.Visual_IsDisabled");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%type%", "Transparent");
                                    sender.sendMessage(Color.format(message));
                                }
                            } else {
                                String message = (String)ConfigManager.getInstance().getLang("General.Errors.Player_Not_Found");
                                message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                sender.sendMessage(Color.format(message));
                            }
                        } else {
                            String message = (String)ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage.Others");
                            message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                            message = message.replace("%type%", "Transparent");
                            sender.sendMessage(Color.format(message));
                        }
                    } else if (args[0].equalsIgnoreCase("freezing")){
                        if (args.length == 7){
                            Player player = Bukkit.getPlayer(args[1]);
                            if (player != null){
                                if (conf.getBoolean("General.Visuals.Freezing")){
                                    int fadeIn = Integer.parseInt(args[4]);
                                    int stay = Integer.parseInt(args[5]);
                                    int fadeOut = Integer.parseInt(args[6]);
                                    visualsFunction.showFrezzingVisual(player, args[2], args[3], fadeIn, stay, fadeOut);
                                    String message = (String)ConfigManager.getInstance().getLang("General.Visual_Was_Sent.With_Title_And_Subtitle");
                                    message = message.replace("%visualtype%", "Freezing");
                                    message = message.replace("%prefix%",(String) ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%target%", player.getName());
                                    message = message.replace("%title%", args[2]);
                                    message = message.replace("%subtitle%", args[3]);
                                    sender.sendMessage(Color.format(message));
                                }else {
                                    String message = (String)ConfigManager.getInstance().getLang("General.Errors.Visual_IsDisabled");
                                    message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                    message = message.replace("%type%", "Freezing");
                                    sender.sendMessage(Color.format(message));
                                }
                            }else {
                                String message = (String)ConfigManager.getInstance().getLang("General.Errors.Player_Not_Found");
                                message = message.replace("%prefix%", (String)ConfigManager.getInstance().getLang("General.Prefix"));
                                sender.sendMessage(Color.format(message));
                            }
                        }else {
                            sender.sendMessage(Color.format("<red>Wrong Usage!"));
                        }
                    }else {
                        sender.sendMessage(Color.format("<red>Wrong Usage!"));
                    }
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("visual")){
            if (args.length == 1) {
                return List.of("fullscreen", "gradient", "transparent", "freezing");
            }else if (args.length == 2){
                if (args[0].equalsIgnoreCase("gradient")){
                    return List.of("fullscreen", "bottom", "top", "topandbottom");
                }
                List<String> players = new java.util.ArrayList<>();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    players.add(player.getName());
                }
                return players;
            }else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("gradient")) {
                    List<String> players = new java.util.ArrayList<>();
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        players.add(player.getName());
                    }
                    return players;
                }
                List<String> text = new java.util.ArrayList<>();
                text.add("text");
                return text;
            }else if (args.length == 4) {
                if (args[0].equalsIgnoreCase("gradient")) {
                    List<String> color = new java.util.ArrayList<>();
                    color.add("title_text");
                    return color;
                }
                if (args[0].equalsIgnoreCase("freezing")){
                    List<String> color = new java.util.ArrayList<>();
                    color.add("subtitle_text");
                    return color;
                }
                List<String> text = new java.util.ArrayList<>();
                text.add("#000000");
                text.add("#FFFFFF");
                text.add("black");
                text.add("white");
                return text;
            }else if (args.length == 5) {
                if (args[0].equalsIgnoreCase("gradient")) {
                    if (args[1].equalsIgnoreCase("fullscreen")) {
                        List<String> text = new java.util.ArrayList<>();
                        text.add("#000000");
                        text.add("#FFFFFF");
                        text.add("black");
                        text.add("white");
                        return text;
                    }
                    List<String> color = new java.util.ArrayList<>();
                    color.add("subtitle_text");
                    return color;
                }
                List<String> text = new java.util.ArrayList<>();
                text.add("fadeIn");
                text.add("500");
                return text;
            }else if (args.length == 6) {
                if (args[0].equalsIgnoreCase("gradient")) {
                    if (args[1].equalsIgnoreCase("fullscreen")) {
                        List<String> text = new java.util.ArrayList<>();
                        text.add("fadeIn");
                        text.add("500");
                        return text;
                    }
                    return null;
                }
                List<String> text = new java.util.ArrayList<>();
                text.add("stay");
                text.add("1760");
                return text;
            }else if (args.length == 7) {
                if (args[0].equalsIgnoreCase("gradient")) {
                    if (args[1].equalsIgnoreCase("fullscreen")) {
                        List<String> text = new java.util.ArrayList<>();
                        text.add("stay");
                        text.add("1760");
                        return text;
                    }
                    return null;
                }
                List<String> text = new java.util.ArrayList<>();
                text.add("fadeOut");
                text.add("500");
                return text;
            }else if (args.length == 8) {
                if (args[0].equalsIgnoreCase("gradient")) {
                    if (args[1].equalsIgnoreCase("fullscreen")) {
                        List<String> text = new java.util.ArrayList<>();
                        text.add("fadeOut");
                        text.add("500");
                        return text;
                    }
                    return null;
                }
                return null;
            }else if (args.length == 9) {
                if (args[0].equalsIgnoreCase("gradient")) {
                    return null;
                }
                return null;
            }
        }
        return null;
    }
}