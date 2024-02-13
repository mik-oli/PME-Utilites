package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class SwapHandItemsListener implements Listener {

    private final PMEUtilities plugin;

    public SwapHandItemsListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private  void onSwapHandItems(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getOffHandItem();

        ListenersUtils.ringsLogic(plugin, player, itemStack);
    }
}
