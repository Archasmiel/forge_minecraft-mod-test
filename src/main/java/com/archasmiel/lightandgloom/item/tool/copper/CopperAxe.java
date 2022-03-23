package com.archasmiel.lightandgloom.item.tool.copper;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.util.ModItemTier;
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
                .tab(LightAndGloom.MOD_TAB)
        );


    }
}
