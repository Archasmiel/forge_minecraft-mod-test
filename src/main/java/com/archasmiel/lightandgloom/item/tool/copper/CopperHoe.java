package com.archasmiel.lightandgloom.item.tool.copper;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.util.tier.ModItemTier;
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
                .tab(LightAndGloom.MOD_TAB)
        );


    }
}
