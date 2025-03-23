package me.poxel.mininion.menu;

import dev.triumphteam.gui.guis.Gui;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryInteractEvent;


public abstract class Menu {


	private final int DEFAULT_MENU_SIZE = 3;
	private final TextComponent DEFAULT_MENU_TITLE = Component.text("Menu").color(NamedTextColor.GOLD);
	@Getter private Gui inventory;

	public Component getTitle() {
		return DEFAULT_MENU_TITLE;
	}

	public int getRow() {
		return DEFAULT_MENU_SIZE;
	}

	public void open(Player player) {
		inventory = Gui.gui()
		               .rows(getRow())
		               .title(getTitle())
		               .create();
		setMenuItems();
		inventory.open(player);
	}

	public abstract void setMenuItems();

	public abstract <T extends InventoryInteractEvent> void setAction(T event);

}