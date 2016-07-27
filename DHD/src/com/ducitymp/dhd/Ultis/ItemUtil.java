package com.ducitymp.dhd.Ultis;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
	
	public ItemUtil(){
		
	}
	
	public ItemStack spacer(){
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE, 1);
		ItemMeta im = i.getItemMeta();
		im.addEnchant(Enchantment.DURABILITY, 1, true);
		i.setItemMeta(im);
		
		return i;
	}
	
	public ItemStack normalitem(Material mat, String name, int amount, List<String> lore){
		ItemStack i = new ItemStack(mat, amount);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(name);
		im.setLore(lore);
		i.setItemMeta(im);
		
		return i;
	}

}
