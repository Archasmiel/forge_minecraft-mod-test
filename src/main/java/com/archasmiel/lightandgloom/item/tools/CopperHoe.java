package com.archasmiel.lightandgloom.item.tools;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.item.ModItemTier;
import net.minecraft.item.HoeItem;
import net.minecraftforge.common.ToolType;

public class CopperHoe extends HoeItem {

    public CopperHoe() {
        super(
                ModItemTier.COPPER,
                2,
                0f,
                new Properties()
                .defaultDurability(ModItemTier.COPPER.getUses())
                .addToolType(ToolType.HOE, ModItemTier.COPPER.getLevel())
                .tab(LightAndGloomMod.MOD_TAB)
        );


    }
}
