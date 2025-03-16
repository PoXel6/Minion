package me.poxel6.mininion;

import dev.triumphteam.cmd.bukkit.BukkitCommandManager;
import lombok.Getter;
import me.poxel6.mininion.commands.MinionCommand;
import me.poxel6.mininion.config.Configuration;
import me.poxel6.mininion.listeners.PlayerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Mininion extends JavaPlugin {
    @Getter
    private static Mininion instance;
    private final Configuration config = new Configuration();
    BukkitCommandManager<CommandSender> manager = BukkitCommandManager.create(this);

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        config.loadConfig(getConfig());
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        manager.registerCommand(new MinionCommand());
        Bukkit.getLogger().info("Mininion has been initialized!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
