package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.utils.enums.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemPickUpListener implements Listener {

    private final PMEUtilities plugin;

    public ItemPickUpListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onItemPickUpEvent(EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        ItemStack item = event.getItem().getItemStack();

        if (player.hasPermission(Permissions.BYPASS_ITEM_LIMIT.getPermission())) return;
        if (ListenersUtils.itemLimiter(player, item)) event.setCancelled(true);
    }
}
