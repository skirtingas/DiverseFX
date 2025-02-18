package net.starfal

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPIBukkitConfig
import net.starfal.cmds.Visual
import net.starfal.cmds.kVisualsCMD
import net.starfal.config.Settings
import net.starfal.config.languages.LM
import net.starfal.funs.Color
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class kVisuals : JavaPlugin() {

    override fun onEnable() {
        instance = this
        log("<yellow><b>Enabling...</b>")
        log("<yellow>Enabling CommandAPI and commands...")
        CommandAPI.onLoad(CommandAPIBukkitConfig(this))
        CommandAPI.onEnable()
        Visual.register()
        kVisualsCMD.register()
        log("<green>CommandAPI has been enabled.")
        log("<yellow>Loading settings...")
        Settings.i()
        log("<green>Settings have been loaded.")
        log("<yellow>Loading languages...")
        LM.i()
        log("<green>Languages have been loaded.")
        log("<green><b>Enabled.</b>")
    }

    override fun onDisable() {
        log("<yellow>Disabling...")
        log("<red>Disabled.")
    }
    companion object {
        lateinit var instance: kVisuals

        val prefix: String = "<gradient:#6200ff:#00fffb>[kVisuals]</gradient> "


        fun log(message: String) {
            Bukkit.getConsoleSender().sendMessage(Color.format(prefix + message))
        }
    }
}
