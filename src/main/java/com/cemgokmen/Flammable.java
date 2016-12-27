package com.cemgokmen;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public class Flammable extends JavaPlugin {
    public static Flammable runningPlugin;

    // This code is called after the server starts and after the /reload command
    @Override
    public void onEnable() {
        Flammable.runningPlugin = this; // SINGLETON!

        getServer().getPluginManager().registerEvents(new ArrowHitListener(), this);
    }

    // This code is called before the server stops and after the /reload command
    @Override
    public void onDisable() {
        Flammable.runningPlugin = null;
        HandlerList.unregisterAll(this);
    }
}
