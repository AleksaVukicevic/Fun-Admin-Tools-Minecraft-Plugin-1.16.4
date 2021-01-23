package me.aleksa.spawnCreepers.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;

public class GmCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public GmCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("gm").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
		Player s = (Player) sender;
		Player p = s;
		
		if(!s.isOp()) {
			s.sendMessage("Don't have Permission");
			return true;
		}
		
		if(args.length > 2) {
			s.sendMessage("Error: /gm takes max 2 args");
			return false;
		}
		
		if(args.length == 2) 
		{
			p = Bukkit.getPlayerExact(args[1]);
			if(p == null) {
				s.sendMessage("Player " + args[1] + " not found");
				return true;
			}
		}		
		
		
		
		if(args[0].equalsIgnoreCase("1")) 
		{
			p.setGameMode(GameMode.CREATIVE);
			p.sendMessage("Changed gamemode to CREATIVE");
		}
		else if(args[0].equalsIgnoreCase("0")) 
		{
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage("Changed gamemode to SURVIVAL");
		}
		else if(args[0].equalsIgnoreCase("2")) 
		{
			p.setGameMode(GameMode.ADVENTURE);
			p.sendMessage("Changed gamemode to ADVENTURE");
		}
		else if(args[0].equalsIgnoreCase("3")) 
		{
			p.setGameMode(GameMode.SPECTATOR);
			p.sendMessage("Changed gamemode to SPECTATOR");
		}
		else 
		{
			s.sendMessage("Error: " + args[0]);
			return false;

		}
		
		return true;
	}
}
