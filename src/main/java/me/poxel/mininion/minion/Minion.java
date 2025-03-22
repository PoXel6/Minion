package me.poxel.mininion.minion;

import lombok.Getter;
import me.poxel.mininion.Mininion;
import me.poxel.mininion.minion.trait.Persistable;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;


public class Minion implements Persistable {


	@Getter private static final String MINION_KEY = "isMinion";
	@Getter private static final Minion instance = MinionFactory.create();
	private final Mininion PLUGIN = Mininion.getInstance();
	private final ArmorStand armorStand = MinionFactory.getMinion();

	protected Minion(Player owner) {
		armorStand.getPersistentDataContainer().set(getKey(), PersistentDataType.BOOLEAN, getValue());
	}

	//<editor-fold desc="Persistable">
	@Override
	public NamespacedKey getKey() {
		return new NamespacedKey(PLUGIN, MINION_KEY);
	}

	@Override
	public Boolean getValue() {
		return true;
	}

	//</editor-fold>
}
