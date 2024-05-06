package com.github.mikoli.pmeutilities.listeners;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.CustomDurabilityUtil;
import com.github.mikoli.pmeutilities.customItems.CustomItemsUtils;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IArmor;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IRing;
import com.github.mikoli.pmeutilities.otherMechanics.ItemLimiter;
import com.github.mikoli.pmeutilities.otherMechanics.RingsManager;

import com.github.mikoli.pmeutilities.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

public class ListenersUtils {

    public static void ringsLogic(PMEUtilities plugin, Player player, ItemStack itemStack) {
        RingsManager ringsManager = plugin.getRingsManager();
        if (!ringsManager.isItemRing(itemStack)) return;
        if (ringsManager.hasPlayerRing(player)) return;

        IRing ring = ringsManager.getRingFromItem(itemStack);
        ringsManager.addPlayerRing(player, ring);
        ringsManager.playerAddEffect(player, ring);
        Bukkit.broadcastMessage(Utils.coloring("&aGracz &e" + player.getName() + " założył pierścień: " + "&e" + ((ICustomItem) ring).getName()));
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

    public static ItemStack armorPlaceholder(ItemStack inputItem) {
        ItemMeta inputMeta = inputItem.getItemMeta();

        ItemStack itemToSet = null;
        if (inputItem.getType().name().toLowerCase().contains("leather")) itemToSet = getItemStack(inputItem);
        else if (inputItem.getType().name().toLowerCase().contains("chainmail")) itemToSet = getItemStack(inputMeta, inputItem);

        ItemMeta itemToSetMeta = itemToSet.getItemMeta();
        itemToSetMeta.setCustomModelData(inputMeta.getCustomModelData());
        itemToSetMeta.setDisplayName(inputMeta.getDisplayName());
        itemToSetMeta.setLore(inputMeta.getLore());

        PersistentDataContainer dataContainer = inputMeta.getPersistentDataContainer();
        PersistentDataContainer dataContainerToSet = itemToSetMeta.getPersistentDataContainer();
        CustomDurabilityUtil.setData(true, dataContainerToSet, CustomDurabilityUtil.getData(true, dataContainer));
        CustomDurabilityUtil.setData(false, dataContainerToSet, CustomDurabilityUtil.getData(false, dataContainer));

        itemToSet.setItemMeta(itemToSetMeta);

        Damageable damageable = (Damageable) inputItem.getItemMeta();
        float x = ((float)damageable.getDamage()/inputItem.getType().getMaxDurability());

        Damageable itemToSetDamageable = (Damageable) itemToSet.getItemMeta();
        int maxDurability = itemToSet.getType().getMaxDurability();
        int damage = maxDurability - (int)(maxDurability*x);
        if (x == 0) damage = 0;
        itemToSetDamageable.setDamage(damage);
        itemToSet.setItemMeta(itemToSetDamageable);

        return itemToSet;
    }

    private static ItemStack getItemStack(ItemStack currentItem) {
        ItemStack itemToSet = null;
        if (currentItem.getType() == Material.LEATHER_HELMET) itemToSet = new ItemStack(Material.CHAINMAIL_HELMET);
        else if (currentItem.getType() == Material.LEATHER_CHESTPLATE) itemToSet = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        else if (currentItem.getType() == Material.LEATHER_LEGGINGS) itemToSet = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        else if (currentItem.getType() == Material.LEATHER_BOOTS) itemToSet = new ItemStack(Material.CHAINMAIL_BOOTS);
        return itemToSet;
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
