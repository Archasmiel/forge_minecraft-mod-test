package com.archasmiel.lightandgloom.item.materials;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import net.minecraft.item.Item;

public class ModMaterial extends Item {
    public ModMaterial() {
        super(
                new Item.Properties()
                .tab(LightAndGloomMod.MOD_TAB)
        );
    }

}
