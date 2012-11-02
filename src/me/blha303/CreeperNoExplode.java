package me.blha303;

import java.util.logging.Logger;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CreeperNoExplode extends JavaPlugin implements Listener {

	public final Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable() {
		log.info(String.format("[%s] Disabled version %s", getDescription().getName(), getDescription().getVersion()));
	}
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		log.info(String.format("[%s] Enabled version %s", getDescription().getName(), getDescription().getVersion()));
	}
	
	@EventHandler
	public void onCreeperExplode(EntityExplodeEvent event) {
		Entity e = event.getEntity();
		if (e instanceof Creeper) {
			event.setCancelled(true);
			return;
		}
	}
	
	@EventHandler
	public void onCreeperDamage(EntityDamageByEntityEvent event) {
		Entity e = event.getDamager();
		if (e instanceof Creeper) {
			event.setCancelled(true);
			return;
		}
	}
}
