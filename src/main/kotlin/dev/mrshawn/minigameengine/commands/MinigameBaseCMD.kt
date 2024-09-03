package dev.mrshawn.minigameengine.commands

import dev.mrshawn.minigameengine.commands.editor.CreateCMD
import dev.mrshawn.minigameengine.commands.editor.DeleteCMD
import dev.mrshawn.mlib.commands.MCommand
import dev.mrshawn.mlib.commands.annotations.CommandAlias

@CommandAlias("minigame|mg")
class MinigameBaseCMD: MCommand() {
	init {
		addSubcommands(
			ManagerCMD(),
			EditorCMD()
		)
	}
}

/**
 * Minigame manager commands are specifically for managing already created minigames.
 * This includes starting and stopping minigames
 */
@CommandAlias("manager|mgr")
class ManagerCMD: MCommand()

/**
 * Minigame editor commands are specifically for modifying and creating minigames.
 * This includes creating new minigames, deleting minigames, and modifying minigames.
 */
@CommandAlias("editor|e")
class EditorCMD: MCommand() {
	init {
		addSubcommands(
			CreateCMD(),
			DeleteCMD()
		)
	}
}
