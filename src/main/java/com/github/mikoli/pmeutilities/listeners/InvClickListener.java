package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.utils.enums.Permissions;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class InvClickListener implements Listener {

    private final PMEUtilities plugin;

    public InvClickListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onInvClickEvent(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        if (inventory == null) return;
        ItemStack itemStack = event.getCursor();

        if (event.getSlot() == 40) ListenersUtils.ringsLogic(plugin, player, itemStack);
        itemLimiter(event);
        armorPainter(event);
    }

    private void itemLimiter(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        if (inventory == null) return;

        if (player.hasPermission(Permissions.BYPASS_ITEM_LIMIT.getPermission())) return;

        ItemStack item = null;
        if (inventory.getHolder() == player) item = event.getCursor();
        else if (inventory.getHolder() != player && event.getClick().isShiftClick()) inventory.getItem(event.getSlot());
        if (item == null) return;

        if (ListenersUtils.itemLimiter(player, item)) event.setCancelled(true);
    }

    private void armorPainter(InventoryClickEvent event) {
        ItemStack itemStack = event.getCursor();
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (itemMeta == null) return;
        if (!itemMeta.hasCustomModelData()) return;
        if (!CustomItemsUtils.isCustomArmor(itemMeta.getCustomModelData())) return;

        if (event.getSlotType() == InventoryType.SlotType.ARMOR) itemStack.setItemMeta(ListenersUtils.armorPainter(itemStack, true));
        else itemStack.setItemMeta(ListenersUtils.armorPainter(itemStack, false));
    }
}
