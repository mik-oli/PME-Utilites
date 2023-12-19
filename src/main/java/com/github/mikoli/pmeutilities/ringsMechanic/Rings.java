package com.github.mikoli.pmeutilities.ringsMechanic;

import org.bukkit.potion.PotionEffectType;

public enum Rings {

    MINJE(101, new PotionEffectType[]{PotionEffectType.SPEED}, new int[] {1}),
    ATJA(102, new PotionEffectType[]{PotionEffectType.INCREASE_DAMAGE}, new int[] {1}),
    NELDE(103, new PotionEffectType[]{PotionEffectType.JUMP}, new int[]{2}),
    KANTA(104, new PotionEffectType[]{PotionEffectType.REGENERATION}, new int[]{1}),
    LOSTA(105, new PotionEffectType[]{PotionEffectType.DAMAGE_RESISTANCE}, new int[]{1}),
    ENKWE(106, new PotionEffectType[]{PotionEffectType.INVISIBILITY}, new int[]{1}),
    OTSO(107, new PotionEffectType[]{PotionEffectType.NIGHT_VISION}, new int[]{1}),
    TOLTO(108, new PotionEffectType[]{PotionEffectType.ABSORPTION}, new int[]{5}),
    NERTE(109, new PotionEffectType[]{PotionEffectType.FIRE_RESISTANCE}, new int[]{1}),
    ASH_NAZG(110,
            new PotionEffectType[] {
                    PotionEffectType.SPEED, PotionEffectType.INCREASE_DAMAGE, PotionEffectType.JUMP,
                    PotionEffectType.REGENERATION, PotionEffectType.DAMAGE_RESISTANCE, PotionEffectType.INVISIBILITY,
                    PotionEffectType.NIGHT_VISION, PotionEffectType.ABSORPTION, PotionEffectType.FIRE_RESISTANCE
            },
            new int[] {1, 1, 2, 1, 1, 1, 1, 5, 1}
    );

    private final int modelDataId;
    private final PotionEffectType[] effects;
    private final int[] effectStrength;

    Rings(int modelDataId, PotionEffectType[] effects, int[] strength) {
        this.modelDataId = modelDataId;
        this.effects = effects;
        this.effectStrength = strength;
    }

    public int getModelDataId() {
        return modelDataId;
    }

    public PotionEffectType[] getEffectType() {
        return this.effects;
    }

    public int[] getEffectStrength() {
        return effectStrength;
    }

    public static Rings getRingFromModelId(int id) {
        for (Rings ring : Rings.values()) {
            if (ring.getModelDataId() == id) return ring;
        }
        return null;
    }
}
