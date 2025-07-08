package dev.skir.freezing

import org.bukkit.entity.Player
import java.util.UUID

class Freeze {
    companion object {
        var frozen : HashMap<Player, String> = HashMap()

        fun isFrozen(player: Player): Boolean {
            return frozen.containsKey(player)
        }

        fun freeze(player: Player, id: String) {
            frozen[player] = id
        }

        fun unfreeze(player: Player) {
            frozen.remove(player)
        }

        fun getFreezeId(player: Player): String? {
            return frozen[player]
        }

        fun getFrozenPlayers(): List<Player> {
            return frozen.keys.toList()
        }

        fun getFreezeIdList(): List<String> {
            return frozen.values.toList()
        }

        fun clear() {
            frozen.clear()
        }

        fun generateId(): String {
            var id = UUID.randomUUID().toString()
            while (frozen.containsValue(id)) {
                id = UUID.randomUUID().toString()
            }
            return id
        }
    }
}