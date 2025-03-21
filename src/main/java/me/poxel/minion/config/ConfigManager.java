package me.poxel.minion.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.poxel.minion.Main;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class ConfigManager {


	public static void reload(Main plugin) {
		plugin.reloadConfig();
	}

}
