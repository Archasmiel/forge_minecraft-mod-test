package com.archasmiel.lightandgloom.item.tools;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.item.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

public class CopperShovel extends ShovelItem {

    public CopperShovel() {
        super(
                ModItemTier.COPPER,
                0f,
                0f,
                new Item.Properties()
                .defaultDurability(ModItemTier.COPPER.getUses())
                .addToolType(ToolType.SHOVEL, ModItemTier.COPPER.getLevel())
                .tab(LightAndGloomMod.MOD_TAB)
        );


    }
}
