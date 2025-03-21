package me.poxel.minion.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.poxel.minion.Main;
import me.poxel.minion.config.ConfigManager;
import me.poxel.minion.minion.StoneMinion;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MinionCommand extends BaseCommand {


	@SuppressWarnings("deprecation")
	public MinionCommand() {
		super("minion");
	}

	@Default
	public void onCommand(CommandSender sender) {
		if (sender instanceof Player owner) {
			new StoneMinion(owner);
		}
		sender.sendMessage("Only players can use this command!");
	}

	@Subcommand("reload")
	public void onReload(CommandSender sender) {
		ConfigManager.reload(Main.getInstance());
	}
}
