package com.archasmiel.lightandgloom.item.tools;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.item.ModItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraftforge.common.ToolType;

public class CopperPickaxe extends PickaxeItem {

    public CopperPickaxe() {
        super(
                ModItemTier.COPPER,
                3,
                0f,
                new Properties()
                .defaultDurability(ModItemTier.COPPER.getUses())
                .addToolType(ToolType.PICKAXE, ModItemTier.COPPER.getLevel())
                .tab(LightAndGloomMod.MOD_TAB)
        );


    }
}
