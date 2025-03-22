package me.poxel.mininion.minion;

import lombok.Getter;
import me.poxel.mininion.command.MinionCommand;
import me.poxel.mininion.config.Configuration;
import me.poxel.mininion.util.TextUtil;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;


public abstract class MinionFactory {


	private static final Player owner = MinionCommand.getSender();
	@Getter private static ArmorStand minion;

	public static Minion create() {
		setAttributes(true);
		setName(true);

		final var location = owner.getLocation();
		minion = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

		return new Minion(owner);
	}

	private static void setAttributes(boolean toggle) {
		minion.setArms(toggle);
		minion.setSmall(toggle);
		minion.setGravity(!toggle);
		minion.setInvulnerable(toggle);
		minion.setArms(toggle);
	}

	private static void setName(boolean toggle) {
		final var name = Configuration.getName();
		minion.customName(TextUtil.legacyDeserializer(name));
		minion.setCustomNameVisible(toggle);
	}


}
