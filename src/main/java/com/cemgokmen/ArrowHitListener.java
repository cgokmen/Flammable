package com.cemgokmen;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

/**
 * Created by cgokmen on 11/30/16.
 */
public class ArrowHitListener implements Listener {
    @EventHandler
    public void onArrowHit(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();
        if (projectile instanceof Arrow) {
            Block block = event.getHitBlock();
            if (block != null && block.getType() != Material.AIR) {
                if (projectile.getFireTicks() > 0) {
                    Location location = projectile.getLocation();
                    Block arrowLanded = location.getBlock();
                    BlockFace burnFace = block.getFace(arrowLanded);
                    Block target = block.getRelative(burnFace);
                    if (target.getType() == Material.AIR) {
                        target.setType(Material.FIRE);
                    }
                }
            }
        }
    }
}
