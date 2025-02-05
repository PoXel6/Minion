package me.poxel6.mininion.commands;

import me.poxel6.mininion.Mininion;
import me.poxel6.mininion.minions.StoneMinion;
import me.poxel6.mininion.utils.ConfigManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinionCommand implements CommandExecutor {
  private final Mininion plugin;

  public MinionCommand(Mininion plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    ConfigManager configManager = plugin.getConfigManager();
    if (sender instanceof Player player) {
      configManager.reload();
      new StoneMinion(player);
    }
    return true;
  }
}
