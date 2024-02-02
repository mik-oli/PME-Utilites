package com.github.mikoli.pmeutilities.customItems.itemInterfaces;

import org.bukkit.Material;

import java.util.HashMap;

public interface ICustomCrafting {

    public abstract String getTag();
    public abstract String[] getShape();
    public abstract HashMap<Character, Material> getIngredientsMap();
}
