package me.admin.retrieverpvp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.admin.retrieverpvp.utils.MessageNoPerm;
import me.admin.retrieverpvp.utils.MessageNotPlayer;
import me.admin.retrieverpvp.utils.MessagePlayersSummoned;
import me.admin.retrieverpvp.utils.MessagePvPNowOn;
import me.admin.retrieverpvp.utils.MessageServerPlay;

public class CommandPvPServerPlay implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]) {
		if(commandlabel.equalsIgnoreCase("pvpserverplay")){
		if (!(sender instanceof Player)) {
			sender.sendMessage(MessageNotPlayer.notPlayer);
			return true;
		}

		Player p = (Player) sender;
		if(!(p.hasPermission("retrieverpvp.serverplay"))){
			p.sendMessage(MessageNoPerm.noPerm);
			return true;
		}
		
		for(Player player : Bukkit.getOnlinePlayers()){
			if(!(player.isOp())){
				player.teleport(p.getLocation());
				
				player.sendMessage(MessageServerPlay.serverPlay);
				
				p.sendMessage(MessagePlayersSummoned.playersSummoned);
			}else{
				player.sendMessage(MessagePvPNowOn.inGame);
				
			}
		}
		
		}
		return true;
	}
	

}
