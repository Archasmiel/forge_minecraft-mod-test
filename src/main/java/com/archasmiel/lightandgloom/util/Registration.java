package com.archasmiel.lightandgloom.util;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class Registration
{

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, LightAndGloomMod.MOD_ID);

    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, LightAndGloomMod.MOD_ID);

    public static void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockProperties) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, blockProperties);
        Registration.ITEMS.register(
                name,
                () -> new BlockItem(
                        toReturn.get(),
                        new Item.Properties().tab(LightAndGloomMod.MOD_TAB)
                )
        );
        return toReturn;
    }

    public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> itemProperties) {
        return Registration.ITEMS.register(name, itemProperties);
    }
}
