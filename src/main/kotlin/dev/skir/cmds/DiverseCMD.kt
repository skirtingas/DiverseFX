package dev.skir.cmds

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.executors.CommandExecutor
import dev.skir.config.Settings
import dev.skir.config.languages.LM
import dev.skir.funs.Color

class DiverseCMD {
    companion object {
        fun register() {
            CommandAPICommand(Settings.i().commands.diversefx)
                .withPermission(Settings.i().permissions.diversefx_reload)
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