package me.rubenbramasco;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class ChestCreator implements Listener{
	
	Player player;
	TrashCanMC plugin;
	
	public ChestCreator(TrashCanMC plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		this.player = event.getPlayer();
		
		ItemStack item = player.getInventory().getItemInMainHand();
		
		ItemStack bStick = new ItemStack(Material.BLAZE_ROD);
		ItemMeta bMeta = bStick.getItemMeta();
		bMeta.setDisplayName(ChatColor.RED + "BroomStick");
		bStick.setItemMeta(bMeta);
		
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			
			Block clickedBlock = event.getClickedBlock();
			
			if(item.equals(bStick) && 
					clickedBlock.getBlockData().getMaterial() == Material.BARREL) {
						player.sendMessage("Trash Can Created");
						plugin.setGui(clickedBlock);
			}
			
			
		}
		
	}

}
