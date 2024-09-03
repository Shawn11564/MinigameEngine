package dev.mrshawn.minigameengine.games

class Minigame(
	private val id: String,
	private val metadata: MinigameMetadata? = null
) {

	fun getId(): String {
		return id
	}

	fun getMetadata(): MinigameMetadata? {
		return metadata
	}

}