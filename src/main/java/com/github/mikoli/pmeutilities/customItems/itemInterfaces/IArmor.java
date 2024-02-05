package com.github.mikoli.pmeutilities.customItems.itemInterfaces;

import com.github.mikoli.pmeutilities.utils.enums.armors.ArmorTypes;

import org.bukkit.inventory.ItemStack;

public interface IArmor {

    public abstract int getColorId();
    public abstract ArmorTypes getArmorType();
    public abstract ItemStack getHelmet();
    public abstract ItemStack getChestplate();
    public abstract ItemStack getLeggings();
    public abstract ItemStack getBoots();
}
