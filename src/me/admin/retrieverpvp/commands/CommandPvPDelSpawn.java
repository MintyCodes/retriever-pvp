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
import me.admin.retrieverpvp.utils.MessageSpawnsDeleted;
import me.admin.retrieverpvp.utils.MessageSyntaxError;

public class CommandPvPDelSpawn extends Abstract implements CommandExecutor{
	
	public CommandPvPDelSpawn(Core core){
		super(core, "PvPSpawns.yml");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]){
		if(commandlabel.equalsIgnoreCase("pvpdelspawn")){
		if(!(sender instanceof Player)){
			sender.sendMessage(MessageNotPlayer.notPlayer);
			return true;
		}
		
		Player p = (Player) sender;
		if(!(p.hasPermission("retrievermc.delspawn"))){
			p.sendMessage(MessageNoPerm.noPerm);
			return true;
		}
		
		
		if(args.length != 1){
			p.sendMessage(MessageSyntaxError.syntaxError);
			return true;
		}
		
		
		config.set("pvpArena", null);
		config.set("location.X", null);
		config.set("location.Y", null);
		config.set("location.Z", null);
		config.set("location.Yaw", null);
		config.set("location.Pitch", null);
		save();
		
		p.sendMessage(MessageSpawnsDeleted.spawnsDeleted);
		return true;
	}
		return true;
	}
	

}
