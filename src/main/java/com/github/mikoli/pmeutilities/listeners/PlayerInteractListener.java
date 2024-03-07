package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteractListener implements Listener {

    private final PMEUtilities plugin;

    public PlayerInteractListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlayerInteractEvent(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR)
            if (event.getAction() != Action.RIGHT_CLICK_BLOCK)
                return;
        if (event.getItem() == null) return;

        Player player = event.getPlayer();
        ItemStack itemToSet = event.getItem();
        ItemMeta itemToSetMeta = itemToSet.getItemMeta();
        EquipmentSlot equipmentSlot = getArmorPart(itemToSet);

        ItemStack itemInSlot = player.getInventory().getItem(equipmentSlot);
        ItemMeta itemInSlotMeta = null;
        if (itemInSlot != null) itemInSlotMeta = itemInSlot.getItemMeta();
        if ((itemToSetMeta != null && !itemToSetMeta.hasCustomModelData()) && (itemInSlotMeta != null && !itemInSlotMeta.hasCustomModelData())) return;

        event.setCancelled(true);

        if (itemToSetMeta != null && itemToSetMeta.hasCustomModelData() && CustomItemsUtils.isCustomArmor(itemToSetMeta.getCustomModelData()))
            itemToSet = ListenersUtils.armorPlaceholder(itemToSet);
        if (itemInSlotMeta != null && itemInSlotMeta.hasCustomModelData() && CustomItemsUtils.isCustomArmor(itemInSlotMeta.getCustomModelData()))
            itemInSlot = ListenersUtils.armorPlaceholder(itemInSlot);

        player.getInventory().setItem(equipmentSlot, itemToSet);
        player.getInventory().setItem(event.getHand(), itemInSlot);
    }

    private static EquipmentSlot getArmorPart(ItemStack itemStack) {
        String str = itemStack.getType().name().toLowerCase();
        if (str.contains("helmet")) return EquipmentSlot.HEAD;
        else if (str.contains("chestplate")) return EquipmentSlot.CHEST;
        else if (str.contains("leggings")) return EquipmentSlot.LEGS;
        else if (str.contains("boots")) return EquipmentSlot.FEET;
        else return null;
    }
}
