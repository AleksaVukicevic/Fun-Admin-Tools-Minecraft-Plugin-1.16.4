package me.aleksa.spawnCreepers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;

public class ChickenCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public ChickenCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("chicken").setExecutor(this);
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
			s.sendMessage("Error brah: chicken takes max 1 args");
			s.sendMessage("/chicken <player>");
			return false;
		}
		
		p.getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);		
		p.setHealth(0);
		p.sendMessage("You've been chickened!");
		s.sendMessage("Chickened player!");

		
		return false;
	}
}
