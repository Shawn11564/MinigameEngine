package dev.mrshawn.minigameengine.engine.actions

import dev.mrshawn.minigameengine.engine.games.GameState

interface Action {

	fun execute(gameState: GameState, vararg args: Any)

}