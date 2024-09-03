package dev.mrshawn.minigameengine.extensions

import dev.mrshawn.mlib.chat.Chat
import org.bukkit.entity.Player

fun Chat.tell(toWhom: Collection<Player>, vararg message: String) {
	toWhom.forEach { player -> tell(player, *message) }
}