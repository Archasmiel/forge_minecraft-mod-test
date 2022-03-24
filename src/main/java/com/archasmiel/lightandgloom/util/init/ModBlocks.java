package com.archasmiel.lightandgloom.util.init;

import com.archasmiel.lightandgloom.LightAndGloom;
import com.archasmiel.lightandgloom.block.ArcaneWorkbench;
import com.archasmiel.lightandgloom.block.Crop;
import com.archasmiel.lightandgloom.block.MetalBlock;
import com.archasmiel.lightandgloom.block.Ore;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {


    /* PACKED BLOCKS */
    public static final RegistryObject<Block> COPPER_BLOCK
            = registerBlock("copper_block", () -> new MetalBlock(3f, 10f, 2));



    /* ORES */
    public static final RegistryObject<Block> COPPER_ORE
            = registerBlock("copper_ore", () -> new Ore(3f, 10f, 2));

    public static final RegistryObject<Block> RANDOM_ORE
            = registerBlock("random_ore", () -> new Ore(3f, 10f, 2));


    /* CROPS */
    public static final RegistryObject<Block> ZUCCINI_CROP
            = registerBlock("zuccini_crop",
                () -> new Crop(AbstractBlock.Properties.copy(Blocks.WHEAT)));



    /* BENCHES */
    public static final RegistryObject<Block> ARCANE_WORKBENCH
            = registerBlock("arcane_workbench", ArcaneWorkbench::new);



    /* REGISTER METHODS */
    public static void register() {}

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockProperties) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, blockProperties);
        Registration.ITEMS.register(
                name,
                () -> new BlockItem(
                        toReturn.get(),
                        new Item.Properties().tab(LightAndGloom.MOD_TAB)
                )
        );
        return toReturn;
    }

}
