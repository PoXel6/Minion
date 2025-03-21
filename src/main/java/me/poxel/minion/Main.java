package me.poxel.minion;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import me.poxel.minion.command.MinionCommand;
import me.poxel.minion.config.Configuration;
import me.poxel.minion.listener.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {


	@Getter
	private static Main instance;
	private PaperCommandManager manager;

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	@Override
	public void onEnable() {
		instance = this;
		manager = new PaperCommandManager(this);
		manager.registerCommand(new MinionCommand());
		loadConfig();
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
		this.getLogger().info("Mininion has been initialized!");
	}

	private void loadConfig() {
		saveDefaultConfig();
		Configuration.loadConfig(getConfig());
	}
}
