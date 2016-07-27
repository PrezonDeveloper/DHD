package eu.ducitymp.dhd.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import eu.ducitymp.dhd.DHD;
import eu.ducitymp.dhd.Ultis.ItemUtil;

public class PlayerJoin implements Listener{
	
	Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
    Team team = null;
    ItemUtil item = new ItemUtil();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = (Player) e.getPlayer();
		
		DHD.sql.createAccount(p);
		
		p.getInventory().clear();
		p.getInventory().setItem(4, new ItemStack(Material.PAPER, 1));
		eu.ducitymp.dhd.Ultis.Scoreboard.buildScoreboard(p);
		
		if(p.isOp() || p.hasPermission("dhd.staff")){
			e.setJoinMessage("§c[Staff] " + p.getName() + " §cis gejoined!");
			
		if(board.getTeam(p.getName()) == null){
	            team = board.registerNewTeam(p.getName());
	    }else{
	            team = board.getTeam(p.getName());
	    }
			
	   
	    team.setPrefix(ChatColor.translateAlternateColorCodes('&', "§c"));
	    team.addPlayer(p);  
			
		}else{
			e.setJoinMessage(null);
		}
		
	}

}
