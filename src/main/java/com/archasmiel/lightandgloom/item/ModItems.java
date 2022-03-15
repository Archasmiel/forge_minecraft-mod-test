package com.archasmiel.lightandgloom.item;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final ItemGroup MOD_TAB = LightAndGloomMod.MOD_TAB;

    public static final RegistryObject<Item> COPPER_INGOT
            = Registration.ITEMS.register("copper_ingot", () -> new Item(
                    new Item.Properties().tab(MOD_TAB)
            )
    );

    public static final RegistryObject<Item> COPPER_WIRE
            = Registration.ITEMS.register("copper_wire", () -> new Item(
                    new Item.Properties().tab(MOD_TAB)
            )
    );

    public static void register() {

    }
}
