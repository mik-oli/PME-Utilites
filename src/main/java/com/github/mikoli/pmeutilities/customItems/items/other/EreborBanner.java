package com.github.mikoli.pmeutilities.customItems.items.other;

import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomCrafting;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public class EreborBanner implements ICustomItem, ICustomCrafting {
    @Override
    public String getTag() {
        return "banner_erebor";
    }

    @Override
    public String[] getShape() {
        return new String[] {"SD ", "   ", "   "};
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
        return 10;
    }

    @Override
    public Material getBaseItem() {
        return Material.WHITE_BANNER;
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
        ItemStack itemStack = new ItemStack(this.getBaseItem());
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(this.getDataModelId());
        itemStack.setItemMeta(itemMeta);

        BannerMeta bannerMeta = (BannerMeta) itemStack.getItemMeta();
        bannerMeta.addPattern(new Pattern(DyeColor.WHITE, PatternType.CREEPER));
        itemStack.setItemMeta(bannerMeta);

        return itemStack;
    }
}
