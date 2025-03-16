package me.poxel6.mininion.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteractEvent(PlayerArmorStandManipulateEvent event) {
        if (event.getRightClicked().hasMetadata("isMinion")) {
            var player = event.getPlayer();
            if (player.isSneaking()) {
                event.getRightClicked().setHealth(0);
            } else {
//        new MinionMainMenu(player);
            }
            event.setCancelled(true);
        }
    }
}
