package me.poxel6.mininion.menus.inventories;

import me.poxel6.mininion.menus.Menu;
import me.poxel6.mininion.menus.utils.PlayerMenu;
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
  public void handleMenu(InventoryClickEvent event) {}

  @Override
  public void setMenuItem() {}
}
