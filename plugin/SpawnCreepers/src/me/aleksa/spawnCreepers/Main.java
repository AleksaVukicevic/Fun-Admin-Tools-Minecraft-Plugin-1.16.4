package me.aleksa.spawnCreepers;

import org.bukkit.plugin.java.JavaPlugin;

import me.aleksa.spawnCreepers.commands.GmCommand;
import me.aleksa.spawnCreepers.commands.HealCommand;
import me.aleksa.spawnCreepers.commands.MobCommand;
import me.aleksa.spawnCreepers.commands.OpenInvCommand;
import me.aleksa.spawnCreepers.commands.PingCommand;
import me.aleksa.spawnCreepers.commands.SpawnCreeper;
import me.aleksa.spawnCreepers.commands.SudoCommand;
import me.aleksa.spawnCreepers.listeners.Listeners;
import me.aleksa.spawnCreepers.listeners.MpData;

public class Main extends JavaPlugin {
	
	@Override 
	public void onEnable() {
		new SpawnCreeper(this);
		new HealCommand(this);
		new PingCommand(this);
		new GmCommand(this);
		new OpenInvCommand(this);
		new SudoCommand(this);
		new MobCommand(this);
		
		new Listeners(this);
		
		//new MpData(this);
	}
	
}