package eu.ducitymp.dhd.Ultis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

import eu.ducitymp.dhd.DHD;

public class Scoreboard {
	
	public static void buildScoreboard(final Player p) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		org.bukkit.scoreboard.Scoreboard scoreboard = manager.getNewScoreboard();
	    	
		Objective objective = scoreboard.registerNewObjective("test", "dummy");
	    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', "     &e&lDagelijks&9&lHaaDee    "));
	    	
	    Score score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&r    "));
		score6.setScore(6);
	    
	    Score score5 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&6&lSpeler:"));
		score5.setScore(5);
	    
	    Score score4 = objective.getScore(ChatColor.translateAlternateColorCodes('&', " " + p.getName()));
		score4.setScore(4);
	    
	    Score score3 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&r  "));
		score3.setScore(3);
	    
	    Score score2 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&6&lPunten:"));
		score2.setScore(2);
	    
	    Score score1 = objective.getScore(ChatColor.translateAlternateColorCodes('&', " " + String.valueOf(DHD.sql.getPUNTEN(p))));
		score1.setScore(1);
	    
		Score score0 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&6&l&m-----------------"));
		score0.setScore(0);
				
	    p.setScoreboard(scoreboard);
	}

}
