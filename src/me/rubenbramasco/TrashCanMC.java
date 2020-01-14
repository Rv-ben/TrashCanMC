package me.rubenbramasco;

import org.bukkit.plugin.java.JavaPlugin;

import commands.Broomstick;

public class TrashCanMC extends JavaPlugin {
	  // Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	new Broomstick(this);
    	getServer().getPluginManager().registerEvents(new ChestCreator(),this);
    }
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
}
