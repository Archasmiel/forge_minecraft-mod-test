package com.archasmiel.lightandgloom.item.tools;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.item.ModItemTier;
import net.minecraft.item.SwordItem;
import net.minecraftforge.common.ToolType;

public class CopperSword extends SwordItem {

    public CopperSword() {
        super(
                ModItemTier.COPPER,
                4,
                0f,
                new Properties()
                .defaultDurability(ModItemTier.COPPER.getUses())
                .tab(LightAndGloomMod.MOD_TAB)
        );


    }
}
