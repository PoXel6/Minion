package me.poxel.mininion;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import me.poxel.mininion.command.MinionCommand;
import me.poxel.mininion.config.Configuration;
import me.poxel.mininion.listener.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Mininion extends JavaPlugin {


	@Getter private static Mininion instance;
	private PaperCommandManager manager;

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	@Override
	public void onEnable() {
		instance = this;
		loadConfig();
		manager = new PaperCommandManager(this);
		registerCommands(new MinionCommand());
		getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
		this.getLogger().info("Mininion has been initialized!");
	}

	private void loadConfig() {
		saveDefaultConfig();
		Configuration.loadConfig(getConfig());
	}

	private void registerCommands(BaseCommand... commands) {
		for (var command : commands)
			manager.registerCommand(command);
	}
}
