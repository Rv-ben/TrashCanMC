package me.rubenbramasco;

import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.inventory.Inventory;


public class RedStoneTrashListener implements Listener{
	
	Inventory cannedItems;
	TrashCanMC plugin;
	
	public RedStoneTrashListener(TrashCanMC plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onRedStonePowered(BlockPhysicsEvent redEvent) {
		
		//check that the block is a barrel
		if(redEvent.getBlock().getType() == Material.BARREL) {
			//check if powered
			if(redEvent.getBlock().getBlockPower() > 0) {
				
				Barrel d = (Barrel)redEvent.getBlock().getState();
				//check if it is a trashcan
				if(d.getCustomName().equals(plugin.trashCanName)) {
					plugin.destroyItems(d.getInventory()); //destroyItems
				}
			}
			
		}
	}
	
}
