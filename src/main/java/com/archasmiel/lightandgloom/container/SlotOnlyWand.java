package com.archasmiel.lightandgloom.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class SlotOnlyWand extends SlotItemHandler {


    public SlotOnlyWand(IItemHandler handler, int index, int x, int y) {
        super(handler, index, x, y);
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        return false;
    }

}
