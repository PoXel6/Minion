package me.poxel.minion.menu.inventories;

import me.poxel.minion.menu.Menu;
import me.poxel.minion.menu.utils.PlayerMenu;
import org.bukkit.event.inventory.InventoryClickEvent;


public class MinionMenu extends Menu {


	public MinionMenu(PlayerMenu playerMenu) {
		super(playerMenu);
	}

	@Override
	public String getMenuName() {
		return "Minion Menu";
	}

	@Override
	public int getSlots() {
		return 36;
	}

	@Override
	public void handleMenu(InventoryClickEvent event) {
	}

	@Override
	public void setMenuItem() {
	}
}
