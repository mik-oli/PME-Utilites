package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomDurabilityUtil;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.List;

public class ItemDamageListener implements Listener {

    private final PMEUtilities plugin;

    public ItemDamageListener(PMEUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemDamageEvent(PlayerItemDamageEvent event) {

        ItemStack itemStack = event.getItem();
        ItemMeta itemMeta = itemStack.getItemMeta();

        PersistentDataContainer dataContainer = itemMeta.getPersistentDataContainer();
        if (!CustomDurabilityUtil.hasData(true, dataContainer)) return;

        int maxCustomDurability = CustomDurabilityUtil.getData(true, dataContainer);
        int customDurability = CustomDurabilityUtil.getData(false, dataContainer);
        customDurability--;
        CustomDurabilityUtil.setData(false, dataContainer, customDurability);

        int maxDurability = itemStack.getType().getMaxDurability();
        float x = ((float)customDurability/maxCustomDurability);
        int damage = maxDurability - (int)(maxDurability*x);

        Damageable damageable = (Damageable) itemStack.getItemMeta();
        int currentDamage = damageable.getDamage();
        if (damage > currentDamage) event.setDamage(1);
        else event.setDamage(0);

        List<String> lore = itemMeta.getLore();
        lore.set(lore.size() - 1, "Durability: " + customDurability + "/" + maxCustomDurability);
        itemMeta.setLore(lore);

        itemStack.setItemMeta(itemMeta);
    }
}
