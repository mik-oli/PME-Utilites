package com.github.mikoli.pmeutilities.customItems.items.swords.other;

import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class WizardSword implements ICustomItem {
    @Override
    public int getDataModelId() {
        return 321;
    }

    @Override
    public Material getBaseItem() {
        return Material.NETHERITE_SWORD;
    }

    @Override
    public String getName() {
        return "Miecz czarodzieja";
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
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
