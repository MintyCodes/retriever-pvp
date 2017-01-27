package me.admin.retrieverpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.admin.retrieverpvp.commands.CommandPvPChallenge;
import me.admin.retrieverpvp.commands.CommandPvPHelp;
import me.admin.retrieverpvp.commands.CommandPvPSetSpawn;
import me.admin.retrieverpvp.commands.CommandPvPTeleport;
import me.admin.retrieverpvp.listeners.PlayerJoinListener;

public class Core extends JavaPlugin implements Listener {

	private static Plugin plugin;

	@Override
	public void onEnable() {
		plugin = this;

		getCommand("pvphelp").setExecutor(new CommandPvPHelp());
		getCommand("pvpchallenge").setExecutor(new CommandPvPChallenge());
		getCommand("pvpsetspawn").setExecutor(new CommandPvPSetSpawn(this));
		getCommand("pvpteleport").setExecutor(new CommandPvPTeleport(this));
		saveConfig();
		
		registerEvents(this, new PlayerJoinListener());
	}

	// Much eaisier then registering events in 10 diffirent methods
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
	}

	// To access the plugin variable from other classes
	public static Plugin getPlugin() {
		return plugin;
	}

}
