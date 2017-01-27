package me.admin.retrieverpvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.admin.retrieverpvp.Core;
import me.admin.retrieverpvp.utils.MessageNoPerm;
import me.admin.retrieverpvp.utils.MessageNotPlayer;
import me.admin.retrieverpvp.utils.MessageSpawnSet;
import me.admin.retrieverpvp.utils.MessageSyntaxError;

public class CommandPvPSetSpawn implements CommandExecutor{
	
	private Core core;
	
	public CommandPvPSetSpawn(Core core){
		this.core = core;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]) {
		if(commandlabel.equalsIgnoreCase("pvpsetspawn")){
		if (!(sender instanceof Player)) {
			sender.sendMessage(MessageNotPlayer.notPlayer);
			return true;
		}

		Player p = (Player) sender;
		if(!(p.hasPermission("retrieverpvp.setspawn"))){
			p.sendMessage(MessageNoPerm.noPerm);
			return true;
		}
		
		if(args.length == 0 || args.length > 1){
			p.sendMessage(MessageSyntaxError.syntaxError);
			return true;
		}
		core.getConfig().set("ArenaName", args[0]);
		core.getConfig().set("location.X", p.getLocation().getBlockX());
		core.getConfig().set("location.Y", p.getLocation().getBlockY());
		core.getConfig().set("location.Z", p.getLocation().getBlockZ());
		core.saveConfig();
		
		p.sendMessage(MessageSpawnSet.spawnSet);
		}
		return true;
	}
	
	
	

}
