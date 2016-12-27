package com.cemgokmen;

public class Flammable extends JavaPlugin {
    public static GrassFeed runningPlugin;

    // This code is called after the server starts and after the /reload command
    @Override
    public void onEnable() {
        GrassFeed.runningPlugin = this; // SINGLETON!

        getServer().getPluginManager().registerEvents(new ArrowHitListener(), this);
    }

    // This code is called before the server stops and after the /reload command
    @Override
    public void onDisable() {
        GrassFeed.runningPlugin = null;
        HandlerList.unregisterAll(this);
    }
}
