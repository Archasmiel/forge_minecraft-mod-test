package com.archasmiel.lightandgloom.init;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.block.MetalBlock;
import com.archasmiel.lightandgloom.block.Ore;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;


public class ModBlocks {

    /* TAB PREFAB */
    public static final Item.Properties usualItemTab
            = new Item.Properties().tab(LightAndGloom.MOD_TAB);



    /* PACKED BLOCKS */
    public static final RegistryObject<Block> COPPER_BLOCK
            = Registration.registerBlock("copper_block", () -> new MetalBlock(3f, 10f, 2));



    /* ORES */
    public static final RegistryObject<Block> COPPER_ORE
            = Registration.registerBlock("copper_ore", () -> new Ore(3f, 10f, 2));

    public static final RegistryObject<Block> RANDOM_ORE
            = Registration.registerBlock("random_ore", () -> new Ore(3f, 10f, 2));



    public static void register() {}

}
