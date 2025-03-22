package me.poxel.mininion.listener;

import me.poxel.mininion.minion.Minion;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.persistence.PersistentDataType;


public class PlayerInteractListener implements Listener {


	@EventHandler
	public void onPlayerInteractEvent(PlayerArmorStandManipulateEvent event) {
		final var armorStand = event.getRightClicked();
		if (isMinion(armorStand))
			return;
		final var player = event.getPlayer();
		if (player.isSneaking())
			armorStand.setHealth(0);
		event.setCancelled(true);
	}

	private static boolean isMinion(final ArmorStand armorStand) {
		return armorStand.getPersistentDataContainer().get(Minion.getInstance().getKey(), PersistentDataType.BOOLEAN);
	}
}
