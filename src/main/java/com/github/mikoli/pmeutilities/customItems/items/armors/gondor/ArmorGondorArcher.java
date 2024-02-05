package com.github.mikoli.pmeutilities.customItems.items.armors.gondor;

import com.github.mikoli.pmeutilities.utils.enums.armors.ArmorTypes;
import com.github.mikoli.pmeutilities.customItems.ArmorUtils;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IArmor;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomCrafting;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class ArmorGondorArcher implements ICustomItem, IArmor, ICustomCrafting {
    @Override
    public int getColorId() {
        return 6553855;
    }

    @Override
    public ArmorTypes getArmorType() {
        return ArmorTypes.LEATHER;
    }

    @Override
    public ItemStack getHelmet() {
        ItemStack itemStack = ArmorUtils.getHelmet(this.getColorId(), this.getArmorType(), "Hełm łucznika Gondoru");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public ItemStack getChestplate() {
        ItemStack itemStack = ArmorUtils.getChestplate(this.getColorId(), this.getArmorType(), "Napierśnik łucznika Gondoru");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public ItemStack getLeggings() {
        ItemStack itemStack = ArmorUtils.getLeggings(this.getColorId(), this.getArmorType(), "Nogawice łucznika Gondoru");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public ItemStack getBoots() {
        ItemStack itemStack = ArmorUtils.getBoots(this.getColorId(), this.getArmorType(), "Buty łucznika Gondoru");
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    @Override
    public String getTag() {
        return "gondorArcher";
    }

    @Override
    public String[] getShape() {
        return new String[] {"SD ", "   ", "   "};
    }

    @Override
    public HashMap<Character, Material> getIngredientsMap() {
        return new HashMap<Character, Material>() {{
            put('S', null);
            put('D', Material.WHITE_DYE);
        }};
    }

    @Override
    public int getDataModelId() {
        return 213;
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
