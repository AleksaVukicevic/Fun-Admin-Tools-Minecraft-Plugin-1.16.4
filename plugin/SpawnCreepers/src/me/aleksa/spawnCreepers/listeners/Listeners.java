package me.aleksa.spawnCreepers.listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.aleksa.spawnCreepers.Main;

public class Listeners implements Listener {
	@SuppressWarnings("unused")
	private Main plugin;
	
	public Listeners(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	
	
	
	//public MpData[] mp = new MpData[Bukkit.getServer().getMaxPlayers()];
	//public List<MpData> mp = new ArrayList<MpData>();
	
	public List<String> playerName = new ArrayList<String>();
	public List<LivingEntity> mob = new ArrayList<LivingEntity>();
	
	public static boolean en = true;
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) 
	{
		if(en) 
		{
			for(int i = 0; i < playerName.size(); i++) 
			{
				if(playerName.get(i) == e.getPlayer().getName()) 
				{			
					mob.get(i).teleport(e.getPlayer().getLocation());				
				}
			}						
		}
	}
	
	@EventHandler
	public void OnInteractEntity(PlayerInteractEntityEvent e) 
	{
		if(en) 
		{			
			Material mat = e.getPlayer().getInventory().getItemInMainHand().getType();	
			
			if(mat == Material.STICK) 
			{
				if(!playerName.isEmpty()) 
				{					
					for(int i = 0; i < playerName.size(); i++) 
					{
						if(playerName.get(i) == e.getPlayer().getName()) 
						{
							// Found player
							if(!mob.get(i).isEmpty()) {
								
								//LivingEntity le = (LivingEntity) mob.get(i);	
								mob.set(i,(LivingEntity) e.getRightClicked());
								mob.get(i).setAI(false);					
								mob.get(i).setCollidable(false);
								mob.get(i).setInvulnerable(true);							
								//mob.set(i, le);								

								e.getPlayer().setCollidable(true);
								e.getPlayer().getPlayer().setInvisible(false);
								return;
							}
							
						//	mob.add((LivingEntity)e.getRightClicked());
						//	mob.get(i).setAI(false);					
						//	mob.get(i).setCollidable(false);
						//	mob.get(i).setInvulnerable(true);							
							//mob.set(i, le);								

						//	e.getPlayer().setCollidable(true);
						////	e.getPlayer().getPlayer().setInvisible(false);
						//	return;
						//	LivingEntity le = (LivingEntity) e.getRightClicked();							
						//	le.setAI(false);					
						//	le.setCollidable(false);
						//	le.setInvulnerable(true);							
						//	mob.set(i, le);							
//
						//	e.getPlayer().setCollidable(false);
						//	e.getPlayer().getPlayer().setInvisible(true);
			
							
						}
					}					
				}
				

				// Didn't find player so add
				
				playerName.add(e.getPlayer().getName());
				mob.add((LivingEntity)e.getRightClicked());
				
				//mp.add(new MpData(e.getPlayer().getName(), e.getRightClicked()));	
				
				for(int i = 0; i < playerName.size(); i++) 
				{
					if(playerName.get(i) == e.getPlayer().getName()) 
					{
						// Found player
						
						//LivingEntity le = (LivingEntity) e.getRightClicked();							
						mob.get(i).setAI(false);					
						mob.get(i).setCollidable(false);
						mob.get(i).setInvulnerable(true);							
						//mob.set(i, le);								

						e.getPlayer().setCollidable(false);
						e.getPlayer().getPlayer().setInvisible(true);
		
						return;
					}
				}	
				
				e.getPlayer().sendMessage("Error");
								
			}
		}

	}

	public void OnInteract(PlayerInteractEvent e) 
	{
		e.getPlayer().setCollidable(true);
		e.getPlayer().setInvisible(false);
		
		if(en) 
		{
			//Material mat = e.getPlayer().getInventory().getItemInMainHand().getType();	
			//mat == Material.STICK
			if(true) 
			{
				for(int i = 0; i < playerName.size(); i++) 
				{
					if(playerName.get(i) == e.getPlayer().getName()) 
					{
						// Found player
						
						//LivingEntity le = (LivingEntity) mob.get(i);	
						mob.get(i).setHealth(0);
					//	le.setAI(true);					
					//	le.setCollidable(true);
					//	le.setInvulnerable(false);							
					//	mob.set(i, le);
						
						//mob.set(i, null);


						
		
						return;
					}
				}
				e.getPlayer().sendMessage("Error");
			}

		}
	}
}
