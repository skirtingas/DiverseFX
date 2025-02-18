package net.starfal.funs

import net.kyori.adventure.title.Title
import net.kyori.adventure.title.Title.Times
import net.starfal.config.Settings
import org.bukkit.entity.Player
import java.time.Duration

class BottomGradientVisual {
    companion object {
        fun show(player: Player, title: String, subtitle: String, color: String, fadeIn: Int, stay: Int, fadeOut: Int) {
            val subtitleFormatted = Color.format(subtitle)
            val titleFormatted = Color.format(title)
            val char = Color.format("${color}${Settings.i().textureGlyphs.gradient_bottom}")
            val times = Times.times(Duration.ofMillis(fadeIn.toLong()), Duration.ofMillis(stay.toLong()), Duration.ofMillis(fadeOut.toLong()))
            val titleDisplay: Title = Title.title(titleFormatted, subtitleFormatted, times)
            player.showTitle(titleDisplay)
            player.sendActionBar(char)
        }
    }
}