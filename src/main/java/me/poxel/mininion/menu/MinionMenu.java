package me.poxel.mininion.menu;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import me.poxel.mininion.config.Configuration;
import me.poxel.mininion.minion.StoneMinion;
import me.poxel.mininion.util.TextUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;


public class MinionMenu extends Menu {


	@Override
	public Component getTitle() {
		return TextUtil.legacyDeserializer(Configuration.getMinionMenuName());
	}

	@Override
	public void setMenuItems() {
		final var stoneMinion = ItemBuilder.from(Material.STONE)
		                                   .name(Component.text("STONE MINION"))
		                                   .asGuiItem();
		getInventory().addItem(stoneMinion);
	}

	@Override
	public void setAction() {
		getInventory().setDefaultClickAction(event -> {
			final var player = ((Player) event.getWhoClicked());
			final var item = event.getCurrentItem();
			player.sendMessage("you clicked on this: " + item);
			new StoneMinion(player);
		});
	}
}
