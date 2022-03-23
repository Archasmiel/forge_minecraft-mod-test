package com.archasmiel.lightandgloom.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Ore extends Block {

    public Ore(Float power1, Float power2, Integer harvestLevel) {
        super(
                AbstractBlock.Properties.
                of(Material.STONE).
                strength(power1, power2).harvestLevel(harvestLevel).
                harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().
                sound(SoundType.STONE)
        );
    }

}
