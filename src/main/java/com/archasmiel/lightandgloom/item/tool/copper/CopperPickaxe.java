package com.archasmiel.lightandgloom.item.tool.copper;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.util.ModItemTier;
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
                .tab(LightAndGloom.MOD_TAB)
        );


    }
}
