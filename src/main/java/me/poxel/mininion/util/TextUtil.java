package me.poxel.mininion.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class TextUtil {


	public static Component legacyDeserializer(String input) {
		return LegacyComponentSerializer.legacyAmpersand().deserialize(input);
	}

	public static Component miniMessageDeserializer(String input) {
		return MiniMessage.miniMessage().deserialize(input);
	}
}
