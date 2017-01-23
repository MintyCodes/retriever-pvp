package me.admin.retrieverpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.avaje.ebeaninternal.server.subclass.GetterSetterMethods;

import me.admin.retrieverpvp.utils.MessageChallengeRequested;
import me.admin.retrieverpvp.utils.MessageChallengeRequestedClient;
import me.admin.retrieverpvp.utils.MessageNoPerm;
import me.admin.retrieverpvp.utils.MessageNotPlayer;
import me.admin.retrieverpvp.utils.MessagePlayerNotFound;
import me.admin.retrieverpvp.utils.MessageSyntaxError;

public class CommandPvPChallenge implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]) {
		if(commandlabel.equalsIgnoreCase("pvpchallenge")){
		if (!(sender instanceof Player)) {
			sender.sendMessage(MessageNotPlayer.notPlayer);
			return true;
		}

		Player p = (Player) sender;
		if(!(p.hasPermission("retrievermc.pvpchallenge"))){
			p.sendMessage(MessageNoPerm.noPerm);
			return true;
		}
		
		if(args.length == 0 || args.length > 1){
			p.sendMessage(MessageSyntaxError.syntaxError);
			return true;
		}
		
		if(args[0].equalsIgnoreCase(p.getName())){
			p.sendMessage(MessageSyntaxError.syntaxError);
			return true;
		}
		
		Player target = Bukkit.getServer().getPlayer(args[0]);
			
		if(target == null){
			p.sendMessage(MessagePlayerNotFound.playerNotFound);
			return true;
		}
		
		target.sendMessage(ChatColor.GOLD + p.getName() + MessageChallengeRequested.challengeRequested);
		
		p.sendMessage(MessageChallengeRequestedClient.challengeRequested + ChatColor.GOLD + target.getName());
		
		return true;
		
	}
		return true;
	
	}
	

}
