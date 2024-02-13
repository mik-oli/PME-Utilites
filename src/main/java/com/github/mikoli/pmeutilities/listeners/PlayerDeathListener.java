package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;
import com.github.mikoli.pmeutilities.utils.enums.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class PlayerDeathListener implements Listener {

    private final PMEUtilities plugin;

    public PlayerDeathListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerDeathEvent(PlayerDeathEvent event) {

        for (ItemStack itemStack : event.getDrops()) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (!itemMeta.hasCustomModelData()) continue;
            if (CustomItemsUtils.isCustomArmor(itemMeta.getCustomModelData())) itemStack.setItemMeta(ListenersUtils.armorPainter(itemStack, false));
        }

        Player player = event.getEntity();
        if (player.hasPermission(Permissions.BYPASS_INVENTORY_CLEAR.getPermission())) return;
        event.getDrops().removeIf(itemStack -> {
            Random random = new Random();
            int randomNum = random.nextInt(100);
            return randomNum >= 50;
        });
    }
}
