package dev.mrshawn.minigameengine.games.factory

import dev.mrshawn.minigameengine.games.Minigame
import org.bukkit.entity.Player

class MinigameFactory {

	fun startCreator(player: Player, id: String): Minigame {
		return Minigame(id)
	}

	fun createMinigame(id: String): Minigame {
		return Minigame(id)
	}

}