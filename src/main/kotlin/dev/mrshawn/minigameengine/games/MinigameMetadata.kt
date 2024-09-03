package dev.mrshawn.minigameengine.games

data class MinigameMetadata(
	var displayName: String,
	var description: Array<String>,
	var author: Array<String>,
	var version: String,
	var genre: Array<String>
) {

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (javaClass != other?.javaClass) return false

		other as MinigameMetadata

		if (displayName != other.displayName) return false
		if (!description.contentEquals(other.description)) return false
		if (!author.contentEquals(other.author)) return false
		if (version != other.version) return false
		if (!genre.contentEquals(other.genre)) return false

		return true
	}

	override fun hashCode(): Int {
		var result = displayName.hashCode()
		result = 31 * result + description.contentHashCode()
		result = 31 * result + author.contentHashCode()
		result = 31 * result + version.hashCode()
		result = 31 * result + genre.contentHashCode()
		return result
	}

}