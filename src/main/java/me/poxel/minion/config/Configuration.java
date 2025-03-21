package me.poxel.minion.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Configuration {


	private static Material chestplate;
	private static Material leggings;
	private static Material boots;
	private static List<String> tabCompletions;
	private static String name;

	public static void loadConfig(FileConfiguration config) {
		name = config.getString("GENERAL.DISPLAY_NAME", "Minion");
		chestplate = Material.getMaterial(config.getString("APPEARANCE.CHESTPLATE", "LEATHER_CHESTPLATE"));
		leggings = Material.getMaterial(config.getString("APPEARANCE.LEGGINGS", "LEATHER_LEGGINGS"));
		boots = Material.getMaterial(config.getString("APPEARANCE.BOOTS", "LEATHER_BOOTS"));
		tabCompletions = config.getStringList("TAB_COMPLETIONS");
	}
}
