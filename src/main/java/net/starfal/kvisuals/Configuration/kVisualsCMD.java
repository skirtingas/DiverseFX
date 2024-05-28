package net.starfal.kvisuals.Configuration;

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
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission(ConfigManager.getConfig().getString("Permissions.General.Admin"))){
                    ConfigManager.reloadConfig();
                    sender.sendMessage("Config reloaded");
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return List.of();
    }
}
