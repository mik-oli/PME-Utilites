package com.github.mikoli.pmeutilities.customItems;

import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;

import java.util.ArrayList;

public class CustomItemsUtils {

    public static ArrayList<ICustomItem> getCustomItems() {
        ArrayList<ICustomItem> toReturn = new ArrayList<>();
        toReturn.addAll(getCustomRings());
        toReturn.addAll(getCustomArmors());
        toReturn.addAll(getCustomSwords());
        return toReturn;
    }

    public static ArrayList<ICustomItem> getCustomRings() {
        return new ArrayList<ICustomItem>() {{
                add(IdList.ASH_NAZG_RING.getCustomItem());
                add(IdList.MINJE_RING.getCustomItem());
                add(IdList.ATJA_RING.getCustomItem());
                add(IdList.NELDE_RING.getCustomItem());
                add(IdList.KANTA_RING.getCustomItem());
                add(IdList.LOSTA_RING.getCustomItem());
                add(IdList.ENKWE_RING.getCustomItem());
                add(IdList.OTSO_RING.getCustomItem());
                add(IdList.TOLTO_RING.getCustomItem());
                add(IdList.NERTE_RING.getCustomItem());
        }};
    }

    public static ArrayList<ICustomItem> getCustomArmors() {
        return new ArrayList<ICustomItem>() {{
            add(IdList.ANGMAR_ARMOR.getCustomItem());
            add(IdList.GHOST_ARMOR.getCustomItem());
            add(IdList.GUNDABAD_ARMOR.getCustomItem());
            add(IdList.NUMENOR_ARMOR.getCustomItem());
            add(IdList.NOLDOR_ARMOR.getCustomItem());
            add(IdList.PRINCE_ARMOR.getCustomItem());
            add(IdList.RIVENDEL_ARMOR.getCustomItem());
            add(IdList.SILVAN_ARMOR.getCustomItem());
            add(IdList.EREBOR_AXEMAN_ARMOR.getCustomItem());
            add(IdList.EREBOR_LIGHT_INFANTRY_ARMOR.getCustomItem());
            add(IdList.EREBOR_RECONITERER_ARMOR.getCustomItem());
            add(IdList.EREBOR_WARIOR_ARMOR.getCustomItem());
            add(IdList.GONDOR_ARCHER_ARMOR.getCustomItem());
            add(IdList.GONDOR_CAVALRY_ARMOR.getCustomItem());
            add(IdList.GONDOR_INFANTRY_ARMOR.getCustomItem());
            add(IdList.GUARDSMAN_ARMOR.getCustomItem());
            add(IdList.RANGER_ARMOR.getCustomItem());
            add(IdList.ROCHAN_INFANTRY_ARMOR.getCustomItem());
            add(IdList.MORDOR_GOBLIN_ARMOR.getCustomItem());
            add(IdList.MORDOR_HEAVY_ORC_ARMOR.getCustomItem());
            add(IdList.MORDOR_MORIA_ARMOR.getCustomItem());
            add(IdList.MORDOR_SNAGA_ORC_ARMOR.getCustomItem());
            add(IdList.MORDOR_URUKHAI_ARMOR.getCustomItem());
        }};
    }

    public static ArrayList<ICustomItem> getCustomSwords() {
        return new ArrayList<ICustomItem>() {{
            add(IdList.ANGMAR_SWORD_1.getCustomItem());
            add(IdList.ANGMAR_SWORD_2.getCustomItem());
            add(IdList.ANGMAR_SWORD_3.getCustomItem());
            add(IdList.ANGMAR_SWORD_4.getCustomItem());
            add(IdList.EREBOR_SWORD_1.getCustomItem());
            add(IdList.EREBOR_SWORD_2.getCustomItem());
            add(IdList.EREBOR_SWORD_3.getCustomItem());
            add(IdList.EREBOR_SWORD_4.getCustomItem());
            add(IdList.EREBOR_SWORD_5.getCustomItem());
            add(IdList.MORDOR_SWORD_1.getCustomItem());
            add(IdList.MORDOR_SWORD_2.getCustomItem());
            add(IdList.MORDOR_SWORD_3.getCustomItem());
            add(IdList.MORDOR_SWORD_4.getCustomItem());
            add(IdList.MORDOR_SWORD_5.getCustomItem());
            add(IdList.MORDOR_SWORD_6.getCustomItem());
            add(IdList.MORDOR_SWORD_7.getCustomItem());
            add(IdList.GONDOR_SWORD_1.getCustomItem());
            add(IdList.GONDOR_SWORD_2.getCustomItem());
            add(IdList.GONDOR_SWORD_3.getCustomItem());
            add(IdList.GONDOR_SWORD_4.getCustomItem());
        }};
    }
}
