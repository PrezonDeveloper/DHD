
/*
 * ZIE INFO.TXT
 */

package com.ducitymp.dhd;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.ducitymp.dhd.Commads.CMD_spawn;
import com.ducitymp.dhd.Listeners.InventroyInteract;
import com.ducitymp.dhd.Listeners.ItemUse;
import com.ducitymp.dhd.Listeners.PlayerJoin;
import com.ducitymp.dhd.Listeners.PlayerMove;
import com.ducitymp.dhd.Managers.ConfigManager;
import com.ducitymp.dhd.MySQL.SQLSettings;
import com.ducitymp.dhd.Ultis.Scoreboard;

public class DHD extends JavaPlugin{
	
	private String VERSION = "1.0.0";
	public static SQLSettings sql;
	ConfigManager file = ConfigManager.getInstance();
	public static HashMap<Player, Integer> cooldownTime;
	public static HashMap<Player, BukkitRunnable> cooldownTask;
	
	public void onEnable(){
		
		sql = new SQLSettings();
		file.setup(getInstance());
		
		Bukkit.getLogger().log(Level.INFO, "[DHD] Enabled DHDServerDevTrial version: " + VERSION + "!");
		
		for(Player p : Bukkit.getOnlinePlayers()){
			Scoreboard.buildScoreboard(p);
		}
		
		Bukkit.getPluginManager().registerEvents(new PlayerMove(), getInstance());	
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), getInstance());	
		Bukkit.getPluginManager().registerEvents(new ItemUse(), getInstance());
		Bukkit.getPluginManager().registerEvents(new InventroyInteract(), getInstance());
		
		getCommand("spawn").setExecutor(new CMD_spawn());
	}
	
	public static Plugin getInstance(){
		return DHD.getPlugin(DHD.class);
	}

}
