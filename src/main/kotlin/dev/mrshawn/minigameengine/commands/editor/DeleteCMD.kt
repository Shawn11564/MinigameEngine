package dev.mrshawn.minigameengine.commands.editor

import dev.mrshawn.minigameengine.games.Minigame
import dev.mrshawn.minigameengine.manager.MinigameManager
import dev.mrshawn.mlib.chat.Chat
import dev.mrshawn.mlib.commands.MCommand
import dev.mrshawn.mlib.commands.annotations.CommandAlias
import dev.mrshawn.mlib.commands.annotations.CommandCompletion
import dev.mrshawn.mlib.commands.annotations.CommandExecutor
import org.bukkit.command.CommandSender

@CommandAlias("delete")
class DeleteCMD: MCommand() {

	init {
		addSubcommands(
			ConfirmCMD()
		)
	}

	companion object {
		private val confirmations = HashMap<CommandSender, Pair<Long, Minigame>>()
		private const val CONFIRMATION_TIMEOUT = 30 * 20 * 10000 // 30 seconds

		fun addConfirmation(commandSender: CommandSender, minigame: Minigame) { confirmations[commandSender] = System.currentTimeMillis() + CONFIRMATION_TIMEOUT to minigame }
		fun removeConfirmation(commandSender: CommandSender) { confirmations.remove(commandSender) }
		fun hasConfirmation(commandSender: CommandSender): Boolean {
			if (confirmations[commandSender] == null) return false
			if (confirmations[commandSender]!!.first <= System.currentTimeMillis()) return true
			return false
		}
		fun getConfirmation(commandSender: CommandSender): Minigame? { return confirmations[commandSender]?.second }
	}

	@CommandCompletion("@minigames")
	@CommandExecutor
	fun execute(sender: CommandSender, minigame: Minigame) {
		addConfirmation(sender, minigame)
		Chat.tell(sender,
			"&aAre you sure you want to delete this minigame? &2This can't be undone!",
			"&aType &2/minigame editor delete confirm &ato confirm."
		)
	}

}

@CommandAlias("confirm")
class ConfirmCMD: MCommand() {

	@CommandExecutor
	fun execute(sender: CommandSender) {
		if (!DeleteCMD.hasConfirmation(sender)) {
			Chat.tell(sender, "&cYou do not have any pending deletions or your confirmation has expired.")
			return
		}

		val minigame = DeleteCMD.getConfirmation(sender)!!
		DeleteCMD.removeConfirmation(sender)
		MinigameManager.deleteMinigame(minigame)

		Chat.tell(sender, "&aMinigame &e${minigame.getId()} &adeleted.")
	}

}