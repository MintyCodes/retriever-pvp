package me.admin.retrieverpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.admin.retrieverpvp.commands.CommandPvPChallenge;
import me.admin.retrieverpvp.commands.CommandPvPHelp;
import me.admin.retrieverpvp.commands.CommandSetSpawn;

public class Core extends JavaPlugin {
	
	private CommandSetSpawn spawnLocs;

	private static Plugin plugin;

	public void onEnable() {
		plugin = this;
		
		if(!(getDataFolder().exists())){
			getDataFolder().mkdirs();
		}
		
		this.spawnLocs = new CommandSetSpawn(this);
		
		
		getCommand("pvphelp").setExecutor(new CommandPvPHelp());
		getCommand("pvpchallenge").setExecutor(new CommandPvPChallenge());
		getCommand("pvpsetspawn").setExecutor(new CommandSetSpawn(this));
	}

	public void onDisable() {
		
		spawnLocs.save();
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
