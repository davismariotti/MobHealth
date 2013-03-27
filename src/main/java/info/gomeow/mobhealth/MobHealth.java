package info.gomeow.mobhealth;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MobHealth extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onAttack(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player && event.getEntity() instanceof LivingEntity) {
			LivingEntity le = (LivingEntity) event.getEntity();
			int health = le.getHealth();
			int missing = le.getMaxHealth() - health;
			StringBuilder sb = new StringBuilder().append(ChatColor.GREEN);
			for(int x = 0; x < health; x++) 
				sb.append("|");
			sb.append(ChatColor.RED);
			for(int x = 0; x < missing; x++)
				sb.append("|");
			le.setCustomName(sb.toString());
		}
	}
	
}
