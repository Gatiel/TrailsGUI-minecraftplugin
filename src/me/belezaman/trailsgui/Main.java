package me.belezaman.trailsgui;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.belezaman.trailsgui.commands.Trail;
import me.belezaman.trailsgui.events.ClickEvent;
import me.belezaman.trailsgui.events.Movement;
import me.belezaman.trailsgui.events.Quit;
import me.belezaman.trailsgui.models.GUI;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		GUI menu = new GUI();
		menu.register();
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new ClickEvent(), this);
		pm.registerEvents(new Quit(), this);
		pm.registerEvents(new Movement(), this);
		
		this.getCommand("trails").setExecutor(new Trail());
	}
	@Override
	public void onDisable() {
		
	}
}
