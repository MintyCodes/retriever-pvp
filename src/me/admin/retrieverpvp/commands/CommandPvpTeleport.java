package me.admin.retrieverpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.avaje.ebeaninternal.server.cluster.mcast.Message;

import me.admin.retrieverpvp.Core;
import me.admin.retrieverpvp.files.Abstract;
import me.admin.retrieverpvp.utils.MessageNoPerm;
import me.admin.retrieverpvp.utils.MessageNotPlayer;
import me.admin.retrieverpvp.utils.MessagePlayerNotFound;
import me.admin.retrieverpvp.utils.MessagePlayerTeleported;
import me.admin.retrieverpvp.utils.MessageSyntaxError;
import me.admin.retrieverpvp.utils.MessageTeleported;

public class CommandPvpTeleport extends Abstract implements CommandExecutor{
	
	public CommandPvpTeleport(Core core){
		super(core, "PvPSpawns.yml");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]){
		if(commandlabel.equalsIgnoreCase("pvpteleport")){
		if(!(sender instanceof Player)){
			sender.sendMessage(MessageNotPlayer.notPlayer);
			return true;
		}
		
		Player p = (Player) sender;
		if(!(p.hasPermission("retrieverpvp.teleport"))){
			p.sendMessage(MessageNoPerm.noPerm);
			return true;
		}
		
		if(args[0].equalsIgnoreCase(p.getName())){
			p.sendMessage(MessageSyntaxError.syntaxError);
			return true;
		}
		
		
		if(args.length == 0){
			
			double x = config.getDouble("X");
			double y = config.getDouble("Y");
			double z = config.getDouble("Z");
			
			
			
			World world = p.getWorld();
			
		Location loc = new Location(world, x , y, z);
			
			p.teleport(loc);
		}
		
		if(!(p.hasPermission("retrieverpvp.teleport.others"))){
			p.sendMessage(MessageSyntaxError.syntaxError);
			return true;
		}
		
		Player target = Bukkit.getPlayer(args[0]);
			if(target == null){
				p.sendMessage(MessagePlayerNotFound.playerNotFound);
				return true;
			}
			
			double x = config.getDouble("X");
			double y = config.getDouble("Y");
			double z = config.getDouble("Z");
			
			World world = p.getWorld();
			
		Location loc = new Location(world, x + 0.5, y, z + 0.5);
			
			target.teleport(loc);
			
			p.sendMessage(MessagePlayerTeleported.playerTeleported + target.getName() + MessagePlayerTeleported.playerTeleported2);
			
			target.sendMessage(MessageTeleported.teleported);
			return true;
		
	}
		return true;
	}
	

}
