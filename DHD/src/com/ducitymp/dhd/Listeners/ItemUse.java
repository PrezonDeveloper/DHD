package com.ducitymp.dhd.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ducitymp.dhd.Menus.SettingsMenu;

public class ItemUse implements Listener{
	
	@EventHandler
	public void onUse(PlayerInteractEvent e){
		
	if ((e.getPlayer().getItemInHand().getType() == Material.PAPER) && (
	(e.getAction() == Action.RIGHT_CLICK_AIR) || 
	(e.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	(e.getAction() == Action.LEFT_CLICK_AIR) || 
	(e.getAction() == Action.LEFT_CLICK_BLOCK)))
	{
	Player p = e.getPlayer();
	e.setCancelled(true);
	
	SettingsMenu menu = new SettingsMenu();
	menu.open(p);
	
	p.updateInventory();
	return;
	
	}else{
		return;
	}
	}

}
