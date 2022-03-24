package com.archasmiel.lightandgloom.item.fuel;

import com.archasmiel.lightandgloom.util.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CoalFuel extends Item {

    private final Integer burnTime;

    public CoalFuel(Integer stacksTo, Integer burnTime) {
        super(ModItems.usualItemTab.stacksTo(stacksTo));
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.burnTime;
    }
}
