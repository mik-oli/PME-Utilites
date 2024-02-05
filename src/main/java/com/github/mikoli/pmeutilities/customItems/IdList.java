package com.github.mikoli.pmeutilities.customItems;

import com.github.mikoli.pmeutilities.customItems.itemInterfaces.ICustomItem;
import com.github.mikoli.pmeutilities.customItems.items.armors.angmar.*;
import com.github.mikoli.pmeutilities.customItems.items.armors.elfs.*;
import com.github.mikoli.pmeutilities.customItems.items.armors.erebor.*;
import com.github.mikoli.pmeutilities.customItems.items.armors.gondor.*;
import com.github.mikoli.pmeutilities.customItems.items.armors.mordor.*;
import com.github.mikoli.pmeutilities.customItems.items.armors.other.ArmorSauron;
import com.github.mikoli.pmeutilities.customItems.items.rings.*;
import com.github.mikoli.pmeutilities.customItems.items.swords.angmar.*;
import com.github.mikoli.pmeutilities.customItems.items.swords.erebor.*;
import com.github.mikoli.pmeutilities.customItems.items.swords.gondor.*;
import com.github.mikoli.pmeutilities.customItems.items.swords.mordor.*;
import com.github.mikoli.pmeutilities.customItems.items.swords.other.GlamdringSword;
import com.github.mikoli.pmeutilities.customItems.items.swords.other.MorgulSword;
import com.github.mikoli.pmeutilities.customItems.items.swords.other.NarsilSword;
import com.github.mikoli.pmeutilities.customItems.items.swords.other.WizardSword;

public enum IdList {

    //RINGS
    ASH_NAZG_RING(100, new AshNazgRing()),
    MINJE_RING(101, new MinjeRing()),
    ATJA_RING(102, new AtjaRing()),
    NELDE_RING(103, new NeldeRing()),
    KANTA_RING(104, new KantaRing()),
    LOSTA_RING(105, new LostaRing()),
    ENKWE_RING(106, new EnkweRing()),
    OTSO_RING(107, new OtsoRing()),
    TOLTO_RING(108, new ToltoRing()),
    NERTE_RING(109, new NerteRing()),

    //ARMORS
    ANGMAR_ARMOR(201, new ArmorAngmar()),
    GHOST_ARMOR(202, new ArmorGhost()),
    GUNDABAD_ARMOR(203, new ArmorGundabad()),
    NUMENOR_ARMOR(204, new ArmorNumenor()),
    NOLDOR_ARMOR(205, new ArmorNoldor()),
    PRINCE_ARMOR(206, new ArmorPrince()),
    RIVENDEL_ARMOR(207, new ArmorRivendel()),
    SILVAN_ARMOR(208, new ArmorSilvan()),
    EREBOR_AXEMAN_ARMOR(209, new ArmorEreborAxeman()),
    EREBOR_LIGHT_INFANTRY_ARMOR(210, new ArmorEreborLightInfantry()),
    EREBOR_RECONITERER_ARMOR(211, new ArmorEreborReconniterer()),
    EREBOR_WARIOR_ARMOR(212, new ArmorEreborWarrior()),
    GONDOR_ARCHER_ARMOR(213, new ArmorGondorArcher()),
    GONDOR_CAVALRY_ARMOR(214, new ArmorGondorCavalry()),
    GONDOR_INFANTRY_ARMOR(215, new ArmorGondorInfantry()),
    GUARDSMAN_ARMOR(216, new ArmorGuardsman()),
    RANGER_ARMOR(217, new ArmorRanger()),
    ROCHAN_INFANTRY_ARMOR(218, new ArmorRochanInfnatry()),
    MORDOR_GOBLIN_ARMOR(219, new ArmorMordorGoblin()),
    MORDOR_HEAVY_ORC_ARMOR(220, new ArmorMordorHeavyOrc()),
    MORDOR_MORIA_ARMOR(221, new ArmorMordorMoria()),
    MORDOR_SNAGA_ORC_ARMOR(222, new ArmorMordorSnagaOrc()),
    MORDOR_URUKHAI_ARMOR(223, new ArmorMordorUrukhai()),
    SAURON_ARMOR(224, new ArmorSauron()),

    //SWORDS
    ANGMAR_SWORD_1(301, new AngmarSword1()),
    ANGMAR_SWORD_2(302, new AngmarSword2()),
    ANGMAR_SWORD_3(303, new AngmarSword3()),
    ANGMAR_SWORD_4(304, new AngmarSword4()),
    EREBOR_SWORD_1(305, new EreborSword1()),
    EREBOR_SWORD_2(306, new EreborSword2()),
    EREBOR_SWORD_3(307, new EreborSword3()),
    EREBOR_SWORD_4(308, new EreborSword4()),
    EREBOR_SWORD_5(309, new EreborSword5()),
    MORDOR_SWORD_1(310, new MordorSword1()),
    MORDOR_SWORD_2(311, new MordorSword2()),
    MORDOR_SWORD_3(312, new MordorSword3()),
    MORDOR_SWORD_4(313, new MordorSword4()),
    MORDOR_SWORD_5(314, new MordorSword5()),
    MORDOR_SWORD_6(315, new MordorSword6()),
    MORDOR_SWORD_7(316, new MordorSword7()),
    GONDOR_SWORD_1(317, new GondorSword1()),
    GONDOR_SWORD_2(318, new GondorSword2()),
    GONDOR_SWORD_3(319, new GondorSword3()),
    GONDOR_SWORD_4(320, new GondorSword4()),
    WIZARD_SWORD(321, new WizardSword()),
    GLAMDRING_SWORD(322, new GlamdringSword()),
    MORGUL_SWORD(323, new MorgulSword()),
    NARSIL_SWORD(324, new NarsilSword());

    private final int id;
    private final ICustomItem customItem;

    IdList(int id, ICustomItem customItem) {
        this.id = id;
        this.customItem = customItem;
    }

    public int getId() {
        return this.id;
    }

    public ICustomItem getCustomItem() {
        return this.customItem;
    }

}
