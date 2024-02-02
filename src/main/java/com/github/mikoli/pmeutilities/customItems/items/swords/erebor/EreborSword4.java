package com.github.mikoli.pmeutilities.customItems.items.swords.erebor;

import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomCrafting;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class EreborSword4 implements ICustomItem, ICustomCrafting {
    @Override
    public String getTag() {
        return "sword_erebor_4";
    }

    @Override
    public String[] getShape() {
        return new String[] {"S  ", " D ", "   "};
    }

    @Override
    public HashMap<Character, Material> getIngredientsMap() {
        return new HashMap<Character, Material>() {{
            put('S', getBaseItem());
            put('D', Material.YELLOW_DYE);
        }};
    }

    @Override
    public int getDataModelId() {
        return 308;
    }

    @Override
    public Material getBaseItem() {
        return Material.IRON_SWORD;
    }

    @Override
    public String getName() {
        return "Żelazny topór ereboru";
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
