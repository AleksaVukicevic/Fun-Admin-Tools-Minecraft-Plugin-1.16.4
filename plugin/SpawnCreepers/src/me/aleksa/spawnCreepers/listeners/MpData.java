package me.aleksa.spawnCreepers.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;

import me.aleksa.spawnCreepers.Main;

public class MpData {
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public String playerName;
	public Entity mob;
	
	public MpData(String playerName, Entity mob) 
	{
		this.playerName = playerName;
		this.mob = mob;
		
	}
	public MpData(Main plugin) {
		this.plugin = plugin;
	}
	
}
