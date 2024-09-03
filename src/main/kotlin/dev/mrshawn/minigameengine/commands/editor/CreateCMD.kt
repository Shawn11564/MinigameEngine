package dev.mrshawn.minigameengine.commands.editor

import dev.mrshawn.minigameengine.games.factory.MinigameFactory
import dev.mrshawn.minigameengine.manager.MinigameManager
import dev.mrshawn.mlib.chat.Chat
import dev.mrshawn.mlib.commands.MCommand
import dev.mrshawn.mlib.commands.annotations.CommandAlias
import dev.mrshawn.mlib.commands.annotations.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@CommandAlias("create")
class CreateCMD: MCommand() {

	@CommandExecutor
	fun execute(sender: CommandSender, id: String) {
		if (MinigameManager.isMinigame(id)) {
			Chat.tell(sender, "&cA minigame with that ID already exists.")
			return
		}

		val minigame = if (sender is Player) {
			MinigameFactory().startCreator(sender, id)
		} else {
			MinigameFactory().createMinigame(id)
		}
		MinigameManager.addMinigame(minigame)

		Chat.tell(sender, "&aMinigame created with ID: &f$id")
	}

}