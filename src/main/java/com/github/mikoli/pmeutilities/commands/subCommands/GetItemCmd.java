package com.github.mikoli.pmeutilities.commands.subCommands;

import com.github.mikoli.pmeutilities.commands.ISubCommand;
import com.github.mikoli.pmeutilities.customItems.IdList;

import com.github.mikoli.pmeutilities.utils.Utils;
import com.github.mikoli.pmeutilities.utils.enums.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetItemCmd implements ISubCommand {

    @Override
    public String getName() {
        return "item";
    }

    @Override
    public String getSyntax() {
        return "/pmeutils item <id>";
    }

    @Override
    public int getArgsLength() {
        return 1;
    }

    @Override
    public boolean isPlayerOnly() {
        return true;
    }

    @Override
    public String getPermission() {
        return Permissions.GET_ITEM_CMD.getPermission();
    }

    @Override
    public void perform(CommandSender commandSender, String[] args) {

        int id, subId = 0;
        if (args[1].contains("-")) {
            id = Integer.parseInt(args[1].split("-")[0]);
            subId = Integer.parseInt(args[1].split("-")[1]);
        } else id = Integer.parseInt(args[1]);
        Player player = Bukkit.getPlayer(commandSender.getName());

        ItemStack item = null;
        for (IdList value : IdList.values()) {
            if (value.getId() == id) {
                item = value.getCustomItem().getItem(subId);
               break;
            }
        }
        if (item != null) player.getInventory().addItem(item);
        else commandSender.sendMessage(Utils.pluginPrefix() + Utils.coloring("&eItem with that id was not found or not exists without sub id."));
    }
}
