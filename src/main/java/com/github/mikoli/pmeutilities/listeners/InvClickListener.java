package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IArmor;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.utils.enums.Permissions;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        if (event.getSlotType() != InventoryType.SlotType.ARMOR) return;
        if (event.getClick() == ClickType.DROP) return;

        ItemStack cursorItem = event.getCursor();
        ItemStack currentItem = event.getCurrentItem();
        ItemMeta cursorItemMeta = null;
        ItemMeta currentItemMeta = null;

        if (cursorItem.hasItemMeta()) cursorItemMeta = cursorItem.getItemMeta();
        if (currentItem.hasItemMeta()) currentItemMeta = currentItem.getItemMeta();

        if (cursorItemMeta != null && cursorItemMeta.hasCustomModelData() && CustomItemsUtils.isCustomArmor(cursorItemMeta.getCustomModelData())) {
            event.setCancelled(true);
            event.getWhoClicked().setItemOnCursor(currentItem);
            event.setCurrentItem(getItemStack(cursorItemMeta, cursorItem));
        }

        if (currentItemMeta != null && currentItemMeta.hasCustomModelData() && CustomItemsUtils.isCustomArmor(currentItemMeta.getCustomModelData())) {
            if (event.getClick() == ClickType.CREATIVE) {
                event.getWhoClicked().setItemOnCursor(ListenersUtils.armorPlaceholder(currentItem));
                ((Player) event.getWhoClicked()).updateInventory();
                event.getWhoClicked().setItemOnCursor(null);
            } else {
                event.setCancelled(true);
                event.setCurrentItem(cursorItem);
                event.getWhoClicked().setItemOnCursor(null);
                event.getWhoClicked().setItemOnCursor(ListenersUtils.armorPlaceholder(currentItem));
                ((Player) event.getWhoClicked()).updateInventory();
            }
        }
    }

    private static ItemStack getItemStack(ItemMeta itemMeta, ItemStack itemStack) {
        IArmor armor = null;
        for (ICustomItem customItem : CustomItemsUtils.getCustomArmors())
            if (customItem.getDataModelId() == itemMeta.getCustomModelData()) armor = (IArmor) customItem;

        if (itemStack.getType() == Material.CHAINMAIL_HELMET) return armor.getHelmet();
        else if (itemStack.getType() == Material.CHAINMAIL_CHESTPLATE) return armor.getChestplate();
        else if (itemStack.getType() == Material.CHAINMAIL_LEGGINGS) return armor.getLeggings();
        else if (itemStack.getType() == Material.CHAINMAIL_BOOTS) return armor.getBoots();
        else return itemStack;
    }
}
