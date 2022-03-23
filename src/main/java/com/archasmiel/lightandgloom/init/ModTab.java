package com.archasmiel.lightandgloom.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTab extends ItemGroup {

    public ModTab(String label) {
        super(label);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.COPPER_INGOT.get());
    }
}
