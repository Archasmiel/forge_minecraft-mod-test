package com.archasmiel.lightandgloom.block.ore;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CopperOre extends Block {

    public CopperOre() {
        super(
                AbstractBlock.Properties.
                of(Material.STONE).
                strength(6f, 20f).
                harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().
                sound(SoundType.STONE)
        );
    }

}
