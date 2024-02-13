package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerDropItemListener implements Listener {

    private final PMEUtilities plugin;

    public PlayerDropItemListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event) {

        ItemStack itemStack = event.getItemDrop().getItemStack();
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (!itemMeta.hasCustomModelData()) return;
        if (CustomItemsUtils.isCustomArmor(itemMeta.getCustomModelData())) itemStack.setItemMeta(ListenersUtils.armorPainter(itemStack, false));
    }
}
