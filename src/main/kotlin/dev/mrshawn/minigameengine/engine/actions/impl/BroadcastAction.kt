package dev.mrshawn.minigameengine.engine.actions.impl

import dev.mrshawn.minigameengine.engine.actions.Action
import dev.mrshawn.minigameengine.engine.games.GameState
import dev.mrshawn.minigameengine.extensions.tell
import dev.mrshawn.mlib.chat.Chat

class BroadcastAction: Action {

	override fun execute(gameState: GameState, vararg args: Any) {
		Chat.tell(gameState.getPlayers(), *args as Array<String>)
	}

}