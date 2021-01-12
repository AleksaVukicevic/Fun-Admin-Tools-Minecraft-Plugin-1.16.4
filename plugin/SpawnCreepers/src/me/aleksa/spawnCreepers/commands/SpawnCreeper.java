package me.aleksa.spawnCreepers.commands;

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
		
		Player p = (Player) sender;
		
		if(!p.isOp()) {
			p.sendMessage("Don't have Permission");
			return false;
		}
		
		Location loc = p.getLocation();
		World w = p.getWorld();
		
		int amount = Integer.parseInt(args[0]);
		
		if(amount <= 100) {
			for(int i = 0; i < amount; i++) {
				w.spawnEntity(loc,EntityType.CREEPER);
			}
			p.sendMessage("Spawned" + amount + "creepers");
		}
		else {
			p.sendMessage("Max is 100 :/");
		}
		
		return false;
	}
}
