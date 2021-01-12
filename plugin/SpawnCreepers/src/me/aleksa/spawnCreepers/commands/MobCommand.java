package me.aleksa.spawnCreepers.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.aleksa.spawnCreepers.Main;
import me.aleksa.spawnCreepers.listeners.Listeners;

public class MobCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public MobCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("mob").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player s = (Player) sender;
		
		if(!s.isOp()) {
			s.sendMessage("Don't have Permission");
			return false;
		}
		
		Listeners.en = !Listeners.en;
		s.sendMessage("Mob set to " + Listeners.en);

		return false;
	}
}
