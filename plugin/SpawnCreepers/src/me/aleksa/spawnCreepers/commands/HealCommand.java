package me.aleksa.spawnCreepers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;

public class HealCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public HealCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("heal").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player s = (Player) sender;
		Player p = s;
		
		if(!s.isOp()) {
			s.sendMessage("Don't have Permission");
			return false;
		}
		
		if(args.length > 1) {
			s.sendMessage("Error brah: heal takes max 1 args");
			s.sendMessage("/heal <player>");
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
		
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setSaturation(5);
		
		return false;
	}
}
