package dev.skir.funs

import net.kyori.adventure.title.Title
import net.kyori.adventure.title.Title.Times
import dev.skir.config.Settings
import dev.skir.freezing.Freeze
import dev.skir.DiverseFX
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.time.Duration

class TransparentVisual {
    companion object {
        fun show(players: Collection<Player>, text: String, color: String, freeze: Boolean, fadeIn: Int, stay: Int, fadeOut: Int) {
            for (player in players) {
                val char = Color.format("${color}${Settings.i().textureGlyphs.transparent}")
                val textComponent = Color.format(text)
                val times = Times.times(Duration.ofMillis(fadeIn.toLong()), Duration.ofMillis(stay.toLong()), Duration.ofMillis(fadeOut.toLong()))
                val title: Title = Title.title(textComponent, char, times)
                player.showTitle(title)
                if (freeze) {
                    val id = Freeze.generateId()
                    Freeze.freeze(player, id)
                    val delayMs = fadeIn.toLong() + stay.toLong() + fadeOut.toLong()
                    val delayTicks = delayMs / 50
                    Bukkit.getScheduler().runTaskLater(DiverseFX.instance, Runnable {
                        if (Freeze.isFrozen(player) && Freeze.getFreezeId(player) == id) {
                            Freeze.unfreeze(player)
                        }
                    }, delayTicks)
                }
            }
        }
    }
}