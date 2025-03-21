package me.poxel.minion.menu;

import me.poxel.minion.menu.utils.PlayerMenu;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;


public abstract class Menu implements InventoryHolder {


	protected Inventory inventory;
	protected PlayerMenu playerMenu;

	public Menu(PlayerMenu playerMenu) {
		this.playerMenu = playerMenu;
	}

	public abstract String getMenuName();

	public abstract int getSlots();

	public abstract void handleMenu(InventoryClickEvent event);

	public abstract void setMenuItem();

	public void open() {
		inventory = Bukkit.createInventory(this, getSlots(), getMenuName());
		this.setMenuItem();
		playerMenu.getOwner().openInventory(inventory);
	}

	@Override
	public Inventory getInventory() {
		return inventory;
	}
}
