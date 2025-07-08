package dev.skir.freezing

import io.papermc.paper.event.player.AsyncChatEvent
import dev.skir.config.Settings
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.event.player.PlayerQuitEvent

class FreezeEvents : Listener {
    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        if(Settings.i().freezeEvents.unfreezeOnQuit) {
            val player = event.player
            if (Freeze.isFrozen(player)) {
                Freeze.unfreeze(player)
            }
        }
    }

    @EventHandler
    fun onMove(event: PlayerMoveEvent) {
        if (Settings.i().freezeEvents.cancelMove) {
            val player = event.player
            if (Freeze.isFrozen(player)) {
                event.isCancelled = true
            }
        }
    }

    @EventHandler
    fun onInteract(event: PlayerInteractEvent) {
        if(Settings.i().freezeEvents.cancelInteract) {
            val player = event.player
            if (Freeze.isFrozen(player)) {
                event.isCancelled = true
            }
        }
    }

    @EventHandler
    fun onChat(event: AsyncChatEvent) {
        if (Settings.i().freezeEvents.cancelChat) {
            val player = event.player
            if (Freeze.isFrozen(player)) {
                event.isCancelled = true
            }
        }
    }
}