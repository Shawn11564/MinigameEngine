package dev.mrshawn.minigameengine.engine.games

import org.bukkit.entity.Player

interface GameState {

	fun getPlayers(): Collection<Player>

}