package dev.skir

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import dev.skir.cmds.Visual
import dev.skir.cmds.DiverseCMD
import dev.skir.config.Settings
import dev.skir.config.languages.LM
import dev.skir.freezing.FreezeEvents
import dev.skir.funs.Color
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class DiverseFX : JavaPlugin() {

    override fun onEnable() {
        instance = this
        log("<yellow><b>Enabling...</b>")
        log("<yellow>Enabling CommandAPI and commands...")
        CommandAPI.onLoad(CommandAPIBukkitConfig(this))
        CommandAPI.onEnable()
        Visual.register()
        DiverseCMD.register()
        log("<green>CommandAPI has been enabled.")
        log("<yellow>Loading settings...")
        Settings.i()
        log("<green>Settings have been loaded.")
        log("<yellow>Loading languages...")
        LM.i()
        log("<green>Languages have been loaded.")
        log("<yellow>Loading events...")
        Bukkit.getPluginManager().registerEvents(FreezeEvents(), this)
        log("<green>Events have been loaded.")
        log("<green><b>Enabled.</b>")
    }

    override fun onDisable() {
        log("<yellow>Disabling...")
        log("<red>Disabled.")
    }
    companion object {
        lateinit var instance: DiverseFX

        val prefix: String = "<gradient:#6200ff:#00fffb>[DiverseFX]</gradient> "

        fun log(message: String) {
            Bukkit.getConsoleSender().sendMessage(Color.format(prefix + message))
        }
    }
}
