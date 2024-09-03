package dev.mrshawn.minigameengine

import dev.mrshawn.minigameengine.commands.MinigameBaseCMD
import dev.mrshawn.minigameengine.games.Minigame
import dev.mrshawn.minigameengine.manager.MinigameManager
import dev.mrshawn.mlib.commands.exceptions.ContextResolverFailedException
import dev.mrshawn.mlib.plugins.MPlugin
import dev.mrshawn.mlib.selections.Selection
import org.bukkit.event.Listener

class MinigameEngine: MPlugin() {

	companion object {
		val instance: MinigameEngine
			get() = MPlugin.instance as MinigameEngine
	}

	override val listeners: Array<Listener>
		get() = arrayOf()

	override fun postEnable() {
		Selection.register(this)
	}

	override fun initObjects() {

	}

	override fun registerCommands() {
		mcm.registerCommand(MinigameBaseCMD())

		mcm.registerCompletion("@minigames") { _ -> MinigameManager.getAllMinigames().map { it.getId() } }

		mcm.registerContext(Minigame::class.java) { _, args ->
			if (MinigameManager.isMinigame(args[0])) {
				MinigameManager.getMinigame(args[0])!!
			} else {
				throw ContextResolverFailedException("Minigame with ID ${args[0]} not found.")
			}
		}
	}

}