package com.github.mikoli.pmeutilities.customItems.items.armors.angmar;

import com.github.mikoli.pmeutilities.utils.enums.ArmorTypes;
import com.github.mikoli.pmeutilities.customItems.ArmorUtils;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IArmor;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomCrafting;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class ArmorGundabad implements ICustomItem, IArmor, ICustomCrafting {
    @Override
    public int getColorId() {
        return 255;
    }

    @Override
    public ArmorTypes getArmorType() {
        return ArmorTypes.LEATHER;
    }

    @Override
    public ItemStack getHelmet() {
        ItemStack itemStack = ArmorUtils.getHelmet(this.getColorId(), this.getArmorType(), "Gundabadzki hełm");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public ItemStack getChestplate() {
        ItemStack itemStack = ArmorUtils.getChestplate(this.getColorId(), this.getArmorType(), "Gundabadzki napierśnik");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public ItemStack getLeggings() {
        ItemStack itemStack = ArmorUtils.getLeggings(this.getColorId(), this.getArmorType(), "Gundabadzkie nogawice");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public ItemStack getBoots() {
        ItemStack itemStack = ArmorUtils.getBoots(this.getColorId(), this.getArmorType(), "Gundabadzkie buty");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public String getTag() {
        return "gundabad";
    }

    @Override
    public String[] getShape() {
        return new String[] {"SD ", "   ", "   "};
    }

    @Override
    public HashMap<Character, Material> getIngredientsMap() {
        return new HashMap<Character, Material>() {{
            put('S', null);
            put('D', Material.BLUE_DYE);
        }};
    }

    @Override
    public int getDataModelId() {
        return 203;
    }

    @Override
    public Material getBaseItem() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<String> getLore() {
        return null;
    }

    @Override
    public ItemStack getItem(int subId) {
        ItemStack itemStack = null;
        switch (subId) {
            case 1:
                itemStack = this.getHelmet();
                break;
            case 2:
                itemStack = this.getChestplate();
                break;
            case 3:
                itemStack = this.getLeggings();
                break;
            case 4:
                itemStack = this.getBoots();
                break;
            default: return null;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
