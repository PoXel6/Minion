package me.poxel.mininion.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Configuration {


	@Getter private static Material chestplate;
	@Getter private static Material leggings;
	@Getter private static Material boots;
	@Getter private static List<String> tabCompletions;
	@Getter private static String name;

	public static void loadConfig(FileConfiguration config) {
		name = config.getString("GENERAL.DISPLAY_NAME", "Minion");
		chestplate = Material.getMaterial(config.getString("APPEARANCE.CHESTPLATE", "LEATHER_CHESTPLATE"));
		leggings = Material.getMaterial(config.getString("APPEARANCE.LEGGINGS", "LEATHER_LEGGINGS"));
		boots = Material.getMaterial(config.getString("APPEARANCE.BOOTS", "LEATHER_BOOTS"));
		tabCompletions = config.getStringList("TAB_COMPLETIONS");
	}
}
