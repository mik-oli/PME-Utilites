package com.github.mikoli.pmeutilities.utils.enums.armors;

public enum ArmorDurability {

    LEATHER(55, 80, 75, 65),
    IRON(165, 240, 225, 195),
    CHAIN(165, 240, 225, 195),
    GOLD(77, 112, 105, 91),
    DIAMOND(363, 528, 495, 429),
    NETHERITE(407, 592, 555, 481);

    private final int helmet, chestplate, leggings, boots;

    ArmorDurability(int helmet, int chestplate, int leggings, int boots) {
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
    }

    public int getHelmet() {
        return helmet;
    }

    public int getChestplate() {
        return chestplate;
    }

    public int getLeggings() {
        return leggings;
    }

    public int getBoots() {
        return boots;
    }
}