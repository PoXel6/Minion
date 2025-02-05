package me.poxel6.mininion.commands;

import java.util.List;
import me.poxel6.mininion.Mininion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

public class MinionTabCompleter implements TabCompleter {
  private final Mininion plugin;

  public MinionTabCompleter(Mininion plugin) {
    this.plugin = plugin;
  }

  @Nullable
  @Override
  public List<String> onTabComplete(
      CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      return null;
    }
    List<String> completion = null;
    if (args.length == 1) {
      completion = (List<String>) plugin.getConfig().getList("TAB_COMPLETIONS");
    }

    return completion;
  }
}
