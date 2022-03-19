package com.archasmiel.lightandgloom.item.fuel;

import com.archasmiel.lightandgloom.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CopperedCoal extends Item {

    public CopperedCoal() {
        super(ModItems.usualItemTab.stacksTo(32));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 3200;
    }
}
