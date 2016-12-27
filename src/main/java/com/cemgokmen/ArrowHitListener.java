package com.cemgokmen;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

/**
 * Created by cgokmen on 11/30/16.
 */
public class ArrowHitListener implements Listener {
    @EventHandler
    public void onPigAte(EntityChangeBlockEvent event) {
        Entity entity = event.getEntity();
        Block block = event.getBlock();
        Material to = event.getTo();

        if (entity instanceof Animals && block.getType() == Material.GRASS && to == Material.DIRT) {
            Animals p = (Animals) entity;

            if (p.equals(GrassFeed.runningPlugin.theAnimal)) {
                GrassFeed.runningPlugin.getServer().broadcastMessage("The animal just ate grass! Hooray!");
            }
        }
    }
}
