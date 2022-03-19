package com.archasmiel.lightandgloom.block.packed;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CopperBlock extends Block {

    public CopperBlock() {
        super(
            AbstractBlock.Properties.
            of(Material.METAL).
            strength(6f, 20f).
            harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops().
            sound(SoundType.METAL)
        );
    }

}
