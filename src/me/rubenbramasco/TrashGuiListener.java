package me.rubenbramasco;

import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class TrashGuiListener implements Listener{
	
	TrashCanMC plugin;
	
	public TrashGuiListener(TrashCanMC plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(InventoryClickEvent openEvent) {
		
		if(openEvent.getClickedInventory().getType() != InventoryType.BARREL)
			return;
					
		Barrel trashCan = (Barrel)openEvent.getClickedInventory().getHolder();
		
		if(trashCan.getCustomName().equals(plugin.trashCanName)){
			if(openEvent.getCurrentItem().getType() == Material.CAMPFIRE) {
				openEvent.setCancelled(true);
				plugin.destroyItems(trashCan.getInventory());
			}
		}
	}
	
	
	
}
