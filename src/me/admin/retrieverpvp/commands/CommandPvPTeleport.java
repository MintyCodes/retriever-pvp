package me.admin.retrieverpvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.admin.retrieverpvp.Core;
import me.admin.retrieverpvp.utils.MessageNoPerm;
import me.admin.retrieverpvp.utils.MessageNotPlayer;
import me.admin.retrieverpvp.utils.MessagePlayerTeleported;
import me.admin.retrieverpvp.utils.MessageTeleported;
import me.admin.retrieverpvp.utils.MessageTeleportedSelf;

public class CommandPvPTeleport implements CommandExecutor {

	Core core;

	public CommandPvPTeleport(Core core) {
		this.core = core;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String args[]) {
		Player p = (Player) sender;
		if (commandlabel.equalsIgnoreCase("pvpteleport")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(MessageNotPlayer.notPlayer);
				return true;
			}

		
			if (!(p.hasPermission("retrieverpvp.teleport"))) {
				p.sendMessage(MessageNoPerm.noPerm);
				return true;

			}

			double X = core.getConfig().getDouble("location.X");
			double Y = core.getConfig().getDouble("location.Y");
			double Z = core.getConfig().getDouble("location.Z");

			World world = p.getWorld();
			Location loc = new Location((world), X, Y, Z);
			p.teleport(loc);

			p.sendMessage(MessageTeleportedSelf.playerTeleported);
			return true;
		}

		/*if (args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);

			double X = core.getConfig().getDouble("location.X");
			double Y = core.getConfig().getDouble("location.Y");
			double Z = core.getConfig().getDouble("location.Z");

			World world = p.getWorld();
			Location loc = new Location((world), X, Y, Z);
			target.teleport(loc);

			p.sendMessage(MessagePlayerTeleported.playerTeleported + ChatColor.GOLD + target.getName()
					+ MessagePlayerTeleported.playerTeleported2);
			target.sendMessage(ChatColor.GOLD + p.getName() + MessageTeleported.teleported);
			return true;
		}

		/*
		 * 
		 * if(args.length != 0 || args.length != 1){
		 * p.sendMessage(MessageSyntaxError.syntaxError); return true;
		 * 
		 * 
		 * }
		 */

		return true;
	}

}
