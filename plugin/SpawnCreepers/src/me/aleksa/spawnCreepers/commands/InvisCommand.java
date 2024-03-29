package me.aleksa.spawnCreepers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;

public class InvisCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public InvisCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("invisible").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
		Player s = (Player) sender;
		Player p = s;
		
		if(!s.isOp()) {
			s.sendMessage("Don't have Permission");
			return true;
		}
		
		if(args.length == 1) 
		{
			p = Bukkit.getPlayerExact(args[0]);
			if(p == null) {
				s.sendMessage("Player " + args[0] + " not found");
				return true;
			}
		}
		else 
		{
			s.sendMessage("Error: /invisible takes max 1 args");
			return false;
		}
		
		p.setInvisible(!p.isInvisible());
		
		return true;
	}
}
