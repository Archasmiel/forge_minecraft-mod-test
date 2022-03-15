package com.archasmiel.lightandgloom.block;

import com.archasmiel.lightandgloom.LightAndGloomMod;
import com.archasmiel.lightandgloom.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final ItemGroup MOD_TAB = LightAndGloomMod.MOD_TAB;

    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block", () -> new Block(
            AbstractBlock.Properties.of(Material.METAL).
            strength(6f, 20f).
            harvestLevel(2).
            harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().
            sound(SoundType.METAL)));

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore", () -> new Block(
            AbstractBlock.Properties.of(Material.STONE).
            strength(6f, 20f).
            harvestLevel(2).
            harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().
            sound(SoundType.STONE)
            )
    );

    public static void register() {

    }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(MOD_TAB)));
        return toReturn;
    }

}
