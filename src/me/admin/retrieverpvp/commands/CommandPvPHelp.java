package me.admin.retrieverpvp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.admin.retrieverpvp.Core;

public class CommandPvPHelp implements CommandExecutor{
	
	Core core = new Core();
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]){
		if(commandlabel.equalsIgnoreCase("pvphelp")){
			
		}
		return true;
	}

}
