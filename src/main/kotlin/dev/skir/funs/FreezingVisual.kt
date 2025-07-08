package dev.skir.funs

import net.kyori.adventure.title.Title
import net.kyori.adventure.title.Title.Times
import dev.skir.freezing.Freeze
import dev.skir.DiverseFX
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.time.Duration

class FreezingVisual {
    companion object {
        fun show(players: Collection<Player>, title: String, subtitle: String, freeze: Boolean, fadeIn: Int, stay: Int, fadeOut: Int) {
            for (player in players) {
                val subtitleFormatted = Color.format(subtitle)
                val titleFormatted = Color.format(title)
                val times = Times.times(Duration.ofMillis(fadeIn.toLong()), Duration.ofMillis(stay.toLong()), Duration.ofMillis(fadeOut.toLong()))
                val titleDisplay: Title = Title.title(titleFormatted, subtitleFormatted, times)
                player.showTitle(titleDisplay)
                player.freezeTicks = ((fadeIn + stay + fadeOut) / 50 * 2)
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