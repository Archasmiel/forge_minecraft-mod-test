package com.archasmiel.lightandgloom.item.tools;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.item.ModItemTier;
import net.minecraft.item.AxeItem;
import net.minecraftforge.common.ToolType;

public class CopperAxe extends AxeItem {

    public CopperAxe() {
        super(
                ModItemTier.COPPER,
                0f,
                0f,
                new Properties()
                .defaultDurability(ModItemTier.COPPER.getUses())
                .addToolType(ToolType.AXE, ModItemTier.COPPER.getLevel())
                .tab(LightAndGloomMod.MOD_TAB)
        );


    }
}
