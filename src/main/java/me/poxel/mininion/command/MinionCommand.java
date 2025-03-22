package me.poxel.mininion.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import lombok.Getter;
import me.poxel.mininion.Mininion;
import me.poxel.mininion.config.ConfigManager;
import me.poxel.mininion.menu.MinionMenu;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


@SuppressWarnings("unused")
public class MinionCommand extends BaseCommand {


	@Getter private static Player sender;

	@SuppressWarnings("deprecation")
	public MinionCommand() {
		super("minion");
	}

	@Default
	public void onCommand(CommandSender sender) {
		if (sender instanceof Player owner) {
			MinionCommand.sender = owner;
			final var minionMenu = new MinionMenu();
			minionMenu.open(owner);
			return;
		}
		sender.sendMessage("Only players can use this command!");
	}

	@Subcommand("reload")
	public void onReload(CommandSender sender) {
		ConfigManager.reload(Mininion.getInstance());
		sender.sendMessage(Component.text("Reloaded Config!").color(NamedTextColor.GREEN));
	}
}
