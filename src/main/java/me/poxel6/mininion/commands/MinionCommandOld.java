package me.poxel6.mininion.commands;

import me.poxel6.mininion.Mininion;
import me.poxel6.mininion.config.Configuration;
import me.poxel6.mininion.minions.StoneMinion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinionCommandOld implements CommandExecutor {
  private final Mininion plugin;

  public MinionCommandOld(Mininion plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
      Configuration.reload(plugin);
      new StoneMinion(player);
    }
    return true;
  }
}
