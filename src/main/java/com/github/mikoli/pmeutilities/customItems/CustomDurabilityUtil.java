package com.github.mikoli.pmeutilities.customItems;

import com.github.mikoli.pmeutilities.PMEUtilities;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomDurabilityUtil {

    private static final NamespacedKey customDurabilityKey = new NamespacedKey(PMEUtilities.getInstance(), "customDurability");
    private static final NamespacedKey maxDurabilityKey = new NamespacedKey(PMEUtilities.getInstance(), "maxDurability");

    public static Boolean hasData(boolean n, PersistentDataContainer dataContainer) {
        if (n) return dataContainer.has(maxDurabilityKey, PersistentDataType.INTEGER);
        else return dataContainer.has(customDurabilityKey, PersistentDataType.INTEGER);
    }

    public static int getData(boolean n, PersistentDataContainer dataContainer) {
        if (n) return dataContainer.get(maxDurabilityKey, PersistentDataType.INTEGER);
        else return dataContainer.get(customDurabilityKey, PersistentDataType.INTEGER);
    }

    public static void setData(boolean n, PersistentDataContainer dataContainer, int value) {
        if (n) dataContainer.set(maxDurabilityKey, PersistentDataType.INTEGER, value);
        else dataContainer.set(customDurabilityKey, PersistentDataType.INTEGER, value);
    }

    public static void removeData(boolean n, PersistentDataContainer dataContainer) {
        if (n) dataContainer.remove(maxDurabilityKey);
        else dataContainer.remove(customDurabilityKey);
    }
}