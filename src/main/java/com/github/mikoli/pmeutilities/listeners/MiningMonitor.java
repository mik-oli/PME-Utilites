package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.utils.enums.Permissions;
import com.github.mikoli.pmeutilities.utils.Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MiningMonitor implements Listener {

    private final PMEUtilities plugin;

    public MiningMonitor(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player targetPlayer = event.getPlayer();
        if (!targetPlayer.hasPermission(Permissions.MININGMONITOR_TRACK.getPermission())) return;
        Block targetBlock = event.getBlock();
        if (plugin.getMiningCounter().wasCounted(targetBlock.getLocation())) return;

        Material ore = targetBlock.getType();
        //TODO ores from config
        if (ore.equals(Material.DIAMOND_ORE) || ore.equals(Material.EMERALD_ORE) || ore.equals(Material.GOLD_ORE)) {
            int blocksTotal = plugin.getMiningCounter().getTotalBlocks(targetBlock);
            String message = ("&c" + targetPlayer.getDisplayName() + " &efound &b" + blocksTotal + " " + ore);

            Utils.consoleInfo(Utils.coloring(message));
            for (Player player : plugin.getServer().getOnlinePlayers()) {
                if (player.hasPermission(Permissions.MININGMONITOR_MONITOR.getPermission())) {
                    //TODO message from config + coloring
                    player.sendMessage(Utils.coloring(message));
                }
            }
        }
    }
}
