package me.poxel6.mininion.listeners;

import me.poxel6.mininion.minions.Minion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;

public class PlayerInteractListener implements Listener {

  @EventHandler
  public void onPlayerInteractEvent(PlayerArmorStandManipulateEvent event) {
    if (event.getRightClicked() instanceof Minion) {
      var player = event.getPlayer();
      if (player.isSneaking()) {
        player.giveExp(1000);
      }
    }
    event.setCancelled(true);
  }
}
