package com.ducitymp.dhd.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.ducitymp.dhd.DHD;
import com.ducitymp.dhd.Ultis.MessageUtils;

public class InventroyInteract implements Listener{
	
	MessageUtils message = new MessageUtils();
	
	@EventHandler
	public void onInvInteract(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
   if(e.getInventory().getName().equalsIgnoreCase("§9§lSettings")){	
	   e.setCancelled(true);
	   
	  if(e.getSlot() != 13){
		  p.closeInventory();
		  return;
	  }
				if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cParticles §7- Disabled")){
					DHD.sql.setPARTICLE(p, 1);
					p.sendMessage(message.MAINPREFIX + "§fJe hebt particles ingeschakeld!");
					p.closeInventory();
					return;
				}
				
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aParticles §7- Enabled")){
					DHD.sql.setPARTICLE(p, 0);
					p.sendMessage(message.MAINPREFIX + "§fJe hebt particles uitgeschakeld!");
					p.closeInventory();
					return;
				}
			}
	}
}
