package net.starfal.kvisuals.Configuration;

import net.starfal.kvisuals.Functions.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class kVisualsCMD implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("kvisuals")) {
            var conf = ConfigManager.getInstance();
            String prefix = (String) ConfigManager.getInstance().getLang("General.Prefix");
            if (sender.hasPermission(conf.getString("Permissions.General.Admin"))) {
                if (!(args.length == 0)){
                    if (args[0].equalsIgnoreCase("reload")){
                        ConfigManager.getInstance().reload();
                        String message = (String) ConfigManager.getInstance().getLang("General.Reloaded");
                        message = message.replace("%prefix%", prefix);
                        sender.sendMessage(Color.format(message));
                    }else {
                        String message = (String) ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage_AdminCMD");
                        message = message.replace("%prefix%", prefix);
                        sender.sendMessage(Color.format(message));
                    }
                }else {
                    String message = (String) ConfigManager.getInstance().getLang("General.Errors.Wrong_Usage_AdminCMD");
                    message = message.replace("%prefix%", prefix);
                    sender.sendMessage(Color.format(message));
                }
            }else{
                String message = (String) ConfigManager.getInstance().getLang("General.Errors.No_Permission");
                message = message.replace("%prefix%", prefix);
                sender.sendMessage(Color.format(message));
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("kvisuals")){
            return List.of("reload");
        }
        return null;
    }
}
