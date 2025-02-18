package net.starfal.funs

import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.title.Title
import net.kyori.adventure.title.Title.Times
import net.starfal.config.Settings
import org.bukkit.entity.Player
import java.time.Duration

class FullscreenVisual {
    companion object {
        fun show(player: Player, text: String, color: String, fadeIn: Int, stay: Int, fadeOut: Int) {
            val char = Color.format("${color}${Settings.i().textureGlyphs.fullscreen}")
            val textComponent = Color.format(text)
            val times = Times.times(Duration.ofMillis(fadeIn.toLong()), Duration.ofMillis(stay.toLong()), Duration.ofMillis(fadeOut.toLong()))
            val title: Title = Title.title(textComponent, char, times)
            player.showTitle(title)
        }
    }
}