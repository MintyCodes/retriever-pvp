package me.admin.retrieverpvp.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.admin.retrieverpvp.Core;
import me.admin.retrieverpvp.files.Abstract;
import me.admin.retrieverpvp.utils.MessageNoPerm;
import me.admin.retrieverpvp.utils.MessageNotPlayer;
import me.admin.retrieverpvp.utils.MessageSpawnSet;
import me.admin.retrieverpvp.utils.MessageSyntaxError;
import net.md_5.bungee.api.ChatColor;

public class CommandPvPSetSpawn extends Abstract implements CommandExecutor{
	

	
	public CommandPvPSetSpawn(Core core){
		super(core, "PvPSpawns.yml");
	}
	
public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]){
	Player p = (Player) sender;
		if(commandlabel.equalsIgnoreCase("pvpsetspawn")){
			if(!(sender instanceof Player)){
				sender.sendMessage(MessageNotPlayer.notPlayer);
				return true;
			}
			
			
			if(!(p.hasPermission("retrievermc.setspawn"))){
				p.sendMessage(MessageNoPerm.noPerm);
				return true;
			}
			
			if(args.length != 1){
				p.sendMessage(MessageSyntaxError.syntaxError);
				return true;
		}
			
			Location loc = p.getLocation();
			
			config.set("pvpArena", args[0]);
			config.set("location.X", loc.getX());
			config.set("location.Y", loc.getY());
			config.set("location.Z", loc.getZ());
			config.set("location.Yaw", loc.getYaw());
			config.set("location.Pitch", loc.getPitch());
			save();
			
			p.sendMessage(MessageSpawnSet.spawnSet + ChatColor.GOLD + args[0]);
			
			return true;
	}
		return true;
		
	


}
	


}
