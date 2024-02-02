package com.github.mikoli.pmeutilities.customItems.itemInterfaces;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public interface IRing {

    public abstract PotionEffectType[] getPotionEffectsTypes();
    public abstract int[] getEffectsStrength();
}
