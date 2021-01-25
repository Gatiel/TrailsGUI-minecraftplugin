package me.belezaman.trailsgui.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import me.belezaman.trailsgui.models.Effects;
import me.belezaman.trailsgui.models.GUI;
import me.belezaman.trailsgui.models.ParticleData;

public class ClickEvent implements Listener{
	
	private GUI menu;
	public ClickEvent() {
		menu = new GUI();
	}
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (!event.getInventory().equals(menu.getInventory()))
			return;
		
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if(event.getView().getType() == InventoryType.PLAYER)
			return;
		
		ParticleData particle = new ParticleData(player.getUniqueId());
		
		if(particle.hasID()) {
			particle.endTask();
			particle.removeID();
		}
		
		Effects trails = new Effects(player);
		
		switch(event.getSlot()) {
		case 3:
			trails.startTotem();
			player.closeInventory();
			player.updateInventory();
			break;
		case 5:
			particle.setID(1);
			player.closeInventory();
			player.updateInventory();
			break;
		default:
			break;
		}
	}
}
