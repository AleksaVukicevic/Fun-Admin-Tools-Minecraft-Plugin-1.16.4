package me.aleksa.spawnCreepers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;

public class SmiteCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public SmiteCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("smite").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
		Player s = (Player) sender;
		Player p = null;
		
		if(!s.isOp()) {
			s.sendMessage("Don't have Permission");
			return false;
		}
		
		if(args.length == 1) 
		{
			p = Bukkit.getPlayerExact(args[0]);
			if(p == null) {
				s.sendMessage("Player " + args[0] + " not found");
				return false;
			}
		}
		else 
		{
			s.sendMessage("Error brah: explode takes max 1 args");
			s.sendMessage("/smite <player>");
			return false;
		}
		
		p.getWorld().spawnEntity(p.getLocation(), EntityType.LIGHTNING);

		
		return false;
	}
}
