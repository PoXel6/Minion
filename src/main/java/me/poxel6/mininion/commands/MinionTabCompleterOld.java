package me.poxel6.mininion.commands;

import me.poxel6.mininion.Mininion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MinionTabCompleterOld implements TabCompleter {
    private final Mininion plugin;

    public MinionTabCompleterOld(Mininion plugin) {
        this.plugin = plugin;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(
            CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return null;
        }
        List<String> completion = null;
        if (args.length == 1) {
//      completion = (List<String>) Configuration.tab

        }

        return completion;
    }
}
