package me.rubenbramasco;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Barrel;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import commands.Broomstick;
import net.md_5.bungee.api.ChatColor;

public class TrashCanMC extends JavaPlugin {
	  // Fired when plugin is first enabled
	
	String trashCanName = ChatColor.BOLD+ "Trash Can";
	
    @Override
    public void onEnable() {
    	new Broomstick(this);
    	getServer().getPluginManager().registerEvents(new ChestCreator(this),this);
    	getServer().getPluginManager().registerEvents(new TrashGuiListener(this),this);
    	getServer().getPluginManager().registerEvents(new RedStoneTrashListener(this),this);
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
    
    public void destroyItems(Inventory cannedItems) {
    	cannedItems.clear();
		addDestroyButton((Barrel)cannedItems.getHolder());
	}
    
    public void setGui(Block chest) {
    	
		Barrel trashCanGui = (Barrel)chest.getState();
		trashCanGui.setCustomName(trashCanName);
		trashCanGui.update();
		addDestroyButton((Barrel)trashCanGui);
	}
    
    public void addDestroyButton(Barrel trashCanGui){
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
