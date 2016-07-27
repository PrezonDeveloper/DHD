package eu.ducitymp.dhd.Menus;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import eu.ducitymp.dhd.DHD;
import eu.ducitymp.dhd.Ultis.ItemUtil;

public class SettingsMenu {
	
	public SettingsMenu(){
		
	}
	
	ItemUtil item = new ItemUtil();
	
	public void open(Player p){
		Inventory inv = Bukkit.createInventory(null, 9*3, "&9&lSettings".replace("&", "§"));
		
		for (int i = 0; i<13; i++){
			 inv.setItem(i, item.spacer());
		}
	       
        ItemStack barrier = new ItemStack(Material.BLAZE_POWDER,1,(short)0);
        ItemMeta barriermeta = barrier.getItemMeta();
        if(DHD.sql.getPARTICLE(p) == 1){
        	
        barriermeta.setDisplayName("§aParticles §7- Enabled");
        List<String> lore = new ArrayList<String>();
        lore.add("§fKlik om particles uit te schakelen!");
        barriermeta.setLore(lore);
        
	  }else{
		  
        barriermeta.setDisplayName("§cParticles §7- Disabled");
        List<String> lore = new ArrayList<String>();
        lore.add("§fKlik om particles in te schakelen!");
        barriermeta.setLore(lore);
        
        }
        barrier.setItemMeta(barriermeta);
        inv.setItem(13, barrier);
        
        for (int i = 14; i<27; i++){
			 inv.setItem(i, item.spacer());
		}

        p.openInventory(inv);
    }

}
