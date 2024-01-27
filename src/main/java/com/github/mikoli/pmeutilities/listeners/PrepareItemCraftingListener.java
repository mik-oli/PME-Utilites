package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class PrepareItemCraftingListener implements Listener {

    private final PMEUtilities plugin;

    public PrepareItemCraftingListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPrepareItemCrafting(PrepareItemCraftEvent event) {

        for (ItemStack item : event.getInventory().getMatrix()) {
            if (item == null) continue;
            Material itemType = item.getType();

            if (itemType == Material.LEATHER_HELMET || itemType == Material.LEATHER_CHESTPLATE || itemType == Material.LEATHER_LEGGINGS || itemType == Material.LEATHER_BOOTS) {
                LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) item.getItemMeta();
                ItemFactory itemFactory = plugin.getServer().getItemFactory();
                if (leatherArmorMeta.getColor() != itemFactory.getDefaultLeatherColor()) {
                    event.getInventory().setResult(null);
                }
            }
        }
    }
}
