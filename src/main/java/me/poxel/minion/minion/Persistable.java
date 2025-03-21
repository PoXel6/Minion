package me.poxel.minion.minion;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;


public interface Persistable {


	NamespacedKey getKey();

	PersistentDataType getDataType();


}
