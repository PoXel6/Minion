package me.poxel.mininion.config;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Configuration {


	@Getter private static Material chestplate;
	@Getter private static Material leggings;
	@Getter private static Material boots;
	@Getter private static String name;
	@Getter private static String minionMenuName;

	public static void loadConfig(FileConfiguration config) {
		name = config.getString("GENERAL.DISPLAY_NAME", "Minion");
		chestplate = Material.getMaterial(config.getString("APPEARANCE.CHESTPLATE", "LEATHER_CHESTPLATE"));
		leggings = Material.getMaterial(config.getString("APPEARANCE.LEGGINGS", "LEATHER_LEGGINGS"));
		boots = Material.getMaterial(config.getString("APPEARANCE.BOOTS", "LEATHER_BOOTS"));
		minionMenuName = config.getString("MENU.minion-menu-name");
	}
}
