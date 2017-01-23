package me.admin.retrieverpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import me.admin.retrieverpvp.commands.CommandPvPDelSpawn;
import me.admin.retrieverpvp.commands.CommandPvPChallenge;
import me.admin.retrieverpvp.commands.CommandPvPHelp;
import me.admin.retrieverpvp.commands.CommandPvPSetSpawn;
import me.admin.retrieverpvp.commands.CommandPvpTeleport;

public class Core extends JavaPlugin {
	
	private CommandPvPSetSpawn spawnLocs;
	private CommandPvPDelSpawn delSpawn;

	private static Plugin plugin;

	public void onEnable() {
		plugin = this;
		
		if(!(getDataFolder().exists())){
			getDataFolder().mkdirs();
		}
		
		this.spawnLocs = new CommandPvPSetSpawn(this);
		this.delSpawn = new CommandPvPDelSpawn(this);
		
		
		getCommand("pvphelp").setExecutor(new CommandPvPHelp());
		getCommand("pvpchallenge").setExecutor(new CommandPvPChallenge());
		getCommand("pvpsetspawn").setExecutor(new CommandPvPSetSpawn(this));
		getCommand("pvpdelspawn").setExecutor(new CommandPvPDelSpawn(this));
		getCommand("pvpteleport").setExecutor(new CommandPvpTeleport(this));
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
