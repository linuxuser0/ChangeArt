package me.user171.ChangeArt;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ChangeArt extends JavaPlugin{
	
	Logger log;
	PluginManager pm;
	PaintingListener paintingListener;
	
	public void onEnable(){
		log = Logger.getLogger("Minecraft");
		log.info("ChangeArt has been enabled.");
	
		paintingListener = new PaintingListener(this);
		
		pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PAINTING_PLACE, paintingListener, Event.Priority.Normal, this);
		pm.registerEvent(Event.Type.PAINTING_BREAK, paintingListener, Event.Priority.Normal, this);
	}
	
	public void onDisable(){
		log.info("ChangeArt has been disabled.");
	}
}
