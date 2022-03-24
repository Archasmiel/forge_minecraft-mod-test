package com.archasmiel.lightandgloom.util;

import com.archasmiel.lightandgloom.LightAndGloom;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;
import java.lang.reflect.Type;
import java.util.function.Supplier;

public class Registration
{

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, LightAndGloom.MOD_ID);

    public static final DeferredRegister<Item> ITEMS
            = DeferredRegister.create(ForgeRegistries.ITEMS, LightAndGloom.MOD_ID);

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, LightAndGloom.MOD_ID);

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, LightAndGloom.MOD_ID);

    public static final DeferredRegister<ContainerType<?>> CONTAINERS
            = DeferredRegister.create(ForgeRegistries.CONTAINERS, LightAndGloom.MOD_ID);

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        FLUIDS.register(eventBus);
        TILE_ENTITY_TYPES.register(eventBus);
        CONTAINERS.register(eventBus);
    }

}
