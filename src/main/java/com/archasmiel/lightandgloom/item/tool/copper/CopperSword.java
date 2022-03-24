package com.archasmiel.lightandgloom.item.tool.copper;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.util.tier.ModItemTier;
import net.minecraft.item.SwordItem;

public class CopperSword extends SwordItem {

    public CopperSword() {
        super(
                ModItemTier.COPPER,
                4,
                0f,
                new Properties()
                .defaultDurability(ModItemTier.COPPER.getUses())
                .tab(LightAndGloom.MOD_TAB)
        );


    }
}
