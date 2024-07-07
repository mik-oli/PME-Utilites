package com.github.mikoli.pmeutilities.commands;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.commands.subCommands.GetItemCmd;
import com.github.mikoli.pmeutilities.utils.Utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandsHandler implements CommandExecutor {

    private final PMEUtilities plugin;
    private final ArrayList<ISubCommand> subCommands = new ArrayList<>();

    public CommandsHandler(PMEUtilities plugin) {
        this.plugin = plugin;
        this.loadSubCommands();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length <= 0) return false;
        ISubCommand subCommand = this.getSubCommand(args[0]);
        if (subCommand == null) return false;
        if (subCommand.isPlayerOnly() && !(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.pluginPrefix() + Utils.coloring("&aThis is player only command!"));
            return true;
        }
        if (args.length < subCommand.getArgsLength() + 1) {
            commandSender.sendMessage(subCommand.getSyntax());
            return true;
        }
        if (!commandSender.hasPermission(subCommand.getPermission())) {
            commandSender.sendMessage(Utils.pluginPrefix() + Utils.coloring("&aYou don't have permission to perform this command!"));
            return true;
        }

        subCommand.perform(commandSender, args);
        return true;
    }

    protected ISubCommand getSubCommand(String str) {
        for (ISubCommand subCmd : subCommands)
            if (subCmd.getName().equalsIgnoreCase(str)) return subCmd;
        return null;
    }

    private void loadSubCommands() {
        subCommands.add(new GetItemCmd());
    }
}
