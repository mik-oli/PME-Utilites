package com.github.mikoli.pmeutilities.customItems.itemInterfaces;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface ICustomItem {

    public abstract int getDataModelId();
    public abstract Material getBaseItem();
    public abstract String getName();
    public abstract List<String> getLore();
    public abstract ItemStack getItem(int subId);
}
