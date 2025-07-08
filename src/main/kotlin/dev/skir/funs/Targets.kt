package dev.skir.funs

import org.bukkit.entity.Player

class Targets {
    companion object {
        fun formatPlayerTargets(players: Collection<Player>, maxDisplay: Int = 3): String {
            val playerNames = players.map { it.name }
            val displayedNames = playerNames.take(maxDisplay).joinToString(", ")
            val extraCount = playerNames.size - maxDisplay
            return if (extraCount > 0) "$displayedNames... (+$extraCount more)" else displayedNames
        }
    }
}