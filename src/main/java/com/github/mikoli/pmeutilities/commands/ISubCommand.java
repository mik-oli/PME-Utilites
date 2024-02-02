package com.github.mikoli.pmeutilities.commands;

import org.bukkit.command.CommandSender;

public interface ISubCommand {

    public abstract String getName();
    public abstract String getSyntax();
    public abstract int getArgsLength();
    public abstract boolean isPlayerOnly();
    public abstract String getPermission();
    public abstract void perform(CommandSender commandSender, String[] args);
}
