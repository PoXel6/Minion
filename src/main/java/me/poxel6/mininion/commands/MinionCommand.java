package me.poxel6.mininion.commands;

import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.Default;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import me.poxel6.mininion.Mininion;
import me.poxel6.mininion.config.Configuration;
import me.poxel6.mininion.minions.StoneMinion;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Command("Minion")
public class MinionCommand extends BaseCommand {
    @Default
    public void executor(CommandSender sender) {
        if (sender instanceof Player owner) {
            new StoneMinion(owner);
        }
        sender.sendMessage("Only players can use this command!");
    }

    @SubCommand("reload")
    public void reload(CommandSender sender) {
        Configuration.reload(Mininion.getInstance());
    }
}
