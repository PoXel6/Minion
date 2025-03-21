package me.poxel.mininion.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import me.poxel.mininion.Mininion;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class ConfigManager {


	public static void reload(Mininion plugin) {
		plugin.reloadConfig();
	}

}
