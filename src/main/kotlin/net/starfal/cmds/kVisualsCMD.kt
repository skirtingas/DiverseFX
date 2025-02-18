package net.starfal.cmds

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.executors.CommandExecutor
import net.starfal.config.Settings
import net.starfal.config.languages.LM
import net.starfal.funs.Color

class kVisualsCMD {
    companion object {
        fun register() {
            CommandAPICommand(Settings.i().commands.kvisuals)
                .withPermission(Settings.i().permissions.kvisuals_reload)
                .withSubcommand(CommandAPICommand("reload")
                    .executes(CommandExecutor { sender, _ ->
                        // Reloading
                        var message = LM.i().getLocale().general.reloading
                        message = message.replace("%prefix%", LM.i().getLocale().general.prefix)
                        sender.sendMessage(Color.format(message))

                        val startTime = System.currentTimeMillis()

                        Settings.reload()
                        LM.i().reload()

                        val endTime = System.currentTimeMillis()
                        val duration = endTime - startTime

                        var messageReload = LM.i().getLocale().general.reloaded
                        messageReload = messageReload.replace("%prefix%", LM.i().getLocale().general.prefix)
                        messageReload = messageReload.replace("%time%", duration.toString())
                        sender.sendMessage(Color.format(messageReload))
                    })
                )
                .register()
        }
    }
}