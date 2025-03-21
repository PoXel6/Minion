package me.poxel.mininion.minion.trait;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;


public interface Persistable {


	NamespacedKey getKey();

	PersistentDataType getDataType();

	Boolean getValue();


}
