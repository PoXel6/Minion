package me.poxel.mininion.minion;

import me.poxel.mininion.Mininion;
import me.poxel.mininion.config.Configuration;
import me.poxel.mininion.util.TextUtil;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


public abstract class MinionFactory {


	private static final Mininion plugin = Mininion.getInstance();
	private static Player owner;
	private static ArmorStand minion;

	public static void create() {
		setAttribute(true);
		setName(true);
		final var location = owner.getLocation();

		minion = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
	}

	private static void setAttribute(final boolean toggle) {
		minion.setArms(toggle);
		minion.setSmall(toggle);
		minion.setGravity(!toggle);
		minion.setInvulnerable(toggle);
		minion.setArms(toggle);
	}

	private static void setName(final boolean toggle) {
		final var name = Configuration.getName();
		minion.customName(TextUtil.legacyDeserializer(name));
		minion.setCustomNameVisible(true);
	}


}
