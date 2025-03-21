package me.poxel.minion.minion;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;


public interface MinionStorage {


	Inventory getInventory();

	void setInventory(Inventory inventory);

	boolean isInventoryInRange(Inventory inventory);

	InventoryHolder getInventoryHolder();

	int getRange();

	void setRange();

	boolean isInventoryFull();
}
