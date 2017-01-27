package me.admin.retrieverpvp.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;

public class PlayerJoinListener implements Listener{
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		EventPriority priority = EventPriority.HIGHEST;
		event.setJoinMessage(null);
		event.setJoinMessage(ChatColor.GREEN + event.getPlayer().getName() + " has joined the server!");
		
		
	
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event){
		event.setQuitMessage(null);
		event.setQuitMessage(ChatColor.GREEN + event.getPlayer().getName() + " has left the server!");
	}
	
	

}
