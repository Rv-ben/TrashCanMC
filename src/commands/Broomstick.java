package commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.rubenbramasco.TrashCanMC;

public class Broomstick implements CommandExecutor{
	
	private TrashCanMC plugin;
	
	public Broomstick(TrashCanMC plugin) {
		this.plugin = plugin;
		plugin.getCommand("broomstick").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("You must be a player");
			return true;
		}
		
		
		Player p = (Player)sender;
		
		PlayerInventory inv = p.getInventory();
		
		ItemStack rod = new ItemStack(Material.BLAZE_ROD);
		
		ItemMeta meta = rod.getItemMeta();
		
		meta.setDisplayName("BroomStick");
		
		rod.setItemMeta(meta);
		
		inv.addItem(rod);
		
		return false;
	}
	
}
