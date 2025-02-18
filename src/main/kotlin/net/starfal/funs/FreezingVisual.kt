package net.starfal.funs

import net.kyori.adventure.title.Title
import net.kyori.adventure.title.Title.Times
import org.bukkit.entity.Player
import java.time.Duration

class FreezingVisual {
    companion object {
        fun show(player: Player, title: String, subtitle: String, fadeIn: Int, stay: Int, fadeOut: Int) {
            val subtitleFormatted = Color.format(subtitle)
            val titleFormatted = Color.format(title)
            val times = Times.times(Duration.ofMillis(fadeIn.toLong()), Duration.ofMillis(stay.toLong()), Duration.ofMillis(fadeOut.toLong()))
            val titleDisplay: Title = Title.title(titleFormatted, subtitleFormatted, times)
            player.showTitle(titleDisplay)
            player.freezeTicks = ((fadeIn + stay + fadeOut) / 50 * 2)
        }
    }
}