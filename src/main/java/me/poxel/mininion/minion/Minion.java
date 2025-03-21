package me.poxel.mininion.minion;

import me.poxel.mininion.Mininion;
import me.poxel.mininion.minion.trait.Persistable;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;


@SuppressWarnings("unused")
public class Minion implements Persistable {


	private static final String MINION_METADATA_KEY = "isMinion";
	private static final Mininion PLUGIN = Mininion.getInstance();
	private final Minion minion = MinionFactory.create();
	private final ArmorStand armorStand = MinionFactory.getMinion();

	protected Minion(Player owner) {
		armorStand.getPersistentDataContainer().set(getKey(), getDataType(), getValue());
	}

	//<editor-fold desc="Persistable">
	@Override
	public NamespacedKey getKey() {
		return new NamespacedKey(PLUGIN, MINION_METADATA_KEY);
	}

	@Override
	public PersistentDataType getDataType() {
		return PersistentDataType.BOOLEAN;
	}

	@Override
	public Boolean getValue() {
		return true;
	}

	//</editor-fold>
}
