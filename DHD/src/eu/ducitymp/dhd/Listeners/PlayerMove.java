package eu.ducitymp.dhd.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import eu.ducitymp.dhd.DHD;
import eu.ducitymp.dhd.Ultis.ParticleEffect;

public class PlayerMove implements Listener{

	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = (Player) e.getPlayer();
	if(DHD.sql.getPARTICLE(p) == 1)
		ParticleEffect.FLAME.display(0.3F, 0F, 0.3F, 0, 5, e.getPlayer().getLocation(), 10);	
	}
}
