package me.poxel6.mininion.utils;

import me.poxel6.mininion.Mininion;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {
  private final Mininion plugin;
  private FileConfiguration config;

  public ConfigManager(Mininion plugin) {
    this.plugin = plugin;
    this.config = plugin.getConfig();
  }

  public void reload() {
    plugin.reloadConfig();
    config = plugin.getConfig();
  }
}
