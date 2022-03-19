package com.archasmiel.lightandgloom.block;

import com.archasmiel.lightandgloom.block.ore.CopperOre;
import com.archasmiel.lightandgloom.block.packed.CopperBlock;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;


public class ModBlocks {

    /* PACKED BLOCKS */
    public static final RegistryObject<Block> COPPER_BLOCK
            = Registration.registerBlock("copper_block", CopperBlock::new);



    /* ORES */
    public static final RegistryObject<Block> COPPER_ORE
            = Registration.registerBlock("copper_ore", CopperOre::new);



    public static void register() {

    }

}
