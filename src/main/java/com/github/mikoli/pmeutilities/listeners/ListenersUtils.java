package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IArmor;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IRing;
import com.github.mikoli.pmeutilities.otherMechanics.ItemLimiter;
import com.github.mikoli.pmeutilities.otherMechanics.RingsManager;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ListenersUtils {

    public static void ringsLogic(PMEUtilities plugin, Player player, ItemStack itemStack) {
        RingsManager ringsManager = plugin.getRingsManager();
        if (!ringsManager.isItemRing(itemStack)) return;
        if (ringsManager.hasPlayerRing(player)) return;

        IRing ring = ringsManager.getRingFromItem(itemStack);
        ringsManager.addPlayerRing(player, ring);
        ringsManager.playerAddEffect(player, ring);
    }

    public static boolean itemLimiter(Player player, ItemStack itemStack) {
        for (ItemLimiter limitedItem : ItemLimiter.values()) {
            if (limitedItem.getItemMaterial() == itemStack.getType()) {
                if (itemStack.getAmount() > (limitedItem.getLimit() - ItemLimiter.getAmount(player, limitedItem))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ItemMeta armorPainter(ItemStack itemStack, boolean customColor) {
        Color color = null;
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (customColor) {
            for (ICustomItem customItem : CustomItemsUtils.getCustomArmors()) {
                if (customItem.getDataModelId() != itemMeta.getCustomModelData()) continue;
                color = Color.fromRGB(((IArmor) customItem).getColorId());
                break;
            }
        }
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        leatherArmorMeta.setColor(color);
        return leatherArmorMeta;
    }
}
