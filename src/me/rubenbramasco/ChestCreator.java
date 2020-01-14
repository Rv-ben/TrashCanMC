package me.rubenbramasco;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class ChestCreator implements Listener{
	
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		ItemStack item = player.getInventory().getItemInMainHand();
		
		ItemStack bStick = new ItemStack(Material.BLAZE_ROD);
		ItemMeta bMeta = bStick.getItemMeta();
		bMeta.setDisplayName("BroomStick");
		bStick.setItemMeta(bMeta);
		
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(item.equals(bStick) && 
					event.getClickedBlock().getBlockData().getMaterial() == Material.CHEST) {
						player.sendMessage("Trash Can created");
			}
		}
		
	}
	

}
