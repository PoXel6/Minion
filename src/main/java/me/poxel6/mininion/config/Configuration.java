package me.poxel6.mininion.config;

import lombok.Getter;
import me.poxel6.mininion.Mininion;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

@Getter
public class Configuration {
    private static Material chestplate;
    private static Material leggings;
    private static Material boots;
    private static List<String> tabCompletions;
    private static String name;

    private Configuration() {
    }

    public static void reload(Mininion plugin) {
        plugin.reloadConfig();
    }

    public void loadConfig(FileConfiguration config) {
        name = config.getString("GENERAL.DISPLAY_NAME", "Minion");
        chestplate = Material.getMaterial(config.getString("APPEARANCE.CHESTPLATE", "LEATHER_CHESTPLATE"));
        leggings = Material.getMaterial(config.getString("APPEARANCE.LEGGINGS", "LEATHER_LEGGINGS"));
        boots = Material.getMaterial(config.getString("APPEARANCE.BOOTS", "LEATHER_BOOTS"));
        tabCompletions = config.getStringList("TAB_COMPLETIONS");
    }
}
