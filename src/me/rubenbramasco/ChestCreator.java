package me.rubenbramasco;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.MetadataValue;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class ChestCreator implements Listener{
	
	Player player;
	
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
						player.sendMessage("Trash Can created_test");
						setGui(clickedBlock);
			}
			
			
		}
		
	}
	
	private void setGui(Block chest) {
	
		Barrel trashCanGui = (Barrel)chest.getState();
		trashCanGui.setCustomName(ChatColor.BOLD + " "+ChatColor.RED + "Trash Can");
		
		ItemStack fireButton = new ItemStack(Material.CAMPFIRE);
		ItemMeta fireButton_Meta = fireButton.getItemMeta();
		
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Dude if you cick this everything is wiped");
		
		fireButton_Meta.setDisplayName("Destory Items");
		fireButton_Meta.setLore(lore);
		fireButton_Meta.setLocalizedName("");
		
		fireButton.setItemMeta(fireButton_Meta);
		trashCanGui.getInventory().setItem(26,fireButton); //26 is the last index of the barrel 

		
	}
	

}
