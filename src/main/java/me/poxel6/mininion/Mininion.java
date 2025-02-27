package me.poxel6.mininion;

import java.util.HashMap;
import me.poxel6.mininion.commands.MinionCommand;
import me.poxel6.mininion.commands.MinionTabCompleter;
import me.poxel6.mininion.listeners.PlayerInteractListener;
import me.poxel6.mininion.menus.utils.PlayerMenu;
import me.poxel6.mininion.utils.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mininion extends JavaPlugin {
  private static final HashMap<Player, PlayerMenu> playerMenuMap = new HashMap<>();
  private static Mininion instance;
  private static ConfigManager configManager;

  public Mininion() {
    instance = this;
  }

  public static PlayerMenu getPlayerMenu(Player p) {
    PlayerMenu playerMenu;
    if (playerMenuMap.containsKey(p)) {
      return playerMenuMap.get(p);
    }
    playerMenu = new PlayerMenu(p);
    playerMenuMap.put(p, playerMenu);
    return playerMenu;
  }

  public static Mininion getInstance() {
    return instance;
  }

  @Override
  public void onEnable() {
    saveResource("config.yml", false);
    saveDefaultConfig();
    configManager = new ConfigManager(this);
    getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    getServer().getPluginCommand("minion").setExecutor(new MinionCommand(this));
    getServer().getPluginCommand("minion").setTabCompleter(new MinionTabCompleter(this));
    Bukkit.getLogger().info("Mininion has been initialized!");
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public ConfigManager getConfigManager() {
    return configManager;
  }
}
