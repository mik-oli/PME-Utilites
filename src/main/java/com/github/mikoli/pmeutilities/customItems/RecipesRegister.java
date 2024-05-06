package com.github.mikoli.pmeutilities.customItems;

import com.github.mikoli.pmeutilities.PMEUtilities;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.IArmor;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomCrafting;
import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.listeners.ListenersUtils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class RecipesRegister {

    private final PMEUtilities plugin;

    public RecipesRegister(PMEUtilities plugin) {
        this.plugin = plugin;
        this.registerRecipes();
    }

    private void registerRecipes() {

        for (IdList id : IdList.values()) {
            ICustomItem customItem = id.getCustomItem();
            if (!(customItem instanceof ICustomCrafting)) continue;

            if (customItem instanceof IArmor) registerArmorCrafting(customItem);
            else {
                ICustomCrafting crafting = (ICustomCrafting) customItem;
                NamespacedKey key = new NamespacedKey(plugin, "pme_" + crafting.getTag());
                ShapedRecipe recipe = new ShapedRecipe(key, customItem.getItem(0));
                recipe.shape(crafting.getShape());
                for (char c : crafting.getIngredientsMap().keySet()) {
                    recipe.setIngredient(c, crafting.getIngredientsMap().get(c));
                }
                plugin.getServer().addRecipe(recipe);
            }
        }
    }

    private void registerArmorCrafting(ICustomItem customItem) {

        IArmor armor = (IArmor) customItem;
        ICustomCrafting crafting = (ICustomCrafting) customItem;

        if (armor.getHelmet() != null) {
            NamespacedKey key = new NamespacedKey(plugin, crafting.getTag() + ".helmet");
//            ShapedRecipe recipe = new ShapedRecipe(key, armor.getHelmet());
            ShapedRecipe recipe = new ShapedRecipe(key, ListenersUtils.armorPlaceholder(armor.getHelmet()));
            recipe.shape(crafting.getShape());
            for (char c : crafting.getIngredientsMap().keySet()) {
                Material material = crafting.getIngredientsMap().get(c);
                if (material == null) material = armor.getArmorType().getHelmet();
                recipe.setIngredient(c, material);
            }
            plugin.getServer().addRecipe(recipe);
        }
        if (armor.getChestplate() != null) {
            NamespacedKey key = new NamespacedKey(plugin, crafting.getTag() + ".chestplate");
//            ShapedRecipe recipe = new ShapedRecipe(key, armor.getChestplate());
            ShapedRecipe recipe = new ShapedRecipe(key, ListenersUtils.armorPlaceholder(armor.getChestplate()));
            recipe.shape(crafting.getShape());
            for (char c : crafting.getIngredientsMap().keySet()) {
                Material material = crafting.getIngredientsMap().get(c);
                if (material == null) material = armor.getArmorType().getChestplate();
                recipe.setIngredient(c, material);
            }
            plugin.getServer().addRecipe(recipe);
        }
        if (armor.getLeggings() != null) {
            NamespacedKey key = new NamespacedKey(plugin, crafting.getTag() + ".leggings");
//            ShapedRecipe recipe = new ShapedRecipe(key, armor.getLeggings());
            ShapedRecipe recipe = new ShapedRecipe(key, ListenersUtils.armorPlaceholder(armor.getLeggings()));
            recipe.shape(crafting.getShape());
            for (char c : crafting.getIngredientsMap().keySet()) {
                Material material = crafting.getIngredientsMap().get(c);
                if (material == null) material = armor.getArmorType().getLeggings();
                recipe.setIngredient(c, material);
            }
            plugin.getServer().addRecipe(recipe);
        }
        if (armor.getBoots() != null) {
            NamespacedKey key = new NamespacedKey(plugin, crafting.getTag() + ".boots");
//            ShapedRecipe recipe = new ShapedRecipe(key, armor.getBoots());
            ShapedRecipe recipe = new ShapedRecipe(key, ListenersUtils.armorPlaceholder(armor.getBoots()));
            recipe.shape(crafting.getShape());
            for (char c : crafting.getIngredientsMap().keySet()) {
                Material material = crafting.getIngredientsMap().get(c);
                if (material == null) material = armor.getArmorType().getBoots();
                recipe.setIngredient(c, material);
            }
            plugin.getServer().addRecipe(recipe);
        }
    }
}
