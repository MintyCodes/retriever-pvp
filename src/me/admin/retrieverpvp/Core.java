package me.admin.retrieverpvp;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin{
	
	  private static Plugin plugin;
	   
	    public void onEnable() {
	        plugin = this;
	 
	    }
	   
	    public void onDisable() {
	       plugin = null;
	    }
	   
	   
	    //Much eaisier then registering events in 10 diffirent methods
	    public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
	        for (Listener listener : listeners) {
	            Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
	        }
	    }
	   
	    //To access the plugin variable from other classes
	    public static Plugin getPlugin() {
	        return plugin;
	    }
	   
	   
	   
	 
	}
	
	

