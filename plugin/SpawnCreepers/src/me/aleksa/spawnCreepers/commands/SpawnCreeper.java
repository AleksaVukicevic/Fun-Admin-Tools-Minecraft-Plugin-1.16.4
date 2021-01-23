package me.aleksa.spawnCreepers.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;

public class SpawnCreeper implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public SpawnCreeper(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("spawncreeps").setExecutor(this);
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
			p = Bukkit.getPlayerExact(args[1]);
			if(p == null) {
				s.sendMessage("Player " + args[1] + " not found");
				return true;
			}
		}
		else if(args.length == 1) 
		{
			p = s;
		}
		else 
		{
			return false;
		}
		
		Location loc = p.getLocation();
		World w = p.getWorld();
		
		int amount = Integer.parseInt(args[0]);
		
		if(amount <= 256) 
		{
			for(int i = 0; i < amount; i++) 
			{
				w.spawnEntity(loc,EntityType.CREEPER);
			}
			p.sendMessage("Spawned " + amount + " creepers");
			return true;
		}
		else {
			p.sendMessage("Max is 256 :/");
			return true;
		}
		
		
	}
}
