package me.poxel6.mininion;

import me.poxel6.mininion.commands.MinionCommand;
import me.poxel6.mininion.listeners.PlayerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mininion extends JavaPlugin {

  @Override
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    Bukkit.getPluginCommand("minion").setExecutor(new MinionCommand());
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
