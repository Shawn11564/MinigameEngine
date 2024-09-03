package dev.mrshawn.minigameengine.manager

import dev.mrshawn.minigameengine.games.Minigame

object MinigameManager {

	private val minigameMap = HashMap<String, Minigame>()

	fun getMinigame(id: String): Minigame? {
		return minigameMap[id]
	}

	fun addMinigame(minigame: Minigame) {
		minigameMap[minigame.getId()] = minigame
	}

	fun removeMinigame(minigame: Minigame) {
		minigameMap.remove(minigame.getId())
	}

	fun deleteMinigame(minigame: Minigame) {
		removeMinigame(minigame)
	}

	fun isMinigame(id: String): Boolean = minigameMap.containsKey(id)

	fun getAllMinigames(): Collection<Minigame> = minigameMap.values

}