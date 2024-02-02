package com.github.mikoli.pmeutilities.customItems.items.rings;

import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IRing;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class AtjaRing implements ICustomItem, IRing {
    @Override
    public int getDataModelId() {
        return 102;
    }

    @Override
    public Material getBaseItem() {
        return Material.GOLD_INGOT;
    }

    @Override
    public String getName() {
        return "Atja Ring";
    }

    @Override
    public List<String> getLore() {
        return null;
    }

    @Override
    public ItemStack getItem(int subId) {
        ItemStack itemStack = new ItemStack(this.getBaseItem());
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setCustomModelData(this.getDataModelId());
        itemMeta.setDisplayName(this.getName());
//        itemMeta.setLore(this.getLore());

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public PotionEffectType[] getPotionEffectsTypes() {
        return new PotionEffectType[]{PotionEffectType.INCREASE_DAMAGE};
    }

    @Override
    public int[] getEffectsStrength() {
        return new int[] {1};
    }
}
