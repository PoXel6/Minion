package me.poxel6.mininion;

import me.poxel6.mininion.commands.MinionCommand;
import me.poxel6.mininion.commands.MinionTabCompleter;
import me.poxel6.mininion.listeners.PlayerInteractListener;
import me.poxel6.mininion.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mininion extends JavaPlugin {
  private static Mininion instance;
  private static ConfigManager configManager;

  public static Mininion getInstance() {
    return instance;
  }

  @Override
  public void onEnable() {
    saveResource("config.yml", false);
    saveDefaultConfig();
    configManager = new ConfigManager(this);
    instance = this;
    getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    Bukkit.getPluginCommand("minion").setExecutor(new MinionCommand(this));
    Bukkit.getPluginCommand("minion").setTabCompleter(new MinionTabCompleter(this));
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public ConfigManager getConfigManager() {
    return configManager;
  }
}
