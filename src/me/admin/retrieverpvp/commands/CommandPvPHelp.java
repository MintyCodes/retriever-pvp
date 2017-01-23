package me.admin.retrieverpvp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.admin.retrieverpvp.Core;
import me.admin.retrieverpvp.utils.MessageBlank;
import me.admin.retrieverpvp.utils.MessageNoPerm;
import me.admin.retrieverpvp.utils.MessageNotPlayer;
import me.admin.retrieverpvp.utils.MessagePvPHeaderFooter;

public class CommandPvPHelp implements CommandExecutor{
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]){
		if(commandlabel.equalsIgnoreCase("pvphelp")){
			if(!(sender instanceof Player)){
				sender.sendMessage(MessageNotPlayer.notPlayer);
				return true;
			}
			
			Player p = (Player) sender;
			if(!(p.hasPermission("retrievermc.pvphelp"))){
				p.sendMessage(MessageNoPerm.noPerm);
				return true;
			}
			
			p.sendMessage(MessagePvPHeaderFooter.Header);
			p.sendMessage(ChatColor.DARK_AQUA + "/pvpsetspawn <arenaName>" + ChatColor.GRAY + ":" + ChatColor.GOLD + " Sets the Spawn Point for a PvP arena");
			p.sendMessage(MessageBlank.blank);
			p.sendMessage(ChatColor.DARK_AQUA + "/pvpdelspawn <arenaName>" + ChatColor.GRAY + ":" + ChatColor.GOLD + " Removes the Spawn Point for a PvP arena");
			p.sendMessage(MessageBlank.blank);
			p.sendMessage(ChatColor.DARK_AQUA + "/pvpserverplay" + ChatColor.GRAY + ":" + ChatColor.GOLD + " Teleports all online players to the PvP arena");
			p.sendMessage(MessageBlank.blank);
			p.sendMessage(ChatColor.DARK_AQUA + "/pvpteleport <arenaName> " + ChatColor.GRAY + ":" + ChatColor.GOLD + " Teleports player to the specified Arena");
			p.sendMessage(ChatColor.DARK_AQUA + "/pvpmode <boolean> " + ChatColor.GRAY + ":" + ChatColor.GOLD + " Puts you in PvP mode");
			p.sendMessage(MessageBlank.blank);
			p.sendMessage(ChatColor.DARK_AQUA + "/pvpchallenge <playerName> " + ChatColor.GRAY + ":" + ChatColor.GOLD + " Challenges a player to a PvP battle");
			p.sendMessage(MessagePvPHeaderFooter.Footer);
			
		}
		return true;
	}

}
