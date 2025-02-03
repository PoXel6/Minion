package me.poxel6.mininion.commands;

import me.poxel6.mininion.minions.StoneMinion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MinionCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player player) {
      new StoneMinion(player);
    }
    return true;
  }
}
