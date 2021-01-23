package me.aleksa.spawnCreepers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;

public class SudoCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public SudoCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("sudo").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			
		Player s = (Player) sender;
		Player p = null;
		
		if(!s.isOp()) {
			s.sendMessage("Don't have Permission");
			return true;
		}
		
		if(args.length == 2) 
		{
			p = Bukkit.getPlayerExact(args[0]);
			if(p == null) {
				s.sendMessage("Player " + args[0] + " not found");
				return true;
			}
		}
		else 
		{
			s.sendMessage("Error: /sudo takes max 2 args");
			return false;
		}
		
		//Do command or chat
		p.chat(args[1]);

		
		return true;
	}
}
